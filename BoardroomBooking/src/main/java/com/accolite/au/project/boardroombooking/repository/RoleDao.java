package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.Role;

public interface RoleDao {
	public List<Role> getAllRoles();
	public Role getRoleById(int id);
	public boolean saveRole(Role role);
	public boolean updateRole(Role role);
	public boolean deleteRoleById(int id);
	public boolean deleteRole(Role role);
}
