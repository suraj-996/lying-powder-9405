package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.MemberException;
import com.vs.model.Member;
import com.vs.repo.MemberRepository;
import com.vs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Member> getAllMembers() throws MemberException {

		List<Member> memberList = memberRepository.findAll();

		if (memberList.isEmpty()) {

			throw new MemberException("No any member found in data.");

		} else {

			return memberList;

		}
	}

	@Override
	public Member getMemberById(Integer memberId) throws MemberException {

		Optional<Member> optional = memberRepository.findById(memberId);

		if (optional.isPresent()) {

			Member member = optional.get();

			return member;
		} else
			throw new MemberException("No any member found with Id : " + memberId);

	}

	@Override
	public Member getMemberByAadharNo(Long aadharNo) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByPanNo(String panNo) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return false;
	}

}
