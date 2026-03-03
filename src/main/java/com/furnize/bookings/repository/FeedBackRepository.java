package com.furnize.bookings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnize.bookings.model.OrdersFeedBack;

public interface FeedBackRepository  extends JpaRepository<OrdersFeedBack, Integer>{
	
	Boolean existsByEmail(String email);
	Optional<OrdersFeedBack> deleteByEmail(String email);

}
