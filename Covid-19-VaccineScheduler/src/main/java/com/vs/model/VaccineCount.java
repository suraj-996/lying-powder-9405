package com.vs.model;

public class VaccineCount {
	private Integer quantity;
	
	private Double price;

	public VaccineCount() {
		// TODO Auto-generated constructor stub
	}

	public VaccineCount(Integer quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
