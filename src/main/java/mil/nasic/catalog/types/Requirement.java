package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

/**
 * 
 * @author jcstewart
 * @since 0.4
 */
public class Requirement {

	private String system;
	private String id;
	private Map<String, Object> ext = new HashMap();

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
