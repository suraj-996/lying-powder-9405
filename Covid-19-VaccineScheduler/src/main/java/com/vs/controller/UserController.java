package com.vs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.UserException;
import com.vs.model.User;
import com.vs.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService cService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<User> saveCustomer(@RequestBody User user) throws UserException {
		
		User savedCustomer= cService.createCustomer(user);
		
		
		return new ResponseEntity<User>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<User> updateCustomer(@RequestBody User customer,@RequestParam(required = false) String key ) throws UserException {
		
		
		User updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<User>(updatedCustomer,HttpStatus.OK);
		
	}
}
