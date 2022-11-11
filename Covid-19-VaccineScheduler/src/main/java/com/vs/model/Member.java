package com.vs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	private Boolean dose1status;
	private Boolean dose2status;
	private LocalDate dose1date;
	private LocalDate dose2date;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
	private VaccineRegistration vaccineRegistration;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointment;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Vaccine> vaccine;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
	private Idcard idcard;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(Boolean dose1status, Boolean dose2status, LocalDate dose1date, LocalDate dose2date,
			VaccineRegistration vaccineRegistration, List<Appointment> appointment, List<Vaccine> vaccine,
			Idcard idcard) {
		super();
		this.dose1status = dose1status;
		this.dose2status = dose2status;
		this.dose1date = dose1date;
		this.dose2date = dose2date;
		this.vaccineRegistration = vaccineRegistration;
		this.appointment = appointment;
		this.vaccine = vaccine;
		this.idcard = idcard;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Boolean getDose1status() {
		return dose1status;
	}

	public void setDose1status(Boolean dose1status) {
		this.dose1status = dose1status;
	}

	public Boolean getDose2status() {
		return dose2status;
	}

	public void setDose2status(Boolean dose2status) {
		this.dose2status = dose2status;
	}

	public LocalDate getDose1date() {
		return dose1date;
	}

	public void setDose1date(LocalDate dose1date) {
		this.dose1date = dose1date;
	}

	public LocalDate getDose2date() {
		return dose2date;
	}

	public void setDose2date(LocalDate dose2date) {
		this.dose2date = dose2date;
	}

	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}

	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public List<Vaccine> getVaccine() {
		return vaccine;
	}

	public void setVaccine(List<Vaccine> vaccine) {
		this.vaccine = vaccine;
	}

	public Idcard getIdcard() {
		return idcard;
	}

	public void setIdcard(Idcard idcard) {
		this.idcard = idcard;
	}

}
