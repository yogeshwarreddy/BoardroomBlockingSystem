package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.Role;

public interface RoleService {
	List<Role> getAllRoles();
	Role getRoleById(int id);
	boolean saveRole(Role role);
	boolean updateRole(Role role);
	boolean deleteRoleById(int id);
	boolean deleteRole(Role role);
}
