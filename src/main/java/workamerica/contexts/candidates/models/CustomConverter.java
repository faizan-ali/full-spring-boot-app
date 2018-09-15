package workamerica.contexts.candidates.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

/**
 * Created by Faizan on 8/3/2016.
 * http://stackoverflow.com/questions/25738569/jpa-map-json-column-to-java-object
 */
public class CustomConverter implements AttributeConverter<Object, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public Object convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
