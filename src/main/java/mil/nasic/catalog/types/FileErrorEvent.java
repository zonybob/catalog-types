package mil.nasic.catalog.types;

public class FileErrorEvent extends Event{

	private String uri;

	private String message;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
