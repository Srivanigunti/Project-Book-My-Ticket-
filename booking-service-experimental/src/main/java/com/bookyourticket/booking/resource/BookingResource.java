package com.bookyourticket.booking.resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourticket.booking.entity.Booking;
import com.bookyourticket.booking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingResource {
	
	@Autowired
	private BookingService service;
		
	@GetMapping
	public List<Booking> getAllBookings() {
		return service.getAllBookings();
	}
	
	@PostMapping
	public ResponseEntity createBooking(@RequestBody Booking booking) {
		service.addBooking(booking);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookingId}")
	public void deleteAccount(@PathVariable int bookingId) {
		service.deleteBooking(bookingId);
	}
	
	@GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getBookingById(@PathVariable int userId) {
		
		List<Booking> bookings = service.getBookingById(userId);
		if(bookings.size() == 0)
			return new ResponseEntity<List<Booking>>(bookings, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK); 
    }
}
