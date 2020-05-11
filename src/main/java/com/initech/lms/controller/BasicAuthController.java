package com.initech.lms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.bean.AuthenticationBean;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/home", method=RequestMethod.GET)
public class BasicAuthController {

	//@GetMapping(path = "/basicauth")
	@RequestMapping(value="/basicauth", method=RequestMethod.GET)
	public AuthenticationBean basicAuth() throws Exception {
		return new AuthenticationBean("You are authenticated..");
	}
}
