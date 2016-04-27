package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class FileInfo {

	private String file_source;
	private String origin;
	private DateTime discovered_time;

	private Map<String, Object> ext = new HashMap();

	public String getFile_source() {
		return file_source;
	}

	public void setFile_source(String file_source) {
		this.file_source = file_source;
	}


	public DateTime getDiscovered_time() {
		return discovered_time;
	}

	public void setDiscovered_time(DateTime discovered_time) {
		this.discovered_time = discovered_time;
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
