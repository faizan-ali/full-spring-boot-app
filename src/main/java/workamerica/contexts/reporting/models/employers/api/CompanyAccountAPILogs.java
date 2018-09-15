package workamerica.contexts.reporting.models.employers.api;

import workamerica.contexts.reporting.models.shared.api.StripeLogs;
import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridLogs;

/**
 * Created by Faizan on 8/15/2016.
 */
public class CompanyAccountAPILogs {

    private SendGridLogs sendGridLogs;
    private StripeLogs stripeLogs;

    public CompanyAccountAPILogs() {}

    public SendGridLogs getSendGridLogs() {
        return sendGridLogs;
    }

    public void setSendGridLogs(SendGridLogs sendGridLogs) {
        this.sendGridLogs = sendGridLogs;
    }

    public StripeLogs getStripeLogs() {
        return stripeLogs;
    }

    public void setStripeLogs(StripeLogs stripeLogs) {
        this.stripeLogs = stripeLogs;
    }
}
