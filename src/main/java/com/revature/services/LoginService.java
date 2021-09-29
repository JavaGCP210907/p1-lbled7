package com.revature.services;

import com.revature.daos.LoginDao;

public class LoginService {

	LoginDao ld = new LoginDao();
	
	public boolean login(String username,String password) {
		
		return ld.validateLogin(username, password);
		
	}
	
	public boolean checkManager(String username) {
		return ld.checkManager(username);
	}
}
