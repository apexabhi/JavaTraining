package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.dto.Book;

@Service
public interface BookService {
	public List<Book> getData();

	public void deleteBook(int code);

	public void update(Book book, int bookCode);

	public void insert(Book book);
}
