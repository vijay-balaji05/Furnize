package com.furnize.bookings.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Entity for Add and Delete Product
 */
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "productName",unique = true)
	private String productName;
	@Column(name = "price")
	private Double price;
	@Column(name = "description")
	private String description;
	@Column(name = "releaseDate")
	private Date releaseDate;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Product(Integer productId, String productName, Double price, String description, Date releaseDate) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.releaseDate = releaseDate;
	}
	public Product() {
	}
	
	
	

}
