package com.pantry_management.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pantry_management.DAO.UserDAO;
import com.pantry_management.models.User;
import com.pantry_management.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	@Override
	public boolean addNewUser(User user) {
		return userDAO.addNewUser(user);
	}

	@Override
	public boolean validateUser(String username, String password) {
		return userDAO.validateUser(username, password);
	}

	@Override
	public User getUserDetails(String username) {
		return userDAO.getUserDetails(username);
	}
	
}
