package com.nitesh.spring.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.spring.project.model.AuditLog;
import com.nitesh.spring.project.model.TempUser;
import com.nitesh.spring.project.model.WhatsAppOptIn;

public interface TempUserRepository extends JpaRepository<TempUser, String> {
	
	List<TempUser> findByMobileNumberAndOtp(String mobileNumber,String otp);

	TempUser save(TempUser whatsAppOptIn);

}

