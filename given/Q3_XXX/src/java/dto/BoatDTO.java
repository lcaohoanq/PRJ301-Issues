package dto;

public class BoatDTO {

	private String boatID;
	private String boatName;
	private int seat;
	private int booked;
	private String departPlaceName;
	private String ticketName;

	// Getters and Setters
	public String getBoatID() {
		return boatID;
	}

	public void setBoatID(String boatID) {
		this.boatID = boatID;
	}

	public String getBoatName() {
		return boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getBooked() {
		return booked;
	}

	public void setBooked(int booked) {
		this.booked = booked;
	}

	public String getDepartPlaceName() {
		return departPlaceName;
	}

	public void setDepartPlaceName(String departPlaceName) {
		this.departPlaceName = departPlaceName;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	@Override
	public String toString() {
		return "BoatDTO{" + "boatID=" + boatID + ", boatName=" + boatName + ", seat=" + seat + ", booked=" + booked + ", departPlaceName=" + departPlaceName + ", ticketName=" + ticketName + '}';
	}

}
