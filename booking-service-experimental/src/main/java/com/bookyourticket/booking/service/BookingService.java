package com.bookyourticket.booking.service;

import java.util.List;
import java.util.Optional;

import com.bookyourticket.booking.entity.Booking;

public interface BookingService {
	List<Booking> getAllBookings();

	void addBooking(Booking booking);

	void deleteBooking(int bookingId);

	List<Booking> getBookingById(int bookingId); 
//	public Booking getBookingById(int bookingId);
}
