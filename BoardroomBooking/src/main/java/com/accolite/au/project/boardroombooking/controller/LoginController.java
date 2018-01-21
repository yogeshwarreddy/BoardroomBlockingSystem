package com.accolite.au.project.boardroombooking.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.service.LoginService;

@RestController
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	static class Login{
		String email;
		String password;
		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login obj) {
		User user =loginService.getUserByEmail(obj.getEmail());
		if(user==null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user name");
		}
		if(user.getPassword().equals(obj.getPassword())) {
			logger.info("User (Name : "+user.getFirstName()+" Emp_id : "+user.getId()+") has logged in");
			return ResponseEntity.ok().body("login successfull");
		}
		else {
			logger.info("login to account "+obj.getEmail()+" has failed due to incorrect password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid password");
		}
	}
}
