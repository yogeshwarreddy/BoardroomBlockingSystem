package com.accolite.au.project.boardroombooking.repository;

import com.accolite.au.project.boardroombooking.model.User;

public interface LoginDao {
	public User getUserByEmail(String email);
}
