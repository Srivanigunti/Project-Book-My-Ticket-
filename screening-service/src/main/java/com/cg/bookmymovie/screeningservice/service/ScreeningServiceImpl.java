package com.cg.bookmymovie.screeningservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmymovie.screeningservice.Repository.ScreeningRespository;
import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

@Service
public class ScreeningServiceImpl implements ScreeningService {

	@Autowired
	private ScreeningRespository repository;

	@Override
	public boolean addScreening(Screening newScreening) {
		boolean flag = false;

		List<Screening> screeningMovieInAAuditorium = repository
				.findScreeningByTheatreAddressAndTheatreNameAndAuditoriumNameAndDate(newScreening.getTheatreAddress(),
						newScreening.getTheatreName(), newScreening.getAuditoriumName(), newScreening.getDate());
		System.out.println(screeningMovieInAAuditorium.size());

		if (screeningMovieInAAuditorium.size() == 0) {
			System.out.println("no screening to conflict");

			List<Screening> screeningsList = repository
					.findScreeningByTheatreAddressAndTheatreNameAndDateAndAuditoriumNameNotLike(
							newScreening.getTheatreAddress(), newScreening.getTheatreName(), newScreening.getDate(),
							newScreening.getAuditoriumName());
			
			if (screeningsList.size() == 0) {
				repository.save(newScreening);
				return true;
			}

			for (Screening screening : screeningsList) {
				if (newScreening.getStartTime().isAfter((screening.getStartTime().plusMinutes(29)))) {
					repository.save(newScreening);
					return true;
				}
			}

			return false;

		} else {
			for (Screening screening : screeningMovieInAAuditorium) {
				System.out.println("hiii");
				if (newScreening.getStartTime()
						.isBefore((screening.getStartTime()).plusHours(screening.getMovieDuration().getHour())
								.plusMinutes(screening.getMovieDuration().getMinute()).plus(1, ChronoUnit.HOURS))) {

					System.out.println("there is a movie at time: "
							+ (screening.getStartTime()).plusHours(screening.getMovieDuration().getHour())
									.plusMinutes(screening.getMovieDuration().getMinute()).plus(1, ChronoUnit.HOURS));
					flag = true;
				}

			}
			if (flag == true) {
				System.out.println("hello bro");
				return false;
			} else {
				System.out.println("let's check for other audi");
				List<Screening> screeningsList = repository
						.findScreeningByTheatreAddressAndTheatreNameAndDateAndAuditoriumNameNotLike(
								newScreening.getTheatreAddress(), newScreening.getTheatreName(), newScreening.getDate(),
								newScreening.getAuditoriumName());
				System.out.println("got the list to ckeck");

				if (screeningsList.size() == 0) {
					repository.save(newScreening);
					return true;
				}
				
				for (Screening screening : screeningsList) {
					if (newScreening.getStartTime().isAfter((screening.getStartTime().plusMinutes(29)))) {
						repository.save(newScreening);
						return true;
					}
				}
				return false;
			}
		}
	}

	@Override
	public List<Screening> getAllScreenings() {
		return repository.findAll();
	}

	@Override
	public List<Screening> getSpecificScreening(Address address, String theatreName, String auditoriumName,
			LocalDate date, LocalTime time) {
		System.out.println(theatreName + " " + auditoriumName + " " + date + " " + time);
		Screening screening = repository.findScreeningByTheatreNameAndAuditoriumNameAndDateAndStartTime(theatreName,
				auditoriumName, date, time);
		System.out.println(screening.getAuditoriumName());
		return null;
	}

	@Override
	public boolean removeScreeningById(int screeningId) {
		if (repository.existsById(screeningId)) {

			Optional<Screening> screeningToRemove = repository.findById(screeningId);
			if (screeningToRemove.get().isShowing() == true)
				return false;

			repository.deleteById(screeningId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateScreening(Screening screening) {
		repository.save(screening);
		return true;
	}

}