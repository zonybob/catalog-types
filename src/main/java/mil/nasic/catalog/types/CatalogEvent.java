
package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Phase 1 version of the catalog message event
 * 
 * @author Joel
 *
 */
@JsonDeserialize(using = CatalogEventDeserializer.class)
public class CatalogEvent extends Event {

    @JsonUnwrapped
    private CatalogRecord catalog;

    public CatalogEvent() {
        setType(Event.CATALOG);
    }

    public CatalogRecord getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogRecord catalog) {
        this.catalog = catalog;
    }

}
