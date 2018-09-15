package workamerica.contexts.reporting.models.employers.origin;

import workamerica.contexts.candidates.models.CustomConverter;
import workamerica.contexts.reporting.models.candidates.origin.SourceLogs;
import workamerica.contexts.reporting.models.shared.DeviceLogs;

import javax.persistence.Convert;

/**
 * Created by Faizan on 8/15/2016.
 */
//@JsonDeserialize(using = OriginLogDeserializer.class)
public class OriginLogs {

    private String workAmericaCreated;
    @Convert(converter = CustomConverter.class)
    private DeviceLogs deviceLogs;
    @Convert(converter = CustomConverter.class)
    private SourceLogs sourceLogs;

    public OriginLogs () {
        this.deviceLogs = new DeviceLogs();
        this.sourceLogs = new SourceLogs();
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
