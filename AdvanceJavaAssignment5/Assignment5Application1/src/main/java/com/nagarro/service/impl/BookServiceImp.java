package com.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dto.Book;
import com.nagarro.service.BookService;

public class BookServiceImp implements BookService{
	//To build connection with springboot app
	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8092/books/";
	//to insert book 
	public void addBook(Book book) {
		restTemplate.postForEntity(url,book,Book.class);
	}
	
	//to fetch books
	public Book[] getBooks() {
		ResponseEntity<Book[]> book=restTemplate.getForEntity(url,Book[].class);
		Book[] books = book.getBody();
		return books;
	}
	
	//to delete books
	public void deleteBook(int code) {
		restTemplate.delete(url+code);
	}
	
	//to update books
	public void update(Book book,int bookCode) {
		restTemplate.put(url+bookCode,book);
	}
}
