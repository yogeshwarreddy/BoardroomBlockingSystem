package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
	public ResponseEntity<User> userLogin(@RequestBody Login obj, HttpSession httpSession) {
		logger.info("User trying to Log in ");
		User user = loginService.getUserByEmail(obj.getEmail());
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		if (user.getPassword().equals(obj.getPassword())) {
			httpSession.setAttribute("userId", user.getId());
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@GetMapping("/currentuser")
	public ResponseEntity<User> getCurrentUser(HttpSession httpSession) {
		logger.info("Obtaining Current user data");
		if(!httpSession.getAttributeNames().hasMoreElements()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		User user = userService.getUserById((int) httpSession.getAttribute("userId"));
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/currentuser/requests")
	public ResponseEntity<List<BookingRequest>> getCurrentUserRequests(HttpSession httpSession) {
		logger.info("Obtaining Current user Requests");
		if(!httpSession.getAttributeNames().hasMoreElements()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		List<BookingRequest> bookingRequests = bookingRequestService
				.getRequestsByUserId((int) httpSession.getAttribute("userId"));
		return ResponseEntity.ok().body(bookingRequests);
	}

	@GetMapping("/logout")
	public ResponseEntity<User> userLogout(HttpSession httpSession) {
		logger.info("User Logging out");
		httpSession.invalidate();
		return ResponseEntity.ok().body(null);
	}

}
