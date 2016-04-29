package mil.nasic.catalog.types;

public class LocationAddEvent extends Event{
	
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

}
