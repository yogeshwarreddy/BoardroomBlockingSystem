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

import com.accolite.au.project.boardroombooking.model.Branch;
import com.accolite.au.project.boardroombooking.service.BranchService;

@RestController
public class BranchController {
	
	private static final Logger logger = Logger.getLogger(BranchController.class);

	@Autowired
	private BranchService branchService;
	

	@PostMapping("/branch")
	public ResponseEntity<String> save(@RequestBody Branch branch) {
		logger.info("New branch added");
		branchService.saveBranch(branch);
		return ResponseEntity.ok().body("New Branch Added");
	}


	@GetMapping("/branch/{id}")
	public ResponseEntity<Branch> get(@PathVariable("id") int id) {
		Branch branch = branchService.getBranchById(id);
		return ResponseEntity.ok().body(branch);
	}

	
	@GetMapping("/branches")
	public ResponseEntity<List<Branch>> list() {
		List<Branch> branches = branchService.getAllBranches();
		return ResponseEntity.ok().body(branches);
	}


	@PutMapping("/branch/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Branch branch) {
		logger.info("Branch with id:"+id+" updated");
		branchService.updateBranch(branch);
		return ResponseEntity.ok().body("Branch has been updated successfully.");
	}


	@DeleteMapping("/branch/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		logger.info("Branch with id:"+id+" deleted");
		branchService.deleteBranchById(id);
		return ResponseEntity.ok().body("Branch has been deleted successfully.");
	}
}
