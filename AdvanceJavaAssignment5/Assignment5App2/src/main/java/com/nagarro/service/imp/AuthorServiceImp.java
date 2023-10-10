package com.nagarro.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dto.Author;
import com.nagarro.repository.AuthorRepo;
import com.nagarro.service.AuthorService;

@Component
public class AuthorServiceImp implements AuthorService{
	@Autowired
	AuthorRepo repo;
	
	//Please make sure to enter authors manually either through db or postman
	public void insertAuthor(Author author) {
		repo.save(author);
	}
	public void updateAuthor(Author author) {
		repo.save(author);
	}
	public List<Author> getAuthor(){
		return repo.findAll();
	}

	public Optional<Author> findId(Integer id){
		return repo.findById(id);
	}

	public void deleteAuthor(Integer id) {
		@SuppressWarnings("deprecation")
		Author author = repo.getById(id);
		repo.delete(author);
	}
}
