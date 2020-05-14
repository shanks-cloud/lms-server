package com.initech.lms.services;

import java.io.File;
import java.io.IOException;

import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.Book;
import com.initech.lms.repository.BookRepository;

@Service
public class BookService {

	File sourceFile, targetFile;
	String sourcePath, targetPath, archivePath, bookCategory, bookImageName, str, dirName, firstDirPath, oldDirName;
	ArrayList<String> strCategoryLst;
	ArrayList<String> strCatalogLst;

	long isbn;
	boolean flag = false;
	File[] fileLst;

	@Autowired
	private BookRepository bookRepository;

	public void addBook(Book book) throws IOException {
		bookCategory = book.getBookCategory();
		bookImageName = book.getBookImageName();
		sourcePath = "assets/images/books/" + bookCategory + "/" + bookImageName;
		book.setBookImageName(sourcePath);

		bookRepository.save(book);
		// this.tagIsbnMoveFile(book);
		// this.tagIsbn(book);

	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void updateBook(Book book) throws IOException {
		bookRepository.save(book);
	}

	public List<Book> getAllBooksByIsbn(long isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	// public boolean tagIsbnMoveFile(Book book) throws IOException {
	public boolean tagIsbn(Book book) throws IOException {

		bookCategory = book.getBookCategory();
		bookImageName = book.getBookImageName();
		isbn = book.getIsbn();

		// sourcePath = "assets/images/source/" + bookCategory + "/" + bookImageName;
		sourcePath = "assets/images/" + bookCategory + "/" + bookImageName;

		// targetPath = "assets/images/target/" + bookCategory + "/" + isbn + "-" +
		// bookImageName;
		targetPath = "assets/images/" + bookCategory + "/" + isbn + "-" + bookImageName;

		sourceFile = new File(sourcePath);
		targetFile = new File(targetPath);

		if (sourceFile.renameTo(targetFile)) {
			// System.out.println("source to target successful..");
			System.out.println("ISBN tagging successful..");
			flag = true;
			return flag;
		} else {
			// System.out.println("error in moving the file from source to target
			// location..");
			System.out.println("error in tagging ISBN..");
			flag = false;
			return flag;
		}
	}

	public void archiveBookByIsbn(long isbn, String bookArchiveReason) {
		Book book = bookRepository.findById(isbn).get();
		ZonedDateTime inclusionDate = ZonedDateTime.now();

		book.setArchiveFlag(true);
		book.setBookArchiveReason(bookArchiveReason);
		book.setInclusionDate(inclusionDate);

		bookRepository.save(book);

		// this.archiveFile(book);
	}

	public void unArchiveBookByIsbn(long isbn) {
		Book book = bookRepository.findById(isbn).get();
		ZonedDateTime inclusionDate = ZonedDateTime.now();

		book.setArchiveFlag(false);
		book.setBookArchiveReason(null);
		book.setInclusionDate(inclusionDate);

		bookRepository.save(book);

		// this.unArchiveFile(book);

	}

//	public boolean archiveFile(Book book) {
//		
//		bookCategory = book.getBookCategory();
//		bookImageName = book.getBookImageName();
//		isbn = book.getIsbn();
//				
//		targetPath = "assets/images/target/" + bookCategory + "/" + isbn + "-" + bookImageName;
//		System.out.println("target path is ..." + targetPath);
//		
//		archivePath= "assets/images/archive/" + bookCategory + "/" + isbn + "-" + bookImageName;
//		System.out.println("archive path is ..." + archivePath);
//		
//		sourceFile = new File(targetPath);
//		targetFile= new File(archivePath);
//		if (sourceFile.renameTo(targetFile)) {
//			System.out.println("taget to archive successful..");
//			flag = true;
//			return flag;
//		} else {
//			System.out.println("error in moving the file from target to archive location..");
//			flag = false;
//			return flag;
//		}
//	}

//	public boolean unArchiveFile(Book book) {
//		
//		bookCategory = book.getBookCategory();
//		bookImageName = book.getBookImageName();
//		isbn = book.getIsbn();
//				
//		targetPath = "assets/images/target/" + bookCategory + "/" + isbn + "-" + bookImageName;
//		System.out.println("target path is ..." + targetPath);
//		
//		archivePath= "assets/images/archive/" + bookCategory + "/" + isbn + "-" + bookImageName;
//		System.out.println("archive path is ..." + archivePath);
//		
//		sourceFile = new File(archivePath);
//		targetFile= new File(targetPath);
//		if (sourceFile.renameTo(targetFile)) {
//			System.out.println("archive to target successful..");
//			flag = true;
//			return flag;
//		} else {
//			System.out.println("error in moving the file from archive to target location..");
//			flag = false;
//			return flag;
//		}
//	}

//	public ArrayList<String> fetchAllFilesByCategory(String bookCategory) {
//		//File file = new File("assets/images/target/" + bookCategory);
//		File file = new File("assets/images/books/" + bookCategory);
//		
//		fileLst = file.listFiles();
//		
//		strCategoryLst = new ArrayList<String>();
//				
//		for(File fl:fileLst) {
//			System.out.println("file name is " + fl);
//			str = fl.getPath();
//			str = str.replace("\\", "/");
//			System.out.println("str is " + str);
//			strCategoryLst.add(str);
//		}
//		return strCategoryLst;
//	}

//	public ArrayList<String> fetchAllFiles(String dirPath, boolean flag) {
//		
//		if (flag == true) {
//			strCatalogLst = new ArrayList<String>();
//		}
//		
//		     File directory = new File(dirPath);
//			
//			//get all the files from a directory
//			 File[] fList = directory.listFiles();
//			
//			 for (File fl : fList){
//		         if (fl.isFile()){
//		             str = fl.getPath();
//		             str = str.replace("\\", "/");
//		             strCatalogLst.add(str);
//		    		 System.out.println("str value after replace is.. " + str);
//		    		
//		    	 } else if (fl.isDirectory()){
//		    		 System.out.println("dir path is " + fl.getPath());    		 
//		    		 flag = false;
//		    		 fetchAllFiles(fl.getPath(), flag);
//		    	}
//			 }
//			 
//			 return strCatalogLst;
//	}

	public ArrayList<String> fetchAllActiveImages() {

		List<Book> bookLst = bookRepository.findAll();
		strCatalogLst = new ArrayList<String>();

		for (Book book : bookLst) {

			if (!book.isArchiveFlag()) {
				System.out.println("inside if-block");
				str = book.getBookImageName();
				System.out.println("file path is  " + str);
				strCatalogLst.add(str);
			} else {
				System.out.println("no images in active state");
			}
		}
		return strCatalogLst;
	}

	public ArrayList<String> fetchAllActiveImagesByCategory(String bookCategory) {

		List<Book> bookLst = bookRepository.findAllByBookCategory(bookCategory);
		strCatalogLst = new ArrayList<String>();

		for (Book book : bookLst) {

			if (!book.isArchiveFlag()) {
				System.out.println("inside if-block");
				str = book.getBookImageName();
				System.out.println("file path is  " + str);
				strCatalogLst.add(str);
			} else {
				System.out.println("inside else-block");
			}
		}
		return strCatalogLst;
	}

	public int countByInclusionDate() {
		return bookRepository.countByInclusionDate();
	}
}
