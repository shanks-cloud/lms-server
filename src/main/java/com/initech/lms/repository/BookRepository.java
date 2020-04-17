package com.initech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.initech.lms.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}