package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MessageEnvelopeDeserializer.class)
public class MessageEnvelope {
	private String schemaVersion;
	private Header header;
	private List<MessageEnvelope> history = new ArrayList();

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	/**
	 * 
	 */
	private Map<String, Object> messages = new HashMap();

	@JsonAnyGetter
	public Map<String, Object> getMessages() {
		return messages;
	}

	@JsonAnySetter
	public void addMessage(String key, Object value) {
		messages.put(key, value);
	}

	public String getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public List<MessageEnvelope> getHistory() {
		return history;
	}

	public void setHistory(List<MessageEnvelope> history) {
		this.history = history;
	}

	public void addHistory(MessageEnvelope me) {
		history.add(me);
	}
}
