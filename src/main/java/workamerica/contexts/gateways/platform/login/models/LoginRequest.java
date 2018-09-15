package workamerica.contexts.gateways.platform.login.models;

import workamerica.contexts.reporting.models.shared.DeviceLogs;

/**
 * Created by Faizan on 8/18/2016.
 */
public class LoginRequest {

    private String userName;
    private String password;
    private DeviceLogs deviceLogs;

    public LoginRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return userName != null && !userName.isEmpty() && password != null && !password.isEmpty();
    }

    public DeviceLogs getDeviceLogs() {
        return deviceLogs;
    }

    public void setDeviceLogs(DeviceLogs deviceLogs) {
        this.deviceLogs = deviceLogs;
    }
}
