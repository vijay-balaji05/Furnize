package com.furnize.bookings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.furnize.bookings.model.OrderBookings;

@Repository
public interface BookingsRepo extends JpaRepository<OrderBookings, Integer>{

	Optional<OrderBookings> findByName(String name);
	Optional<OrderBookings> deleteByName(String name);
	Boolean existsByEmail(String email);
	Boolean existsByPhone(Long phone);
}
