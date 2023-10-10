package com.nagarro.service;

import com.nagarro.dto.User;

public interface UserService {
	public void saveUser(User user);
	public boolean checkUser(String uname, String pwd);
}
