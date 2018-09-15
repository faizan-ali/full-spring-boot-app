package workamerica.contexts.reporting.models.candidates.activity;

import java.util.HashMap;

/**
 * Created by Faizan on 8/9/2016.
 */
public class UpdateLogs {

    private String time;
    private HashMap<String, HashMap<String, String>> updates;

    public UpdateLogs () {}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HashMap<String, HashMap<String, String>> getUpdates() {
        return updates;
    }

    public void setUpdates(HashMap<String, HashMap<String, String>> updates) {
        this.updates = updates;
    }
}
