package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.VaccineException;
import com.vs.model.Vaccine;
import com.vs.repo.VaccineRepo;
import com.vs.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {
	@Autowired
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
		Vaccine vaccine=vaccineRepo.findVaccineByName(vaccineName);
		if(vaccine!=null) {
			return vaccine;
		}else {
			throw new VaccineException("Vaccine not found with vaccine name - "+vaccineName);
		}
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException{
		Optional<Vaccine> opt=vaccineRepo.findById(vaccineId);
		if(opt.isPresent()) {
			Vaccine vaccine=opt.get();
			return vaccine;
		}else {
			throw new VaccineException("Vaccine not found with vaccine id - "+vaccineId);
		}
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException{
		Vaccine vacc=vaccineRepo.save(vaccine);
		if(vacc!=null) {
			return vacc;
		}else {
			throw new VaccineException("Vaccine not added");
		}
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException{
		Optional<Vaccine> opt=vaccineRepo.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			Vaccine updatedVaccine=vaccineRepo.save(vaccine);
			return updatedVaccine;
		}else {
			throw new VaccineException("Vaccine not found ");
		}
		
	}

	@Override
	public Boolean deleteVaccine(Vaccine vaccine) throws VaccineException{
		boolean ans=false;
		Optional<Vaccine> opt=vaccineRepo.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			vaccineRepo.delete(vaccine);
			ans=true;
		}else {
			throw new VaccineException("Vaccine not found ");
		}
		return ans;
	}

}
