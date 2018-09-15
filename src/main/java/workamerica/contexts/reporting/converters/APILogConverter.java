package workamerica.contexts.reporting.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import workamerica.contexts.reporting.models.employers.api.CompanyAccountAPILogs;

import javax.persistence.AttributeConverter;

/**
 * Created by Faizan on 8/22/2016.
 */
public class APILogConverter implements AttributeConverter<CompanyAccountAPILogs, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(CompanyAccountAPILogs object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public CompanyAccountAPILogs convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, CompanyAccountAPILogs.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
