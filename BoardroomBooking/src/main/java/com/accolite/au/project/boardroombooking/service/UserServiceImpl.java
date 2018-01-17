package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.repository.UserDao;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDao userDao;
	
	
	@Override
	   public List<User> getAllUsers() {
	      return userDao.getAllUsers();
	   }
}
