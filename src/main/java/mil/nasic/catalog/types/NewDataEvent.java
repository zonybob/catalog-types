package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = NewDataEventDeserializer.class)
public class NewDataEvent extends Event {

    @JsonUnwrapped
    private CatalogRecord catalog;

    public NewDataEvent() {
        setType(Event.CATALOG);
    }

    public CatalogRecord getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogRecord catalog) {
        this.catalog = catalog;
    }
}
