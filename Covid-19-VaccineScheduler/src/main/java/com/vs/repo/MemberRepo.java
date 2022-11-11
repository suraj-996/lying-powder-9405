package com.vs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

//	public Member findByAdharNo(Long aadharNo);
//
//	public Member findByPanNo(String panNo);
	
//	public List<Member> findBymemberId(Integer memberId);

}
