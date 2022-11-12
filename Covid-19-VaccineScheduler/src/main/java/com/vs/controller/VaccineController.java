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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;
import com.vs.service.VaccineService;

//@RestController
public class VaccineController {
//	@Autowired
//	private VaccineService vaccineService;
//	
//	@GetMapping("/vaccines")
//	public ResponseEntity<List<Vaccine>> allVaccineController() throws VaccineException{
//		List<Vaccine> vaccines= vaccineService.allVaccines();
//		return new ResponseEntity<List<Vaccine>>(vaccines,HttpStatus.OK);
//	}
//	
//	@GetMapping("/vaccine")
//	public ResponseEntity<List<Vaccine>> getVaccineByNameController(@RequestParam("vaccineName") String vaccineName) throws VaccineException{
//		List<Vaccine> vaccines=vaccineService.getVaccineByName(vaccineName);
//		return new ResponseEntity<List<Vaccine>>(vaccines,HttpStatus.OK);
//	}
//	
//	@GetMapping("/vaccine/{vaccineId}")
//	public ResponseEntity<Vaccine> getVaccineByIdController(@PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
//		Vaccine vaccine=vaccineService.getVaccineById(vaccineId);
//		return new ResponseEntity<Vaccine>(vaccine,HttpStatus.OK);
//	}
//	
//	@PostMapping("/vaccines")
//	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine) throws VaccineException{
//		Vaccine vacc=vaccineService.addVaccine(vaccine);
//		return new ResponseEntity<Vaccine>(vacc,HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/vaccines")
//	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine) throws VaccineException{
//		Vaccine vacc=vaccineService.updateVaccine(vaccine);
//		return new ResponseEntity<Vaccine>(vacc,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/vaccines/{vaccineId}")
//	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId) throws VaccineException{
//		Boolean ans=vaccineService.deleteVaccine(vaccineId);
//		return new ResponseEntity<Boolean>(ans,HttpStatus.OK);
//	}
	
}
