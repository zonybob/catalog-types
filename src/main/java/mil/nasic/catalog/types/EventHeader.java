package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class EventHeader {

	private DateTime time;
	private String guid;
	private List<String> parent_id = new ArrayList();
	private ProducerInfo producer;
	private Map<String, Object> ext = new HashMap();

	public EventHeader() {
		super();
	}

	public EventHeader(DateTime time, String guid, List<String> parent_id, ProducerInfo producer,
			Map<String, Object> ext) {
		super();
		this.time = time;
		this.guid = guid;
		this.parent_id = parent_id;
		this.producer = producer;
		this.ext = ext;
	}

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public List<String> getParent_id() {
		return parent_id;
	}

	public void addParentId(String id) {
		parent_id.add(id);
	}

	public void setParent_id(List<String> parent_id) {
		this.parent_id = parent_id;
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

	public static class Builder {
		private DateTime time = new DateTime();
		private String guid = UUID.randomUUID().toString();
		private List<String> parent_id = new ArrayList();
		private ProducerInfo.Builder producer = new ProducerInfo.Builder();
		private Map<String, Object> ext = new HashMap();

		public EventHeader build() {
			return new EventHeader(time, guid, parent_id, producer.build(), ext);
		}

		public EventHeader.Builder parent_id_from(EventHeader trigger) {
			parent_id = new ArrayList(trigger.getParent_id());
			parent_id.add(trigger.getGuid());
			return this;
		}

		public EventHeader.Builder addParentID(String id) {
			parent_id.add(id);
			return this;
		}

		public EventHeader.Builder parent_id(List<String> parents) {
			parent_id = parents;
			return this;
		}

		public EventHeader.Builder guid(String id) {
			guid = id;
			return this;
		}

		public EventHeader.Builder time(DateTime time) {
			this.time = time;
			return this;
		}

		public EventHeader.Builder ext(String key, Object value) {
			this.ext.put(key, value);
			return this;
		}

		public EventHeader.Builder producer(ProducerInfo.Builder producer) {
			this.producer = producer;
			return this;
		}
		
		public EventHeader.Builder producername(String name) {
			producer.name(name);
			return this;
		}

		public EventHeader.Builder producernode(String node) {
			producer.node(node);
			return this;
		}

		public EventHeader.Builder producerversion(String version) {
			producer.version(version);
			return this;
		}

	}

}
