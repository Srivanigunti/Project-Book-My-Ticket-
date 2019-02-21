package com.cg.bookmymovie.movie.movie.testController;

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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.movie.movie.entity.Cast;
import com.cg.bookmymovie.movie.movie.entity.Crew;
import com.cg.bookmymovie.movie.movie.entity.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestCasesOfController {

	Movie movie;
	Movie movie2;
	Movie movie3;
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Before // Before Annotation is used
	public void input() throws Exception {

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
		movie = new Movie(105, "sun", "Shubham",
				"URI chronicles the events of the surgical strike conducted " + "by the Indian military",
				LocalTime.of(2, 45), LocalDate.of(2019, Month.JANUARY, 11), castList, crewList);

		movie2 = new Movie(101, "BAJIGAR", "Hema",
				"URI chronicles the events of the surgical strike conducted " + "by the Indian military",
				LocalTime.of(2, 45), LocalDate.of(2019, Month.AUGUST, 13), castList, crewList);

		movie3 = new Movie(102, "sun", "Shubham",
				"URI chronicles the events of the surgical strike conducted " + "by the Indian military",
				LocalTime.of(2, 45), LocalDate.of(1999, Month.JUNE, 29), castList, crewList);

	}

	// Test Case With no controller

	@Test
	@Ignore
	public void testnoController() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	// Test Case With without Mapping

	@Test
	@Ignore
	public void testControllerWITHOUTMAPPING() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test // Test Case of Get alL Movie
	public void getALLMovie() {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	// Test Case Of all Movie By Wrong Url

	@Test
	public void getALLMovieByWrongUrl() {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movie", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test // Test Case of MovieByName
	@Ignore
	public void getMovieByName() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/BAJIGAR", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test // Test Case Of MOVIE Name thAT Does not Exist
	public void testGetMovieByNameThatDoesNotExist() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/Rocky", String.class);
		System.out.println(responseEntity.getStatusCode());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test // test Case of Movie by wrong DATAType
	@Ignore
	public void testGetMovieByNameByWrongType() {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/BAJIGA", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test // Test Case Of Add Movies
	//@Ignore
	public void testAddMovies() {

		ResponseEntity responseEntity = testRestTemplate.postForEntity("/movies", movie2, null);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test // Test Cases of Wrong InPUT
	public void testAddMovieswithWrongValue() {
		ResponseEntity responseEntity = testRestTemplate.postForEntity("/movies", movie3, null);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test // Test Cases Of delete the right one Movie
	@Ignore
	public void testDeleteRightOneMovie() {
		testRestTemplate.delete("/movies/BAJIGAR");
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/BAJIGAR", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);

	}

	@Test // Test Cases of Delete the wrong Movie
	//@Ignore
	public void testDeleteInvalidMovie() {
		testRestTemplate.delete("/movies/Rocky");
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/Rocky", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);

	}

	// Update THe right Movie release Date
	@Test
	//@Ignore
	public void testUpdateMovieReleaseDate() {
		testRestTemplate.put("/movies/BAJIGAR?releaseDate=2019-08-08", null);
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/movies/BAJIGAR", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

}
