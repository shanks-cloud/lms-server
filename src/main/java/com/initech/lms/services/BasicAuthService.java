package com.initech.lms.services;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.initech.lms.bean.User;
import com.initech.lms.models.Contact;
import com.initech.lms.repository.ContactRepository;

@Service
public class BasicAuthService {

	boolean foundFlag;
	
	@Autowired
	private ContactRepository contactRepository;
	
		
	BasicAuthService() {
		this.foundFlag = false;
	}
	
		
	public boolean fetchEmailIdAndPassword(User user, HttpHeaders header) throws IOException {
		
		List<Contact> contacts = contactRepository.findAllByEmailId(user.getEmailId());
		
		System.out.println("inside service..");
		
		for (Contact cnt : contacts)	 {
				String pswd = cnt.getMember().getPassword();
				if (pswd.equals(user.getPassword())) {
				    System.out.println("password matched..");
					foundFlag = true;
														
//			   		FileOutputStream fos = new FileOutputStream("/src/main/resource/application.properties");
//					Properties prop = new Properties();
//					
//					prop.setProperty("spring.security.user.name", emailId);
//					prop.setProperty("spring.security.user.password", password);
//					
//					prop.store(fos, "file saved successfully");
//					
			   } else {
				   System.out.println("inside else...");
				   foundFlag = false;
			}
		}
		return foundFlag;
	}
	
}

