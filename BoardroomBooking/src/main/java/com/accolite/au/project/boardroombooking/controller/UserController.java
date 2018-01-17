package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.service.UserService;

@RestController
public class UserController {

	@Autowired
	   private UserService userService;
	
	  @GetMapping("/users")
	   public ResponseEntity<List<User>> list() {
	      List<User> users = userService.getAllUsers();
	      return ResponseEntity.ok().body(users);
	   }

}
