package com.cg.bookmymovie.screeningservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

public interface ScreeningService {

//	List<Screening> getScreenings(Address theatreAddress, String theatreName, String auditoriumName, LocalDate date);

	List<Screening> getAllScreenings();

	boolean addScreening(Screening newScreening);

	boolean removeScreeningById(int screeningId);

	List<Screening> getSpecificScreening(Address address, String theatreName, String auditoriumName, LocalDate date, LocalTime time);

	boolean updateScreening(Screening screening);

}
