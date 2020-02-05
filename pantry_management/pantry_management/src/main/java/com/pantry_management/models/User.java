package com.pantry_management.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class User {
	@NotNull
	private String name;
	private int id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	private Date doj;
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
