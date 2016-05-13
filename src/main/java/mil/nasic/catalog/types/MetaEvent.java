package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MetaEventDeserializer.class)
@EventType(type = "meta")
public class MetaEvent extends Event {

	@JsonUnwrapped
	private Meta meta;

	public MetaEvent() {
		
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}
