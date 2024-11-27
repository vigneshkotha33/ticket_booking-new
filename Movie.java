package tkt_booking;

import java.time.LocalTime;
import java.util.Date;

public class Movie {
	private int id;
	private String movieTitle;
	private LocalTime duration;
	private double rating;
	private Date releaseDate;
	private String audioLanguage;

	public Movie(String movieName, String screenName, String showTime, String location) {
		
	}

	public Movie(int id, String movieTitle, LocalTime duration, double rating, Date releaseDate, String audioLanguage) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.duration = duration;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.audioLanguage = audioLanguage;
	}

	public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public String getMovieTitle() {
	return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
	}

	public LocalTime getDuration() {
	return duration;
	}

	public void setDuration(LocalTime duration) {
	this.duration = duration;
	}

	public double getRating() {
	return rating;
	}

	public void setRating(double rating) {
	this.rating = rating;
	}

	public Date getReleaseDate() {
	return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
	}

	public String getAudioLanguage() {
	return audioLanguage;
	}

	public void setAudioLanguage(String audioLanguage) {
	this.audioLanguage = audioLanguage;
	}

	public String getscreenName() {
		return null;
	}

	public String getShowTime() {
		return null;
	}

	

	

	

	
}
