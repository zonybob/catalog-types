package mil.nasic.catalog.types;

@MessageType(type = NewDataMessage.NAME)
public class NewDataMessage {

	public static final String NAME = "new_data";
	
	private long version;

	private CatalogRecord document;

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public CatalogRecord getDocument() {
		return document;
	}

	public void setDocument(CatalogRecord document) {
		this.document = document;
	}

}
