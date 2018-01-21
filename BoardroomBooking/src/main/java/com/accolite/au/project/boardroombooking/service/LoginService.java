package com.accolite.au.project.boardroombooking.service;

import com.accolite.au.project.boardroombooking.model.User;

public interface LoginService {
	User getUserByEmail(String email);
}
