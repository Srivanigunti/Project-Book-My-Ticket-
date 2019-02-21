package com.bookyourticket.profile.tests;

import static org.junit.Assert.assertEquals;

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

import com.bookyourticket.profile.entity.UserAddress;
import com.bookyourticket.profile.entity.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TestForResource {

	private Profile profile;
	/*
	 * @Before public void setup() {
	 * 
	 * profile = new Profile(101, "Srivani", "kunni@gmail.com", "7894561230", new
	 * Address("900", "Ramnagar", "Karimnagar", "Telangana", "India"),null, "M",
	 * null); }
	 */

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Ignore
	public void controllerIdentified() throws Exception {
		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiles", Profile.class);
		System.out.println(responseEntity.getStatusCode());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	@Ignore
	public void AddProfile() throws Exception {
		
		//Profile profile = new Profile();
		ResponseEntity<Profile> responseEntity = testRestTemplate.postForEntity("/profiles", profile, Profile.class);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	@Ignore
	public void getProfileById() throws Exception{

		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiles/101", Profile.class, profile);
		// System.out.println(responseEntity);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getClass());
		System.out.println(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

	}
	
	@Test
	@Ignore
	public void getProfileWhichIsNotPresent() {

		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiles/1", Profile.class, profile);
		// System.out.println(responseEntity);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getClass());
		System.out.println(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	@Ignore
	public void deleteProfileById() {
		testRestTemplate.delete("/profiles/101");
		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiles/101", Profile.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	@Ignore
	public void deleteProfileWhichIsNotPresent() {
		testRestTemplate.delete("/profiles/1");
		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiles/1", Profile.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	/*
	 * @Test public void testForUpdate() {
	 * 
	 * testRestTemplate.put("/profiles", profile);
	 * 
	 * ResponseEntity<Profile> responseEntity =
	 * testRestTemplate.getForEntity("/profiles", Profile.class);
	 * System.out.println(responseEntity.getBody().getEmailId());
	 * assertEquals(profile.getGender(), responseEntity.getBody().getGender()); }
	 */
}
