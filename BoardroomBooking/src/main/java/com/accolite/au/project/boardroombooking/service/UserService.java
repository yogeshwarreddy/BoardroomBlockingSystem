package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(int id);
	boolean saveUser(User user);
	boolean saveAdmin(User user);
	boolean updateUser(User user);
	boolean deleteUserById(int id);
	boolean deleteUser(User user);

}
