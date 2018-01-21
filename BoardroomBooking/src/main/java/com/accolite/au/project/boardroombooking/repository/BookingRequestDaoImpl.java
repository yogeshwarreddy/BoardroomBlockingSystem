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
	public List<BookingRequest> getRequestsByBranchId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BookingRequest br WHERE br.user.id IN (SELECT u.id FROM User u WHERE u.branch.id="+id+")";
		@SuppressWarnings("unchecked")
		Query<BookingRequest> query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public BookingRequest getRequestById(int id) {
		return sessionFactory.getCurrentSession().get(BookingRequest.class, id);
	}

	@Override
	public boolean saveRequest(BookingRequest request) {
		if (request.getUser().getBranch().getLocation().equals(request.getBoardroom().getBranch().getLocation())) {
			request.setStatus("REQUESTED");
			sessionFactory.getCurrentSession().save(request);
			return true;
		} else {
			return false;
		}
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

	@Override
	public boolean acceptRequest(int id) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request = session.byId(BookingRequest.class).load(id);
		if (request.getStatus().equals("REQUESTED")) {
			request.setStatus("ACCEPTED");
			return true;
		}
		return false;
	}

	@Override
	public boolean rejectRequest(int id) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request = session.byId(BookingRequest.class).load(id);
		request.setStatus("REJECTED");
		return false;
	}

	@Override
	public boolean rescheduleRequest(int id) {
		Session session = sessionFactory.getCurrentSession();
		BookingRequest request = session.byId(BookingRequest.class).load(id);
		request.setStatus("RESCHEDULED");
		return false;
	}

	@Override
	public List<BookingRequest> getRequestsByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BookingRequest br WHERE br.user.id ="+id;
		@SuppressWarnings("unchecked")
		Query<BookingRequest> query = session.createQuery(hql);
		return query.getResultList();
	}


}
