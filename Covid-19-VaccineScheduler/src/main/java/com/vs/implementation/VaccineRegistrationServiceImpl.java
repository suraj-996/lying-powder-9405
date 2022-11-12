package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.exception.VaccineRegistrationException;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.MemberRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.repo.VaccineRegistrationRepo;
import com.vs.service.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Autowired
	private VaccineRegistrationRepo vaccineRegistrationRepo;

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private AdminSessionRepo adminRepo;

	@Autowired
	private UserSessionRepo userRepo;

	@Override
	public VaccineRegistration getVaccineRegistration(Long moblieno, String key)
			throws VaccineRegistrationException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			VaccineRegistration vaccineRegistration = vaccineRegistrationRepo.findByMobileno(moblieno, key);
			if (vaccineRegistration != null) {
				return vaccineRegistration;
			} else {
				throw new VaccineRegistrationException("No VaccineRegistration found...");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public List<Member> getAllMember(Long mobileno, String key) throws VaccineRegistrationException, LoginException {

		List<Member> member = memberRepo.findAll();

		if (member.size() == 0) {
			throw new VaccineRegistrationException("No memeber Found");
		} else {
			return member;
		}

	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration regs, String key)
			throws VaccineRegistrationException, LoginException {
//		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
//		if(opt.isPresent()) {
//			throw new VaccineRegistrationException("VaccineRegistration present already");
//		}
//		return opt.

//		Optional<VaccineRegistration> vaccineRegestration = vaccineRegistrationRepo.findById(regs.getRegistrationNo());

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			VaccineRegistration addVaccineRegistration = vaccineRegistrationRepo.save(regs);

			return addVaccineRegistration;

		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration regs, String key)
			throws VaccineRegistrationException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
			if (opt.isPresent()) {
				VaccineRegistration updatedVaccineRegs = vaccineRegistrationRepo.save(regs);
				return updatedVaccineRegs;
			} else {
				throw new VaccineRegistrationException("Invalid VaccineRegistration");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration regs, String key)
			throws VaccineRegistrationException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
			if (!opt.isPresent()) {
				throw new RuntimeException("not able to access");
			} else {
				VaccineRegistration vaccineRegestration = vaccineRegistrationRepo.findById(regs.getRegistrationNo())
						.orElseThrow(() -> new VaccineRegistrationException("Vaccine Registration not Found"));
				vaccineRegistrationRepo.delete(vaccineRegestration);
				return true;
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
	}

}
