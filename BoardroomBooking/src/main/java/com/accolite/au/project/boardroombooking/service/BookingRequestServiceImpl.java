package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.BookingRequest;
import com.accolite.au.project.boardroombooking.repository.BookingRequestDao;

@Service
@Transactional
public class BookingRequestServiceImpl implements BookingRequestService {
	
	@Autowired
	private BookingRequestDao bookingRequestDao;

	@Override
	public List<BookingRequest> getAllRequests() {
		return bookingRequestDao.getAllRequests();
	}

	@Override
	public BookingRequest getRequestById(int id) {
		return bookingRequestDao.getRequestById(id);
	}

	@Override
	public boolean saveRequest(BookingRequest request) {
		return bookingRequestDao.saveRequest(request);
	}

	@Override
	public boolean updateRequest(BookingRequest request) {
		return bookingRequestDao.updateRequest(request);
	}

	@Override
	public boolean deleteRequestById(int id) {
		return bookingRequestDao.deleteRequestById(id);
	}

	@Override
	public boolean deleteRequest(BookingRequest request) {
		return bookingRequestDao.deleteRequest(request);
	}

}
