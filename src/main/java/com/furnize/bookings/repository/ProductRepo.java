package com.furnize.bookings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnize.bookings.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	Boolean existsByProductName(String name);
	Optional<Product> findByProductName(String name);
}
