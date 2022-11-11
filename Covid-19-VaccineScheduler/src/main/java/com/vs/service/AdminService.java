package com.vs.service;

import com.vs.exception.AdminException;
import com.vs.model.Admin;

public interface AdminService {
	public Admin createCustomer(Admin admin)throws AdminException;
	
	public Admin updateCustomer(Admin admin,String key)throws AdminException;
}
