package com.nitesh.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.spring.project.model.AuditLog;

public interface AuditRepository extends JpaRepository<AuditLog, Integer> {

	AuditLog save(AuditLog auditLog);
}
