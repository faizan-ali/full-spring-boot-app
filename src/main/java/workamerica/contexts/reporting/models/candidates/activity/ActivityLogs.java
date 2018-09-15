package workamerica.contexts.reporting.models.candidates.activity;

import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.Clock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/8/2016.
 */
public class ActivityLogs {

    private String date;
    private String startTime;
    private String endTime;
    private DeviceLogs deviceLogs;
    private List<UpdateLogs> updateLogs;

    public ActivityLogs () {
        this.updateLogs = new ArrayList<>();
        this.date = Clock.currentDate();
        this.startTime = Clock.currentTime();
        this.endTime = Clock.currentTime();
    }

    public ActivityLogs (DeviceLogs deviceLogs) {
        this.updateLogs = new ArrayList<>();
        this.date = Clock.currentDate();
        this.startTime = Clock.currentTime();
        this.endTime = Clock.currentTime();
        this.deviceLogs = deviceLogs;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public DeviceLogs getDeviceLogs() {
        return deviceLogs;
    }

    public void setDeviceLogs(DeviceLogs deviceLogs) {
        this.deviceLogs = deviceLogs;
    }

    public List<UpdateLogs> getUpdateLogs() {
        return updateLogs;
    }

    public void setUpdateLogs(List<UpdateLogs> updateLogs) {
        this.updateLogs = updateLogs;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
