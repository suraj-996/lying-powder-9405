package com.vs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

<<<<<<< HEAD
	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.adharCard.adharNo=?1)")
	public Member getByAdharNo(Long aadharNo);

	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.panCard.panNo=?1)")
	public Member getByPanNo(String panNo);
=======
//	public Member findByAdharNo(Long aadharNo);
//
//	public Member findByPanNo(String panNo);
	
//	public List<Member> findBymemberId(Integer memberId);
>>>>>>> d9ef656f4f945056e27fe2db78bec3f30f257f5c

}
