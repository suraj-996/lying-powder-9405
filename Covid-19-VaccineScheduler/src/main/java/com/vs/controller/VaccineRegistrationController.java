package com.vs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;
import com.vs.service.VaccineRegistrationService;

//@RestController
public class VaccineRegistrationController {
	
//	@Autowired
//	private VaccineRegistrationService vrService;
//	
//	@GetMapping("/vaccineRegistration/{moblineno}")
//	public ResponseEntity<List<VaccineRegistration>> getVaccineRegistrationHandler(@PathVariable("moblineno") Long mobileno) throws VaccineRegistrationException{
//		
//		List<VaccineRegistration> vaccineRegistration = vrService.getVaccineRegistration(mobileno);
//		return new ResponseEntity<List<VaccineRegistration>>(vaccineRegistration, HttpStatus.OK);
//		
//	}
//	
//	@GetMapping("/getMembers/{mobileno}")
//	public ResponseEntity<List<Member>> getAllMemberHandler(@PathVariable("mobileno") Long mobileno) throws VaccineRegistrationException{
//		List<Member> members = vrService.getAllMember(mobileno);
//		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
//	}
//	
//	@PutMapping("/addvaccineRegistration")
//	public ResponseEntity<VaccineRegistration> addVaccineRegistrationHandler(@RequestBody VaccineRegistration regs) throws VaccineRegistrationException{
//		VaccineRegistration addVaccineRegistration= vrService.addVaccineRegistration(regs);
//		return new ResponseEntity<VaccineRegistration>(addVaccineRegistration, HttpStatus.OK);
//	}
//	
//	@PutMapping("/vaccineRegisrations")
//	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler(@RequestBody VaccineRegistration vaccineRegistration) throws VaccineRegistrationException{
//		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration);
//		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
//	}
//	
//	@DeleteMapping("/vaccineRegistration/{registrationNo}")
//	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(@PathVariable("registrationNo") Integer registrationNo) throws VaccineRegistrationException{
//		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo);
//		
//	//	return new ResponseEntity<Boolean>(vrService.deleteVaccineRegistration(registrationNo));
//	}

}
