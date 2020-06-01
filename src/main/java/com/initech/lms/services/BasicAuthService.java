package com.initech.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.initech.lms.bean.User;
import com.initech.lms.models.Contact;
import com.initech.lms.models.Member;
import com.initech.lms.repository.ContactRepository;
import com.initech.lms.repository.MemberRepository;

@Service
public class BasicAuthService implements UserDetailsService {

	boolean foundFlag;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
		
	BasicAuthService() {
		this.foundFlag = false;
	}


	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("user name is " + emailId);
		Contact contact = contactRepository.findByEmailId(emailId);
		
		System.out.println("memberid is " + contact.getMember().getMemberId());
		
		
		Member member = memberRepository.findById(contact.getMember().getMemberId()).get();
		
		System.out.println("password is " + member.getPassword());
	
			
		User user = new User(emailId, member.getPassword());
		return user;
		
	}
	
}

