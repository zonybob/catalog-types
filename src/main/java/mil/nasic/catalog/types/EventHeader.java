package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class EventHeader {

	private DateTime time;
	private String id;
	private ProducerInfo producer;
	private Map<String, Object> ext = new HashMap();

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProducerInfo getProducer() {
		return producer;
	}

	public void setProducer(ProducerInfo producer) {
		this.producer = producer;
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
