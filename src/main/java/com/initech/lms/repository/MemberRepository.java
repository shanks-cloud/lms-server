package com.initech.lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.initech.lms.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	@Query(value="SELECT count(enrollment_date) FROM lms.member WHERE enrollment_date >= DATE(CURDATE()) - INTERVAL 7 DAY AND member_status = 'active'", nativeQuery=true)
	public int countByEnrollmentDate();


}
