package com.vs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotNull(message = "Name is mandatory")
	private String name;
	@Size(max = 10,min = 10)
	private String mobileNo;
	@NotNull(message = "Password is mandatory")
	private String password;
	@Email
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String name, String mobileNo, String password, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
