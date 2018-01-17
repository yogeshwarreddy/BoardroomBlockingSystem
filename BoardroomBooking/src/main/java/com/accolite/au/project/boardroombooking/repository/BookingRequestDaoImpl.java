package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accolite.au.project.boardroombooking.model.BookingRequest;

@Repository
public class BookingRequestDaoImpl implements BookingRequestDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<BookingRequest> getAllRequests() {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<BookingRequest> cq = cb.createQuery(BookingRequest.class);
	    Root<BookingRequest> root = cq.from(BookingRequest.class);
	    cq.select(root);
	    Query<BookingRequest> query = session.createQuery(cq);
	    return query.getResultList();
	}

	@Override
	public BookingRequest getRequestById(int id) {
		return sessionFactory.getCurrentSession().get(BookingRequest.class, id);
	}

	@Override
	public boolean saveRequest(BookingRequest request) {
		sessionFactory.getCurrentSession().save(request);
		return true;
	}

	@Override
	public boolean updateRequest(BookingRequest request) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request2 = session.byId(BookingRequest.class).load(request.getId());
		request2.setBoardroom(request.getBoardroom());
		request2.setBooking_date(request.getBooking_date());
		request2.setHours(request.getHours());
		request2.setPurpose(request.getPurpose());
		request2.setStatus(request.getStatus());
		request2.setUser(request.getUser());
	    session.flush();
	    return true;
	}

	@Override
	public boolean deleteRequestById(int id) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request = session.byId(BookingRequest.class).load(id);
	    session.delete(request);
		return true;
	}

	@Override
	public boolean deleteRequest(BookingRequest request) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request2 = session.byId(BookingRequest.class).load(request.getId());
	    session.delete(request2);
		return true;
	}

}
