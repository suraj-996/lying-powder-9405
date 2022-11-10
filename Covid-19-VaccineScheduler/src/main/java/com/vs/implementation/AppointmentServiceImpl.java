package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.AppointmentException;
import com.vs.model.Appointment;
import com.vs.repo.AppointmentRepo;
import com.vs.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

//	@Autowired
//	public AppointmentRepo appointmentRepo;
//	
//	@Override
//	public List<Appointment> getAllAppoinments() throws AppointmentException {
//		
//        List<Appointment> appointments = appointmentRepo.findAll();
//		
//        if (appointments.size() > 0)
//			return appointments;
//		else
//			throw new AppointmentException("No appointments found");
//        
//	}
//	
//	
//	
//	
//
//	@Override
//	public Appointment getAppoinment(Long bookingId) throws AppointmentException {
//		
//		return appointmentRepo.findById(bookingId)
//				.orElseThrow(() -> new AppointmentException("Appointment not found by booking id :"+bookingId));
//	}
//	
//	
//	
//	
//	
//
//	@Override
//	public Appointment addAppoinment(Appointment app) throws AppointmentException {
//		Appointment appointment = appointmentRepo.save(app);
//		if(appointment!=null) {
//			return appointment;
//		}else {
//			throw new AppointmentException("Appointment not Scheduled! Please try after some time!");
//		}
//	}
//
//	@Override
//	public Appointment updateAppoinment(Appointment app) throws AppointmentException {
//        Optional<Appointment> appointment = appointmentRepo.findById(app.getBookingid());
//		
//		if(appointment.isPresent()) {
//			
//			appointmentRepo.save(app);
//			
//			return appointment.get();
//		}
//		else {
//			throw new AppointmentException("No Appointment found!");
//		}
//	}
//	
//	
//
//	@Override
//	public boolean deleteAppoinment(Appointment app) throws AppointmentException {
//		
//		Appointment appointment = appointmentRepo.findById(app.getBookingid())
//				.orElseThrow(() -> new AppointmentException("Appointment not found!"));
//		
//		appointmentRepo.delete(appointment);
//		
//		
//		return true;
//	}

}
