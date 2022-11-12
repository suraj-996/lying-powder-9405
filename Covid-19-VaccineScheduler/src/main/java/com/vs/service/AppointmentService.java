package com.vs.service;

import java.util.List;
import com.vs.exception.AppointmentException;
import com.vs.exception.UserException;
import com.vs.model.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppoinments() throws AppointmentException;

	public Appointment getAppoinment(Integer bookingId, String key) throws AppointmentException, UserException;

	public Appointment addAppoinment(Appointment app, String key) throws AppointmentException, UserException;

	public Appointment updateAppoinment(Appointment app, String key) throws AppointmentException, UserException;

	public boolean deleteAppoinment(Appointment app, String key) throws AppointmentException, UserException;

}
