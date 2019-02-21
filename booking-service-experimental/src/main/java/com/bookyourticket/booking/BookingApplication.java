package com.bookyourticket.booking;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.bookyourticket.booking.entity.Booking;
import com.bookyourticket.booking.repository.BookingRepository;
@EnableDiscoveryClient
@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner populateData(BookingRepository repository) {
		return (arg)->{	
			/*
			 * repository.save(new Booking(12, 8900.67, LocalDateTime.now(), true));
			 * repository.save(new Booking(14, 9600.87, null, false)); repository.save(new
			 * Booking(16, 2309.23, LocalDateTime.now(), true));
			 */
		};
	}
}

