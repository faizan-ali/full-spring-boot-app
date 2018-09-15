package workamerica.contexts.criteria.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.criteria.entities.Field;
import workamerica.contexts.criteria.repositories.FieldRepository;

import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
@Component
public class FieldComponent {

    FieldRepository repository;

    @Autowired
    FieldComponent(FieldRepository repository) { this.repository = repository; }

    public List<Field> getByCategory (String category) {
        if (category != null && !category.isEmpty()) {
            return repository.findByCategory(category);
        }
        return null;
    }

    public String getNameByID (Long fieldID) {
        if (fieldID != null && fieldID > 0) {
            Field field = repository.findNameByFieldID(fieldID);
            if (field != null) {
                String name = field.getName();
                return name == null ? "" : name;
            }
        }
        return "";
    }

}
