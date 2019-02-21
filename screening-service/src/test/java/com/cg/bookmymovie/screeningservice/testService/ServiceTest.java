package com.cg.bookmymovie.screeningservice.testService;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;
import com.cg.bookmymovie.screeningservice.entity.Seat;
import com.cg.bookmymovie.screeningservice.service.ScreeningService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceTest {

	@Autowired
	private ScreeningService service;

	Screening screening;

	@Test
	@Ignore
	public void addScreeningSuccessfullyTest() {
		Map<Integer, Seat> seat = new HashMap<Integer, Seat>();
		seat.put(1, new Seat("gold", 'A', 1, true, 200.0));
		seat.put(2, new Seat("gold", 'A', 2, true, 200.0));
		seat.put(3, new Seat("gold", 'A', 3, true, 200.0));

		seat.put(4, new Seat("silver", 'B', 1, true, 100.0));
		seat.put(5, new Seat("silver", 'B', 2, true, 100.0));
		seat.put(6, new Seat("silver", 'B', 3, true, 100.0));

		LocalTime movieDuration = LocalTime.of(2, 0);
		screening = new Screening(22, "thackeray", movieDuration, "thriller", "hindi",
				"https://github.com/book-movie/images/blob/master/thackeray-the-film-2019.jpg?raw=true", "Inox",
				new Address("rajasthan", "jaipur", "pratap nagar"), "alpha", LocalTime.of(9, 0),
				LocalDate.of(2019, 02, 22), true, seat);

		assertEquals(true, service.addScreening(screening));
	}

	@Test
	public void addScreeningWhenThereIsAlreadyAScreeningAtThatTimeFailedTest() {
		Map<Integer, Seat> seat = new HashMap<Integer, Seat>();
		seat.put(1, new Seat("gold", 'A', 1, true, 200.0));
		seat.put(2, new Seat("gold", 'A', 2, true, 200.0));
		seat.put(3, new Seat("gold", 'A', 3, true, 200.0));

		seat.put(4, new Seat("silver", 'B', 1, true, 100.0));
		seat.put(5, new Seat("silver", 'B', 2, true, 100.0));
		seat.put(6, new Seat("silver", 'B', 3, true, 100.0));

		LocalTime movieDuration = LocalTime.of(2, 0);
		Screening screeningOne = new Screening(23, "thackeray", movieDuration, "thriller", "hindi",
				"https://github.com/book-movie/images/blob/master/thackeray-the-film-2019.jpg?raw=true", "Inox",
				new Address("rajasthan", "jaipur", "pratap nagar"), "alpha", LocalTime.of(10, 0),
				LocalDate.of(2019, 02, 22), true, seat);
		assertEquals(false, service.addScreening(screeningOne));
	}

	@Test
	@Ignore
	public void getAllScreeningTest() {
		assertEquals(1, service.getAllScreenings().size());
	}

//Get screening by id test	
	/*
	 * @Test public void getScreeningByIdWithValidIdTest() {
	 * assertEquals(1,service.getScreeningById(1).get().getScreeningId()); }
	 * 
	 * @Test public void getScreeningByIdWithInValidIdTest() {
	 * assertEquals(null,service.getScreeningById(10)); }
	 */

	@Test
	@Ignore
	public void deleteSreeningByIdWhenScreeningToRemoveExistTest() {
		assertEquals(true, service.removeScreeningById(1));
	}

	@Test
	public void deleteScreeningByIdWhenScreeningToRemoveNotExist() {
		assertEquals(false, service.removeScreeningById(102));
	}
}
