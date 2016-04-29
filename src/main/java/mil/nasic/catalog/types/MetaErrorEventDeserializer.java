package mil.nasic.catalog.types;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class MetaErrorEventDeserializer extends JsonDeserializer<MetaErrorEvent> {

	@Override
	public MetaErrorEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		ErrorInfo err = oc.treeToValue(node, ErrorInfo.class);

		MetaErrorEvent merr = new MetaErrorEvent();
		merr.setError(err);

		return merr;
	}
}