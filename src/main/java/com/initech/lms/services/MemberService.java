package com.initech.lms.services;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initech.lms.DTO.ProfileDTO;
import com.initech.lms.models.Contact;
import com.initech.lms.models.Member;
import com.initech.lms.repository.ContactRepository;
import com.initech.lms.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	private ModelMapper modelMapper;
	
	public MemberService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public void register(ProfileDTO profileDTO) throws IOException {
		
		Member member = new Member();
		Contact contact = new Contact();
		
		member = modelMapper.map(profileDTO, Member.class);
		contact = modelMapper.map(profileDTO,  Contact.class);
		
		ZonedDateTime enrollmentDate = ZonedDateTime.now();
		member.setEnrollmentDate(enrollmentDate);
		
		member.setMemberStatus("active");
		
		System.out.println("inside service member class " + member.getMemberId());
		System.out.println("inside service contact class " + contact.getMember().getMemberId());
				
		contactRepository.save(contact);
		memberRepository.save(member);
	}
	
	
	public int getNewMembersCount() {
		return memberRepository.countByEnrollmentDate();
	}
	
	public Contact fetchEmailId(String emailId) {
		return contactRepository.findByEmailId(emailId);
	}
	
}
