package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.Vaccine;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer>{

}
