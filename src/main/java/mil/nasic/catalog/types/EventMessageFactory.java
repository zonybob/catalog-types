package mil.nasic.catalog.types;

public class EventMessageFactory {

    public static EventMessage createCatalogMessage(EventHeader header, CatalogRecord record) {
        return createEventMessage(header, new CatalogEvent(record));
    }

    public static EventMessage createEventMessage(EventHeader header, Event event) {
        return new EventMessage(header, event);
    }

}
