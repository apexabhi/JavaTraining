package com.nagarro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nagarro.dto.Author;
import com.nagarro.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService as;
	@PostMapping(path = "/authors")
	public void addAuthors(@RequestBody Author author) {
		as.insertAuthor(author);
	}
	@PutMapping(path = "/authors")
	public void saveOrUpdateAuthors(@RequestBody Author author) {
		as.updateAuthor(author);
	}

	@GetMapping(path = "/authors")
	public List<Author> getAuthors() {
		return as.getAuthor();
	}


	@RequestMapping("/authors/{id}")
	public Optional<Author> getAuthor(@PathVariable("id") Integer id) {
	return as.findId(id);
	}

	@DeleteMapping("/authors/{id}")
	public void deleteBook(@PathVariable("id") Integer id) {
		as.deleteAuthor(id);
	}
}
