package com.vs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vs.model.Vaccine;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {

	@Query("select v from Vaccine v where v.vaccineName=?1")
	public List<Vaccine> findVaccineByName(String vaccineName, String key);
}
