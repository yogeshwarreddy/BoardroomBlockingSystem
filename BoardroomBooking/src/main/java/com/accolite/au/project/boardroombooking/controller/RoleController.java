package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.Role;
import com.accolite.au.project.boardroombooking.service.RoleService;

@RestController
public class RoleController {
	
	private static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;
	

	@PostMapping("/role")
	public ResponseEntity<String> save(@RequestBody Role role) {
		logger.info("New role added");
		roleService.saveRole(role);
		return ResponseEntity.ok().body("New Role Added");
	}


	@GetMapping("/role/{id}")
	public ResponseEntity<Role> get(@PathVariable("id") int id) {
		Role role = roleService.getRoleById(id);
		return ResponseEntity.ok().body(role);
	}

	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> list() {
		List<Role> roles = roleService.getAllRoles();
		return ResponseEntity.ok().body(roles);
	}


	@PutMapping("/role/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Role role) {
		logger.info("Role with id:"+id+" updated");
		roleService.updateRole(role);
		return ResponseEntity.ok().body("Role has been updated successfully.");
	}


	@DeleteMapping("/role/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		logger.info("Role with id:"+id+" deleted");
		roleService.deleteRoleById(id);
		return ResponseEntity.ok().body("Role has been deleted successfully.");
	}

}
