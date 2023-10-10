package com.nagarro.service;

import java.util.List;

import com.nagarro.dto.Book;


public interface BookService {
	public void addBook(Book book);
	public Book[] getBooks();
	public void deleteBook(int code);
	public void update(Book book, int bookCode);
}
