package workamerica.contexts.companies.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.companies.entities.CompanyAccount;
import workamerica.contexts.companies.repositories.CompanyAccountRepository;
import workamerica.contexts.reporting.components.employers.CompanyAccountReportComponent;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.Authentication;
import workamerica.contexts.utilities.StringUtilities;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/15/2016.
 */
@Component
public class CompanyAccountComponent {

    @Autowired
    CompanyAccountRepository repository;
    @Autowired
    CompanyAccountReportComponent reportComponent;

    public boolean createAccount (String firstName, String lastName, String phone, String email, String password, String zip, ArrayList<Integer> fields, DeviceLogs device, Long companyID) {
        try {
            String [] saltyPassword = Authentication.hashPassword(password);
            String salt = saltyPassword[1];
            password = saltyPassword[0];

            CompanyAccount account = new CompanyAccount(firstName, lastName, phone, email, password, salt, zip, companyID, fields);
            account = repository.save(account);
            reportComponent.createFromWebsite(account.getCompanyAccountID(), device);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CompanyAccount login(String userName, String password, DeviceLogs device) {
        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            if (StringUtilities.isValidUserName(userName)) {
                userName = userName.trim().toLowerCase();
                CompanyAccount account = repository.findByEmail(userName);

                if (account != null && Authentication.isValid(password, account.getPassword(), account.getSalt())) {
                    reportComponent.logLogin(account.getCompanyAccountID(), device);
                    return account;
                }
            }
        }
        return null;
    }

    public boolean existsByEmail(String email) {
        if (StringUtilities.isValidEmail(email)) {
            return repository.findByEmail(email) != null;
        }
        return false;
    }
}
