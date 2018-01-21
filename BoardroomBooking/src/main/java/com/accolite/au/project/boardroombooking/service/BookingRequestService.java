package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.BookingRequest;

public interface BookingRequestService {
	List<BookingRequest> getAllRequests();
	List<BookingRequest> getRequestsByBranchId(int id);
	BookingRequest getRequestById(int id);
	boolean saveRequest(BookingRequest request);
	boolean acceptRequest(int id);
	boolean rejectRequest(int id);
	boolean rescheduleRequest(int id);
	boolean deleteRequestById(int id);
	boolean deleteRequest(BookingRequest request);
}
