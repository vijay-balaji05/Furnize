package com.furnize.bookings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnize.bookings.exceptions.NoProductFoundException;
import com.furnize.bookings.exceptions.ProductAlreadyExistsException;
import com.furnize.bookings.model.Product;
import com.furnize.bookings.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public String addProduct(Product prod) {
		
		if(repo.existsByProductName(prod.getProductName())) {
			throw new ProductAlreadyExistsException("Product Already Exists");
		}
		repo.save(prod);
		return "The "+prod.getProductName()+" will be Added!";
	}

	public List<Product> getProducts() {
		
		if(repo.count()==0) {
			throw new NoProductFoundException("No Product Found Exception");
		}
		return repo.findAll();
	}

	public String deleteProductByName(String name) {
		
		Product product=repo.findByProductName(name).orElseThrow(()->new 
							NoProductFoundException("Cannot Find the product with "+name));
		repo.delete(product);
		
		return "Product Deleted Successfully";
	}

}
