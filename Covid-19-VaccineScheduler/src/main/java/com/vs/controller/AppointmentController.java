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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.AppointmentException;
import com.vs.model.Appointment;
import com.vs.service.AppointmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//@RestController
public class AppointmentController {

//	@Autowired
//	private AppointmentService appointmentService;
//
//	@GetMapping("/appointments")
//	public ResponseEntity<List<Appointment>> getAllAppoinments() throws AppointmentException {
//
//		List<Appointment> appnintmentList = appointmentService.getAllAppoinments();
//
//		return new ResponseEntity<List<Appointment>>(appnintmentList, HttpStatus.OK);
//	}
//
//	@GetMapping("/appointments/{bookingid}")
//	public ResponseEntity<Appointment> getAppoinment(@PathVariable("bookingid") Long bookingId)
//			throws AppointmentException {
//
//		Appointment appointment = appointmentService.getAppoinment(bookingId);
//
//		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
//
//	}
//
//	@PostMapping("/appointments")
//	public ResponseEntity<Appointment> addAppoinment(@RequestBody Appointment app,
//			@RequestParam(value = "key", required = false) String key) throws AppointmentException {
//
//		Appointment appointment = appointmentService.addAppoinment(app);
//
//		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
//	}
//
//	@PutMapping("/appointments")
//	public ResponseEntity<Appointment> updateAppoinment(@RequestBody Appointment app) throws AppointmentException {
//
//		Appointment appointment = appointmentService.updateAppoinment(app);
//
//		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/appointments")
//	public ResponseEntity<Boolean> deleteAppoinment(@RequestBody Appointment app) throws AppointmentException {
//
//		Boolean result = appointmentService.deleteAppoinment(app);
//
//		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
//
//	}

}
