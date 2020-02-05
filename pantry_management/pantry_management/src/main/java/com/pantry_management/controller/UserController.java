package com.pantry_management.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pantry_management.models.User;
import com.pantry_management.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	@CrossOrigin
	public boolean addNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
	
	@PostMapping("/login")
	@CrossOrigin
	public boolean validateUser(@RequestBody Map<String,Object> userDetails) {
		return userService.validateUser((String)userDetails.get("username"),(String)userDetails.get("password"));
	}
	
	@GetMapping("/userDetails/{username}")
	@CrossOrigin
	public User getUserDetails(@PathVariable String username) {
		return userService.getUserDetails(username);
	}
}
