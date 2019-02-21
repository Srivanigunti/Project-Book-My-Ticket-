package com.cg.bookmymovie.screeningservice.testRestController;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

	private Screening screening;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Before
	public void setUp() {
		Map<String, Double> priceBySeat = new HashMap<String, Double>();
		priceBySeat.put("front", 100.0);
		priceBySeat.put("middle", 150.0);
		priceBySeat.put("back", 200.0);
		LocalTime movieDuration = LocalTime.of(2,0);
//TODO		screening = new Screening(1,"URI", movieDuration,"thriller","hindi", "abc","Inox",new Address("Maharashtra","mumbai","thane"),"beta",LocalTime.of(10, 30),LocalDate.of(2019, 02, 12),priceBySeat, true);
	}

	//TODO
	@Test
	@Ignore
	public void noRestControllerTest() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/screenings", Resource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	@Ignore
	public void getMappingMethodDoesNotExistTest() throws Exception {

		ResponseEntity<Resource> responseEntity = testRestTemplate.getForEntity("/screenings", Resource.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void getMappingMethodExistButReturnsNullTest() throws
	 * Exception {
	 * 
	 * ResponseEntity<Resource> responseEntity =
	 * testRestTemplate.getForEntity("/screenings", Resource.class);
	 * 
	 * assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.
	 * INTERNAL_SERVER_ERROR); }
	 */

	@Test
	@Ignore
	public void getMappingExistAndReturnsDataTest() throws Exception {

		ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("/screenings", List.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	@Ignore
	public void postMappingMethodDoesNotExistTest() throws Exception {
		
		ResponseEntity responseEntity = testRestTemplate.postForEntity("/screenings", screening, null);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());
	}

	
	@Test
	@Ignore
	public void postMappingMethodExistButWithDbErrorTest() throws Exception {

		ResponseEntity responseEntity = testRestTemplate.postForEntity("/screenings", screening, null);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	@Ignore
	public void postMappingMethodExistTest() throws Exception {

		ResponseEntity responseEntity = testRestTemplate.postForEntity("/screenings", screening, null);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}
	
	@Test
	public void postMappingMethodExistButInvalidInputScreeningTest() throws Exception {

		ResponseEntity responseEntity = testRestTemplate.postForEntity("/screenings", screening, null);
		assertEquals(HttpStatus.NOT_ACCEPTABLE,responseEntity.getStatusCode());
	}
}
