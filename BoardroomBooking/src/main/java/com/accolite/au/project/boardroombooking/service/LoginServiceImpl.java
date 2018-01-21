package com.accolite.au.project.boardroombooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.repository.LoginDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public User getUserByEmail(String email) {
		return loginDao.getUserByEmail(email);
	}

}
