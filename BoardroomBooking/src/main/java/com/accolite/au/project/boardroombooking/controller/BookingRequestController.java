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

import com.accolite.au.project.boardroombooking.model.BookingRequest;
import com.accolite.au.project.boardroombooking.service.BookingRequestService;

@RestController
public class BookingRequestController {

	@Autowired
	private BookingRequestService bookingRequestService;
	

	@PostMapping("/request")
	public ResponseEntity<String> save(@RequestBody BookingRequest request) {
		bookingRequestService.saveRequest(request);
		return ResponseEntity.ok().body("New Request Added");
	}


	@GetMapping("/request/{id}")
	public ResponseEntity<BookingRequest> get(@PathVariable("id") int id) {
		BookingRequest request = bookingRequestService.getRequestById(id);
		return ResponseEntity.ok().body(request);
	}

	
	@GetMapping("/requests")
	public ResponseEntity<List<BookingRequest>> list() {
		List<BookingRequest> requests = bookingRequestService.getAllRequests();
		return ResponseEntity.ok().body(requests);
	}


	@PutMapping("/request/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody BookingRequest request) {
		bookingRequestService.updateRequest(request);
		return ResponseEntity.ok().body("Request has been updated successfully.");
	}


	@DeleteMapping("/request/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		bookingRequestService.deleteRequestById(id);
		return ResponseEntity.ok().body("Request has been deleted successfully.");
	}


}
