package workamerica.contexts.gateways.website.conversion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workamerica.contexts.criteria.entities.Field;
import workamerica.contexts.gateways.website.conversion.components.EmployerConversionComponent;
import workamerica.contexts.gateways.website.conversion.models.employers.EmployerCreateRequest;
import workamerica.contexts.gateways.website.conversion.models.shared.CreateResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Faizan on 8/11/2016.
 */
@RestController
@RequestMapping("/website/conversion/employer")
public class EmployerConversionController {

    @Autowired
    EmployerConversionComponent component;

    @RequestMapping(method = RequestMethod.GET)
    public List<Field> getFields (@RequestParam(name = "category") String [] categories) {
        System.out.println(Arrays.toString(categories));
        return categories != null ? component.getFields(categories) : new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CreateResponse createEmployer(@RequestBody EmployerCreateRequest request, @RequestHeader("User-Agent") String userAgent) {
        if (request != null) {
            return component.createAccount(request, userAgent);
        }
        return new CreateResponse(false, "Null request");
    }
}
