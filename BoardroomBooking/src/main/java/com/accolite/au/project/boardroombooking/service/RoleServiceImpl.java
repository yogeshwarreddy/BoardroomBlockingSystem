package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.Role;
import com.accolite.au.project.boardroombooking.repository.RoleDao;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public boolean saveRole(Role role) {
		return roleDao.saveRole(role);
	}

	@Override
	public boolean updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	@Override
	public boolean deleteRoleById(int id) {
		return roleDao.deleteRoleById(id);
	}

	@Override
	public boolean deleteRole(Role role) {
		return roleDao.deleteRole(role);
	}

}
