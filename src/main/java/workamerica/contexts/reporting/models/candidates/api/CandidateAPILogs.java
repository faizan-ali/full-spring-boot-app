package workamerica.contexts.reporting.models.candidates.api;

import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridLogs;

/**
 * Created by Faizan on 8/8/2016.
 */
public class CandidateAPILogs {

    private SendGridLogs sendGridLogs;

    public CandidateAPILogs() {
        this.sendGridLogs = new SendGridLogs();
    }

    public SendGridLogs getSendGridLogs() {
        return sendGridLogs;
    }

    public void setSendGridLogs(SendGridLogs sendGridLogs) {
        this.sendGridLogs = sendGridLogs;
    }
}
