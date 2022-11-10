package com.vs.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.model.VaccineInventory;



public interface VaccineInventoryRepo extends JpaRepository<VaccineInventory, Integer>{

	public List<VaccineInventory> findByDate(LocalDate date);
	
s
	
	
	
}
