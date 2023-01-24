package com.vs.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.UserException;
import com.vs.model.CurrentUserSession;
import com.vs.model.User;
import com.vs.repo.UserRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo uRepo;

	@Autowired
	private UserSessionRepo usRepo;

	@Override
	public User createCustomer(User user) throws UserException {
		User existingUser = uRepo.findByMobileNo(user.getMobileNo());
		if (existingUser == null) {
			return uRepo.save(user);
		} else {
			throw new UserException("User already registered with mobile number");
		}
	}

	@Override
	public User updateCustomer(User user, String key) throws UserException {
		CurrentUserSession loggedInUser = usRepo.findByuuid(key);
		if (loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a user");
		}

		if (user.getUserId() == loggedInUser.getUserId()) {
			return uRepo.save(user);
		} else {
			throw new UserException("Invalid user details , please login first");
		}
	}

}
