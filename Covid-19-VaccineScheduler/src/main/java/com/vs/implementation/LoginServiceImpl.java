package com.vs.implementation;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.model.Admin;
import com.vs.model.AdminLogin;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.UserLogin;
import com.vs.model.User;
import com.vs.repo.AdminRepo;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.UserRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepo uRepo;
	@Autowired
	private UserSessionRepo usRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminSessionRepo adminSRepo;
	@Override
	public String logIntoAccount(UserLogin login) throws LoginException {
		User existingUser=uRepo.findByMobileNo(login.getMobileNo());
		
		if(existingUser==null) {
			throw new LoginException("Please enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> opt=usRepo.findById(existingUser.getUserId());
		
		if(opt.isPresent()) {
			throw new LoginException("User already logged in with this number");
		}
		
		if(existingUser.getPassword().equals(login.getPassword())) {
			String key=RandomString.make(6);
			CurrentUserSession currentUserSession=new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			usRepo.save(currentUserSession);
			return currentUserSession.toString();
		}else {
			throw new LoginException("Please Enter a valid password");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentUserSession validUserSession = usRepo.findByuuid(key);
		
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		usRepo.delete(validUserSession);
		
		
		return "Logged Out !";
	}

	@Override
	public String logIntoAdmin(AdminLogin adl) throws LoginException {
		Admin existingUser=adminRepo.findByMobileNo(adl.getMobileNo());
		
		if(existingUser==null) {
			throw new LoginException("Please enter a valid mobile number");
		}
		
		Optional<CurrentAdminSession> opt=adminSRepo.findById(existingUser.getUserId());
		
		if(opt.isPresent()) {
			throw new LoginException("Admin already logged in with this number");
		}
		
		if(existingUser.getPassword().equals(adl.getPassword())) {
			String key=RandomString.make(6);
			CurrentAdminSession currentUserSession=new CurrentAdminSession(existingUser.getUserId(),key,LocalDateTime.now());
			adminSRepo.save(currentUserSession);
			return currentUserSession.toString();
		}else {
			throw new LoginException("Please Enter a valid password");
		}
	}

	@Override
	public String logOutAdmin(String key) throws LoginException {
		CurrentAdminSession validUserSession = adminSRepo.findByuuid(key);
		
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		adminSRepo.delete(validUserSession);
		
		
		return "Logged Out !";
	}

}
