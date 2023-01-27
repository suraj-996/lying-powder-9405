package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.AppointmentException;
import com.vs.exception.UserException;
import com.vs.model.Appointment;
import com.vs.model.CurrentUserSession;
import com.vs.model.VaccinationCenter;
import com.vs.repo.AppointmentRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.repo.VaccinationCenterRepo;
import com.vs.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	public AppointmentRepo appointmentRepo;

	@Autowired
	private UserSessionRepo userSessionRepo;

	@Autowired
	private VaccinationCenterRepo vaccinationCenterRepo;

	@Override
	public List<Appointment> getAllAppoinmentsByVaccineCenterId(Integer vaccinationCenterId)
			throws AppointmentException {

		Optional<VaccinationCenter> optVaccinationCenter = vaccinationCenterRepo.findById(vaccinationCenterId);

		if (optVaccinationCenter.isPresent()) {
			List<Appointment> oppointments = optVaccinationCenter.get().getAppointments();
			if (oppointments.size() != 0)
				return oppointments;
			else
				throw new AppointmentException("No appointments found");
		} else {
			throw new AppointmentException("Enter proper vaccination center Id.");
		}

	}

	@Override
	public Appointment getAppoinment(Integer bookingId, String key) throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {
			return appointmentRepo.findById(bookingId)
					.orElseThrow(() -> new AppointmentException("Appointment not found by booking id :" + bookingId));
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

	@Override
	public Appointment addAppoinment(Appointment app, Integer vaccinationCenterId, String key)
			throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {
			Optional<VaccinationCenter> optVaccinationCenter = vaccinationCenterRepo.findById(vaccinationCenterId);
			if (optVaccinationCenter.isPresent()) {
				VaccinationCenter vaccinationCenter = optVaccinationCenter.get();
				app.getVaccinationCenters().add(vaccinationCenter);
				vaccinationCenter.getAppointments().add(app);
				vaccinationCenterRepo.save(vaccinationCenter);
				return appointmentRepo.save(app);
			} else {
				throw new AppointmentException("VaccinationCenter not found enter correct ID.");
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

	@Override
	public Appointment updateAppoinment(Appointment app, String key) throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {

			Optional<Appointment> appointment = appointmentRepo.findById(app.getBookingid());

			if (appointment.isPresent()) {

				appointmentRepo.save(app);

				return appointment.get();
			} else {
				throw new AppointmentException("No Appointment found!");
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

	@Override
	public boolean deleteAppoinment(Appointment app, String key) throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {
			Appointment appointment = appointmentRepo.findById(app.getBookingid())
					.orElseThrow(() -> new AppointmentException("Appointment not found!"));

			appointmentRepo.delete(appointment);

			return true;

		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

}
