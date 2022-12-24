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
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception me, WebRequest re) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<MyErrorDetails> myIllegalArgumentExceptionHandler(IllegalArgumentException iae,
			WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(iae.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(VaccineException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(VaccineException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdCardException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(IdCardException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(MemberException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(AdminException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(AppointmentException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(LoginException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(UserException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VaccineCenterException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(VaccineCenterException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VaccineRegistrationException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(VaccineRegistrationException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
