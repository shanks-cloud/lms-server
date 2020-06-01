package com.initech.lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.initech.lms.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	


}
