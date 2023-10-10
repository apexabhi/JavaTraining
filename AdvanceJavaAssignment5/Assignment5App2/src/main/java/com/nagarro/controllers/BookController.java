package com.nagarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nagarro.dto.Book;
import com.nagarro.service.BookService;

@RestController
public class BookController {
    @Autowired
	BookService bs;

    @PostMapping(path = "/books")
    public void addUsers(@RequestBody Book book) {
    	System.out.println(book.getBookName());
    	bs.insert(book);

    }
    @PutMapping(path = "/users", consumes = {"application/json"})
    public void updateBook(@RequestBody Book book) {
        bs.update(book,book.getBookCode());
    }
    

    @GetMapping(path = "/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bs.getData();
		if (books != null && books.size() > 0) {
			return new ResponseEntity<>(books, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}




    @DeleteMapping("/users/{bookCode}")
    public void deleteUser(@PathVariable("bookCode") int code) {
    	bs.deleteBook(code);
    }

}
