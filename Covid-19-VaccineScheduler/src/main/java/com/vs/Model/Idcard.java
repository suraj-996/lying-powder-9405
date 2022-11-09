package com.vs.model;

import java.time.LocalDate;

public class Idcard {
	private Integer id;
	private String name;
	private LocalDate dob;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	public Idcard() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Override
	public String toString() {
		return "Idcard [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
}
