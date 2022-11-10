package com.vs.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime timeStamp;
	private String message;
	private String details;

	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}

}
