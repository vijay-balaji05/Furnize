package com.furnize.bookings.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.furnize.bookings.exceptions.DuplicateFieldException;
import com.furnize.bookings.exceptions.NameNotFoundException;
import com.furnize.bookings.model.OrderBookings;
import com.furnize.bookings.repository.BookingsRepo;

@Service
public class BookingsService {
	
	/*
	 * Dependency Injection for Repository
	 */
	private BookingsRepo repo;
	
	public BookingsService(BookingsRepo repo) {
		this.repo=repo;
	}
	
	/*
	 * Post Mapping
	 */
	public OrderBookings addBookings(OrderBookings orderBookings)
	{
		
		
		return repo.save(orderBookings);
		
	}

	/*
	 * Get Mapping
	 */
	public List<OrderBookings> getOrders() {
		return repo.findAll();
	}

	/*
	 * Get Mapping for Specific Order
	 */
	public OrderBookings getSpecificOrder(String name) {
		
		OrderBookings order=
				repo.findByName(name).orElseThrow(()->new NameNotFoundException(name+" not available") );
		return order;
		
	}
	

	/*
	 * Delete Mapping
	 */
	public String deleteSpecificOrder(String name) {
		
		OrderBookings order=
				repo.deleteByName(name).orElseThrow(()->new NameNotFoundException(name+" not available") );
		repo.deleteByName(order.getName());
		return "Order Delete SuccessFully!!";
		
	}

}
