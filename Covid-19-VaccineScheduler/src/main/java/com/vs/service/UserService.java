package com.vs.service;

import com.vs.exception.UserException;
import com.vs.model.User;

public interface UserService {
	public User createCustomer(User user)throws UserException;
	
	public User updateCustomer(User user,String key)throws UserException;
}
