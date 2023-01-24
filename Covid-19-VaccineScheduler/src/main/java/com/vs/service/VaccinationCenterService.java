package com.vs.service;

import java.util.List;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineCenterException;
import com.vs.model.VaccinationCenter;

public interface VaccinationCenterService {

	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException;

	public VaccinationCenter getVaccineCenter(Integer centerId, String key)
			throws VaccineCenterException, LoginException;

	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, Integer vaccineInventoryId, String key)
			throws VaccineCenterException, LoginException;

	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException;

	public boolean deleteVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException;

}
