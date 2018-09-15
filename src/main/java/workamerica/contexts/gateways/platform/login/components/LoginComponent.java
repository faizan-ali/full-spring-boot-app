package workamerica.contexts.gateways.platform.login.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.candidates.components.CandidateComponent;
import workamerica.contexts.companies.components.CompanyAccountComponent;
import workamerica.contexts.gateways.platform.login.models.LoginRequest;
import workamerica.contexts.gateways.platform.login.models.LoginResponse;
import workamerica.contexts.utilities.Authentication;
import workamerica.contexts.utilities.HTTPUtilities;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Faizan on 8/17/2016.
 */
@Component
public class LoginComponent {

    @Autowired
    CandidateComponent candidateComponent;
    @Autowired
    CompanyAccountComponent accountComponent;

    // TODO Make this threaded?
    public LoginResponse login(LoginRequest request, HttpServletRequest servletRequest) {
        if (request.isValid()) {
            request.setDeviceLogs(HTTPUtilities.getDevice(servletRequest));

            // First checks employers accounts then candidate accounts
            Object account = accountComponent.login(request.getUserName(), request.getPassword(), request.getDeviceLogs());

            if (account != null) {
                return new LoginResponse(account, Authentication.generateEmployerToken(HTTPUtilities.getClientUserAgent(servletRequest)));
            } else {
                Object candidate = candidateComponent.login(request.getUserName(), request.getPassword(), request.getDeviceLogs());
                if (candidate != null) {
                    return new LoginResponse(candidate, Authentication.generateCandidateToken(HTTPUtilities.getClientUserAgent(servletRequest)));
                }
            }
            return new LoginResponse(false, "Invalid login details");
        }
        return new LoginResponse(false, "An error occurred");
    }

}
