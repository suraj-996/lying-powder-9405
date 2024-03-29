package com.vs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccineName;
	private String description;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Member member;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineInventory vaccineInventory;

	public Vaccine() {
		// TODO Auto-generated constructor stub
	}

	public Vaccine(Integer vaccineId, String vaccineName, String description, Member member) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.description = description;
		this.member = member;
	}

	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public VaccineInventory getVaccineInventory() {
		return vaccineInventory;
	}

	public void setVaccineInventory(VaccineInventory vaccineInventory) {
		this.vaccineInventory = vaccineInventory;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", vaccineName=" + vaccineName + ", description=" + description
				+ ", member=" + member + ", vaccineInventory=" + vaccineInventory + "]";
	}

}
