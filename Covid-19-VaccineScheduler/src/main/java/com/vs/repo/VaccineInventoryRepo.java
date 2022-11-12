package com.vs.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.VaccineInventory;


@Repository
public interface VaccineInventoryRepo extends JpaRepository<VaccineInventory, Integer>{

	public List<VaccineInventory> findByDate(LocalDate date);
	
	@Query("select vaccineInventory from Vaccine v where v.vaccineId=?1")
	public VaccineInventory getVaccineInventoryByVaccine(Integer vaccineId);
	
}
