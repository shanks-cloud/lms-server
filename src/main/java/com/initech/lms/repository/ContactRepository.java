package com.initech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initech.lms.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
