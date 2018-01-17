package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.repository.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDao userDao;
	
	
	@Override
	   public List<User> getAllUsers() {
	      return userDao.getAllUsers();
	   }


	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}


	@Override
	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	}


	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}


	@Override
	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}


	@Override
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}
}
