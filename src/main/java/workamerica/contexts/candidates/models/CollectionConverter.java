package workamerica.contexts.candidates.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import workamerica.contexts.candidates.entities.CandidateField;

import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * Created by Faizan on 8/22/2016.
 */
public class CollectionConverter implements AttributeConverter<List<CandidateField>, String> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<CandidateField> object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<CandidateField> convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, new TypeReference<List<CandidateField>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
