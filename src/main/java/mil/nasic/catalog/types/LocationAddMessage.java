package mil.nasic.catalog.types;

@MessageType(type = LocationAddMessage.NAME)
public class LocationAddMessage {
	public static final String NAME = "location_add";

	private String id;

	private Location from;

	private Location location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Location getFrom() {
		return from;
	}

	public void setFrom(Location from) {
		this.from = from;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
