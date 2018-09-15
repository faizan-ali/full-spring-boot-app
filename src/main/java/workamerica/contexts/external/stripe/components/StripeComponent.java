package workamerica.contexts.external.stripe.components;

import com.stripe.exception.*;
import com.stripe.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faizan on 8/16/2016.
 */
@Component
public class StripeComponent {

    private static final String key = "";

    public String bill(String token, String plan, String email) {
        if (token != null && !token.isEmpty()) {
            Map<String, Object> params = new HashMap<>();
            params.put("source", token);
            params.put("plan", plan);
            params.put("email", email);

            try {
                Customer customer = Customer.create(params);
                return customer.getId();
            } catch (CardException e) {
                // Since it's a decline, CardException will be caught
                System.out.println("Status is: " + e.getCode());
                System.out.println("Message is: " + e.getMessage());
            } catch (RateLimitException e) {
                // Too many requests made to the API too quickly
            } catch (InvalidRequestException e) {
                // Invalid parameters were supplied to Stripe's API
            } catch (AuthenticationException e) {
                // Authentication with Stripe's API failed
                // (maybe you changed API keys recently)
            } catch (APIConnectionException e) {
                // Network communication with Stripe failed
            } catch (StripeException e) {
                // Display a very generic error to the user, and maybe send
                // yourself an email
            } catch (Exception e) {
                // Something else happened, completely unrelated to Stripe
            }
        }
        return null;
    }
}
