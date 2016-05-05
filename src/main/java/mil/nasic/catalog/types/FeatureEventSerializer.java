package mil.nasic.catalog.types;

import java.io.IOException;

import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FeatureEventSerializer extends JsonSerializer<FeatureEvent> {

	@Override
	public void serialize(FeatureEvent value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		GeoJsonObject jsonObj = value.getFeature();
		if (jsonObj == null ){
			jsonObj = value.getFeatures();
		}
		
		jgen.writeObject(jsonObj);

	}

}
