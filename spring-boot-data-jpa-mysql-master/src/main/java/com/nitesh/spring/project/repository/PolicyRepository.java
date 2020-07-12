package com.nitesh.spring.project.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.spring.project.model.AuditLog;
import com.nitesh.spring.project.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	
	List<Policy> findByPolicyNumber(int policyNumber);
	
	List<Policy> findByEmailAddressAndDob(String emailAddress,Date dob);

	List<Policy> findByEmailAddress(String emailAddress);

	List<Policy> findByMobileNumber(String mobileNumber);

	List<Policy> findByDob(Date dob);

	List<Policy> findByMobileNumberAndDob(String mobileNumber,Date dob);
	
	Policy save(Policy policy);

	
}
