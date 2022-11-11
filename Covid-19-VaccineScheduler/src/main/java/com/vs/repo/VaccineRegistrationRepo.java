package com.vs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.VaccineRegistration;

@Repository
public interface VaccineRegistrationRepo extends JpaRepository<VaccineRegistration, Integer>{
	
	public List<VaccineRegistration> findByMobileno(Long mobileno);

}
