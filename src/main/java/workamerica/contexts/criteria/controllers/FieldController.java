package workamerica.contexts.criteria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workamerica.contexts.criteria.components.FieldComponent;
import workamerica.contexts.criteria.entities.Field;

import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
@RestController
@RequestMapping("/criteria/fields")
public class FieldController {

    @Autowired
    FieldComponent component;

    @RequestMapping(method = RequestMethod.GET)
    public List<Field> getFieldsByCategory(@RequestParam String category) {
        if (category != null && !category.isEmpty()) {
            return component.getByCategory(category);
        }
        return null;
    }
}
