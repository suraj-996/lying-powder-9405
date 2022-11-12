package com.vs.service;

import java.util.List;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;

public interface VaccineRegistrationService {


	public VaccineRegistration getVaccineRegistration(Long moblieno, String key)
			throws VaccineRegistrationException, LoginException;

	public List<Member> getAllMember(Long mobileno, String key)
			throws VaccineRegistrationException, LoginException; /* should use memExcp or VrExcp */

	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException;

	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException;

	public boolean deleteVaccineRegistration(Integer reg, String key)
			throws VaccineRegistrationException, LoginException;

	
	


}
