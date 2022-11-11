package com.vs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.LoginException;
import com.vs.model.AdminLogin;
import com.vs.model.UserLogin;
import com.vs.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/loginuser")
	public ResponseEntity<String> logInCustomer(@RequestBody UserLogin dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@DeleteMapping("/logoutuser")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAccount(key);
		
	}
	
	@PostMapping("/loginadmin")
	public ResponseEntity<String> logInAdmin(@RequestBody AdminLogin dto) throws LoginException {
		
		String result = customerLogin.logIntoAdmin(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@DeleteMapping("/logoutadmin")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutAdmin(key);
		
	}
}
