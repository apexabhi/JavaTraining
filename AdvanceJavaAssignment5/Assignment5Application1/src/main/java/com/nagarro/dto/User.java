package com.nagarro.dto;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

public class User {
	String userid;
	String password;
	public String getUserid() {
		return userid;
	}
	public void setUserId(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}