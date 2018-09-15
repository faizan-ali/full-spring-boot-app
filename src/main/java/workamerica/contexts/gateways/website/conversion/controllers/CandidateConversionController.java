package workamerica.contexts.gateways.website.conversion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workamerica.contexts.gateways.website.conversion.components.CandidateConversionComponent;
import workamerica.contexts.gateways.website.conversion.models.shared.CreateResponse;
import workamerica.contexts.gateways.website.conversion.models.candidates.CandidateConversionRequest;
import workamerica.contexts.gateways.website.conversion.models.candidates.CandidateConversionResponse;

/**
 * Created by Faizan on 8/5/2016.
 */
@RestController
@RequestMapping("/website/conversion/candidate")
public class CandidateConversionController {

    @Autowired
    CandidateConversionComponent component;

    @RequestMapping(method = RequestMethod.POST)
    public CreateResponse response(@RequestBody CandidateConversionRequest request, @RequestHeader("User-Agent") String userAgent) {
        try {
            return component.createCandidate(request, userAgent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CreateResponse(false, "An error occurred. Please try again later");
    }

    @RequestMapping(method = RequestMethod.GET)
    public CandidateConversionResponse employersAndFields(@RequestParam(name = "category") String category) {
        if (category != null && !category.isEmpty()) {
            return component.employersAndFields(category);
        }
        return null;
    }

}
