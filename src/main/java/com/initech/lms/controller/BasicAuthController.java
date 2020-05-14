package com.initech.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.bean.User;
import com.initech.lms.services.BasicAuthService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping(value="/home", method=RequestMethod.GET)
public class BasicAuthController {

	@Autowired
	private BasicAuthService basicAuthService;
	
	//@GetMapping(path = "/basicauth")
	@RequestMapping(value="/home/basicauth", method=RequestMethod.POST)
	public boolean basicAuth(@RequestBody User user, @RequestHeader HttpHeaders headers) throws Exception {
		System.out.println("inside basicauth controller..");
		return basicAuthService.fetchEmailIdAndPassword(user, headers);
	}
}
