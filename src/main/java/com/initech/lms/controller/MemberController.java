package com.initech.lms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.DTO.ProfileDTO;
import com.initech.lms.models.Contact;
import com.initech.lms.models.Member;
import com.initech.lms.services.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="Member/Register", method=RequestMethod.POST)
	public void register(@RequestBody ProfileDTO profileDTO) throws IOException {
		
		//System.out.println("memberId server-side inside controller.." + profileDTO.getMemberId());
		
		memberService.register(profileDTO);
	}
	
	
	@RequestMapping(value="/Member/newMembersCount", method=RequestMethod.GET)
	public int getNewMembersCount() {
		return memberService.getNewMembersCount();
	}
	
	@RequestMapping(value="/Member/fetchMember/{emailId}", method=RequestMethod.GET)
	public Contact fetchEmailId(@PathVariable String emailId) {
		return memberService.fetchEmailId(emailId);
	}
	
	@RequestMapping(value="/Member/fetchAllMembers")
	public List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}
	
	
//	@RequestMapping(value="/Profile", method=RequestMethod.POST)
//	public void addProfile(@RequestBody ProfileDTO profileDTO) throws IOException {
//		
//		System.out.println("memberId server-side inside controller.." + profileDTO.getMemberId());
//		
//		memberService.addMember(profileDTO);
//	}
}
