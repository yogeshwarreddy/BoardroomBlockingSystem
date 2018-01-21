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

import com.accolite.au.project.boardroombooking.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> getAllRoles() {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Role> cq = cb.createQuery(Role.class);
	    Root<Role> root = cq.from(Role.class);
	    cq.select(root);
	    Query<Role> query = session.createQuery(cq);
	    return query.getResultList();
	}

	@Override
	public Role getRoleById(int id) {
		return sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public boolean saveRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
		return true;
	}

	@Override
	public boolean updateRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
	    Role role2 = session.byId(Role.class).load(role.getId());
	    role2.setRoleName(role.getRoleName());
	    session.flush();
	    return true;
	}

	@Override
	public boolean deleteRoleById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Role role = session.byId(Role.class).load(id);
	    session.delete(role);
		return true;
	}

	@Override
	public boolean deleteRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
	    Role role2 = session.byId(Role.class).load(role.getId());
	    session.delete(role2);
		return false;
	}

}
