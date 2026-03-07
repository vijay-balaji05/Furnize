package com.furnize.bookings.exceptions;

public class ProductAlreadyExistsException extends RuntimeException{
	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}

}
