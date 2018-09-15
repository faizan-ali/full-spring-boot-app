package workamerica.contexts.reporting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import workamerica.contexts.reporting.components.candidates.CandidateEventListenerComponent;
import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridEvent;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/15/2016.
 */
public class EmployerEventListener {
    @Autowired
    CandidateEventListenerComponent component;

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void consume (@RequestBody ArrayList<SendGridEvent> events) {
        if (events != null) {
            component.persistEvents(events);
        }
    }
}
