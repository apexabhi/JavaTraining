package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.dto.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
