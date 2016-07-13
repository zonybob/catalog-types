package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.List;

@MessageType(type = LocationRemoveMessage.NAME)
public class LocationRemoveMessage {
	public static final String NAME = "location_remove";

	private String id;

	private List<Location> locations = new ArrayList();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void addLocation(Location location) {
		locations.add(location);
	}

}
