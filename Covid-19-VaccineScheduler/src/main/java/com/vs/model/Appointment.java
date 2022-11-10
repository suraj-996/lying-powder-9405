package com.vs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.vs.myenum.Slots;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingid;
	private Long mobileno;
	private LocalDate dateofbooking;
	
	private Slots slots;
	private Boolean bookingstatus;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
	List<VaccinationCenter> vaccinationCenters;

	public Appointment() {

	}

	public Appointment(Long bookingid, Long mobileno, LocalDate dateofbooking, Slots slots, Boolean bookingstatus,
			List<VaccinationCenter> vaccinationCenters) {
		super();
		this.bookingid = bookingid;
		this.mobileno = mobileno;
		this.dateofbooking = dateofbooking;
		this.slots = slots;
		this.bookingstatus = bookingstatus;
		this.vaccinationCenters = vaccinationCenters;
	}

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public LocalDate getDateofbooking() {
		return dateofbooking;
	}

	public void setDateofbooking(LocalDate dateofbooking) {
		this.dateofbooking = dateofbooking;
	}

	public Slots getSlot() {
		return slots;
	}

	public void setSlot(Slots slots) {
		this.slots = slots;
	}

	public boolean isBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(boolean bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public List<VaccinationCenter> getVaccinationCenters() {
		return vaccinationCenters;
	}

	public void setVaccinationCenters(List<VaccinationCenter> vaccinationCenters) {
		this.vaccinationCenters = vaccinationCenters;
	}

}
