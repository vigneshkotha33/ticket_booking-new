package tkt_booking;

public class BookingStatus {
	private int id;
	private String bookingStatusCode;
	private String description;
	private String displayName;

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getBookingStatusCode() {
	    return bookingStatusCode;
	}

	public void setBookingStatusCode(String bookingStatusCode) {
	    this.bookingStatusCode = bookingStatusCode;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public String getDisplayName() {
	    return displayName;
	}

	public void setDisplayName(String displayName) {
	    this.displayName = displayName;
	}

}
