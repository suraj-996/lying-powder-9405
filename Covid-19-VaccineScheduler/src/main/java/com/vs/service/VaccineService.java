package com.vs.service;

import java.util.List;

import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;

public interface VaccineService {
	public List<Vaccine> allVaccines() throws VaccineException;
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException;
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException;
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException;
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException;
	public Boolean deleteVaccine(Vaccine vaccine) throws VaccineException;
}
