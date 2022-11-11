package com.vs.service;

import java.util.List;

import com.vs.exception.VaccineCenterException;
import com.vs.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException;
	
	public VaccinationCenter getVaccineCenter(Integer centerId) throws VaccineCenterException;
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center)throws VaccineCenterException;

	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center) throws VaccineCenterException;
	
	public boolean deleteVaccinationCenter(VaccinationCenter center) throws VaccineCenterException;
	
	
}
