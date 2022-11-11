package com.vs.service;

import java.util.List;
import com.vs.exception.AppointmentException;
import com.vs.model.Appointment;

public interface AppointmentService {
	
	public List<Appointment> getAllAppointments() throws AppointmentException;
	
	public Appointment getAppointment(Long bookingId) throws AppointmentException;
	
	public Appointment addAppointment(Appointment app) throws AppointmentException;
	
	public Appointment updateAppointment(Appointment app) throws AppointmentException;
	
	public boolean deleteAppointment(Long bookingId) throws AppointmentException;

}
