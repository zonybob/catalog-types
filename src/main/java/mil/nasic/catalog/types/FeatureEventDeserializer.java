package mil.nasic.catalog.types;

import java.io.IOException;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class FeatureEventDeserializer extends JsonDeserializer<FeatureEvent> {

	@Override
	public FeatureEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		FeatureEvent fev = new FeatureEvent();

		GeoJsonObject obj = oc.treeToValue(node, GeoJsonObject.class);
		if (obj instanceof FeatureCollection) {
			FeatureCollection fcoll = (FeatureCollection) obj;
			fev.setFeatures(fcoll);
		} else {
			Feature f = (Feature) obj;
			fev.setFeature(f);
		}

		return fev;
	}
}