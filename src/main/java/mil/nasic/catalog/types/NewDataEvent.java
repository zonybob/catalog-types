package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = NewDataEventDeserializer.class)
@EventType(type = "new_data")
public class NewDataEvent extends Event {

	@JsonUnwrapped
	private CatalogRecord catalog;

	public NewDataEvent() {

	}

	public CatalogRecord getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogRecord catalog) {
		this.catalog = catalog;
	}
}
