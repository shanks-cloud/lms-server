package com.initech.lms.models;

import javax.persistence.Column;

import javax.persistence.Entity;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "bookId")
//	private int bookId;

	@Id
	@Column(name = "isbn")
	private long isbn;

	@Column(name = "bookTitle", nullable = false)
	private String bookTitle;

	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "publisher", nullable = false)
	private String publisher;

	@Column(name = "inclusionDate", nullable = false)
	private String inclusionDate;

	@Column(name = "bookCategory", nullable = false)
	private String bookCategory;
	
	@Column(name = "bookImageName")
	private String bookImageName;
	
	
	public Book() {

	}

	public Book(long isbn, String bookTitle, String publisher, String author, String inclusionDate,
			String bookCategory, String bookImageName) {
		super();
		//this.bookId = bookId;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.publisher = publisher;
		this.author = author;
		this.inclusionDate = inclusionDate;
		this.bookCategory = bookCategory;
		this.bookImageName = bookImageName;
	}

//	public int getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(int bookId) {
//		this.bookId = bookId;
//	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(String inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookImageName() {
		return bookImageName;
	}

	public void setBookImageName(String bookImageName) {
		this.bookImageName = bookImageName;
	}


}
