package com.initech.lms.services;

//import java.util.ArrayList;

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
		//		List<Book> books = new ArrayList<>();
		//		bookRepository.findAll().forEach(books::add );
		//		return books;
		
		return bookRepository.findAll();
	}
	
	
	//	public void updateBook(int bookId, Book book) {
	//		//Book bk = this.getBook(bookId);
	//		bookRepository.save(book);
	//	}
	
	public void updateBook(Book book) {
		//Book bk = this.getBook(bookId);
		bookRepository.save(book);
	}
	
	
	//	public Book getBook(int bookId) {
	//		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	//		return bookRepository.findById(bookId).get();
	//	}
	
	public List<Book> getBook(long isbn) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return bookRepository.findByIsbn(isbn);
	}
	
	public void deleteBookByIsbn(long isbn) {
		bookRepository.deleteById(isbn);
    }
	
}
