package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.Idcard;

@Repository
public interface IdCardRepo extends JpaRepository<Idcard, Integer>{

}
