package workamerica.contexts.candidates.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.candidates.entities.Candidate;
import workamerica.contexts.candidates.entities.CandidateField;
import workamerica.contexts.candidates.entities.Interest;
import workamerica.contexts.candidates.repository.CandidateRepository;
import workamerica.contexts.companies.components.CompanyComponent;
import workamerica.contexts.criteria.components.FieldComponent;
import workamerica.contexts.reporting.components.candidates.CandidateReportComponent;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.Authentication;
import workamerica.contexts.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Faizan on 8/3/2016.
 */
@Component
public class CandidateComponent

    @Autowired
    CandidateRepository repository;

    @Autowired
    CandidateComponent(CandidateRepository repository) {
        this.repository = repository;
    }

    @Autowired
    FieldComponent fieldComponent;
    @Autowired
    CompanyComponent companyComponent;
    @Autowired
    CandidateReportComponent reportComponent;

    public Candidate create(Candidate candidate) {
        if (candidate != null) {
            candidate = sanitize(candidate);
            return repository.save(candidate);
        }
        return null;
    }

    public boolean createFromWebsite(String firstName, String lastName, String email, String password, Long fieldID, String zip,
                                     ArrayList<Long> interestIDs, DeviceLogs device) {

        try {
            String fieldName = fieldComponent.getNameByID(fieldID);
            Candidate candidate = new Candidate(firstName, lastName, email, zip);
            candidate = repository.save(candidate);

            if (fieldName != null) {
                CandidateField field = new CandidateField(fieldID, fieldName, true, candidate.getCandidateID());
                candidate.getFields().add(field);
            }

            if (interestIDs != null) {
                List<Interest> interests = new ArrayList<>();
                for (Long companyID : interestIDs) {
                    String [] array = companyComponent.getNameAndImageByID(companyID);
                    String name = array[0], image = array[1];

                    if (name != null) {
                        interests.add(new Interest(companyID, name, image, candidate.getCandidateID()));
                    }
                }
               candidate.getInterests().addAll(interests);
            }
            candidate = generatePassword(candidate, password);
            candidate = repository.save(candidate);
            reportComponent.createFromWebsite(candidate.getCandidateID(), device);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean exists(String email) {
        if (StringUtilities.isValidEmail(email)) {
            return repository.findByEmail(email) != null;
        }
        return true;
    }

    public Candidate findByEmail(String email) {
        if (StringUtilities.isValidEmail(email)) {
            return repository.findByEmail(email);
        }
        return null;
    }

    public Candidate findByID(Long candidateID) {
        return candidateID != null && candidateID > 0 ? repository.findOne(candidateID) : null;
    }

    private Candidate sanitize(Candidate candidate) {
        if (candidate != null) {
            String firstName = candidate.getFirstName() != null ? StringUtilities.capitalizeFirstLetter(candidate.getFirstName()) : "",
                    lastName = candidate.getLastName() != null ? StringUtilities.capitalizeFirstLetter(candidate.getLastName()) : "",
                    zip = StringUtilities.isValidZip(candidate.getZip()) ? candidate.getZip().trim() : "",
                    email = StringUtilities.isValidEmail(candidate.getEmail()) ? candidate.getEmail().trim() : "";

            return candidate;
        }
        return null;
    }

    public Candidate login(String userName, String password, DeviceLogs device) {
        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            if (StringUtilities.isValidUserName(userName)) {
                userName = userName.trim().toLowerCase();

                Candidate candidate = repository.findByEmailOrPhoneOrAlternatePhone(userName, userName, userName);

                if (candidate != null && Authentication.isValid(password, candidate.getPassword(), candidate.getSalt())) {
                    reportComponent.logLogin(candidate.getCandidateID(), device);
                    return candidate;
                }

            }
        }
        return null;
    }

    public void addField(Long fieldID, Long candidateID) {
        Candidate candidate = repository.findOne(candidateID);
        CandidateField field = new CandidateField(fieldID, "", true, candidate.getCandidateID());
        candidate.getFields().add(field);
        repository.saveAndFlush(candidate);
    }

    public Candidate generatePassword(Candidate candidate, String password) {
        if (candidate != null && password != null) {
            String[] saltyPassword = Authentication.hashPassword(password);
            String salt = saltyPassword[1];
            password = saltyPassword[0];
            candidate.setPassword(password);
            candidate.setSalt(salt);
        }
        return candidate;
    }
}
