package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;
import com.vs.repo.MemberRepo;
import com.vs.repo.VaccineRegistrationRepo;
import com.vs.service.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{
	
	@Autowired
	private VaccineRegistrationRepo vaccineRegistrationRepo;
	
	@Autowired
	private MemberRepo memberRepo;

	@Override
	public List<VaccineRegistration> getVaccineRegistration(Long moblieno) throws VaccineRegistrationException {
		
		List<VaccineRegistration> vaccineRegistration = vaccineRegistrationRepo.findByMobileno(moblieno);
		if(vaccineRegistration.size() > 0) {
			return vaccineRegistration;
		}else {
			throw new VaccineRegistrationException("No VaccineRegistration found...");
		}
		
	}

	@Override
	public List<Member> getAllMember(Long mobileno) throws VaccineRegistrationException {
		
		List<Member> member = memberRepo.findAll();
		
		if(member.size()==0) {
			throw new VaccineRegistrationException("No memeber Found");
		}else {
			return member;
		}
		
		
	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
//		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
//		if(opt.isPresent()) {
//			throw new VaccineRegistrationException("VaccineRegistration present already");
//		}
//		return opt.
		
//		Optional<VaccineRegistration> vaccineRegestration = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
		
		VaccineRegistration addVaccineRegistration = vaccineRegistrationRepo.save(regs);
		
		return addVaccineRegistration;
		
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
		
		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
		if(opt.isPresent()) {
			VaccineRegistration updatedVaccineRegs = vaccineRegistrationRepo.save(regs);
			return updatedVaccineRegs;
		}else {
			throw new VaccineRegistrationException("Invalid VaccineRegistration");
		}
		
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
		if(!opt.isPresent()) {
			throw new RuntimeException("not able to access");
		}
		
		VaccineRegistration vaccineRegestration = vaccineRegistrationRepo.findById(regs.getRegistrationNo())
													.orElseThrow(()->new VaccineRegistrationException("Vaccine Registration not Found"));
		vaccineRegistrationRepo.delete(vaccineRegestration);
		return true;
	}

}
