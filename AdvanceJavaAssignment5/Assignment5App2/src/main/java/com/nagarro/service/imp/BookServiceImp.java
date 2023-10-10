package com.nagarro.service.imp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dto.Book;
import com.nagarro.repository.Bookrepo;
import com.nagarro.service.BookService;

@Component
public class BookServiceImp implements BookService {
	@Autowired
    Bookrepo repo;
	public List<Book> getData(){
		List<Book> booksData = (List<Book>) repo.findAll();
		List<Book> list = new ArrayList<Book>();
		for (Book bookEntity : booksData) {
			Book book = new Book();
			book.setAuthor(bookEntity.getAuthor());
			book.setBookCode(bookEntity.getBookCode());
			book.setBookName(bookEntity.getBookName());
			book.setDate(bookEntity.getDate());
			list.add(book);
		}
		return list;
	}
	public void insert(Book book) {
		Optional<Book> b=repo.findById(book.getBookCode());
		System.out.print(b);
		if(b.isEmpty()==true) {
			repo.save(book);
		}
	}
	public void deleteBook(int code) {
		repo.deleteById(code);
	}
	public void update(Book book, int bookCode) {
		repo.save(book);
	}
}
