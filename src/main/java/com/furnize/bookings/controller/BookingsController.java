package com.furnize.bookings.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.furnize.bookings.model.OrderBookings;
import com.furnize.bookings.service.BookingsService;


@RestController
@RequestMapping("/furn")
@CrossOrigin(origins = {
		"http:localhost:5500",
		"http:127.0.0.1:5500"
})
public class BookingsController {
	
	/*
	 * Dependency Injection for Service Layer
	 */
	private BookingsService service;
	public BookingsController(BookingsService service) {
		this.service=service;
		
	}
	
	/*
	 * Post Mapping
	 */
	@PostMapping("/addBooking")
	public ResponseEntity<OrderBookings> addBookings(@RequestBody OrderBookings orderBookings){
		
		return new ResponseEntity<OrderBookings>(service.addBookings(orderBookings),
				HttpStatus.CREATED);
	}
	
	/*
	 * Get Mapping
	 */
	@GetMapping("/getOrders")
	public ResponseEntity<List<OrderBookings>> getOrders(){
		
		return new ResponseEntity<>(service.getOrders(),HttpStatus.OK);
	}
	
	/*
	 * Get Specific Order
	 */
	@GetMapping("/getOrders/{name}")
	public ResponseEntity<OrderBookings> getSpecificOrder(@PathVariable String name){
		return new ResponseEntity<>(service.getSpecificOrder(name),HttpStatus.OK);
	}
	
	/*
	 * Delete Mapping
	 */
	@DeleteMapping("/deleteOrder/{name}")
	public ResponseEntity<String> deleteSpecificOrder(@PathVariable String name){
		return new ResponseEntity<String>(service.deleteSpecificOrder(name),HttpStatus.OK);
		
	}

}
