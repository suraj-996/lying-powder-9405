package com.vs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.IdCardException;
import com.vs.exception.MemberException;
import com.vs.exception.UserException;
import com.vs.exception.VaccineCenterException;
import com.vs.exception.VaccineException;
import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Idcard;
import com.vs.model.Member;
import com.vs.model.User;
import com.vs.model.VaccinationCenter;
import com.vs.model.Vaccine;
import com.vs.model.VaccineRegistration;
import com.vs.service.IdCardService;
import com.vs.service.MemberService;
import com.vs.service.UserService;
import com.vs.service.VaccinationCenterService;
import com.vs.service.VaccineRegistrationService;
import com.vs.service.VaccineService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService cService;

	@Autowired
	private VaccineRegistrationService vrService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private VaccineService vaccineService;
	// user own method

	@Autowired
	private VaccinationCenterService vaccenser;
	
	@Autowired
	private IdCardService idCardService;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException {

		User savedCustomer = cService.createCustomer(user);

		return new ResponseEntity<User>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User customer, @RequestParam(required = false) String key)
			throws UserException {

		User updatedCustomer = cService.updateCustomer(customer, key);

		return new ResponseEntity<User>(updatedCustomer, HttpStatus.OK);

	}

	// user can perform member crud operation

	@GetMapping(value = "/members")
	public ResponseEntity<List<Member>> getAllMembers() throws MemberException {

		List<Member> members = memberService.getAllMembers();

		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);

	}

	@GetMapping(value = "/members/{memberId}")
	public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Integer memberId) throws MemberException {

		Member member = memberService.getMemberById(memberId);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbyaadhar/{aadhar}")
	public ResponseEntity<Member> getMemberByAadharNo(@PathVariable("aadhar") Long aadharNo) throws MemberException {

		Member member = memberService.getMemberByAadharNo(aadharNo);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbypan/{pan}")
	public ResponseEntity<Member> getMemberByPanNo(@PathVariable("pan") String panNo) throws MemberException {

		Member member = memberService.getMemberByPanNo(panNo);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@PostMapping(value = "/members")
	public ResponseEntity<Member> addMember(@RequestBody Member member) throws MemberException {

		Member addedMember = memberService.addMember(member);

		return new ResponseEntity<Member>(addedMember, HttpStatus.OK);

	}

	@PutMapping(value = "/members")
	public ResponseEntity<Member> updateMember(@RequestBody Member member) throws MemberException {

		Member updatedMember = memberService.updateMember(member);

		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping(value = "/members")
	public ResponseEntity<Boolean> deleteMember(@RequestBody Member member) throws MemberException {

		Boolean ans = memberService.deleteMember(member);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);

	}

	// user can perform vaccine registration crud operation

	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<List<VaccineRegistration>> getVaccineRegistrationHandler(
			@PathVariable("moblineno") Long mobileno) throws VaccineRegistrationException {

		List<VaccineRegistration> vaccineRegistration = vrService.getVaccineRegistration(mobileno);
		return new ResponseEntity<List<VaccineRegistration>>(vaccineRegistration, HttpStatus.OK);

	}

	@PutMapping("/vaccineRegisrations")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler(
			@RequestBody VaccineRegistration vaccineRegistration) throws VaccineRegistrationException {
		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration);
		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}

//	@DeleteMapping("/vaccineRegistration/{registrationNo}")
//	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(@PathVariable("registrationNo") Integer registrationNo) throws VaccineRegistrationException{
//		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo);
//		
//	//	return new ResponseEntity<Boolean>(vrService.deleteVaccineRegistration(registrationNo));
//	}

	// user can perform vaccine crud operation

	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccineController() throws VaccineException {
		List<Vaccine> vaccines = vaccineService.allVaccines();
		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine")
	public ResponseEntity<List<Vaccine>> getVaccineByNameController(@RequestParam("vaccineName") String vaccineName)
			throws VaccineException {
		List<Vaccine> vaccines = vaccineService.getVaccineByName(vaccineName);
		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineByIdController(@PathVariable("vaccineId") Integer vaccineId)
			throws VaccineException {
		Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
		return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
	}

	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine) throws VaccineException {
		Vaccine vacc = vaccineService.addVaccine(vaccine);
		return new ResponseEntity<Vaccine>(vacc, HttpStatus.CREATED);
	}

	@PutMapping("/vaccines")
	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine) throws VaccineException {
		Vaccine vacc = vaccineService.updateVaccine(vaccine);
		return new ResponseEntity<Vaccine>(vacc, HttpStatus.OK);
	}

	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId)
			throws VaccineException {
		Boolean ans = vaccineService.deleteVaccine(vaccineId);
		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}

	// user vaccine center access
	@GetMapping("/getVaccCenter")
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {

		List<VaccinationCenter> allvaclist = vaccenser.getAllVaccineCenters();

		if (allvaclist.size() == 0) {
			throw new VaccineCenterException("No Vaccine Centers availavle");
		}

		return allvaclist;
	}
	@GetMapping("/getVaccCenter/{centerId}")
	public VaccinationCenter getVaccineCenter(@PathVariable("centerId") Integer centerId) throws VaccineCenterException {
		
		 VaccinationCenter vc =vaccenser.getVaccineCenter(centerId);
		 
		 if(vc==null) {
			 
				throw new VaccineCenterException("Vaccination Center does not found with center id :"+centerId);

		 }
		
		 return vc;
	}
	
	
	
	@GetMapping("/panNo")
	public ResponseEntity<Idcard> getPanCardByNumberController(@RequestParam("panNo") String panNo) throws IdCardException{
		Idcard idcard= idCardService.getPanCardByNumber(panNo);
		return new ResponseEntity<Idcard>(idcard,HttpStatus.OK);
	}
	@GetMapping("/adharNo")
	public ResponseEntity<Idcard> getAdharCardByNoController(@RequestParam("adharNo") Long adharNo) throws IdCardException{
		Idcard idcard= idCardService.getAdharCardByNo(adharNo);
		return new ResponseEntity<Idcard>(idcard,HttpStatus.OK);
	}
	@PostMapping("/idcard")
	public ResponseEntity<Idcard> addIdCardController(@RequestBody Idcard idCard) throws IdCardException{
		Idcard idcard= idCardService.addIdCard(idCard);
		return new ResponseEntity<Idcard>(idcard,HttpStatus.CREATED);
	}
}