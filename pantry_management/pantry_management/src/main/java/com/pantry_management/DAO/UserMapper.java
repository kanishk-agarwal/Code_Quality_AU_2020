package com.pantry_management.DAO;
import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.pantry_management.models.*;
public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) {
		User user=new User();
		try {
		if(rs.getFetchSize()==0) {
			return null;
		}
		user.setId(rs.getInt("user_id"));
		user.setDoj(rs.getDate("DOJ"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
	
}
