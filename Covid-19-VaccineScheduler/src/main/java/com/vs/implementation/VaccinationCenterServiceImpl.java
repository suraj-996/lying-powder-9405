package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineCenterException;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.VaccinationCenter;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.repo.VaccinationCenterRepo;
import com.vs.service.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepo vacenRepo;

	@Autowired
	private AdminSessionRepo adminRepo;

	@Autowired
	private UserSessionRepo userRepo;

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {

		List<VaccinationCenter> allvaccenters = vacenRepo.findAll();

		if (allvaccenters.size() == 0) {

			throw new VaccineCenterException("List is Empty , no Vaccinaton Center found");
		}

		return allvaccenters;

	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerId, String key)
			throws VaccineCenterException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vacenRepo.findById(centerId);

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				return vc;

			} else
				throw new VaccineCenterException("Vaccination Center does not found with center id :" + centerId);
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vacenRepo.findById(center.getCode());

			if (opt.isPresent()) {

				throw new VaccineCenterException("sorry this Vaccination center already exist");
			} else
				return vacenRepo.save(center);
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vacenRepo.findById(center.getCode());

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				return vacenRepo.save(vc);
			} else
				throw new VaccineCenterException("Vaccination Center does not exist to update");
		} else {
			throw new LoginException("Oops...! Login as a user/Admin first.");
		}

	}

	@Override
	public boolean deleteVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vacenRepo.findById(center.getCode());

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				vacenRepo.delete(vc);

				return true;

			} else {
				throw new VaccineCenterException("Vaccination Center cannot be deleted ");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

}
