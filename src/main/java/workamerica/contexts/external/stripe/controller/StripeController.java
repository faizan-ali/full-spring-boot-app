package workamerica.contexts.external.stripe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workamerica.contexts.external.stripe.components.StripeComponent;

/**
 * Created by Faizan on 8/16/2016.
 */
@RestController
@RequestMapping("/stripe")
public class StripeController {

    @Autowired
    StripeComponent component;

    @RequestMapping(method = RequestMethod.POST)
    public void bill (@RequestParam("stripeToken") String stripeToken) {

    }
}
