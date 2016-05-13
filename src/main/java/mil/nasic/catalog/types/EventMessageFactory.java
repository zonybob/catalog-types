package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;

public class EventMessageFactory {


	public static EventMessage createCatalogMessage(EventHeader header, CatalogRecord record) {
		return createEventMessage(header, new CatalogEvent(record));
	}

	public static EventMessage createEventMessage(EventHeader header, Event event) {
		return new EventMessage(header, event);
	}

}
