package com.accolite.au.project.boardroombooking.controller;

<<<<<<< HEAD
import org.apache.log4j.Logger;
=======
import java.util.List;

import javax.servlet.http.HttpSession;

>>>>>>> e1bc1ad6ba726e6974068c3ace012694b86901c9
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.BookingRequest;
import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.service.BookingRequestService;
import com.accolite.au.project.boardroombooking.service.LoginService;
import com.accolite.au.project.boardroombooking.service.UserService;

@RestController
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession httpSession;
	

	@Autowired
	private UserService userService;

	@Autowired
	private BookingRequestService bookingRequestService;

	static class Login {
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
<<<<<<< HEAD
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
=======
	public ResponseEntity<User> save(@RequestBody Login obj) {
		User user = loginService.getUserByEmail(obj.getEmail());
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		if (user.getPassword().equals(obj.getPassword())) {
			httpSession.setAttribute("userId", user.getId());
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
>>>>>>> e1bc1ad6ba726e6974068c3ace012694b86901c9
		}
	}

	@GetMapping("/currentuser")
	public ResponseEntity<User> getCurrentUser() {
		User user = userService.getUserById((int) httpSession.getAttribute("userId"));
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/currentuser/requests")
	public ResponseEntity<List<BookingRequest>> getCurrentUserRequests() {
		List<BookingRequest> bookingRequests = bookingRequestService.getRequestsByUserId((int) httpSession.getAttribute("userId"));
		return ResponseEntity.ok().body(bookingRequests);
	}

}
