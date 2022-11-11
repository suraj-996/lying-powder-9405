package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.VaccineCenterException;
import com.vs.model.VaccinationCenter;
import com.vs.repo.VaccinationCenterRepo;
import com.vs.service.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{
	
	@Autowired
	private VaccinationCenterRepo vacenRepo;
	

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {
		
		List<VaccinationCenter> allvaccenters =vacenRepo.findAll();
		
		if(allvaccenters.size()==0) {
			
			throw new VaccineCenterException("List is Empty , no Vaccinaton Center found");
		}
		
		return allvaccenters;
		
	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerId) throws VaccineCenterException {
		
		Optional<VaccinationCenter> opt =vacenRepo.findById(centerId);
		
		if(opt.isPresent()) {
			
			VaccinationCenter vc =opt.get();
			
			return vc;
			
			
		}
		
		throw new VaccineCenterException("Vaccination Center does not found with center id :"+centerId);
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
		
		
		Optional<VaccinationCenter> opt =vacenRepo.findById(center.getCode());
		
		if(opt.isPresent()) {
			
			throw new VaccineCenterException("sorry this Vaccination center already exist");
		}
		
		return vacenRepo.save(center);
		
	}

	
	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
		
		Optional<VaccinationCenter> opt =vacenRepo.findById(center.getCode());
		
		if(opt.isPresent()) {
			
			VaccinationCenter vc =opt.get();
			
			return vacenRepo.save(vc);
		}
		
		throw new VaccineCenterException("Vaccination Center does not exist to update");
		
		
	}

	@Override
	public boolean deleteVaccinationCenter(VaccinationCenter center) throws VaccineCenterException {
		
		
		
		Optional<VaccinationCenter> opt =vacenRepo.findById(center.getCode());
		
		if(opt.isPresent()) {
			
			VaccinationCenter vc =opt.get();
			
			vacenRepo.delete(vc);
			
			return true;
			
		}
		
		
		
		throw new VaccineCenterException("Vaccination Center cannot be deleted ");
		
	}

	

}
