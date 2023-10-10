package com.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dto.Author;
import com.nagarro.service.AuthorService;

public class AuthorServiceImp implements AuthorService{
	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8092/authors/";
	//to fetch authors from db
	public Author[] getAuthors() {
		ResponseEntity<Author[]> responseEntity=restTemplate.getForEntity(url,Author[].class);
		return responseEntity.getBody();
	}
}
