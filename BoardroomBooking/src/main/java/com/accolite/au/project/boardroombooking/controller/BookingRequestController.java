package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@GetMapping("/request/{id}")
	public ResponseEntity<BookingRequest> get(@PathVariable("id") int id) {
		BookingRequest request = bookingRequestService.getRequestById(id);
		return ResponseEntity.ok().body(request);
	}
	
	@GetMapping("/requests/{branchId}")
	public ResponseEntity<List<BookingRequest>> getRequestByBranchId(@PathVariable("branchId") int id) {
		List<BookingRequest> requests = bookingRequestService.getRequestsByBranchId(id);
		return ResponseEntity.ok().body(requests);
	}

	@GetMapping("/requests")
	public ResponseEntity<List<BookingRequest>> list() {
		List<BookingRequest> requests = bookingRequestService.getAllRequests();
		return ResponseEntity.ok().body(requests);
	}

	@PostMapping("/request")
	public ResponseEntity<String> save(@RequestBody BookingRequest request) {
		if (bookingRequestService.saveRequest(request)) {
			return ResponseEntity.ok().body("New Request Added");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You cannot add a request"
				+ "User Location and Room Location are Different");
	}

	@PutMapping("/request/reschedule/{id}")
	public ResponseEntity<String> updateRequestReschedule(@PathVariable("id") int id,
			@RequestBody BookingRequest request) {
		bookingRequestService.rescheduleRequest(id);
		return ResponseEntity.ok().body("Booking request has been Rescheduled successfully.");
	}

	@PutMapping("/request/accept/{id}")
	public ResponseEntity<String> updateRequestAccept(@PathVariable("id") int id, @RequestBody BookingRequest request) {
		if (bookingRequestService.acceptRequest(id)) {
			return ResponseEntity.ok().body("Booking request has been accepted successfully.");
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("This request cannot be"
				+ " accpeted as there is already another request with same time. " + "Try using RESHCEDULE option");
	}

	@PutMapping("/request/reject/{id}")
	public ResponseEntity<String> updateRequestReject(@PathVariable("id") int id) {
		bookingRequestService.rejectRequest(id);
		return ResponseEntity.ok().body("Booking request has been rejected");
	}

	@DeleteMapping("/request/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		bookingRequestService.deleteRequestById(id);
		return ResponseEntity.ok().body("Request has been deleted successfully.");
	}

}
