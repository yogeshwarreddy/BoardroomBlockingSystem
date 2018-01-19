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

import com.accolite.au.project.boardroombooking.model.Branch;

@Repository
public class BranchDaoImpl implements BranchDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Branch> getAllBranches() {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Branch> cq = cb.createQuery(Branch.class);
	    Root<Branch> root = cq.from(Branch.class);
	    cq.select(root);
	    Query<Branch> query = session.createQuery(cq);
	    return query.getResultList();
	}

	@Override
	public Branch getBranchById(int id) {
		return sessionFactory.getCurrentSession().get(Branch.class, id);
	}

	@Override
	public boolean saveBranch(Branch branch) {
		  sessionFactory.getCurrentSession().save(branch);
		  return true;
	}

	@Override
	public boolean updateBranch(Branch branch) {
		Session session = sessionFactory.getCurrentSession();
	    Branch branch2 = session.byId(Branch.class).load(branch.getId());
	    branch2.setLocation(branch.getLocation());
	    session.flush();
	    return true;
	}

	@Override
	public boolean deleteBranchById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Branch branch = session.byId(Branch.class).load(id);
	    session.delete(branch);
		return true;
	}

	@Override
	public boolean deleteBranch(Branch branch) {
		Session session = sessionFactory.getCurrentSession();
	    Branch branch2 = session.byId(Branch.class).load(branch.getId());
	    session.delete(branch2);
		return true;
	}

}
