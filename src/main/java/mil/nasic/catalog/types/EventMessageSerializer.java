package mil.nasic.catalog.types;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EventMessageSerializer extends JsonSerializer<EventMessage> {

	@Override
	public void serialize(EventMessage value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();

		jgen.writeObjectField("header", value.getHeader());
		jgen.writeObjectField(value.getEvent().getType(), value.getEvent());

		jgen.writeEndObject();
	}

}
