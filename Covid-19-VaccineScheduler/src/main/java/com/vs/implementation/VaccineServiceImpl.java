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
	public List<Vaccine> getVaccineByName(String vaccineName) throws VaccineException{
		List<Vaccine> vaccines=vaccineRepo.findVaccineByName(vaccineName);
		if(vaccines.size()!=0) {
			return vaccines;
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
	public Boolean deleteVaccine(Integer vaccineId) throws VaccineException{
		boolean ans=false;
		Optional<Vaccine> opt=vaccineRepo.findById(vaccineId);
		if(opt.isPresent()) {
			Vaccine v=opt.get();
			if(v.getVaccineCount().getQuantity()==0) {
				vaccineRepo.delete(v);
				ans=true;
				
			}
			
		}else {
			throw new VaccineException("Vaccine not found ");
		}
		return ans;
	}

}
