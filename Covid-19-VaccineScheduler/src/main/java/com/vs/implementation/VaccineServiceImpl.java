package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineException;
import com.vs.model.Admin;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.User;
import com.vs.model.Vaccine;
import com.vs.model.VaccineInventory;
import com.vs.repo.AdminRepo;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.UserRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.repo.VaccineInventoryRepo;
import com.vs.repo.VaccineRepo;
import com.vs.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepo vaccineRepo;

	@Autowired
	private AdminSessionRepo adminSessionRepo;

	@Autowired
	private UserSessionRepo userSessionRepo;

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private VaccineInventoryRepo vaccineInventoryRepo;

	@Override
	public List<Vaccine> allVaccines() throws VaccineException {
		List<Vaccine> vaccines = vaccineRepo.findAll();
		if (vaccines.size() != 0) {
			return vaccines;
		} else {
			throw new VaccineException("Vaccine not found");
		}
	}

	@Override
	public List<Vaccine> getVaccineByName(String vaccineName, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			List<Vaccine> vaccines = vaccineRepo.findVaccineByName(vaccineName, key);
			if (vaccines.size() != 0) {
				return vaccines;
			} else {
				throw new VaccineException("Vaccine not found with vaccine name - " + vaccineName);
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Vaccine> opt = vaccineRepo.findById(vaccineId);
			if (opt.isPresent()) {
				Vaccine vaccine = opt.get();
				System.out.println(vaccine);
//				Optional<VaccineInventory> optVaccineInventory = vaccineInventoryRepo
//						.findById(vaccine.getVaccineInventory().getInventoryId());
//				System.out.println(optVaccineInventory.get());
				return vaccine;
			} else {
				throw new VaccineException("Vaccine not found with vaccine id - " + vaccineId);
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, Integer vaccineInventoryId, String key)
			throws VaccineException, LoginException {
		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccineInventory> optionalVaccineInventory = vaccineInventoryRepo.findById(vaccineInventoryId);
			if (optionalVaccineInventory.isPresent()) {
				VaccineInventory vaccineInventory = optionalVaccineInventory.get();
				vaccine.setVaccineInventory(vaccineInventory);
				return vaccineRepo.save(vaccine);
			} else {
				throw new VaccineException("Inventory not found with ID " + vaccineInventoryId);
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Vaccine> opt = vaccineRepo.findById(vaccine.getVaccineId());
			if (opt.isPresent()) {
				Vaccine updatedVaccine = vaccineRepo.save(vaccine);
				return updatedVaccine;
			} else {
				throw new VaccineException("Vaccine not found ");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public Boolean deleteVaccine(Integer vaccineId, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			boolean ans = false;
			Optional<Vaccine> opt = vaccineRepo.findById(vaccineId);
			if (opt.isPresent()) {
				Vaccine v = opt.get();
				VaccineInventory vaccineInventory = v.getVaccineInventory();
				if (vaccineInventory.getVaccineCount().getQuantity() == 0) {
					vaccineRepo.delete(v);
					ans = true;
				}

			} else {
				throw new VaccineException("Vaccine not found ");
			}
			return ans;
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
	}

	@Override
	public String bookVaccine(Integer vaccineId, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminSessionRepo.findByuuid(key);
		CurrentUserSession currentSessionUser = userSessionRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {
			Optional<User> optUser = userRepo.findById(currentSessionUser.getUserId());
			if (optUser.isPresent()) {

			}

			Optional<Admin> optAdmin = adminRepo.findById(currentSessionAdmin.getUserId());
			if (optAdmin.isPresent()) {

			}

		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

		return null;
	}

}
