package com.techlab.model;

public class LoginBean {
	private String username;
	private String password;
	
	public LoginBean(String username,String password) {
		this.username=username;
		this.password=password;
	}
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}
