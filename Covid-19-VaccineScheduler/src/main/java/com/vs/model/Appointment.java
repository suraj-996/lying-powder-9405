package com.vs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.myenum.Slots;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;
	
	
//	@NotBlank(message = "Mobile Number is Mandatory")
//	@Size(max=10,message="Moblie Number length should be 10!")
//	@Pattern(regexp = "^[6-9][0-9]{9}$",message="Mobile No is Invalid!")
	private Long mobileno;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateofbooking;
	
	private Slots slots;
	
	private Boolean bookingstatus;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
	List<VaccinationCenter> vaccinationCenter;

	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	public Appointment() {

	}

	public Appointment(Integer bookingid, Long mobileno, LocalDate dateofbooking, Slots slots, Boolean bookingstatus,
			List<VaccinationCenter> vaccinationCenters) {
		super();
		this.bookingid = bookingid;
		this.mobileno = mobileno;
		this.dateofbooking = dateofbooking;
		this.slots = slots;
		this.bookingstatus = bookingstatus;
		this.vaccinationCenter = vaccinationCenters;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
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
		return vaccinationCenter;
	}

	public void setVaccinationCenters(List<VaccinationCenter> vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

}
