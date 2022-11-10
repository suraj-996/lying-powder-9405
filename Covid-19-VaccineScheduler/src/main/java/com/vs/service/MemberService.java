package com.vs.service;

import java.util.List;

import com.vs.exception.MemberException;
import com.vs.model.Member;

public interface MemberService {

	public List<Member> getAllMembers() throws MemberException;

	public Member getMemberById(Integer memberId) throws MemberException;

	public Member getMemberByAadharNo(Long aadharNo) throws MemberException;

	public Member getMemberByPanNo(String panNo) throws MemberException;

	public Member addMember(Member member) throws MemberException;

	public Member updateMember(Member member) throws MemberException;

	public boolean deleteMember(Member member) throws MemberException;
	
}
