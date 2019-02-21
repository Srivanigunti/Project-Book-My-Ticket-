package com.bookyourticket.booking.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookyourticket.booking.entity.Address;
import com.bookyourticket.booking.entity.Booking;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingServiceTests {
	
	/*
	 * @Mock private BookingService service;
	 * 
	 * @Mock private BookingResource repository;
	 * 
	 * @Before public void init() { MockitoAnnotations.initMocks(this); }
	 */
	
	@Autowired
	private BookingService service;
	
	private Integer getUniqueId() {
        UUID idOne = UUID.randomUUID();
        int uid = idOne.hashCode();
        return uid;
    }
	
	/*
	 * @Test
	 * 
	 * @Ignore public void getAllBookings() { List<Booking> list = new
	 * ArrayList<Booking>(); Booking firstBooking = new Booking(67, 800.67,
	 * LocalDateTime.now(), true); Booking secondBooking = new Booking(56, 5600.67,
	 * LocalDateTime.now(), false);
	 * 
	 * list.add(firstBooking); list.add(secondBooking);
	 * 
	 * when(service.getAllBookings()).thenReturn(list);
	 * 
	 * List<Booking> bookingslist = service.getAllBookings(); assertEquals(2,
	 * bookingslist.size()); }
	 */
	
	@Test
    public void createBookingsTest()
    {
		Integer uid = getUniqueId();
		Map<Integer, Character> seatDetails = new HashMap<>();
		seatDetails.put(1, 'A');
		seatDetails.put(2, 'B');
		Map<String, Map<Integer, Character>> seat = new HashMap<String,  Map<Integer, Character>>();

		seat.put("gold",seatDetails);
        Booking booking = new Booking(uid, 101, "uri","Inox", new Address("rajasthan", "jaipur", "pratap nagar"),
        		 LocalDate.of(2019, 02, 22),LocalTime.of(10, 0), seat, 200.0);
        service.addBooking(booking); 
       int userId = service.getBookingById(101).get(0).getUserId();
         assertEquals(101,userId);
       // verify(service, times(1)).addBooking(booking); 
    }
	
	/*
	 * @Test public void deleteBookingById() { Booking booking = new Booking(59,
	 * 560.67, LocalDateTime.now(), true); service.deleteAccount(12);
	 * 
	 * verify(service, times(0)).addBooking(booking); }
	 */
	}
