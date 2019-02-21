
package com.cg.bookmymovie.theatreService.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Auditorium;
import com.cg.bookmymovie.theatreService.entity.Seat;
import com.cg.bookmymovie.theatreService.entity.Theatre;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TheatreServiceImplIntegrationTest {

	@Autowired(required = true)
	private TheatreService theatreService;

	Theatre theatre1, theatre2;

	@Before
	public void addTheatreFailedTest() {

		Map<Integer,Seat> seatSet1 = new HashMap<Integer, Seat>();
		Map<Integer,Seat> seatSet2 = new HashMap<Integer, Seat>();
//audi one of theatre one		
		seatSet1.put(1, new Seat("gold",'A', 1,true,100.0));
		seatSet1.put(2, new Seat("gold",'A', 2,true,100.0));
		seatSet1.put(3, new Seat("gold",'A', 3,true,100.0));
		seatSet1.put(4, new Seat("gold",'B', 1,true,100.0));
		seatSet1.put(5, new Seat("gold",'B', 2,true,100.0));
		seatSet1.put(6, new Seat("gold",'B', 3,true,100.0));
		
		seatSet1.put(7, new Seat("silver",'C', 1,true,80.0));
		seatSet1.put(8, new Seat("silver",'C', 2,true,80.0));
		seatSet1.put(9, new Seat("silver",'C', 3,true,80.0));
		seatSet1.put(10, new Seat("silver",'D', 1,true,80.0));
		seatSet1.put(11, new Seat("silver",'D', 2,true,80.0));
		seatSet1.put(12, new Seat("silver",'D', 3,true,80.0));

////audi two of theatre one			
		seatSet2.put(1, new Seat("gold",'A', 1,true,100.0));
		seatSet2.put(2, new Seat("gold",'A', 2,true,100.0));
		seatSet2.put(3, new Seat("gold",'A', 3,true,100.0));
		seatSet2.put(4, new Seat("gold",'B', 1,true,100.0));
		seatSet2.put(5, new Seat("gold",'B', 2,true,100.0));
		seatSet2.put(6, new Seat("gold",'B', 3,true,100.0));
		
		seatSet2.put(7, new Seat("silver",'C', 1,true,80.0));
		seatSet2.put(8, new Seat("silver",'C', 2,true,80.0));
		seatSet2.put(9, new Seat("silver",'C', 3,true,80.0));
		seatSet2.put(10, new Seat("silver",'D', 1,true,80.0));
		seatSet2.put(11, new Seat("silver",'D', 2,true,80.0));
		seatSet2.put(12, new Seat("silver",'D', 3,true,80.0));
		
		Set<Auditorium> auditoriumSet = new HashSet<Auditorium>();
		auditoriumSet.add(new Auditorium("Kibe", seatSet1));
		auditoriumSet.add(new Auditorium("vide",seatSet2));
		
		
		Address address = new Address( "Maharashtra", "Mumbai","Thane");
		theatre1 = new Theatre(3, "E-SQUARE", address, auditoriumSet);
//theatre two		
		seatSet1.put(1, new Seat("platinum",'A', 1,true,100.0));
		seatSet1.put(2, new Seat("platinum",'A', 2,true,100.0));
		seatSet1.put(3, new Seat("platinum",'A', 3,true,100.0));
		seatSet1.put(4, new Seat("silver",'B', 1,true,80.0));
		seatSet1.put(5, new Seat("silver",'B', 2,true,80.0));
		seatSet1.put(6, new Seat("silver",'B', 3,true,80.0));
		
		seatSet1.put(7, new Seat("silver",'C', 1,true,80.0));
		seatSet1.put(8, new Seat("silver",'C', 2,true,80.0));
		seatSet1.put(9, new Seat("silver",'C', 3,true,80.0));
		seatSet1.put(10, new Seat("gold",'D', 1,true,180.0));
		seatSet1.put(11, new Seat("gold",'D', 2,true,180.0));
		seatSet1.put(12, new Seat("gold",'D', 3,true,180.0));

////audi two of theatre one			
		seatSet2.put(1, new Seat("gold",'A', 1,true,100.0));
		seatSet2.put(2, new Seat("gold",'A', 2,true,100.0));
		seatSet2.put(3, new Seat("gold",'A', 3,true,100.0));
		seatSet2.put(4, new Seat("gold",'B', 1,true,100.0));
		seatSet2.put(5, new Seat("gold",'B', 2,true,100.0));
		seatSet2.put(6, new Seat("gold",'B', 3,true,100.0));
		
		seatSet2.put(7, new Seat("silver",'C', 1,true,80.0));
		seatSet2.put(8, new Seat("silver",'C', 2,true,80.0));
		seatSet2.put(9, new Seat("silver",'C', 3,true,80.0));
		seatSet2.put(10, new Seat("silver",'D', 1,true,80.0));
		seatSet2.put(11, new Seat("silver",'D', 2,true,80.0));
		seatSet2.put(12, new Seat("silver",'D', 3,true,80.0));
	
		auditoriumSet.add(new Auditorium("alpha", seatSet1));
		auditoriumSet.add(new Auditorium("beta",seatSet2));
		
		
		address = new Address( "Maharashtra", "Mumbai","Airoli");
		
		
		
		theatre2 = new Theatre(4, "Inox", address, auditoriumSet);
	}

	@Test
	@Ignore
	public void testGetTheatreByWrongId() {
		assertEquals(null, theatreService.getTheatreById(1));
	}

	@Test
	@Ignore
	public void testGetTheatreByCorrectId() {
		assertEquals(theatre1.getTheatreName(), theatreService.getTheatreById(1).get().getTheatreName());
	}

	@Test
	@Ignore
	public void testDeleteTheatre() {
		theatreService.deleteTheatre(theatre1);
		assertEquals(null, theatreService.getTheatreById(1));
	}

	@Test
	@Ignore
	public void testgetAllTheatreQuantity() {
		assertEquals(2, theatreService.getAllTheatres().size());
	}
	
	@Test
	public void addNewTheatres() {
		theatreService.addNewTheatre(theatre1);
		theatreService.addNewTheatre(theatre2);
		

		System.out.println("hello");
		System.out.println(theatreService.getTheatreById(2).get().getTheatreName());
		assertEquals("Wave Mall", theatreService.getTheatreById(2).get().getTheatreName());
	}
}
