package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	public Admin findByMobileNo(String mobileNo);
}
