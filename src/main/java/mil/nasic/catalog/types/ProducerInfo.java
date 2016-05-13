package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ProducerInfo {
	private String name;
	private String node;
	private String version;
	private Map<String, Object> ext = new HashMap();

	public ProducerInfo() {
		super();
	}

	public ProducerInfo(String name, String node, String version, Map<String, Object> ext) {
		super();
		this.name = name;
		this.node = node;
		this.version = version;
		this.ext = ext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
		private String name;
		private String node;
		private String version;
		private Map<String, Object> ext = new HashMap();

		public Builder() {
		}

		public ProducerInfo build() {
			return new ProducerInfo(name, node, version, ext);
		}

		public ProducerInfo.Builder name(String name) {
			this.name = name;
			return this;
		}

		public ProducerInfo.Builder node(String node) {
			this.node = node;
			return this;
		}

		public ProducerInfo.Builder version(String version) {
			this.version = version;
			return this;
		}

		public ProducerInfo.Builder ext(String key, Object value) {
			this.ext.put(key, value);
			return this;
		}
	}
}
