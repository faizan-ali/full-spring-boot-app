package workamerica.contexts.reporting.models.shared.api.sendgrid;

import workamerica.contexts.reporting.models.shared.api.sendgrid.welcome.SendGridWelcome;

/**
 * Created by Faizan on 8/9/2016.
 */
public class SendGridLogs {

    private SendGridWelcome welcome;

    public SendGridLogs () {
        this.welcome = new SendGridWelcome();
    }

    public SendGridWelcome getWelcome() {
        return welcome;
    }

    public void setWelcome(SendGridWelcome welcome) {
        this.welcome = welcome;
    }
}
