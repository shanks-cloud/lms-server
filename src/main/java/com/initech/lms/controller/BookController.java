package com.initech.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.models.Book;
import com.initech.lms.services.BookService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/book", method=RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@RequestMapping(value="/book/viewAllBooks", method=RequestMethod.GET)
	public List<Book> viewAllBooks() {
		return bookService.getAllBooks();
	}
	
	//@RequestMapping(method=RequestMethod.PUT, value="/book/editBook/{bookId}")
	//	public void updateBook(@PathVariable int bookId, @RequestBody Book book ){
	//		bookService.updateBook(bookId, book);
	//	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/book/editBook/{isbn}")
	public void updateBook(@RequestBody Book book){
			bookService.updateBook(book);
	}
	
	//	@RequestMapping("/book/{bookId}")
	//	public Book getBook(@PathVariable int bookId){
	//		return bookService.getBook(bookId);
	//	}
	
	@RequestMapping("/book/{isbn}")
	public List<Book> getBook(@PathVariable long isbn){
		return bookService.getBook(isbn);
	}
	
}
