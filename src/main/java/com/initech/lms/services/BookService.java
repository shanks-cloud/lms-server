package com.initech.lms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.Book;
import com.initech.lms.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add );
		return books;
	}
	
}
