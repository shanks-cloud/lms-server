package com.initech.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.initech.lms.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List<Book> findByIsbn(long isbn);
			
			
}