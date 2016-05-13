package mil.nasic.catalog.types;

@EventType(type = "location_add")
public class LocationAddEvent extends Event {

	private Location location;

	public LocationAddEvent() {

	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
