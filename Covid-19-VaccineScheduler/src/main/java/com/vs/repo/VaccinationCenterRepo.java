package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.VaccinationCenter;

@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

	@Query("select c from VaccinationCenter c where c.centername=?1")
	public VaccinationCenter findVaccinationCenterByName(String centername, String key);

}
