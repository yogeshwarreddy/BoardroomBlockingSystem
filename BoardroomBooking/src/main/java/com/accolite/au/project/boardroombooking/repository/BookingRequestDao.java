package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.BookingRequest;

public interface BookingRequestDao {
	public List<BookingRequest> getAllRequests();
	public BookingRequest getRequestById(int id);
	public boolean saveRequest(BookingRequest request);
	public boolean updateRequest(BookingRequest request);
	public boolean deleteRequestById(int id);
	public boolean deleteRequest(BookingRequest request);
	
}
