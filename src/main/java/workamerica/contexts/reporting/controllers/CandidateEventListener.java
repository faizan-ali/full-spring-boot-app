package workamerica.contexts.reporting.controllers;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workamerica.contexts.reporting.models.shared.api.sendgrid.SendGridEvent;
import workamerica.contexts.reporting.components.candidates.CandidateEventListenerComponent;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/8/2016.
 */
@RestController
@RequestMapping("/candidates")
public class CandidateEventListener {

    @Autowired
    CandidateEventListenerComponent component;

    @RequestMapping(method = RequestMethod.GET)
    public void work ( @RequestHeader("User-Agent") String userAgentString) {
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        String browser = userAgent.getBrowser().getName(), browserVersion = userAgent.getBrowserVersion().getMajorVersion(),
                operatingSystem = userAgent.getOperatingSystem().getName(), deviceType = userAgent.getOperatingSystem().getDeviceType().getName(),
                vendor = userAgent.getOperatingSystem().getManufacturer().getName();
        System.out.println(browser + " " + browserVersion + " " + operatingSystem + " " + deviceType + " " + vendor);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void consume (@RequestBody ArrayList<SendGridEvent> events) {
        if (events != null) {
            component.persistEvents(events);
        }
    }
}
