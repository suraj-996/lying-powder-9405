package com.vs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;
import com.vs.model.VaccineInventory;
import com.vs.service.VaccineInventoryService;

//@RestController
public class VaccineInventoryController {

	@Autowired
	private VaccineInventoryService vaccInvSer;
//	
//	@GetMapping("/getInvByCenter/{centerid}")
//	public ResponseEntity<VaccineInventory> getVaccineInventoryByCenter(@PathVariable("centerid") Integer Centerid)throws VaccineException{
//		
//		
//		VaccineInventory vaccineinventory =vaccInvSer.getVaccineInventoryByCenter(Centerid);
//		
//		return new ResponseEntity<VaccineInventory>(vaccineinventory,HttpStatus.OK);
//	}
//	
	
	@PutMapping("/addVaccCount/{count}")
	public ResponseEntity<VaccineInventory> addVaccineCount(@RequestBody VaccineInventory vinv ,@PathVariable("count") Integer count)throws VaccineException{
		
		VaccineInventory vaccineinventory =vaccInvSer.addVaccineCount(vinv, count);
		return new ResponseEntity<VaccineInventory>(vaccineinventory,HttpStatus.OK);

	}
	
	
	@PutMapping("/updateVaccinv/vinv")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody VaccineInventory vinv)throws VaccineException{
		
		VaccineInventory vaccineinventory  =vaccInvSer.updateVaccineInventory(vinv);
		return new ResponseEntity<VaccineInventory>(vaccineinventory,HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteinv")
	public boolean deleteVaccineInventory(@RequestBody VaccineInventory vinv)throws VaccineException{
		
		boolean flag  =vaccInvSer.deleteVaccineInventory(vinv);
		
		if(flag) {
			return flag;
		}
		
		throw new VaccineException("VaccineInventory cannot be deleted ");
		
		
	}
	
	@GetMapping("/getVaccinvByDate/{ld}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDate(@PathVariable("ld") LocalDate ld)throws VaccineException{
		
		
		List<VaccineInventory> invlist =vaccInvSer.getVaccineInventoryByDate(ld);
		
		
		if(invlist.size()==0) {
			throw new VaccineException("list is empty ");
		}
		
		return new ResponseEntity<List<VaccineInventory>>(invlist,HttpStatus.OK);
		
	}
	
	
//	@GetMapping("/getinvByVaccname/{vaccine}")
//	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByVaccine(@PathVariable("vaccine") Vaccine vc)throws VaccineException{
//		
//		
//		List<VaccineInventory> invList =vaccInvSer.getVaccineInventoryByVaccine(vc);
//		
//		if(invList.size()==0) {
//			
//			throw new VaccineException("inventory List is empty");
//		}
//		
//		return new ResponseEntity<List<VaccineInventory>>(invList,HttpStatus.OK);
//			
//		
//		
//	}


	
}
