package workamerica.contexts.gateways.website.conversion.components;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.candidates.components.CandidateComponent;
import workamerica.contexts.companies.components.CompanyComponent;
import workamerica.contexts.companies.entities.Company;
import workamerica.contexts.criteria.components.FieldComponent;
import workamerica.contexts.criteria.entities.Field;
import workamerica.contexts.external.sendgrid.component.SendGridMailComponent;
import workamerica.contexts.gateways.website.conversion.models.shared.CreateResponse;
import workamerica.contexts.gateways.website.conversion.models.candidates.CandidateConversionRequest;
import workamerica.contexts.gateways.website.conversion.models.candidates.CandidateConversionResponse;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
@Component
public class CandidateConversionComponent {

    @Autowired
    FieldComponent fieldComponent;
    @Autowired
    CompanyComponent companyComponent;
    @Autowired
    CandidateComponent candidateComponent;

    public CandidateConversionResponse employersAndFields(String category) {
        if (category != null && !category.isEmpty()) {
            List<Field> fieldList = fieldComponent.getByCategory(category);
            List<Company> companyList = companyComponent.getByCategory(category);

            fieldList = fieldList == null ? new ArrayList<Field>() : fieldList;
            companyList = companyList == null ? new ArrayList<Company>() : companyList;

            return new CandidateConversionResponse(fieldList, companyList);
        }
        return null;
    }

    public CreateResponse createCandidate(CandidateConversionRequest request, String userAgentString) {
        if (request.isValid()) {
            if (!StringUtilities.isValidEmail(request.getEmail())) {
                return new CreateResponse(false, "Please enter a valid e-mail");
            } else if (candidateComponent.exists(request.getEmail())) {
                return new CreateResponse(false, "An account with this e-mail already exists");
            } else if (!StringUtilities.isValidZip(request.getZip())) {
                return new CreateResponse(false, "Please enter a valid zip");
            }

            if (userAgentString != null && !userAgentString.isEmpty()) {
                UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
                String browser = userAgent.getBrowser().getName(), browserVersion = userAgent.getBrowserVersion().getMajorVersion(),
                        operatingSystem = userAgent.getOperatingSystem().getName(), deviceType = userAgent.getOperatingSystem().getDeviceType().getName(),
                        vendor = userAgent.getOperatingSystem().getManufacturer().getName();
                request.setDevice(new DeviceLogs(deviceType, vendor, operatingSystem, browser, browserVersion));
            }

            boolean success = candidateComponent.createFromWebsite(request.getFirstName(), request.getLastName(), request.getEmail(),
                    request.getPassword(), Long.parseLong(request.getFieldID() + ""), request.getZip(), request.getInterests(), request.getDevice());

            if (success) {
                SendGridMailComponent.welcomeCandidate(request.getFirstName(), request.getEmail());
                return new CreateResponse(true, "");
            }
        }
        return new CreateResponse(false, "An error occurred. Please try again later");
    }
}
