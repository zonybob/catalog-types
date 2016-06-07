
package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Phase 1 version of the catalog message event
 * 
 * @author Joel
 *
 */
@MessageType(type = CatalogMessage.NAME)
public class CatalogMessage {

	public static final String NAME = "catalog";

	private CatalogRecord document;

	public CatalogMessage() {
	}

	public CatalogMessage(CatalogRecord document) {
		super();
		this.document = document;
	}

	public CatalogRecord getDocument() {
		return document;
	}

	public void setDocument(CatalogRecord document) {
		this.document = document;
	}

}
