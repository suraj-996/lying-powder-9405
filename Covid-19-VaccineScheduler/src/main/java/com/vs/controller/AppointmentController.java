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
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.AppointmentException;
import com.vs.model.Appointment;
import com.vs.service.AppointmentService;

@RestController
public class AppointmentController {
	
	 @Autowired
	 public AppointmentService appointmentService;
	 
	 @PostMapping("/appointment")
		public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) throws AppointmentException{
			Appointment app = appointmentService.addAppointment(appointment);
			return new ResponseEntity<Appointment>(app,HttpStatus.CREATED);
		}
	 
	 @GetMapping("/appointments")
		public ResponseEntity<List<Appointment>> getAllAppointmentController() throws AppointmentException{
			List<Appointment> vaccines= appointmentService.getAllAppointments();
			return new ResponseEntity<List<Appointment>>(vaccines,HttpStatus.OK);
		}
	 
	 @GetMapping("/appointment/{bookingId}")
		public ResponseEntity<Appointment> getAppointmentController(@PathVariable("bookingId") Long bookingId) throws AppointmentException{
			Appointment app = appointmentService.getAppointment(bookingId);
			return new ResponseEntity<Appointment>(app,HttpStatus.OK);
		}
	 
	 @PutMapping("/update_appointment")
		public ResponseEntity<Appointment> updateVaccineController(@RequestBody Appointment appointment) throws AppointmentException{
			Appointment app = appointmentService.updateAppointment(appointment);
			return new ResponseEntity<Appointment>(app,HttpStatus.OK);
		}
	 
	 @DeleteMapping("/appointments/{bookingId}")
		public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("bookingId") Long bookingId) throws AppointmentException{
			Boolean res = appointmentService.deleteAppointment(bookingId);
			return new ResponseEntity<Boolean>(res,HttpStatus.OK);
		}
	 

}
