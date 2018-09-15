package workamerica.contexts.gateways.platform.login.models;

/**
 * Created by Faizan on 8/18/2016.
 */
public class LoginResponse {

    private String token;
    private Object user;
    private boolean success;
    private String error;

    public LoginResponse() {}

    public LoginResponse(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public LoginResponse(Object user) {
        this.success = true;
        this.error = "";
        this.user = user;
    }

    public LoginResponse(Object user, String token) {
        this.success = true;
        this.error = "";
        this.user = user;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
