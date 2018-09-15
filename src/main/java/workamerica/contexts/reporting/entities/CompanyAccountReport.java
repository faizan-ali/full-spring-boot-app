package workamerica.contexts.reporting.entities;

import workamerica.contexts.reporting.converters.APILogConverter;
import workamerica.contexts.reporting.converters.ActivityLogListConverter;
import workamerica.contexts.reporting.converters.OriginConverter;
import workamerica.contexts.reporting.models.employers.activity.ActivityLogs;
import workamerica.contexts.reporting.models.employers.activity.ActivityLogsList;
import workamerica.contexts.reporting.models.employers.api.CompanyAccountAPILogs;
import workamerica.contexts.reporting.models.employers.origin.OriginLogs;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Faizan on 8/15/2016.
 */
@Entity
@Table(name = "CompanyAccountReports", schema = "Reporting")
public class CompanyAccountReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyAccountReportID")
    private Long companyAccountReportID;
    @Column(name = "CompanyAccountID")
    private Long companyAccountID;
    @Column(name = "APILogs")
    @Convert(converter = APILogConverter.class)
    private CompanyAccountAPILogs companyAccountApiLogs;
    @Column(name = "OriginLogs")
    @Convert(converter = OriginConverter.class)
    private OriginLogs originLogs;
    @Column(name = "ActivityLogs")
    @Convert(converter = ActivityLogListConverter.class)
    private ActivityLogsList activityLogsList;

    public CompanyAccountReport () {}

    public CompanyAccountReport(Long companyAccountID) {
        this.companyAccountID = companyAccountID;
        this.companyAccountApiLogs = new CompanyAccountAPILogs();
        this.activityLogsList = new ActivityLogsList();
        this.originLogs = new OriginLogs();
    }

    public CompanyAccountReport (Long companyAccountID, OriginLogs originLogs) {
        this.companyAccountID = companyAccountID;
        this.originLogs = originLogs;
        this.companyAccountApiLogs = new CompanyAccountAPILogs();
        this.activityLogsList =  new ActivityLogsList();
    }

    public Long getCompanyAccountReportID() {
        return companyAccountReportID;
    }

    public void setCompanyAccountReportID(Long companyAccountReportID) {
        this.companyAccountReportID = companyAccountReportID;
    }

    public Long getCompanyAccountID() {
        return companyAccountID;
    }

    public void setCompanyAccountID(Long companyAccountID) {
        this.companyAccountID = companyAccountID;
    }

    public CompanyAccountAPILogs getCompanyAccountApiLogs() {
        return companyAccountApiLogs;
    }

    public void setCompanyAccountApiLogs(CompanyAccountAPILogs companyAccountApiLogs) {
        this.companyAccountApiLogs = companyAccountApiLogs;
    }

    public OriginLogs getOriginLogs() {
        return originLogs;
    }

    public void setOriginLogs(OriginLogs originLogs) {
        this.originLogs = originLogs;
    }

    public List<ActivityLogs> getActivityLogs() {
        if (activityLogsList == null) {
            activityLogsList = new ActivityLogsList();
        }
        return activityLogsList.getActivityLogs();
    }

    public Long getCounter() {
        if (activityLogsList == null) {
            activityLogsList = new ActivityLogsList();
            return 0L;
        }
        return activityLogsList.getCounter();
    }

    public void addToActivityLogs(ActivityLogs logs) {
        if (logs != null) {
            logs.setActivityLogsID(activityLogsList.getCounter());
            this.activityLogsList.incrementCounter();
            this.activityLogsList.add(logs);
        }
    }
}
