package com.furnize.bookings.exceptions;

public class EmailAlreadyReportedException extends RuntimeException{
	
	public EmailAlreadyReportedException(String msg) {
		super(msg);
	}

}
