package com.vs.service;

import com.vs.exception.LoginException;
import com.vs.model.AdminLogin;
import com.vs.model.UserLogin;

public interface LoginService {
	public String logIntoAccount(UserLogin dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	public String logIntoAdmin(AdminLogin adl) throws LoginException;
	
	public String logOutAdmin(String key) throws LoginException;
	
}
