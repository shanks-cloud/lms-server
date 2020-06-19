package com.initech.lms.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.models.Book;
import com.initech.lms.models.BookCheckout;
import com.initech.lms.repository.BookCheckoutRepository;
import com.initech.lms.repository.BookRepository;

@Service
public class BookCheckoutService {

	Book book;
	
	@Autowired
	private BookCheckoutRepository bookCheckoutRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public void checkoutBook(BookCheckout checkoutData) {
		System.out.println("BookCheckOut data is ... " + checkoutData.getMemberId());
		
		checkoutData.setCheckOutDate(ZonedDateTime.now());
	
		List<Long> isbn = checkoutData.getIsbn();
		for (long itr  : isbn) {
				book = bookRepository.findById(itr).get();
				book.setCheckOutStatus(true);
		}
		
		bookRepository.save(book);
		bookCheckoutRepository.save(checkoutData);
	}
}