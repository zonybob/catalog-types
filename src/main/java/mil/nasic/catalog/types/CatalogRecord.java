package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author jcstewart
 */
public class CatalogRecord {

	private String id;

	private String type;

	@JsonInclude(Include.NON_NULL)
	private Meta meta;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("file_error")
	private FileErrorInfo fileError;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("meta_error")
	private ErrorInfo metaError;

	@JsonInclude(Include.NON_EMPTY)
	private List<Location> locations = new ArrayList();

	private Map<String, Object> ext = new HashMap();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void addLocations(Location location) {
		locations.add(location);
	}

	public FileErrorInfo getFileError() {
		return fileError;
	}

	public void setFileError(FileErrorInfo fileError) {
		this.fileError = fileError;
	}

	public ErrorInfo getMetaError() {
		return metaError;
	}

	public void setMetaError(ErrorInfo metaError) {
		this.metaError = metaError;
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
