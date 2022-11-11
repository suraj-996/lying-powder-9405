package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByMobileNo(String mobileNo);
}
