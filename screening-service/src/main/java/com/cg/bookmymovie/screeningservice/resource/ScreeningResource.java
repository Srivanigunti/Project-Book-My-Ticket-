package com.cg.bookmymovie.screeningservice.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;
import com.cg.bookmymovie.screeningservice.service.ScreeningService;

@RestController("/screenings")
public class ScreeningResource {

	@Autowired
	private ScreeningService service;

	@GetMapping
	public ResponseEntity<List<Screening>> getAllScreening() {

		List<Screening> screens = service.getAllScreenings();
		return new ResponseEntity<>(screens, HttpStatus.OK);
	}

	@GetMapping("/specific")
	public ResponseEntity<List<Screening>> getParticularScreening(@RequestParam String state, @RequestParam String city,
			@RequestParam String area, @RequestParam String theatreName, @RequestParam String auditoriumName,
			@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,
			@RequestParam @DateTimeFormat(iso = ISO.TIME) LocalTime time) {

		Address address = new Address();
		address.setState(state);
		address.setCity(city);
		address.setArea(area);

		List<Screening> screens = service.getSpecificScreening(address, theatreName, auditoriumName, date, time);

		return new ResponseEntity<List<Screening>>(screens, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity addNewScreening(@RequestBody Screening newScreening) {
		System.out.println("hello");
		boolean result = service.addScreening(newScreening);
		if (result == true)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping
	public void updateScreening(@RequestBody Screening screening) {
		service.updateScreening(screening);
	}

	@DeleteMapping("/{screeningId}")
	public void removeScreening(@PathVariable int screeningId) {
		service.removeScreeningById(screeningId);
	}
}
