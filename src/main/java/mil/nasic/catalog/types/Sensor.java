package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author jcstewart
 * @since 0.4
 */
public class Sensor {
	private String name;
	@JsonProperty("class")
	private String clazz;
	private String mode;
	private Map<String, Object> ext = new HashMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
