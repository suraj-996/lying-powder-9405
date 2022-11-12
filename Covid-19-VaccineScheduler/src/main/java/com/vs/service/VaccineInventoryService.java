package com.vs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vs.exception.VaccineException;
import com.vs.model.VaccinationCenter;
import com.vs.model.Vaccine;
import com.vs.model.VaccineInventory;

public interface VaccineInventoryService{

	public VaccineInventory getVaccineInventoryByCenter(Integer Centerid)throws VaccineException;
		
	public  VaccineInventory addVaccineCount(VaccineInventory vinv,Integer count)throws VaccineException;

	public VaccineInventory updateVaccineInventory(VaccineInventory vinv)throws VaccineException;
		
	public boolean deleteVaccineInventory(VaccineInventory vinv)throws VaccineException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate ld)throws VaccineException;
	
	
	public VaccineInventory getVaccineInventoryByVaccine(Vaccine vc)throws VaccineException;
	
	
}
