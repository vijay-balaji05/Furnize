package com.furnize.bookings.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.furnize.bookings.model.OrdersFeedBack;
import com.furnize.bookings.service.FeedBackService;

@RestController
@RequestMapping("/furn/feedBack")
@CrossOrigin(origins ="*")
public class FeedBackController {
	
	private FeedBackService service;
	
	public FeedBackController(FeedBackService service) {
		this.service=service;
		
	}
	
	@PostMapping("/addFeedBack")
	public ResponseEntity<OrdersFeedBack> addFeedBack(@RequestBody OrdersFeedBack feedBack){
		return new ResponseEntity<OrdersFeedBack>(service.addFeedBack(feedBack),HttpStatus.CREATED);
	}
	
	@GetMapping("/getFeedBack")
	public ResponseEntity<List<OrdersFeedBack>> getFeedBacks(){
		return new ResponseEntity<>(service.getFeedBacks(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteFeedBack/{email}")
	public ResponseEntity<String> deleteFeedBack(@PathVariable String email){
		return new ResponseEntity<String>(service.deleteFeedBack(email),HttpStatus.OK);
	}

}
