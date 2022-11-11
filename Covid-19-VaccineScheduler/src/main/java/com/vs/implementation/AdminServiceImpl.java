package com.vs.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.AdminException;
import com.vs.model.Admin;
import com.vs.model.CurrentAdminSession;
import com.vs.repo.AdminRepo;
import com.vs.repo.AdminSessionRepo;
import com.vs.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private AdminSessionRepo adminSRepo;
	@Override
	public Admin createCustomer(Admin admin) throws AdminException {
		
		Admin existingUser=adminRepo.findByMobileNo(admin.getMobileNo());
		if(existingUser==null) {
			return adminRepo.save(admin);
		}else {
			throw new AdminException("User already registered with mobile number");
		}
	}

	@Override
	public Admin updateCustomer(Admin admin, String key) throws AdminException {
		CurrentAdminSession loggedInUser=adminSRepo.findByuuid(key);
		if(loggedInUser==null) {
			throw new AdminException("Please provide a valid key to update a user");
		}
		
		if(admin.getUserId()==loggedInUser.getUserId()) {
			return adminRepo.save(admin);
		}else {
			throw new AdminException("Invalid user details , please login first");
		}
	}

}
