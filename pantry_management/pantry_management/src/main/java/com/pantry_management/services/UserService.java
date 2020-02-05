package com.pantry_management.services;


import com.pantry_management.models.User;


public interface UserService {
	public boolean addNewUser(User user);
	public boolean validateUser(String username,String password);
	public User getUserDetails(String username);
}
