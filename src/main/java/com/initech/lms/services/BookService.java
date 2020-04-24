package com.initech.lms.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.Book;
import com.initech.lms.repository.BookRepository;

@Service
public class BookService {
	
	File sourceFile, targetFile;
	String sourcePath, targetPath, bookCategory, bookImageName;
	long isbn;
	boolean flag;
	
	@Autowired
	private BookRepository bookRepository;

	public void addBook(Book book) throws IOException, InterruptedException {
		
		bookRepository.save(book);
		this.moveFile(book);
		
	}
	
	public boolean moveFile(Book book) {
		bookCategory = book.getBookCategory();
		bookImageName = book.getBookImageName();
		isbn = book.getIsbn();
		
		//sourcePath="D:/my-angular-workspace/lms-client/src/assets/images/source/Computer Science/bpb-Joydip_Kanjilal.jpg";
		sourcePath="D:/my-angular-workspace/lms-client/src/assets/images/source/" + bookCategory + "/" + bookImageName;
				
		//targetPath="D:/my-angular-workspace/lms-client/src/assets/images/target/Computer Science/1234567890123-bpb-Joydip_Kanjilal.jpg";
		targetPath="D:/my-angular-workspace/lms-client/src/assets/images/target/" + bookCategory + "/" + isbn + "-" + bookImageName;
		
		sourceFile = new File(sourcePath);
		targetFile= new File(targetPath);
		 
		if (sourceFile.renameTo(targetFile)) {
			System.out.println("Source file moved to target location successfully..");
			flag = true;
			return flag;
		} else {
			System.out.println("error in moving the file to target location..");
			flag = false;
			return flag;
		}
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	
	public List<Book> getBookByIsbn(long isbn) {
		return bookRepository.findByIsbn(isbn);
	}
	
	public void deleteBookByIsbn(long isbn) {
		bookRepository.deleteById(isbn);
    }
	
}
