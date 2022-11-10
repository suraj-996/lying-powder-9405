package com.vs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> myIllegalArgumentExceptionHandler(IllegalArgumentException iae,
			WebRequest request) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(iae.getMessage());
		error.setDetails(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNoHandlerFoundExceptionHandler(NoHandlerFoundException nhfe,
			WebRequest request) {

		System.out.println("Wrong Request");

		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(nhfe.getMessage());
		error.setDetails(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e, WebRequest request) {

		System.out.println("Please enter correct Details");

		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDetails(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);

	}

}
