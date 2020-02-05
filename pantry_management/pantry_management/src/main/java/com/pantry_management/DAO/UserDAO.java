package com.pantry_management.DAO;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pantry_management.constants.UserConstants;
import com.pantry_management.models.User;
import com.pantry_management.util.GenerateDate;
@Repository
public class UserDAO {
	private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	JdbcTemplate jdbcTemplate;
	public boolean addNewUser(User user) {
		if(this.checkUsernameExists(user.getUsername())) {
			logger.log(Level.WARNING,"The Username already exists");
			return false;
		}
		user.setDoj(GenerateDate.generateDate());	
		try {
			this.jdbcTemplate.update(UserConstants.queries.POST_USER,user.getName(),user.getDoj(),user.getUsername(),user.getPassword());
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	public Boolean validateUser(String username,String password) {
		try {
			this.jdbcTemplate.queryForObject(UserConstants.queries.VALIDATE_USER,new Object[] {username, password}, Integer.class);
		}
		catch(Exception e) {
			logger.log(Level.WARNING,"Invalid username/password");
			return false;
		}
		return true;
	}
	public User getUserDetails(String username) {
		List<Map<String,Object>> userList= this.jdbcTemplate.queryForList(UserConstants.queries.GET_USER,new Object[] {username});
		User user=new User();
		for(Map<String,Object> rs:userList) {
			user.setId((int)rs.get("user_id"));
			user.setDoj((Date)rs.get("DOJ"));
			user.setName((String)rs.get("name"));
			user.setUsername((String)rs.get("username"));
			user.setPassword((String)rs.get("password"));
			return user;
		}
		return null;
	}
	public boolean checkUsernameExists(String username) {
		String s;
		try {
			s=this.jdbcTemplate.queryForObject(UserConstants.queries.CHECK_USERNAME_EXISTS,new Object[] {username},String.class);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		if(s.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
}
