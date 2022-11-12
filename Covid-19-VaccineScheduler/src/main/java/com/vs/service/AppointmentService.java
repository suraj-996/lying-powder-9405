package com.vs.service;

import java.util.List;
import com.vs.exception.AppointmentException;
import com.vs.model.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppoinments() throws AppointmentException;

	public Appointment getAppoinment(Long bookingId) throws AppointmentException;

	public Appointment addAppoinment(Appointment app) throws AppointmentException;

	public Appointment updateAppoinment(Appointment app) throws AppointmentException;

	public boolean deleteAppoinment(Appointment app) throws AppointmentException;

}
