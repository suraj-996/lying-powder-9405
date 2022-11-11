package com.vs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.IdCardException;
import com.vs.model.Idcard;
import com.vs.service.IdCardService;

//@RestController
public class IdCardController {
	@Autowired
	private IdCardService idCardService;
	
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
