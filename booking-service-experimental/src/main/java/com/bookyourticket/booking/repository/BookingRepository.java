package com.bookyourticket.booking.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookyourticket.booking.entity.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Integer> {

	List<Booking> findBookingByUserId(int userId);
} 
