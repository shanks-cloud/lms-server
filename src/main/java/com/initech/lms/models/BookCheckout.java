package com.initech.lms.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookCheckout")
public class BookCheckout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookCheckOutId")
	private long bookCheckOutId;
	
	@ElementCollection
	@Column(name="isbn")
	private List<Long> isbn = new ArrayList<>();
	
	@Column(name="memberId")
	private long memberId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="checkOutDate")
	private ZonedDateTime checkOutDate;
	

	public long getBookCheckOutId() {
		return bookCheckOutId;
	}

	public void setBookCheckOutId(long bookCheckOutId) {
		this.bookCheckOutId = bookCheckOutId;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Long> getIsbn() {
		return isbn;
	}

	public void setIsbn(List<Long> isbn) {
		this.isbn = isbn;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public ZonedDateTime getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(ZonedDateTime checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	
}
