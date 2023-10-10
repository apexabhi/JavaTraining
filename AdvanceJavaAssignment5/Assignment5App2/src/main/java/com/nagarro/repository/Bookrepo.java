package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.dto.Book;

public interface Bookrepo extends JpaRepository<Book, Integer>{
}
