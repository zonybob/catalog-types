package mil.nasic.catalog.types;

public class MetaErrorEvent extends Event {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
