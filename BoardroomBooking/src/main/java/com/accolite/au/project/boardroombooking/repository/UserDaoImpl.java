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

import com.accolite.au.project.boardroombooking.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User>  root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public User getUserById(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public boolean saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
	    User user2 = session.byId(User.class).load(user.getId());
	    user2.setFirstName(user.getFirstName());
	    user2.setLastName(user.getLastName());
	    user2.setEmail(user.getEmail());
	    user2.setPassword(user.getPassword());
	    user2.setBranch(user.getBranch());
	    session.flush();
	    return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    User user = session.byId(User.class).load(id);
	    session.delete(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
	    User user2 = session.byId(User.class).load(user.getId());
	    session.delete(user2);
		return true;
	}

}
