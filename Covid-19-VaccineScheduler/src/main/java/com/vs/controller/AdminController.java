package com.vs.controller;

import java.time.LocalDate;
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

import com.vs.exception.AdminException;
import com.vs.exception.MemberException;
import com.vs.exception.VaccineCenterException;
import com.vs.exception.VaccineException;
import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Admin;
import com.vs.model.Member;
import com.vs.model.VaccinationCenter;
import com.vs.model.Vaccine;
import com.vs.model.VaccineInventory;
import com.vs.model.VaccineRegistration;
import com.vs.service.AdminService;
import com.vs.service.MemberService;
import com.vs.service.VaccinationCenterService;
import com.vs.service.VaccineInventoryService;
import com.vs.service.VaccineRegistrationService;
import com.vs.service.VaccineService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private VaccineService vaccineService;
	

	@Autowired
	private VaccinationCenterService vaccenser;
	
	@Autowired
	private VaccineRegistrationService vrService;
	
	@Autowired
	private VaccineInventoryService vaccInvSer;
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveUser(@RequestBody Admin admin) throws AdminException {

		Admin savedCustomer = adminService.createCustomer(admin);

		return new ResponseEntity<Admin>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/admin")
	public ResponseEntity<Admin> updateUser(@RequestBody Admin admin, @RequestParam(required = false) String key)
			throws AdminException {

		Admin updatedCustomer = adminService.updateCustomer(admin, key);

		return new ResponseEntity<Admin>(updatedCustomer, HttpStatus.OK);

	}
	
	//member method

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
	
	//vaccine method
	
	
	
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccineController() throws VaccineException{
		List<Vaccine> vaccines= vaccineService.allVaccines();
		return new ResponseEntity<List<Vaccine>>(vaccines,HttpStatus.OK);
	}
	
	@GetMapping("/vaccine")
	public ResponseEntity<List<Vaccine>> getVaccineByNameController(@RequestParam("vaccineName") String vaccineName) throws VaccineException{
		List<Vaccine> vaccines=vaccineService.getVaccineByName(vaccineName);
		return new ResponseEntity<List<Vaccine>>(vaccines,HttpStatus.OK);
	}
	
	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineByIdController(@PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
		Vaccine vaccine=vaccineService.getVaccineById(vaccineId);
		return new ResponseEntity<Vaccine>(vaccine,HttpStatus.OK);
	}
	
	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine) throws VaccineException{
		Vaccine vacc=vaccineService.addVaccine(vaccine);
		return new ResponseEntity<Vaccine>(vacc,HttpStatus.CREATED);
	}
	
	@PutMapping("/vaccines")
	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine) throws VaccineException{
		Vaccine vacc=vaccineService.updateVaccine(vaccine);
		return new ResponseEntity<Vaccine>(vacc,HttpStatus.OK);
	}
	
	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
		Boolean ans=vaccineService.deleteVaccine(vaccineId);
		return new ResponseEntity<Boolean>(ans,HttpStatus.OK);
	}
	
	
	//vaccine center 
	


	@GetMapping("/getVaccCenter")
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {
		
		
		List<VaccinationCenter> allvaclist = vaccenser.getAllVaccineCenters();
		
		if(allvaclist.size()==0) {
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

	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
	
		
		
		VaccinationCenter vc =vaccenser.addVaccinationCenter(center);
		
		if(vc!=null) {
			return vc;
		}
		
			
			throw new VaccineCenterException("sorry this Vaccination center already exist");
		
		
	}

	
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
		
		
		VaccinationCenter vc =vaccenser.updateVaccinationCenter(center);
		
		if(vc==null)
			return vc;
		
		
		throw new VaccineCenterException("Vaccination Center does not exist to update");
		
		
	}

	
	public boolean deleteVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
		
		
		
	boolean flag =vaccenser.deleteVaccinationCenter(center);
		
		if(flag)
			return flag;
		
		throw new VaccineCenterException("Vaccination Center cannot be deleted ");
		
	}
	
	//vaccine registration 
	
	
	
	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<List<VaccineRegistration>> getVaccineRegistrationHandler(@PathVariable("moblineno") Long mobileno) throws VaccineRegistrationException{
		
		List<VaccineRegistration> vaccineRegistration = vrService.getVaccineRegistration(mobileno);
		return new ResponseEntity<List<VaccineRegistration>>(vaccineRegistration, HttpStatus.OK);
		
	}
	
	@PutMapping("/vaccineRegisrations")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler(@RequestBody VaccineRegistration vaccineRegistration) throws VaccineRegistrationException{
		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration);
		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}
	
//	@DeleteMapping("/vaccineRegistration/{registrationNo}")
//	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(@PathVariable("registrationNo") Integer registrationNo) throws VaccineRegistrationException{
//		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo);
//		
//	//	return new ResponseEntity<Boolean>(vrService.deleteVaccineRegistration(registrationNo));
//	}
	
	//vaccine inventory
	
	
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
