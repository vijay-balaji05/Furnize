package com.furnize.bookings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.furnize.bookings.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateFieldException.class)
	public ResponseEntity<ErrorResponse> duplicateFieldException(DuplicateFieldException dupExcep,
			WebRequest request){
		
		ErrorResponse response=new ErrorResponse(dupExcep.getMessage(), request.getDescription(false),
													HttpStatus.CONFLICT);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<ErrorResponse> nameNotFoundException(NameNotFoundException name,WebRequest req){
		
		ErrorResponse response=new ErrorResponse(name.getMessage(), req.getDescription(false), 
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFeedBacksFoundException.class)
	public ResponseEntity<ErrorResponse> noFeedBackFoundException(NoFeedBacksFoundException exce,
																	WebRequest req){
		ErrorResponse response=new ErrorResponse(exce.getMessage(), req.getDescription(false), 
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyReportedException.class)
	public ResponseEntity<ErrorResponse> emailAlreadyReportedException(EmailAlreadyReportedException exce,
																	WebRequest req){
		ErrorResponse response=new ErrorResponse(exce.getMessage(), req.getDescription(false), 
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(PhoneNumberAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> phoneNumberAlreadyExists(PhoneNumberAlreadyExistsException ph,
			WebRequest req){
		ErrorResponse response=new ErrorResponse(ph.getMessage(), req.getDescription(false), HttpStatus.ALREADY_REPORTED);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.ALREADY_REPORTED);
	}
	
	
	
	

}
