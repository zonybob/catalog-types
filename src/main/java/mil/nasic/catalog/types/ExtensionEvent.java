package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Support for other types.  This enables an old version of the catalog-types to 
 * be able to serialize and deserialize events it has no knowledge of. 
 * @author jcstewart
 *
 */
public final class ExtensionEvent extends Event{

	private String typeName;

	@JsonIgnore
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
