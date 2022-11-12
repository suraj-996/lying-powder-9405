package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineException;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.Vaccine;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.repo.VaccineRepo;
import com.vs.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepo vaccineRepo;

	@Autowired
	private AdminSessionRepo adminRepo;

	@Autowired
	private UserSessionRepo userRepo;

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

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

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

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Vaccine> opt = vaccineRepo.findById(vaccineId);
			if (opt.isPresent()) {
				Vaccine vaccine = opt.get();
				return vaccine;
			} else {
				throw new VaccineException("Vaccine not found with vaccine id - " + vaccineId);
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException {
		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Vaccine vacc = vaccineRepo.save(vaccine);
			if (vacc != null) {
				return vacc;
			} else {
				throw new VaccineException("Vaccine not added");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

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

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			boolean ans = false;
			Optional<Vaccine> opt = vaccineRepo.findById(vaccineId);
			if (opt.isPresent()) {
				Vaccine v = opt.get();
				if (v.getVaccineCount().getQuantity() == 0) {
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

}
