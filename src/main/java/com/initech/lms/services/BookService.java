package com.initech.lms.services;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.Book;
import com.initech.lms.repository.BookRepository;

@Service
public class BookService {
	
	File sourceFile, targetFile;
	String sourcePath, targetPath, bookCategory, bookImageName, str, dirName, firstDirPath, oldDirName;
	//ArrayList <String> strCatalogLst = new ArrayList<String>();
	ArrayList <String> strCategoryLst;
	ArrayList <String> strCatalogLst;
		
	
	long isbn;
	boolean flag=false;
	File[] fileLst;
	
	
	@Autowired
	private BookRepository bookRepository;

	public void addBook(Book book) throws IOException {
		bookRepository.save(book);
		this.moveFile(book);
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
	
	
	public boolean moveFile(Book book) throws IOException {
		bookCategory = book.getBookCategory();
		bookImageName = book.getBookImageName();
		isbn = book.getIsbn();
		
		System.out.println("Book Category is.. " + book.getBookCategory());
		System.out.println("Book name is.. " + book.getBookImageName());
		
		
		sourcePath="assets/images/source/" + bookCategory + "/" + bookImageName;
		targetPath="assets/images/target/" + bookCategory + "/" + isbn + "-" + bookImageName;
		
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
	
	
	public ArrayList<String> fetchAllFilesByCategory(String bookCategory) {
		File file = new File("assets/images/target/" + bookCategory);
		fileLst = file.listFiles();
		
		strCategoryLst = new ArrayList<String>();
				
		for(File fl:fileLst) {
			System.out.println("file name is " + fl);
			str = fl.getPath();
			str = str.replace("\\", "/");
			System.out.println("str is " + str);
			strCategoryLst.add(str);
		}
		return strCategoryLst;
	}
	
	
	public ArrayList<String> fetchAllFiles(String dirPath, boolean flag) {
		
		if (flag == true) {
			strCatalogLst = new ArrayList<String>();
		}
		
		     File directory = new File(dirPath);
			
			//get all the files from a directory
			 File[] fList = directory.listFiles();
			
			 for (File fl : fList){
		         if (fl.isFile()){
		             str = fl.getPath();
		             str = str.replace("\\", "/");
		             strCatalogLst.add(str);
		    		 System.out.println("str value after replace is.. " + str);
		    		
		    	 } else if (fl.isDirectory()){
		    		 System.out.println("dir path is " + fl.getPath());    		 
		    		 flag = false;
		    		 fetchAllFiles(fl.getPath(), flag);
		    	}
			 }
			 
			 return strCatalogLst;
	}
	
	
	 public int countByInclusionDate(){
		   return bookRepository.countByInclusionDate();
	 }
}
