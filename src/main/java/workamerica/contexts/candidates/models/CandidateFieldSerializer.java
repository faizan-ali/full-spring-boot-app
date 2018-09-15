package workamerica.contexts.candidates.models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import workamerica.contexts.candidates.entities.CandidateField;

import java.io.IOException;
import java.util.List;

/**
 * Created by Faizan on 8/22/2016.
 */
public class CandidateFieldSerializer extends StdSerializer<List<CandidateField>> {

    public CandidateFieldSerializer() {
        this(null);
    }

    public CandidateFieldSerializer(Class<List<CandidateField>> t) {
        super(t);
    }

    @Override
    public void serialize(List<CandidateField> fields, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for (CandidateField field : fields) {
            jgen.writeStartObject();
            jgen.writeNumberField("fieldID", field.getFieldID());
            jgen.writeStringField("name", field.getName());
            jgen.writeBooleanField("current", field.isCurrent());
            jgen.writeEndObject();
        }
        System.out.println("ASDFASDF");
        jgen.writeEndArray();
        jgen.close();
    }
}
