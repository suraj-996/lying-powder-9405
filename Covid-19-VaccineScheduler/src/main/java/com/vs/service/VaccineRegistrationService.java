package com.vs.service;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;

@RestController
public interface VaccineRegistrationService {
	
	public List<VaccineRegistration> getVaccineRegistration(Long moblieno) throws VaccineRegistrationException;
	
	public List<Member> getAllMember(Long mobileno) throws VaccineRegistrationException;   /* should use memExcp or VrExcp */
	
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException;
	
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException;
	
	public boolean deleteVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException;

}
