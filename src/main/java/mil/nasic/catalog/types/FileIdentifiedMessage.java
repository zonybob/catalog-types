package mil.nasic.catalog.types;

@MessageType(type = FileIdentifiedMessage.NAME)
public class FileIdentifiedMessage {

	public static final String NAME = "fileIdentified";

	private String dataType;

	private Source source;

	public FileIdentifiedMessage() {

	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
