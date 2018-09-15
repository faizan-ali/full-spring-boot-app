package workamerica.contexts.reporting.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import workamerica.contexts.reporting.models.employers.activity.ActivityLogsList;

import javax.persistence.AttributeConverter;

/**
 * Created by Faizan on 8/22/2016.
 */
public class ActivityLogListConverter implements AttributeConverter<ActivityLogsList, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ActivityLogsList object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public ActivityLogsList convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, ActivityLogsList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
