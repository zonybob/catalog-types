package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MetaErrorEventDeserializer.class)
@EventType(type = "meta_error")
public class MetaErrorEvent extends Event {

	@JsonUnwrapped
	private ErrorInfo error;

	public MetaErrorEvent(){
		
	}
	
	public ErrorInfo getError() {
		return error;
	}

	public void setError(ErrorInfo error) {
		this.error = error;
	}

}
