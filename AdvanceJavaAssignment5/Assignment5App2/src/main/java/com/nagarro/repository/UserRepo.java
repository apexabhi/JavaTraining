package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.dto.User;

public interface UserRepo extends JpaRepository<User, String>{
	
}
