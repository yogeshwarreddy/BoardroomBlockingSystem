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

import com.accolite.au.project.boardroombooking.model.BoardRoom;

@Repository
public class BoardRoomDaoImp implements BoardRoomDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<BoardRoom> getAllRooms() {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<BoardRoom> cq = cb.createQuery(BoardRoom.class);
	    Root<BoardRoom> root = cq.from(BoardRoom.class);
	    cq.select(root);
	    Query<BoardRoom> query = session.createQuery(cq);
	    return query.getResultList();
	}
	
	@Override
	public List<BoardRoom> getRoomsByBranchId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BoardRoom br WHERE br.branch.id ="+id;
		@SuppressWarnings("unchecked")
		Query<BoardRoom> query = session.createQuery(hql);
		return query.getResultList();
		
	}

	@Override
	public BoardRoom getRoomById(int id) {
		return sessionFactory.getCurrentSession().get(BoardRoom.class, id);
	}

	@Override
	public boolean saveRoom(BoardRoom room) {
		sessionFactory.getCurrentSession().save(room);
		return true;
	}

	@Override
	public boolean updateRoom(BoardRoom room) {
		Session session = sessionFactory.getCurrentSession();
	    BoardRoom room2 = session.byId(BoardRoom.class).load(room.getId());
	    room2.setName(room.getName());
	    room2.setBranch(room.getBranch());
	    room2.setCapacity(room.getCapacity());
	    session.flush();
	    return true;
	}

	@Override
	public boolean deleteRoomById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    BoardRoom room = session.byId(BoardRoom.class).load(id);
	    session.delete(room);
		return true;
	}

	@Override
	public boolean deleteRoom(BoardRoom room) {
		Session session = sessionFactory.getCurrentSession();
	    BoardRoom room2 = session.byId(BoardRoom.class).load(room.getId());
	    session.delete(room2);
		return true;
	}

}
