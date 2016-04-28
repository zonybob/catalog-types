package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Event {

	public static final String FILE_IDENTIFIED = "file_identified";
	public static final String FILE_ERROR = "file_error";
	public static final String META = "meta";
	public static final String META_ERROR = "meta_error";
	public static final String META_EXTENSION_SUFFIX = "_meta";
	public static final String META_ERROR_EXTENSION_SUFFIX = "_meta_error";

	/**
	 * Support arbitrary json events...
	 */
	private Map<String, Object> ext = new HashMap();

	private String type;

	@JsonIgnore
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
