package com.techlab.service;

import java.util.ArrayList;
import java.util.List;

import com.techlab.model.LoginBean;

public class AuthenticationService {
	List<LoginBean> users=new ArrayList<LoginBean>();
	
	public AuthenticationService() {
		users.add(new LoginBean("admin","admin"));
		users.add(new LoginBean("admin1","admin1"));
		users.add(new LoginBean("admin2","admin2"));
	}
	public String authenticateUser(LoginBean login) {
		String usernm=login.getUserName();
		System.out.println(usernm);
		String pass=login.getPassword();
		System.out.println(pass);
		if( usernm.equals("admin") && pass.equals("admin")) {
			return "Admin";
		}
		return "Invalid User";
	}
}
