package workamerica.contexts.reporting.models.shared.api.sendgrid.welcome;

import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/9/2016.
 */
public class SendGridWelcome {

    private String messageID;
    private boolean success;
    private List<SendGridEvent> events;

    public SendGridWelcome () {
        this.events = new ArrayList<>();
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String ID) {
        this.messageID = ID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<SendGridEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SendGridEvent> events) {
        this.events = events;
    }
}
