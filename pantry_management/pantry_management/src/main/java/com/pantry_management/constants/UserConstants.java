package com.pantry_management.constants;

public class UserConstants {
	public static class queries{
		public final static String POST_USER="insert into users(name,DOJ,username,password) values(?,?,?,?)";
		public final static String GET_USER="select * from users where username=?";
		public final static String VALIDATE_USER="select user_id from users where Username=? && Password=?";
		public final static String CHECK_USERNAME_EXISTS="select username from users where username=?";
		public final static String GET_ID_FROM_USERNAME="select user_id from users where username=?";
	}
}
