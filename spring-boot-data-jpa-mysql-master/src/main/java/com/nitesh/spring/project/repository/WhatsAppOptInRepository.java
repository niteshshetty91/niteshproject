package com.nitesh.spring.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.spring.project.model.AuditLog;
import com.nitesh.spring.project.model.WhatsAppOptIn;

public interface WhatsAppOptInRepository extends JpaRepository<WhatsAppOptIn, Integer> {

	WhatsAppOptIn save(WhatsAppOptIn whatsAppOptIn);
	
	List<WhatsAppOptIn> findByMobileNumber(String mobileNumber);

}

