package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.BookingRequest;

public interface BookingRequestService {
	List<BookingRequest> getAllRequests();
	BookingRequest getRequestById(int id);
	boolean saveRequest(BookingRequest request);
	boolean updateRequest(BookingRequest request);
	boolean deleteRequestById(int id);
	boolean deleteRequest(BookingRequest request);
}
