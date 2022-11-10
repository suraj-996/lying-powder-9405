package com.vs.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;
import com.vs.repo.VaccineRepo;
import com.vs.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {
	private VaccineRepo vaccineRepo;
	@Override
	public List<Vaccine> allVaccines() throws VaccineException{
		List<Vaccine> vaccines=vaccineRepo.findAll();
		if(vaccines.size()!=0) {
			return vaccines;
		}else {
			throw new VaccineException("Vaccine not found");
		}
	}

	@Override
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteVaccine(Vaccine vaccine) throws VaccineException{
		// TODO Auto-generated method stub
		return null;
	}

}
