package com.initech.lms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initech.lms.DTO.ProfileDTO;
import com.initech.lms.services.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/Register", method=RequestMethod.POST)
	public void register(@RequestBody ProfileDTO profileDTO) throws IOException {
		
		//System.out.println("memberId server-side inside controller.." + profileDTO.getMemberId());
		
		memberService.register(profileDTO);
	}
	
	
//	@RequestMapping(value="/Profile", method=RequestMethod.POST)
//	public void addProfile(@RequestBody ProfileDTO profileDTO) throws IOException {
//		
//		System.out.println("memberId server-side inside controller.." + profileDTO.getMemberId());
//		
//		memberService.addMember(profileDTO);
//	}
}
