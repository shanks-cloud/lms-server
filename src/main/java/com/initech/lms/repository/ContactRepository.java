package com.initech.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initech.lms.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	public Contact findByEmailId(String emailId);
	
	
	
}
