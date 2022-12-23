package com.vs.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registrationNo;
	private String mobileno;
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	public VaccineRegistration() {
		// TODO Auto-generated constructor stub
	}
	
	public VaccineRegistration(String mobileno, LocalDate dateofregistration) {
		super();
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
	}

	public Integer getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Integer registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public LocalDate getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
	

	
	
}
