package com.furnize.bookings.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_bookings")
public class OrderBookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private String name;
	private String email;
	private Long phone;
	private Date prefferDate;
	private String address;
	private String orderType;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getPrefferDate() {
		return prefferDate;
	}
	public void setPrefferDate(Date prefferDate) {
		this.prefferDate = prefferDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public OrderBookings(Integer orderId, String name, String email, Long phone, Date prefferDate, String address,String orderType) {
		this.orderId = orderId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.prefferDate = prefferDate;
		this.address = address;
		this.orderType=orderType;
	}
	
	public OrderBookings() {
		
	}
	
	
	
	
	
	
	
	

}
