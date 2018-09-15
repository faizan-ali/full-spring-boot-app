package workamerica.contexts.gateways.website.conversion.models.shared;

/**
 * Created by Faizan on 8/10/2016.
 */
public class CreateResponse {

    private boolean success;
    private String reason;

    public CreateResponse() {}

    public CreateResponse(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
