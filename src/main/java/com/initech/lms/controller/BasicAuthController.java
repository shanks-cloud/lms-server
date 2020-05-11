package com.initech.lms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.config.SpringSecurityConfig;
import com.lms.initech.bean.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/home", method=RequestMethod.GET)
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicAuth() throws Exception {
		//SpringSecurityConfig springSecurityConfig = new SpringSecurityConfig();
		return new AuthenticationBean("You are authenticated");
	}
}
