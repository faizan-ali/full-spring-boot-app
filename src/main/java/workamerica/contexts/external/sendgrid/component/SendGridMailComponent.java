package workamerica.contexts.external.sendgrid.component;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.candidates.components.CandidateComponent;
import workamerica.contexts.candidates.entities.Candidate;
import workamerica.contexts.errors.components.CandidateErrorComponent;
import workamerica.contexts.utilities.StringUtilities;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Faizan on 8/8/2016.
 */

@Component
public class SendGridMailComponent {
    private final static String apiKey = "";


    @Autowired
    static CandidateErrorComponent errorComponent;
    @Autowired
    static CandidateComponent candidateComponent;

    private static boolean sendMail (Mail mail) throws IOException {
        // Setting content type
        Content content = new Content();
        content.setType("text/html");
        content.setValue(" ");

        mail.addContent(content);

        // Building Request object to facilitate request
        Request request = new Request();
        request.method = Method.POST;
        request.endpoint = "mail/send";
        request.body = mail.build();

        // Declaring SendGrid object to handle authentication and sending
        SendGrid sendGrid = new SendGrid(apiKey);

        // Response object models SendGrid response
        Response response = sendGrid.api(request);
        String status = response.statusCode + "";
        return status.contains("20");
    }

    public static boolean welcomeEmployer(String name, String email) {
        if (StringUtilities.isValidEmail(email)) {

        }
        return false;
    }

    public static boolean welcomeCandidate(String name, String email) {
        if (StringUtilities.isValidEmail(email)) {
            String requestAccessID = "";
            try {
                // Email subject
                String subject = "Thank you from WorkAmerica!";

                // Recipient info
                Email to = new Email();
                to.setEmail(email);
                to.setName(name);

                // Sender info
                Email from = new Email();
                from.setEmail("www@workamerica.co");
                from.setName("");

                // Building Mail object to POST and setting template
                Mail mail = new Mail();
                mail.setFrom(from);
                Personalization personalization = new Personalization();
                personalization.addTo(to);
                personalization.setSubject(subject);
                personalization.addSubstitution(":name", name);
                mail.addPersonalization(personalization);
                mail.setTemplateId(requestAccessID);

                if (!sendMail(mail)) {
                    Candidate candidate = candidateComponent.findByEmail(email);
                    if (candidate != null) {
                        errorComponent.create(candidate.getCandidateID(), "Welcome E-mail", "No exception");
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Candidate candidate = candidateComponent.findByEmail(email);
                if (candidate != null) {
                    errorComponent.create(candidate.getCandidateID(), "Welcome E-mail", Arrays.toString(e.getStackTrace()));
                }
            }
        }
        return false;
    }
}
