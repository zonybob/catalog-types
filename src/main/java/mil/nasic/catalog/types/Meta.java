package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geojson.GeoJsonObject;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Meta {

	private DateTime start;
	private DateTime end;
	private List<String> tags = new ArrayList();
	private List<GeoJsonObject> geom = new ArrayList();
	private Classification classification;

	private Map<String, Object> ext = new HashMap();

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public List<String> getTags() {
		return tags;
	}

	public void addTags(String tag) {
		tags.add(tag);
	}

	public List<GeoJsonObject> getGeom() {
		return geom;
	}

	public void addGeom(GeoJsonObject geo) {
		geom.add(geo);
	}	

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

}
