package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.dto.Author;

@Service
public interface AuthorService {
	public void insertAuthor(Author author);

	public void updateAuthor(Author author);

	public List<Author> getAuthor();

	public Optional<Author> findId(Integer id);

	public void deleteAuthor(Integer id);
}
