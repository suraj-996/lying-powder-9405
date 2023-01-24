package com.vs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer code;
	private String centername;
	private String address;
	private String state;
	private String pincode;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointments;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineInventory vaccineInventory;

	public List<Appointment> getAppointments() {

		return appointments;

	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public VaccineInventory getVaccineInventory() {
		return vaccineInventory;
	}

	public void setVaccineInventory(VaccineInventory vaccineInventory) {
		this.vaccineInventory = vaccineInventory;
	}

	public VaccinationCenter() {
		// TODO Auto-generated constructor stub
	}

	public VaccinationCenter(Integer code, String centername, String address, String state, String pincode) {
		super();
		this.code = code;
		this.centername = centername;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {

		this.state = state;

	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
