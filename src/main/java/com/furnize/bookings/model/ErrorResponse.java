package com.furnize.bookings.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private LocalDateTime timeStamp;
	private String errorMsg;
	private String errorDescription;
	private HttpStatus status;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public ErrorResponse(String errorMsg, String errorDescription, HttpStatus status) {
		this.timeStamp = LocalDateTime.now();
		this.errorMsg = errorMsg;
		this.errorDescription = errorDescription;
		this.status = status;
	}
	
}
