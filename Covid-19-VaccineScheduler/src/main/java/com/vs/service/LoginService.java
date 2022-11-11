package com.vs.service;

import com.vs.exception.LoginException;
import com.vs.model.Login;

public interface LoginService {
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
}
