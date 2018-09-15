package workamerica.contexts.gateways.website.conversion.components;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.companies.components.CompanyAccountComponent;
import workamerica.contexts.companies.components.CompanyComponent;
import workamerica.contexts.criteria.components.FieldComponent;
import workamerica.contexts.criteria.entities.Field;
import workamerica.contexts.gateways.website.conversion.models.employers.EmployerCreateRequest;
import workamerica.contexts.gateways.website.conversion.models.shared.CreateResponse;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/11/2016.
 */
@Component
public class EmployerConversionComponent {

    @Autowired
    FieldComponent fieldComponent;
    @Autowired
    CompanyAccountComponent accountComponent;
    @Autowired
    CompanyComponent companyComponent;

    public List<Field> getFields (String [] categories) {
        if (categories != null) {
            List<Field> list = new ArrayList<>();
            for (String category : categories) {
                list.addAll( fieldComponent.getByCategory(category));
            }
            return list;
        }
        return new ArrayList<>();
    }

    public CreateResponse createAccount(EmployerCreateRequest request, String userAgentString) {
        if (request != null) {
            if (accountComponent.existsByEmail(request.getEmail())) {
                return new CreateResponse(false, "An account with this e-mail already exists");
            }

            Long companyID = companyComponent.createFromWebsite(StringUtilities.capitalizeFirstLetter(request.getCompany()), request.getCategories());
            companyID = companyID == null ? 0 : companyID;

            if (userAgentString != null && !userAgentString.isEmpty()) {
                UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
                String browser = userAgent.getBrowser().getName(), browserVersion = userAgent.getBrowserVersion().getMajorVersion(),
                        operatingSystem = userAgent.getOperatingSystem().getName(), deviceType = userAgent.getOperatingSystem().getDeviceType().getName(),
                        vendor = userAgent.getOperatingSystem().getManufacturer().getName();
                request.setDevice(new DeviceLogs(deviceType, vendor, operatingSystem, browser, browserVersion));
            }

            boolean success = accountComponent.createAccount(StringUtilities.capitalizeFirstLetter(request.getFirstName()), StringUtilities.capitalizeFirstLetter(request.getLastName()),
                    StringUtilities.cleanNumber(request.getPhone()), request.getEmail(), request.getPassword(), request.getZip(), request.getFields(), request.getDevice(), companyID);

            if (success) {
                return new CreateResponse(true, "");
            }
        }
        return new CreateResponse(false, "An error occurred. Please try again later");
    }
}
