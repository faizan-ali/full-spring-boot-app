package workamerica.contexts.reporting.components.employers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.reporting.entities.CompanyAccountReport;
import workamerica.contexts.reporting.models.candidates.origin.SourceLogs;
import workamerica.contexts.reporting.models.employers.activity.ActivityLogs;
import workamerica.contexts.reporting.models.employers.origin.OriginLogs;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.reporting.repositories.CompanyAccountReportRepository;

/**
 * Created by Faizan on 8/16/2016.
 */
@Component
public class CompanyAccountReportComponent {

    @Autowired
    CompanyAccountReportRepository repository;

    @Autowired
    CompanyAccountReportComponent(CompanyAccountReportRepository repository) {
        this.repository = repository;
    }

    public CompanyAccountReport createFromWebsite(Long companyAccountID, DeviceLogs device) {
        if (companyAccountID != null && companyAccountID > 0) {
            OriginLogs originLogs = new OriginLogs("No", device, new SourceLogs("Organic", "Website"));
            CompanyAccountReport report = new CompanyAccountReport(companyAccountID, originLogs);
            return repository.save(report);
        }
        return null;
    }

    public void logLogin(Long companyAccountID, DeviceLogs deviceLogs) {
        if (companyAccountID != null && companyAccountID > 0) {
            CompanyAccountReport report = repository.findByCompanyAccountID(companyAccountID);
            report = report == null ? new CompanyAccountReport(companyAccountID) : report;
            ActivityLogs activityLogs = new ActivityLogs(deviceLogs);
            report.addToActivityLogs(new ActivityLogs(deviceLogs));
            report = repository.saveAndFlush(report);
        }
    }

}
