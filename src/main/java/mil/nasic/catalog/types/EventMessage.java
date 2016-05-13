package mil.nasic.catalog.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = EventMessageDeserializer.class)
@JsonSerialize(using = EventMessageSerializer.class)
public class EventMessage {

	private EventHeader header;

	private Event event;

	public EventMessage() {
		super();
	}

	public EventMessage(EventHeader header, Event event) {
		super();
		this.header = header;
		this.event = event;
	}

	public EventHeader getHeader() {
		return header;
	}

	public void setHeader(EventHeader header) {
		this.header = header;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
