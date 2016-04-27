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

public class Event {

	public static final String FILE_IDENTIFIED = "file_identified";
	public static final String FILE_ERROR = "file_error";
	public static final String META_EXTENSION_SUFFIX = "_meta";
	public static final String META_ERROR_EXTENSION_SUFFIX = "_meta_error";

	private EventHeader header;

	@JsonProperty(Event.FILE_IDENTIFIED)
	@JsonInclude(Include.NON_NULL)
	private FileIdentified fileIdentified;

	/**
	 * Support arbitrary json events...
	 */
	private Map<String, Object> ext = new HashMap();

	/**
	 * Splits the Event into a list of events containing a single event. Used
	 * when Event is a payload of multiple events to get each as an individual
	 * event.
	 * 
	 * @return
	 */
	public List<Event> splitEvent() {
		List<Event> evs = new ArrayList();

		if (fileIdentified != null) {
			Event ev = new Event();
			ev.setHeader(header);
			evs.add(ev);
		}

		for (String key : ext.keySet()) {
			Event ev = new Event();
			ev.setHeader(header);
			ev.add(key, ext.get(key));
			evs.add(ev);
		}

		return evs;
	}

	public boolean hasExtensionMeta() {
		for (String key : ext.keySet()) {
			if (key.endsWith(META_EXTENSION_SUFFIX)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasExtensionMetaError() {
		for (String key : ext.keySet()) {
			if (key.endsWith(META_ERROR_EXTENSION_SUFFIX)) {
				return true;
			}
		}
		return false;
	}

	public EventHeader getHeader() {
		return header;
	}

	public void setHeader(EventHeader header) {
		this.header = header;
	}

	public FileIdentified getFileIdentified() {
		return fileIdentified;
	}

	public void setFileIdentified(FileIdentified fileIdentified) {
		this.fileIdentified = fileIdentified;
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
