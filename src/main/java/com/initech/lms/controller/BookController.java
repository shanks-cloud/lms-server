package com.initech.lms.controller;

import java.io.IOException;

import java.util.ArrayList;
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
	
	//String dirPath = "assets/images/target/";
	String dirPath = "assets/images/books/";
	boolean flag=true;
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/Books", method=RequestMethod.POST)
	public void addBook(@RequestBody Book book) throws IOException {
		bookService.addBook(book);
	}
	
	@RequestMapping(value="/Books/viewAllBooks", method=RequestMethod.GET)
	public List<Book> viewAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value="/Books/fetchBook/{isbn}", method=RequestMethod.GET)
	public List<Book> getAllBooksByIsbn(@PathVariable long isbn){
		return bookService.getAllBooksByIsbn(isbn);
	}
	
	@RequestMapping(value="/Books/editBook/{isbn}", method=RequestMethod.PUT)
	public void updateBook(@PathVariable long isbn, @RequestBody Book book) throws IOException{
		bookService.updateBook(book);
	}
	
	@RequestMapping(value="/Books/archiveBook/{isbn}", method=RequestMethod.PUT)
    public void archiveBookByIsbn(@PathVariable long isbn, @RequestBody String bookArchiveReason)  {
		
		System.out.println("inside controller..." + isbn + bookArchiveReason);
      	bookService.archiveBookByIsbn(isbn, bookArchiveReason);
    }
	
	
	@RequestMapping(value="/Books/unArchiveBook/{isbn}", method=RequestMethod.PUT)
    public void unArchiveBookByIsbn(@PathVariable long isbn)  {
		
		System.out.println("inside controller..." + isbn);
      	bookService.unArchiveBookByIsbn(isbn);
    }
	
	
	@RequestMapping(value="/Catalog/{bookCategory}", method=RequestMethod.GET)
	public ArrayList<String> fetchAllFilesByCategory(@PathVariable String bookCategory) {
		return bookService.fetchAllActiveImagesByCategory(bookCategory);
	}
	
	@RequestMapping(value="/Catalog", method=RequestMethod.GET)
	public ArrayList<String> fetchAllFiles() {
		//return bookService.fetchAllFiles(dirPath, flag);
		return bookService.fetchAllActiveImages();
	}
	
	@RequestMapping(value= "/Books/newArrivalsCount", method = RequestMethod.GET)
    public int countByInclusionDate() {
        return bookService.countByInclusionDate();
    }
	
}
