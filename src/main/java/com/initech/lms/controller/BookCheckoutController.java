package com.initech.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.models.BookCheckout;
import com.initech.lms.services.BookCheckoutService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookCheckoutController {
	
	
	@Autowired
	BookCheckoutService bookCheckoutService;
	
	@RequestMapping(value="/Books/BookCheckout", method=RequestMethod.POST)
	public void checkoutBook(@RequestBody BookCheckout checkoutData) {
		bookCheckoutService.checkoutBook(checkoutData);
	}
}
