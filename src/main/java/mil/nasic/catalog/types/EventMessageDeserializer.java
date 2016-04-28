package mil.nasic.catalog.types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class EventMessageDeserializer extends JsonDeserializer<EventMessage> {

	private static final Map<String, Class<? extends Event>> typeMap = new HashMap();

	static {
		typeMap.put(Event.FILE_IDENTIFIED, FileIdentifiedEvent.class);
		typeMap.put(Event.META, MetaEvent.class);
	}

	@Override
	public EventMessage deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		Iterator<String> fields = node.fieldNames();
		List<String> fieldNames = new ArrayList();
		while (fields.hasNext()) {
			fieldNames.add(fields.next());
		}

		// validate
		if (!fieldNames.contains("header")) {
			throw new IllegalArgumentException("event message does not contain header");
		} else if (fieldNames.size() != 2) {
			throw new IllegalArgumentException("event message may only contain 1 event");
		}

		fieldNames.remove("header");

		// create event message
		EventMessage em = new EventMessage();
		EventHeader header = oc.treeToValue(node.get("header"), EventHeader.class);
		em.setHeader(header);

		String eventType = fieldNames.get(0);
		Event event = null;

		if (typeMap.containsKey(eventType)) {
			event = oc.treeToValue(node.get(eventType), typeMap.get(eventType));
		} else {
			// Extension Event
			event = oc.treeToValue(node.get(eventType), Event.class);
		}

		event.setType(eventType);
		em.setEvent(event);

		return em;
	}
}
