package com.nagarro.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dto.User;
import com.nagarro.repository.UserRepo;

@RestController
public class LoginController {
	@Autowired
    UserRepo repo;
	@PostMapping(path = "/user")
    public void addUsers(@RequestBody User u) {
        repo.save(u);
    }
    @RequestMapping("/user/{uname}")
    public Optional<User> getUser(@PathVariable("uname") String uname) {
        return repo.findById(uname);
    }

}
