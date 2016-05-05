package mil.nasic.catalog.types;

public class LocationRemoveEvent extends Event{
	
	private Location location;

	public LocationRemoveEvent(){
		setType(Event.LOCATION_REMOVE);
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
