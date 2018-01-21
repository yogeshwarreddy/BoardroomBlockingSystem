package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accolite.au.project.boardroombooking.model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = '"+email + "'";
		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery(hql);
		List<User> users = query.list();
		if(users.isEmpty())
		{
			return null;
		}
		else
			return users.get(0);
	}
}
