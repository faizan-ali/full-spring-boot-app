package workamerica.contexts.reporting.components.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.candidates.components.CandidateComponent;
import workamerica.contexts.candidates.entities.Candidate;
import workamerica.contexts.reporting.entities.CandidateReport;
import workamerica.contexts.reporting.models.candidates.api.CandidateAPILogs;
import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridLogs;
import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridEvent;
import workamerica.contexts.reporting.models.shared.api.sendgrid.welcome.SendGridWelcome;
import workamerica.contexts.utilities.Clock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan on 8/10/2016.
 */
@Component
public class CandidateEventListenerComponent {

    @Autowired
    CandidateComponent candidateComponent;
    @Autowired
    CandidateReportComponent reportComponent;

    public void persistEvents(ArrayList<SendGridEvent> events) {
        if (events != null && !events.isEmpty()) {
            for (SendGridEvent event : events) {
                Candidate candidate = candidateComponent.findByEmail(event.getEmail());
                if (candidate != null) {
                    persistEvent(event, candidate.getCandidateID());
                }
            }
        }
    }

    private void persistEvent(SendGridEvent event, Long candidateID) {
        CandidateReport report = reportComponent.findByCandidateID(candidateID);
        report = report == null ? new CandidateReport(candidateID) : report;
        CandidateAPILogs candidateApiLogs = report.getCandidateApiLogs() == null ? new CandidateAPILogs() : report.getCandidateApiLogs();
        SendGridLogs sendGridLogs = candidateApiLogs.getSendGridLogs() == null ? new SendGridLogs() : candidateApiLogs.getSendGridLogs();
        SendGridWelcome welcome = sendGridLogs.getWelcome() == null ? new SendGridWelcome() : sendGridLogs.getWelcome();
        List<SendGridEvent> events = welcome.getEvents() == null ? new ArrayList<>() : welcome.getEvents();

        if (event.isSuccess()) { welcome.setSuccess(true); }
        event.setDate(Clock.currentDate());
        event.setTime(Clock.currentTime());
        events.add(event);

        welcome.setEvents(events);
        sendGridLogs.setWelcome(welcome);
        candidateApiLogs.setSendGridLogs(sendGridLogs);
        report.setCandidateApiLogs(candidateApiLogs);
        reportComponent.save(report);
    }

}
