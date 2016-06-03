package mil.nasic.catalog.types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class MessageEnvelopeDeserializer extends JsonDeserializer<MessageEnvelope> {

	private static final Logger log = LoggerFactory.getLogger(MessageEnvelopeDeserializer.class);

	@Override
	public MessageEnvelope deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		MessageEnvelope me = new MessageEnvelope();

		Iterator<String> fields = node.fieldNames();
		while (fields.hasNext()) {
			String fieldName = fields.next();

			if (fieldName.equals("header")) {
				me.setHeader(oc.treeToValue(node.get("header"), Header.class));
			} else if (fieldName.equals("schemaVersion")) {
				me.setSchemaVersion(oc.treeToValue(node.get("schemaVersion"), String.class));
			} else if (fieldName.equals("history")) {
				ArrayNode arraynode = (ArrayNode) node.get("history");
				Iterator<JsonNode> hist = arraynode.iterator();
				while (hist.hasNext()) {
					JsonNode childMe = hist.next();
					me.addHistory(oc.treeToValue(childMe, MessageEnvelope.class));
				}
			} else {
				Class evClazz = MessageTypeRegistry.getClassForType(fieldName);
				if (evClazz == null) {
					log.warn("unknown message type " + fieldName);
					me.addMessage(fieldName, oc.treeToValue(node.get(fieldName), Object.class));
					continue;
				}
				Object event = oc.treeToValue(node.get(fieldName), evClazz);
				me.addMessage(fieldName, event);

			}

		}

		return me;
	}

}
