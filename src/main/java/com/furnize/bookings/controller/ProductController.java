package com.furnize.bookings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.furnize.bookings.model.Product;
import com.furnize.bookings.service.ProductService;



@RestController
@RequestMapping("/furn/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product prod){
		return new ResponseEntity<>(service.addProduct(prod),HttpStatus.CREATED);
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{name}")
	public ResponseEntity<String> deleteProductByName(@PathVariable String name)
	{
		return new ResponseEntity<>(service.deleteProductByName(name),HttpStatus.OK);
	}
	

}
