package workamerica.contexts.reporting.models.shared.api.sendgrid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Faizan on 8/10/2016.
 */
public class SendGridEvent {

    @JsonProperty(value = "sg_message_id")
    private String messageID;
    @JsonProperty(value = "sendgrid")
    private String email;
    @JsonProperty(value = "timestamp")
    private String timestamp;
    @JsonProperty(value = "event")
    private String eventType;
    @JsonIgnore
    private String date;
    @JsonIgnore
    private String time;

    public SendGridEvent () {}

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDeliveryEvent () {
        if (eventType != null && (eventType.equals("bounce") || eventType.equals("deferred") || eventType.equals("delivered") ||
                eventType.equals("dropped") || eventType.equals("processed"))) {
            return true;
        }
        return false;
    }

    public boolean isEngagementEvent () {
        return eventType != null && !isDeliveryEvent();
    }

    public boolean isSuccess () {
        return eventType != null && (isEngagementEvent() || eventType.equals("delivered"));
    }
}
