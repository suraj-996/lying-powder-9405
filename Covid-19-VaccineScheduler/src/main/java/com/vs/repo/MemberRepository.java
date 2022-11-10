package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vs.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
