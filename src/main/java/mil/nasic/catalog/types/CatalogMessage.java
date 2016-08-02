
package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Phase 1 version of the catalog message event
 * 
 * @author Joel
 *
 */
@MessageType(type = CatalogMessage.NAME)
public class CatalogMessage {

	public static final String NAME = "catalog";

	public CatalogMessage() {
	}

	private String id;

	private String version;

	private String dataType;

	private Meta meta;

	private List<Location> locations = new ArrayList();

	private Map<String, Object> ext = new HashMap();

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

	public void addLocations(Location location) {
		locations.add(location);
	}

	public String getDataType() {
		return dataType;
	}

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	public String getId() {
		return id;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
