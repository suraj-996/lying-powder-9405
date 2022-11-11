package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.CurrentUserSession;

@Repository
public interface UserSessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	public CurrentUserSession findByuuid(String uuid);

}
