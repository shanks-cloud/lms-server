package com.initech.lms.models;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId")
	private long memberId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enrollmentDate")
	private ZonedDateTime enrollmentDate;
	
	@Column(name = "memberStatus")
	private String memberStatus;
	
	
//	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn (name="contactId")
//	private Contact contact;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn (name="memberId")
	private BookCheckout bookCheckout;
	
		
	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ZonedDateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(ZonedDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public BookCheckout getBookCheckout() {
		return bookCheckout;
	}

	public void setBookCheckout(BookCheckout bookCheckout) {
		this.bookCheckout = bookCheckout;
	}

}
