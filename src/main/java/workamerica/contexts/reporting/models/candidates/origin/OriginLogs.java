package workamerica.contexts.reporting.models.candidates.origin;

import workamerica.contexts.reporting.models.shared.DeviceLogs;

/**
 * Created by Faizan on 8/9/2016.
 */
public class OriginLogs {

    private String workAmericaCreated;
    private DeviceLogs deviceLogs;
    private SourceLogs sourceLogs;

    public OriginLogs () {
        this.deviceLogs = new DeviceLogs();
        this.sourceLogs = new SourceLogs();
    }

    public OriginLogs (String workAmericaCreated) {
        this.deviceLogs = new DeviceLogs();
        this.sourceLogs = new SourceLogs();
        this.workAmericaCreated = workAmericaCreated;
    }

    public OriginLogs(String workAmericaCreated, DeviceLogs deviceLogs, SourceLogs sourceLogs) {
        this.workAmericaCreated = workAmericaCreated;
        this.deviceLogs = deviceLogs;
        this.sourceLogs = sourceLogs;
    }

    public String getWorkAmericaCreated() {
        return workAmericaCreated;
    }

    public void setWorkAmericaCreated(String workAmericaCreated) {
        this.workAmericaCreated = workAmericaCreated;
    }

    public DeviceLogs getDeviceLogs() {
        return deviceLogs;
    }

    public void setDeviceLogs(DeviceLogs deviceLogs) {
        this.deviceLogs = deviceLogs;
    }

    public SourceLogs getSourceLogs() {
        return sourceLogs;
    }

    public void setSourceLogs(SourceLogs sourceLogs) {
        this.sourceLogs = sourceLogs;
    }
}
