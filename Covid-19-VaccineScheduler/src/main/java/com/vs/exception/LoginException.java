package com.vs.exception;

import org.springframework.beans.factory.annotation.Autowired;

import com.vs.repo.UserRepo;
import com.vs.repo.UserSessionRepo;

public class LoginException extends Exception{
	
	public LoginException() {
		
	}
	
	public LoginException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
