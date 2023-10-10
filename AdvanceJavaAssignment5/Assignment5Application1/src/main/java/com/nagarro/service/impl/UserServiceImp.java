package com.nagarro.service.impl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.nagarro.dto.User;
import com.nagarro.service.UserService;

public class UserServiceImp implements UserService{	
	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8092/user/";
	//to insert user in db
	public void saveUser(User user) {
		restTemplate.postForEntity(url,user,User.class);
	}
	
	//to validate credentials
	public boolean checkUser(String uname, String pwd) {
		ResponseEntity<User> u=restTemplate.getForEntity(url+uname,User.class);
		User user=u.getBody();
		return user != null && user.getPassword().equals(pwd);
	}
}
