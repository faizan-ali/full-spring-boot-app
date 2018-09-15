package workamerica.contexts.reporting.components.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.reporting.entities.CandidateReport;
import workamerica.contexts.reporting.models.candidates.activity.ActivityLogs;
import workamerica.contexts.reporting.models.candidates.origin.OriginLogs;
import workamerica.contexts.reporting.models.candidates.origin.SourceLogs;
import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.reporting.repositories.CandidateReportRepository;

/**
 * Created by Faizan on 8/11/2016.
 */
@Component
public class CandidateReportComponent {

    @Autowired
    CandidateReportRepository reportRepository;

    public CandidateReport findByCandidateID(Long candidateID) {
        if (candidateID != null && candidateID > 0) {
            return reportRepository.findByCandidateID(candidateID);
        }
        return null;
    }

    public void save (CandidateReport report) {
        if (report != null) {
            reportRepository.save(report);
        }
    }

    public CandidateReport createFromWebsite(Long candidateID, DeviceLogs device) {
        if (candidateID != null && candidateID > 0) {
            OriginLogs originLogs = new OriginLogs("No", device, new SourceLogs("Organic", "Website"));
            CandidateReport report = new CandidateReport(candidateID, originLogs);
            return reportRepository.save(report);
        }
        return null;
    }

    public void logLogin(Long candidateID, DeviceLogs deviceLogs) {
        if (candidateID != null && candidateID > 0) {
            CandidateReport report = reportRepository.findByCandidateID(candidateID);
            report = report == null ? new CandidateReport(candidateID) : report;
            report.getActivityLogs().add(new ActivityLogs(deviceLogs));
            reportRepository.save(report);
        }
    }


}
