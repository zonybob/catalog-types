package mil.nasic.catalog.types;

@EventType(type = "location_remove")
public class LocationRemoveEvent extends Event{
	
	private Location location;

	public LocationRemoveEvent(){
		
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
