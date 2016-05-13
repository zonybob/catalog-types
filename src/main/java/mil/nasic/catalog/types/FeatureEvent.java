package mil.nasic.catalog.types;

import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = FeatureEventDeserializer.class)
@JsonSerialize(using = FeatureEventSerializer.class)
@EventType(type = "feature")
public class FeatureEvent extends Event {

	private Feature feature;

	private FeatureCollection features;

	public FeatureEvent() {
	
	}

	public FeatureCollection getFeatures() {
		return features;
	}

	public void setFeatures(FeatureCollection features) {
		this.features = features;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

}
