package com.cg.bookmymovie.booking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;


public class Booking {
	private Integer bookingId;
	
	private Integer userId;
	private String movieName;
	private String theatreName;
	private Address theareAddress;
	private LocalDate date;
	private LocalTime time;
	private Map<String, Map<Integer,Character>> seat;
	private Double price;
	
	public Booking() {
	}

	public Booking(Integer bookingId, Integer userId, String movieName, String theatreName, Address theareAddress,
			LocalDate date, LocalTime time, Map<String, Map<Integer, Character>> seat, Double price) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.theareAddress = theareAddress;
		this.date = date;
		this.time = time;
		this.seat = seat;
		this.price = price;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Address getTheareAddress() {
		return theareAddress;
	}

	public void setTheareAddress(Address theareAddress) {
		this.theareAddress = theareAddress;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Map<String, Map<Integer, Character>> getSeat() {
		return seat;
	}

	public void setSeat(Map<String, Map<Integer, Character>> seat) {
		this.seat = seat;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", movieName=" + movieName + ", theatreName="
				+ theatreName + ", theareAddress=" + theareAddress + ", date=" + date + ", time=" + time + ", seat="
				+ seat + ", price=" + price + "]";
	}

	

}