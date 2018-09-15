package workamerica.contexts.reporting.entities;

import workamerica.contexts.candidates.models.CustomConverter;
import workamerica.contexts.reporting.models.candidates.api.CandidateAPILogs;
import workamerica.contexts.reporting.models.candidates.activity.ActivityLogs;
import workamerica.contexts.reporting.models.candidates.origin.OriginLogs;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Faizan on 8/8/2016.
 */
@Entity
@Table(name = "CandidateReports", schema = "Reporting")
public class CandidateReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CandidateReportingID")
    private Long candidateReportingID;
    @Column(name = "CandidateID")
    private Long candidateID;
    @Column(name = "APILogs")
    @Convert(converter = CustomConverter.class)
    private CandidateAPILogs candidateApiLogs;
    @Column(name = "OriginLogs")
    @Convert(converter = CustomConverter.class)
    private OriginLogs originLogs;
    @Column(name = "ActivityLogs")
    @Convert(converter = CustomConverter.class)
    private ArrayList<ActivityLogs> activityLogs;

    public CandidateReport() {}

    public CandidateReport(Long candidateID) {
        this.candidateID = candidateID;
        this.candidateApiLogs = new CandidateAPILogs();
        this.activityLogs = new ArrayList<>();
        this.originLogs = new OriginLogs();
    }

    public CandidateReport (Long candidateID, OriginLogs originLogs) {
        this.candidateID = candidateID;
        this.candidateApiLogs = new CandidateAPILogs();
        this.activityLogs = new ArrayList<>();
        this.originLogs = originLogs;
    }

    public Long getCandidateReportingID() {
        return candidateReportingID;
    }

    public void setCandidateReportingID(Long candidateReportingID) {
        this.candidateReportingID = candidateReportingID;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public CandidateAPILogs getCandidateApiLogs() {
        return candidateApiLogs;
    }

    public void setCandidateApiLogs(CandidateAPILogs candidateApiLogs) {
        this.candidateApiLogs = candidateApiLogs;
    }

    public ArrayList<ActivityLogs> getActivityLogs() {
        return activityLogs;
    }

    public void setActivityLogs(ArrayList<ActivityLogs> activityLogs) {
        this.activityLogs = activityLogs;
    }

    public OriginLogs getOriginLogs() {
        return originLogs;
    }

    public void setOriginLogs(OriginLogs originLogs) {
        this.originLogs = originLogs;
    }
}
