package tkt_booking;

import java.time.LocalTime;

public class ShowTime {
	private int id;
	private int screenId;
	private LocalTime showTime;
	private int isActive;
	private int currentMovieId;

	public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public int getScreenId() {
	return screenId;
	}

	public void setScreenId(int screenId) {
	this.screenId = screenId;
	}

	public LocalTime getShowTime() {
	return showTime;
	}

	public void setShowTime(LocalTime showTime) {
	this.showTime = showTime;
	}

	public int getIsActive() {
	return isActive;
	}

	public void setIsActive(int isActive) {
	this.isActive = isActive;
	}

	public int getCurrentMovieId() {
	return currentMovieId;
	}

	public void setCurrentMovieId(int currentMovieId) {
	this.currentMovieId = currentMovieId;
	}
}
