package com.cg.bookmymovie.movie.movie.testServices;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.movie.movie.entity.Cast;
import com.cg.bookmymovie.movie.movie.entity.Crew;
import com.cg.bookmymovie.movie.movie.entity.Movie;
import com.cg.bookmymovie.movie.movie.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestCaseOfServices {
	@Autowired(required = true)
	MovieService movieService;

	Movie movie2, movie3;

	@Before
	public void input() {

		List<Cast> castList = new ArrayList<Cast>();
		List<Crew> crewList = new ArrayList<Crew>();

		castList.add(new Cast("Vicky Kaushal",
				"Vicky Kaushal is an Indian actor who is best "
						+ "remembered for his performance in award-winning movie Masaan in 2015 for which "
						+ "he won the IIFA Award for Best Male Debut.\n",
				"ACTOR", "hhtp://something", LocalDate.now()));

		castList.add(new Cast("Yami Gautam",
				"Born on 28th November 1988, Yami Gautam is an Indian "
						+ "film and TV actress who mainly appears in Hindi cinema.",
				"ACTOR", "hhtp://something", LocalDate.now()));

		crewList.add(new Crew("Aditya Dhar",
				"Starting off as a lyricist in Bollywood, Aditya Dhar"
						+ " has lent his creative genius to Kabul Express (2006) and has also written the"
						+ " dialogue for Priyadarshan's Aakrosh (2010) and Tezz (2012).",
				"DIRECTOR", "hhtp://something", LocalDate.now()));

		crewList.add(new Crew("Ronnie's ",
				"The founder of media conglomerate UTV Software "
						+ "Communications and one of the biggest names in film production and distribution",
				"PRODUCER", "hhtp://something", LocalDate.now()));

		movie2 = new Movie(109, "BAJIGAR", "Hema",
				"URI chronicles the events of the surgical strike conducted " + "by the Indian military",
				LocalTime.of(2, 45), LocalDate.of(2019, Month.AUGUST, 13), castList, crewList);

		movie3 = new Movie(110, "2.0", "RamaKrishnan",
				"2.0 is superHero Robot Based Film which is sequel of Robot",
				LocalTime.of(2, 45), LocalDate.of(2019, Month.AUGUST, 13), castList, crewList);
	}

	@Test
	@Ignore
	public void testGetMoviesByWrongMovieName() {
		assertEquals(null , movieService.findMovieByName("Rocky"));
	}

	
	@Test
	@Ignore
	public void testGetMoviesByRightMovieName() {
		assertEquals(movieService.findMovieByName("BAJIGAR").get().getMovieName(), movie2.getMovieName());
	}
	
	@Test
	@Ignore
	public void testgetAllMoviesSize() {
		assertEquals(1, movieService.getAllMovie().size());
	}

	@Test
	//@Ignore
	public void testAddNewMovies() {
		movieService.addNewMovie(movie2);
		assertEquals("Hema", movieService.findMovieByName("BAJIGAR").get().getDirector());
	}
	
	@Test
	@Ignore
	public void testDeleteMovies() {
		movieService.deleteMovies(movie3);
		assertEquals(null, movieService.findMovieByName("2.0"));
	}
	
	@Test
	@Ignore
	public void testUpdateMoviesServices() {
		LocalDate releaseDate = LocalDate.of(2019, Month.MARCH, 25);
		movie3.setReleaseDate(releaseDate);
		movieService.addNewMovie(movie3);
		assertEquals(releaseDate, movieService.findMovieByName("2.0").get().getReleaseDate());
	}
	
}
