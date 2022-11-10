package com.vs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.MemberException;
import com.vs.model.Member;
import com.vs.repo.MemberRepo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;

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
	public Member getMemberById(Integer memberId) throws MemberException {

		Optional<Member> optional = memberRepo.findById(memberId);

		if (optional.isPresent()) {

			Member member = optional.get();

			return member;

		} else {

			throw new MemberException("No any member found with Id : " + memberId);

		}

	}

//	@Override
//	public Member getMemberByAadharNo(Long aadharNo) throws MemberException {
//
//		Member member = memberRepo.findByAdharNo(aadharNo);
//
//		if (member != null) {
//
//			return member;
//
//		} else {
//
//			throw new MemberException("Member not found with Aadhar No : " + aadharNo);
//
//		}
//	}
//
//	@Override
//	public Member getMemberByPanNo(String panNo) throws MemberException {
//
//		Member member = memberRepo.findByPanNo(panNo);
//
//		if (member != null) {
//
//			return member;
//
//		} else {
//
//			throw new MemberException("Member not found with Aadhar No : " + panNo);
//
//		}
//	}

	@Override
	public Member addMember(Member member) throws MemberException {

		Member registeredMember = memberRepo.save(member);

		if (registeredMember != null) {

			return member;

		} else {

			throw new MemberException("Something went wrong.");

		}
	}

	@Override
	public Member updateMember(Member member) throws MemberException {

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
	}

	@Override
	public Boolean deleteMember(Member member) throws MemberException {

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
	}

}
