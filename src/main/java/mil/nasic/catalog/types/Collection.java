package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

/**
 * 
 * @author jcstewart
 * @since 0.4
 */
public class Collection {

	private String key;
	private String type;
	private String subType;
	private List<Sensor> sensors = new ArrayList();
	private Map<String, Object> ext = new HashMap();

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

}
