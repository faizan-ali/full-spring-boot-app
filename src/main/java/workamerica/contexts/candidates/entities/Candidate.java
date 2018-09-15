package workamerica.contexts.candidates.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;
import workamerica.contexts.utilities.Clock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Faizan on 8/2/2016.
 */
@Entity
@Table(name = "Candidates", schema = "Candidate")
public class Candidate extends ResourceSupport {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateID")
    private Long candidateID;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;

    // Location data
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "Zip")
    private String zip;
    @JsonIgnore
    @Column(name = "Latitude")
    private String latitude;
    @JsonIgnore
    @Column(name = "Longitude")
    private String longitude;

    // Auth & Contact
    @Column(name = "Email")
    private String email;
    @JsonIgnore
    @Column(name = "Password")
    private String password;
    @JsonIgnore
    @Column(name = "Salt")
    private String salt;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "AlternatePhone")
    private String alternatePhone;

    // Boolean fields
    @Column(name = "Veteran")
    private Boolean veteran;
    @Column(name = "Employed")
    private Boolean employed;
    @Column(name = "WillRelocate")
    private Boolean willRelocate;
    @Column(name = "Authorized")
    private Boolean authorized;
    @Column(name = "Approved")
    private Boolean approved;
    @Column(name = "HasDriversLicense")
    private Boolean hasDriversLicense;

    @Column(name = "AdditionalInformation")
    private String additionalInformation;
    @Column(name = "WorkExperience")
    private String workExperience;

    @Column(name = "PastEducation")
    private String pastEducation;
    @Column(name = "School")
    private String school;

    @JsonIgnore
    @Column(name = "DateCreated")
    private String dateCreated;
    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "Resume")
    private String resume;
    @Column(name = "Photo")
    private String photo;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "candidate")
    private List<CandidateCertification> certifications;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "candidate")
    private List<CandidateField> fields;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "candidate")
    private List<Interest> interests;

    public Candidate() {
        this.certifications = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.interests = new ArrayList<>();
        this.timeCreated = Clock.currentTime();
        this.dateCreated = Clock.currentDate();
    }

    public Candidate(String firstName, String lastName, String email, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zip = zip;
        this.certifications = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.interests = new ArrayList<>();
        this.timeCreated = Clock.currentTime();
        this.dateCreated = Clock.currentDate();
    }

    public Candidate(String firstName, String lastName, String email, String password, String salt, String zip,
                     List<Interest> interests, List<CandidateField> fields) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.zip = zip;
        this.interests = interests;
        this.fields = fields;
        this.timeCreated = Clock.currentTime();
        this.dateCreated = Clock.currentDate();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Candidate candidate;
            if (obj == null || (candidate = ((Candidate) obj)).getCandidateID() <= 0) {
                return false;
            } else {
                return (this.candidateID == candidate.getCandidateID())
                        && this.email.equals(candidate.getEmail());
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.candidateID, this.email);
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public Boolean getVeteran() {
        return veteran;
    }

    public void setVeteran(Boolean veteran) {
        this.veteran = veteran;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Boolean getEmployed() {
        return employed;
    }

    public void setEmployed(Boolean employed) {
        this.employed = employed;
    }

    public Boolean getWillRelocate() {
        return willRelocate;
    }

    public void setWillRelocate(Boolean willRelocate) {
        this.willRelocate = willRelocate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPastEducation() {
        return pastEducation;
    }

    public void setPastEducation(String pastEducation) {
        this.pastEducation = pastEducation;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getWorkAmericaCreated() {
        return "";
    }

    public String getTimeCreated() {
        return "";
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getHasDriversLicense() {
        return hasDriversLicense;
    }

    public void setHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<CandidateCertification> getCertifications() {
        return certifications == null ? new ArrayList<CandidateCertification>() : certifications;
    }

    public void setCertifications(List<CandidateCertification> certifications) {
        if (certifications != null) {
            this.certifications = certifications;
        }
    }

    public List<CandidateField> getFields() {
        return fields == null ? new ArrayList<CandidateField>() : fields;
    }

    public void setFields(List<CandidateField> fields) {
        if (fields != null) {
            this.fields = fields;
        }
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}