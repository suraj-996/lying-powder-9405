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

import com.vs.exception.AppointmentException;
import com.vs.exception.IdCardException;
import com.vs.exception.LoginException;
import com.vs.exception.MemberException;
import com.vs.exception.UserException;
import com.vs.exception.VaccineCenterException;
import com.vs.exception.VaccineException;
import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Appointment;
import com.vs.model.Idcard;
import com.vs.model.Member;
import com.vs.model.User;
import com.vs.model.VaccinationCenter;
import com.vs.model.Vaccine;
import com.vs.model.VaccineRegistration;
import com.vs.service.AppointmentService;
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

	@Autowired
	private VaccinationCenterService vaccenser;

	@Autowired
	private IdCardService idCardService;

	@Autowired
	private AppointmentService appointmentService;

	// user own method

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
	public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Integer memberId,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberById(memberId, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbyaadhar/{aadhar}")
	public ResponseEntity<Member> getMemberByAadharNo(@PathVariable("aadhar") Long aadharNo,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberByAadharNo(aadharNo, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbypan/{pan}")
	public ResponseEntity<Member> getMemberByPanNo(@PathVariable("pan") String panNo,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberByPanNo(panNo, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@PostMapping(value = "/members")
	public ResponseEntity<Member> addMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Member addedMember = memberService.addMember(member, key);

		return new ResponseEntity<Member>(addedMember, HttpStatus.OK);

	}

	@PutMapping(value = "/members")
	public ResponseEntity<Member> updateMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Member updatedMember = memberService.updateMember(member, key);

		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping(value = "/members")
	public ResponseEntity<Boolean> deleteMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Boolean ans = memberService.deleteMember(member, key);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);

	}

	// user can perform vaccine registration crud operation

	@PostMapping("/addvaccineRegistration")
	public ResponseEntity<VaccineRegistration> addVaccineRegistrationHandler(@RequestBody VaccineRegistration regs,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {
		VaccineRegistration addVaccineRegistration = vrService.addVaccineRegistration(regs, key);
		return new ResponseEntity<VaccineRegistration>(addVaccineRegistration, HttpStatus.OK);
	}

	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistrationHandler(@PathVariable("moblineno") Long mobileno,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {

		VaccineRegistration vaccineRegistration = vrService.getVaccineRegistration(mobileno, key);

		return new ResponseEntity<VaccineRegistration>(vaccineRegistration, HttpStatus.OK);

	}

	@PutMapping("/vaccineRegisrations")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler(
			@RequestBody VaccineRegistration vaccineRegistration,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {

		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration, key);

		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/vaccineRegistration/{registrationNo}")
	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(
			@PathVariable("registrationNo") Integer registrationNo,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {
		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo, key);

		return new ResponseEntity<Boolean>(deleteVR, HttpStatus.OK);
	}

	// user can perform vaccine crud operation

	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccineController() throws VaccineException {
		List<Vaccine> vaccines = vaccineService.allVaccines();
		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine")
	public ResponseEntity<List<Vaccine>> getVaccineByNameController(@RequestParam("vaccineName") String vaccineName,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		List<Vaccine> vaccines = vaccineService.getVaccineByName(vaccineName, key);

		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineByIdController(@PathVariable("vaccineId") Integer vaccineId,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vaccine = vaccineService.getVaccineById(vaccineId, key);

		return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
	}

	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine, Integer vaccineInventoryId,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vacc = vaccineService.addVaccine(vaccine, vaccineInventoryId, key);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.CREATED);
	}

	@PutMapping("/vaccines")
	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vacc = vaccineService.updateVaccine(vaccine, key);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.OK);
	}

	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Boolean ans = vaccineService.deleteVaccine(vaccineId, key);

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
	public VaccinationCenter getVaccineCenter(@PathVariable("centerId") Integer centerId,
			@RequestParam(value = "key", required = false) String key) throws VaccineCenterException, LoginException {

		VaccinationCenter vc = vaccenser.getVaccineCenter(centerId, key);

		if (vc == null) {

			throw new VaccineCenterException("Vaccination Center does not found with center id :" + centerId);

		}

		return vc;
	}

	@GetMapping("/panNo")
	public ResponseEntity<Idcard> getPanCardByNumberController(@RequestParam("panNo") String panNo,
			@RequestParam(value = "key", required = false) String key) throws IdCardException, UserException {

		Idcard idcard = idCardService.getPanCardByNumber(panNo, key);

		return new ResponseEntity<Idcard>(idcard, HttpStatus.OK);

	}

	@GetMapping("/adharNo")
	public ResponseEntity<Idcard> getAdharCardByNoController(@RequestParam("adharNo") Long adharNo,
			@RequestParam(value = "key", required = false) String key) throws IdCardException, UserException {

		Idcard idcard = idCardService.getAdharCardByNo(adharNo, key);

		return new ResponseEntity<Idcard>(idcard, HttpStatus.OK);

	}

	@PostMapping("/idcard")
	public ResponseEntity<Idcard> addIdCardController(@RequestBody Idcard idCard,
			@RequestParam(value = "key", required = false) String key) throws IdCardException, UserException {

		Idcard idcard = idCardService.addIdCard(idCard, key);

		return new ResponseEntity<Idcard>(idcard, HttpStatus.CREATED);

	}

	// Appointment method

	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppoinments() throws AppointmentException {

		List<Appointment> appnintmentList = appointmentService.getAllAppoinments();

		return new ResponseEntity<List<Appointment>>(appnintmentList, HttpStatus.OK);
	}

	@GetMapping("/appointments/{bookingid}")
	public ResponseEntity<Appointment> getAppoinment(@PathVariable("bookingid") Integer bookingId,
			@RequestParam(value = "key", required = false) String key) throws AppointmentException, UserException {

		Appointment appointment = appointmentService.getAppoinment(bookingId, key);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);

	}

	@PostMapping("/appointments")
	public ResponseEntity<Appointment> addAppoinment(@RequestBody Appointment app,
			@RequestParam(value = "key", required = false) String key) throws AppointmentException, UserException {

		Appointment appointment = appointmentService.addAppoinment(app, key);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@PutMapping("/appointments")
	public ResponseEntity<Appointment> updateAppoinment(@RequestBody Appointment app,
			@RequestParam(value = "key", required = false) String key) throws AppointmentException, UserException {

		Appointment appointment = appointmentService.updateAppoinment(app, key);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@DeleteMapping("/appointments")
	public ResponseEntity<Boolean> deleteAppoinment(@RequestBody Appointment app,
			@RequestParam(value = "key", required = false) String key) throws AppointmentException, UserException {

		Boolean result = appointmentService.deleteAppoinment(app, key);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}

}
