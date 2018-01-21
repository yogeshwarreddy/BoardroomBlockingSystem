package com.accolite.au.project.boardroombooking.controller;

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
	public ResponseEntity<String> save(@RequestBody Login obj) {
		User user =loginService.getUserByEmail(obj.getEmail());
		if(user==null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user name");
		}
		if(user.getPassword().equals(obj.getPassword())) {
			return ResponseEntity.ok().body("login successfull");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid password");
		}
	}
}
