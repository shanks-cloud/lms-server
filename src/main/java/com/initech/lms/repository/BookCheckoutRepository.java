package com.initech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initech.lms.models.BookCheckout;


public interface BookCheckoutRepository extends JpaRepository<BookCheckout, Long> {

	
	public int countByMemberId(long memberId);
	
	
}
