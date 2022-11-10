package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.Idcard;

@Repository
public interface IdCardRepo extends JpaRepository<Idcard, Integer>{
	@Query("select i from Idcard i where adharCard.adharNo=?1")
	public Idcard findByAdharCardNo(Long adharNo);
	@Query("select i from Idcard i where panCard.panNo=?1")
	public Idcard findByPanCardNo(String panNo);
}
