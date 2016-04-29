package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MetaErrorEventDeserializer.class)
public class MetaErrorEvent extends Event {

	@JsonUnwrapped
	private ErrorInfo error;

	public ErrorInfo getError() {
		return error;
	}

	public void setError(ErrorInfo error) {
		this.error = error;
	}

}
