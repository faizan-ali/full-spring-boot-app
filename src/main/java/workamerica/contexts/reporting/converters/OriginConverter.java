package workamerica.contexts.reporting.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import workamerica.contexts.reporting.models.employers.origin.OriginLogs;

import javax.persistence.AttributeConverter;

/**
 * Created by Faizan on 8/22/2016.
 */
public class OriginConverter implements AttributeConverter<OriginLogs, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(OriginLogs object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public OriginLogs convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, OriginLogs.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
