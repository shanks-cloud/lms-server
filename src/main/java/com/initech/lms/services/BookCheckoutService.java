package com.initech.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.BookCheckout;
import com.initech.lms.repository.BookCheckoutRepository;

@Service
public class BookCheckoutService {
		
	@Autowired
	private BookCheckoutRepository bookCheckoutRepository;
	
	public void checkoutBook(BookCheckout checkoutData) {
		System.out.println("BookCheckOut data is ... " + checkoutData.getMemberId());
		bookCheckoutRepository.save(checkoutData);
	}
}