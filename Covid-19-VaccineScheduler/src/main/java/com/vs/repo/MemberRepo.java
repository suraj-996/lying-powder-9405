package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.adharCard.adharNo=?1)")
	public Member getByAdharNo(Long aadharNo);

	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.panCard.panNo=?1)")
	public Member getByPanNo(String panNo);

}
