package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<String> save(@RequestBody User user) {
		userService.saveUser(user);
		return ResponseEntity.ok().body("New user Added");
	}


	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody User user) {
		userService.updateUser(user);
		return ResponseEntity.ok().body("User has been updated successfully.");
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}


}
