package com.vs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VaccineInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	private LocalDate date;
	private String location;
	
	@Embedded
	private VaccineCount vaccineCount; 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vaccineInventory")
	private List<VaccinationCenter> vaccinationCenters;
	
	public VaccineInventory() {
		// TODO Auto-generated constructor stub
	}

	public VaccineInventory(LocalDate date, String location, VaccineCount vaccineCount,
			List<VaccinationCenter> vaccinationCenters) {
		super();
		this.date = date;
		this.location = location;
		this.vaccineCount = vaccineCount;
		this.vaccinationCenters = vaccinationCenters;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public VaccineCount getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(VaccineCount vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

	public List<VaccinationCenter> getVaccinationCenters() {
		return vaccinationCenters;
	}

	public void setVaccinationCenters(List<VaccinationCenter> vaccinationCenters) {
		this.vaccinationCenters = vaccinationCenters;
	}
	
	
	

	








	
}
