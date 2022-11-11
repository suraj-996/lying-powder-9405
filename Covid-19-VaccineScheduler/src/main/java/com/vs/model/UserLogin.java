package com.vs.model;

public class UserLogin {
	private String mobileNo;
	private String password;
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	public UserLogin(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
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
	
	
}
