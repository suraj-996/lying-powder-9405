package com.vs.service;

import java.util.List;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;

public interface VaccineService {

	public List<Vaccine> allVaccines() throws VaccineException;

	public List<Vaccine> getVaccineByName(String vaccineName, String key) throws VaccineException, LoginException;

	public Vaccine getVaccineById(Integer vaccineId, String key) throws VaccineException, LoginException;

	public Vaccine addVaccine(Vaccine vaccine, Integer vaccineInventoryId, String key)
			throws VaccineException, LoginException;

	public Vaccine updateVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException;

	public Boolean deleteVaccine(Integer vaccineId, String key) throws VaccineException, LoginException;

	public String bookVaccine(Integer vaccineId, Integer memberId, String key) throws VaccineException, LoginException;

}
