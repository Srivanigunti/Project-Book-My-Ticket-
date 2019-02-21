package com.bookyourticket.booking.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bookyourticket.booking.entity.Booking;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTests {

	/*
	 * @Autowired private MockMvc mockMvc;
	 * 
	 * @Test public void testGetAllBookings() throws Exception { String uri =
	 * "/booking"; MvcResult mvcResult =
	 * mockMvc.perform(MockMvcRequestBuilders.get(uri)
	 * .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); int status =
	 * mvcResult.getResponse().getStatus(); assertEquals(200, status); }
	 * 
	 * @Test public void testBookingMovie() throws Exception { Booking booking = new
	 * Booking(22, 900.67, LocalDateTime.now(), false); String uri = "/booking";
	 * MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	 * .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn(); int status =
	 * mvcResult.getResponse().getStatus(); assertEquals(200, status); }
	 * 
	 * @Test public void testCancelBookedTicket() throws Exception {
	 * mockMvc.perform(delete("/booking/21").contentType(MediaType.APPLICATION_JSON)
	 * ) .andExpect(status().isOk()); }
	 * 
	 * @Test public void testCancelBookedTicket() throws Exception {
	 * mockMvc.perform(delete("/booking/"+
	 * 1241).contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk()); }
	 * 
	 * @Test public void testCancelBookedTicketWithWrongPath() throws Exception {
	 * String one = "one"; MvcResult mvcResult = mockMvc.perform(delete("/booking/"+
	 * one).contentType(MediaType.APPLICATION_JSON)).andReturn(); int status =
	 * mvcResult.getResponse().getStatus(); assertEquals(400, status); }
	 */
}
