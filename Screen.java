package tkt_booking;

public class Screen {
	private int id;
	private String screenName;
	private String location;
	private String city;
	private String state;
	private String country;
	private int seatingCapacity;

	public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public String getScreenName() {
	return screenName;
	}

	public void setScreenName(String screenName) {
	this.screenName = screenName;
	}

	public String getLocation() {
	return location;
	}

	public void setLocation(String location) {
	this.location = location;
	}

	public String getCity() {
	return city;
	}

	public void setCity(String city) {
	this.city = city;
	}

	public String getState() {
	return state;
	}

	public void setState(String state) {
	this.state = state;
	}

	public String getCountry() {
	return country;
	}

	public void setCountry(String country) {
	this.country = country;
	}

	public int getSeatingCapacity() {
	return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
	this.seatingCapacity = seatingCapacity;
	}
}
