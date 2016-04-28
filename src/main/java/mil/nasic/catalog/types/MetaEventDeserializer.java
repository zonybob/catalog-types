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

public class MetaEventDeserializer extends JsonDeserializer<MetaEvent> {

	@Override
	public MetaEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		Meta meta = oc.treeToValue(node, Meta.class);

		MetaEvent me = new MetaEvent();
		me.setMeta(meta);
		me.setType("meta");

		return me;
	}
}