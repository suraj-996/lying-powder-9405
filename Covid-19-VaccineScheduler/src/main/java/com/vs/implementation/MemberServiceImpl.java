package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.LoginException;
import com.vs.exception.MemberException;
import com.vs.model.CurrentAdminSession;
import com.vs.model.CurrentUserSession;
import com.vs.model.Member;
import com.vs.repo.AdminSessionRepo;
import com.vs.repo.MemberRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private AdminSessionRepo adminRepo;

	@Autowired
	private UserSessionRepo userRepo;

	@Override
	public List<Member> getAllMembers() throws MemberException {

		List<Member> memberList = memberRepo.findAll();

		if (memberList.isEmpty()) {

			throw new MemberException("No any member found in data.");

		} else {

			return memberList;

		}
	}

	@Override
	public Member getMemberById(Integer memberId, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberRepo.findById(memberId);

			if (optional.isPresent()) {

				Member member = optional.get();

				return member;

			} else {

				throw new MemberException("No any member found with Id : " + memberId);

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");

	}

	@Override
	public Member getMemberByAadharNo(Long aadharNo, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member member = memberRepo.getByAdharNo(aadharNo);

			if (member != null) {

				return member;

			} else {

				throw new MemberException("Member not found with Aadhar No : " + aadharNo);

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
	}

	@Override
	public Member getMemberByPanNo(String panNo, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member member = memberRepo.getByPanNo(panNo);

			if (member != null) {

				return member;

			} else {

				throw new MemberException("Member not found with Aadhar No : " + panNo);

			}

		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
	}

	@Override
	public Member addMember(Member member, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member registeredMember = memberRepo.save(member);

			if (registeredMember != null) {

				return member;

			} else {

				throw new MemberException("Something went wrong.");

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
	}

	@Override
	public Member updateMember(Member member, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberRepo.findById(member.getMemberId());

			if (optional.isPresent()) {

				Member oldMember = optional.get();

				oldMember.setDose1date(member.getDose1date());
				oldMember.setDose1status(member.getDose1status());
				oldMember.setDose2date(member.getDose2date());
				oldMember.setDose2status(member.getDose2status());

				return memberRepo.save(oldMember);

			} else {

				throw new MemberException("No any member found with memberId : " + member.getMemberId());

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
	}

	@Override
	public Boolean deleteMember(Member member, String key) throws MemberException, LoginException {

		CurrentAdminSession currentSessionAdmin = adminRepo.findByuuid(key);

		CurrentUserSession currentSessionUser = userRepo.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberRepo.findById(member.getMemberId());

			if (optional.isPresent()) {

				Member currentMember = optional.get();

				if (currentMember.getDose1status() == true) {

					if (currentMember.getDose2status() == true) {

						memberRepo.delete(currentMember);

						return true;

					} else {
						throw new MemberException("Member must have to complete dose 2.");
					}

				} else {
					throw new MemberException("Member must have to complete dose 1 & dose 2.");
				}

			} else {
				throw new MemberException("No any member found with memberId : " + member.getMemberId());
			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
	}

}
