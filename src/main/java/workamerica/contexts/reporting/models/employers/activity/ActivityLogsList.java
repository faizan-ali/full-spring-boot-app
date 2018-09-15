package workamerica.contexts.reporting.models.employers.activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/22/2016.
 */
public class ActivityLogsList {

    private List<ActivityLogs> activityLogs;
    private Long counter = 0L;

    public ActivityLogsList () {
        this.activityLogs = new ArrayList<>();
    }

    public List<ActivityLogs> getActivityLogs() {
        return activityLogs;
    }

    public void setActivityLogs(List<ActivityLogs> activityLogs) {
        this.activityLogs = activityLogs;
    }

    public Long getCounter() {
        return counter == null ? 50 : counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public void incrementCounter () {
        counter++;
    }

    public void add(ActivityLogs logs) {
        if (logs != null) {
            if (this.activityLogs == null) {
                this.activityLogs = new ArrayList<>();
            }
            this.activityLogs.add(logs);
        }
    }
}
