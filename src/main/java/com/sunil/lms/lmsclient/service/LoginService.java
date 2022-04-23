package com.sunil.lms.lmsclient.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	 public boolean validateUser(String userid, String password) {
	        // Sunil, Sanu
	        return userid.equalsIgnoreCase("sunil")
	                && password.equalsIgnoreCase("Sanu");
	    }
}
