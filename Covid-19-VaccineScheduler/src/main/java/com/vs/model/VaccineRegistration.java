package com.vs.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VaccineRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registrationNo;
	private Long mobileno;
	private LocalDate dateofregistration;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	public VaccineRegistration() {
		// TODO Auto-generated constructor stub
	}
	
	public VaccineRegistration(long mobileno, LocalDate dateofregistration) {
		super();
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
	}


	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public LocalDate getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	
	
}
