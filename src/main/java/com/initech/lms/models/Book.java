package com.initech.lms.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
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
	//private String inclusionDate;
	private ZonedDateTime inclusionDate;

	@Column(name = "bookCategory", nullable = false)
	private String bookCategory;
	
	@Column(name = "bookImageName")
	private String bookImageName;
	
	@Column(name = "bookArchiveReason")
	private String bookArchiveReason;
	
	@Column(name = "archiveFlag")
	private boolean archiveFlag;
	
	@Column(name = "lang")
	private String lang;
	
	@Column(name = "bookPrice")
	private double bookPrice;
	
	@Column(name = "bookCopies")
	private int bookCopies;
	
	@Column(name = "pageCount")
	private int pageCount;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn (name="memberId")
//	private BookCheckout bookCheckout;
	
	
	public Book() {
		
	}
	
	public Book(long isbn, String bookTitle, String author, String publisher, ZonedDateTime inclusionDate, String bookCategory,
			String bookImageName, String bookArchiveReason, boolean archiveFlag, String lang, double bookPrice,
			int bookCopies, int pageCount) {
		super();
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.inclusionDate = inclusionDate;
		this.bookCategory = bookCategory;
		this.bookImageName = bookImageName;
		this.bookArchiveReason = bookArchiveReason;
		this.archiveFlag = archiveFlag;
		this.lang = lang;
		this.bookPrice = bookPrice;
		this.bookCopies = bookCopies;
		this.pageCount = pageCount;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public ZonedDateTime getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(ZonedDateTime inclusionDate) {
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

	public String getBookArchiveReason() {
		return bookArchiveReason;
	}

	public void setBookArchiveReason(String bookArchiveReason) {
		this.bookArchiveReason = bookArchiveReason;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(int bookCopies) {
		this.bookCopies = bookCopies;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isArchiveFlag() {
		return archiveFlag;
	}

	public void setArchiveFlag(boolean archiveFlag) {
		this.archiveFlag = archiveFlag;
	}
	
}
