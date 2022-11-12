package com.vs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.VaccineCenterException;
import com.vs.model.VaccinationCenter;
import com.vs.service.VaccinationCenterService;

//@RestController
public class VaccinationCenterController {

	
//	@Autowired
//	private VaccinationCenterService vaccenser;
//
//	@GetMapping("/getVaccCenter")
//	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {
//		
//		
//		List<VaccinationCenter> allvaclist = vaccenser.getAllVaccineCenters();
//		
//		if(allvaclist.size()==0) {
//			throw new VaccineCenterException("No Vaccine Centers availavle");
//		}
//		
//		return allvaclist;
//	}
//
//	@GetMapping("/getVaccCenter/{centerId}")
//	public VaccinationCenter getVaccineCenter(@PathVariable("centerId") Integer centerId) throws VaccineCenterException {
//		
//		 VaccinationCenter vc =vaccenser.getVaccineCenter(centerId);
//		 
//		 if(vc==null) {
//			 
//				throw new VaccineCenterException("Vaccination Center does not found with center id :"+centerId);
//
//		 }
//		
//		 return vc;
//	}
//
//	
//	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
//	
//		
//		
//		VaccinationCenter vc =vaccenser.addVaccinationCenter(center);
//		
//		if(vc!=null) {
//			return vc;
//		}
//		
//			
//			throw new VaccineCenterException("sorry this Vaccination center already exist");
//		
//		
//	}
//
//	
//	
//	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
//		
//		
//		VaccinationCenter vc =vaccenser.updateVaccinationCenter(center);
//		
//		if(vc==null)
//			return vc;
//		
//		
//		throw new VaccineCenterException("Vaccination Center does not exist to update");
//		
//		
//	}
//
//	
//	public boolean deleteVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
//		
//		
//		
//	boolean flag =vaccenser.deleteVaccinationCenter(center);
//		
//		if(flag)
//			return flag;
//		
//		throw new VaccineCenterException("Vaccination Center cannot be deleted ");
//		
//	}
	
	
	
}
