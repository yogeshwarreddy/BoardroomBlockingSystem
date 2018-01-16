package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public boolean saveUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserById(int id);
	public boolean deleteUser(User user);
}
