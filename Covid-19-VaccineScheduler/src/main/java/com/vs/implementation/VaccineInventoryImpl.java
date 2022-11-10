package com.vs.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vs.exception.VaccineException;
import com.vs.model.VaccinationCenter;
import com.vs.model.Vaccine;
import com.vs.model.VaccineCount;
import com.vs.model.VaccineInventory;
import com.vs.repo.VaccineInventoryRepo;
import com.vs.service.VaccineInventoryService;

@Service
public class VaccineInventoryImpl implements VaccineInventoryService {

	@Autowired
	private VaccineInventoryRepo viRepo;

   //   private VaccinationCentreRepo vcRepo;

	@Override
	public VaccineInventory getVaccineInventoryByCenter(Integer Centerid) throws VaccineException {

//		Optional<VaccinationCenter> opt = vcRepo.findById(Centerid);
//
//		if (opt.isPresent()) {
//
//			VaccinationCenter vc = opt.get();
//
//			return vc.getVaccineInventory();
//		}
//
//		throw new VaccineException("Enter valid center id");
		
		return null;

	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory vinv, Integer count) throws VaccineException {
		// TODO Auto-generated method stub

		Optional<VaccineInventory> opt = viRepo.findById(vinv.getInventoryId());

		if (opt.isPresent()) {

			VaccineInventory vi = opt.get();

			if (count >= 0) {
				
				VaccineCount vcCount = vi.getVaccineCount();

				Integer update = vcCount.getQuantity() + count;

				Double price = vcCount.getPrice();

				vcCount.setQuantity(update);
				vcCount.setPrice(price);

				vi.setVaccineCount(vcCount);

				return viRepo.save(vi);
			} else {
				throw new VaccineException("Count must be greater than 0.");
			}
		} else {
			throw new VaccineException("Vaccine Inventory not found.");
		}

	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vinv) throws VaccineException {

		// TODO Auto-generated method stub
		Optional<VaccineInventory> opt = viRepo.findById(vinv.getInventoryId());
		
		if(opt.isPresent()) {
			
			VaccineInventory vi  =opt.get();
			
			vi.setDate(vinv.getDate());
			vi.setInventoryId(vinv.getInventoryId());
			vi.setLocation(vinv.getLocation());
			vi.setVaccinationCenters(vinv.getVaccinationCenters());
			vi.setVaccineCount(vinv.getVaccineCount());
			
			return vi;
	}
		
		throw new VaccineException("Vaccine inventory not found");


	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory vinv) throws VaccineException {
		// TODO Auto-generated method stub
		
		Optional<VaccineInventory> opt =viRepo.findById(vinv.getInventoryId());
		
		if(opt!=null) {
			
			VaccineInventory vi =opt.get();
			
			viRepo.delete(vi);
			
			return true;
		}

		return false;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate ld) throws VaccineException {
		// TODO Auto-generated method stub

	       List<VaccineInventory> inventorylist = viRepo.findByDate(ld);
	       
	       if(inventorylist.size()>0) {
	    	   
	    	   return inventorylist;
	       }
	       
		
		throw new VaccineException("Vaccine inventory not found");
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vc) throws VaccineException {
		// TODO Auto-generated method stub
		
		List<VaccineInventory> inventorylist =viRepo.findAll();
		
		if(inventorylist.size()==0) {
			throw new VaccineException("inventoryList is empty");
		}
		
		List<VaccineInventory> inventorylistbyvaccinename = new ArrayList<>();
		
		for(VaccineInventory vaccineinventory: inventorylist) {
			
			if(vaccineinventory.getVaccine().getVaccineName().equalsIgnoreCase(vc.getVaccineName())) {
				inventorylistbyvaccinename.add(vaccineinventory);
			}
			
		}
		
		if(inventorylistbyvaccinename.size()==0) {
			throw new VaccineException("no such Vaccineinventory exist with vaccine name:"+vc.getVaccineName());
		}
		

		return inventorylistbyvaccinename;
	}

	
}
