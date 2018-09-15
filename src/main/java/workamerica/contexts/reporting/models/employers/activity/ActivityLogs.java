package workamerica.contexts.reporting.models.employers.activity;

import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.Clock;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/15/2016.
 */
public class ActivityLogs {

    private Long activityLogsID;
    private String date;
    private String startTime;
    private String endTime;
    private DeviceLogs deviceLogs;
    private ArrayList<ViewLogs> viewLogs;
    private ArrayList<PipelineLogs> pipelineLogs;
    private ArrayList<SearchLogs> searchLogs;

    public ActivityLogs () {
        this.deviceLogs = new DeviceLogs();
        this.viewLogs = new ArrayList<>();
        this.pipelineLogs = new ArrayList<>();
        this.searchLogs = new ArrayList<>();
        this.date = Clock.currentDate();
        this.startTime = Clock.currentTime();
    }

    public ActivityLogs(DeviceLogs deviceLogs) {
        this.deviceLogs = deviceLogs;
        this.viewLogs = new ArrayList<>();
        this.pipelineLogs = new ArrayList<>();
        this.searchLogs = new ArrayList<>();
        this.startTime = Clock.currentTime();
        this.endTime = Clock.currentTime();
        this.date = Clock.currentDate();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            ActivityLogs logs;
            if (obj == null || (logs = ((ActivityLogs) obj)).getActivityLogsID() <= 0) {
                return false;
            } else {
                return (this.getActivityLogsID() == logs.getActivityLogsID());
            }
        } catch (Exception e) {
            return false;
        }
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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public DeviceLogs getDeviceLogs() {
        return deviceLogs;
    }

    public void setDeviceLogs(DeviceLogs deviceLogs) {
        this.deviceLogs = deviceLogs;
    }

    public ArrayList<ViewLogs> getViewLogs() {
        return viewLogs;
    }

    public void setViewLogs(ArrayList<ViewLogs> viewLogs) {
        this.viewLogs = viewLogs;
    }

    public ArrayList<PipelineLogs> getPipelineLogs() {
        return pipelineLogs;
    }

    public void setPipelineLogs(ArrayList<PipelineLogs> pipelineLogs) {
        this.pipelineLogs = pipelineLogs;
    }

    public ArrayList<SearchLogs> getSearchLogs() {
        return searchLogs;
    }

    public void setSearchLogs(ArrayList<SearchLogs> searchLogs) {
        this.searchLogs = searchLogs;
    }

    public Long getActivityLogsID() {
        return activityLogsID;
    }

    public void setActivityLogsID(Long activityLogsID) {
        this.activityLogsID = activityLogsID;
    }
}
