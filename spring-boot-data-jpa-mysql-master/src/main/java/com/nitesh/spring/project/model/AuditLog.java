package com.nitesh.spring.project.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "AuditLog")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Audit_Log_id")
	private int auditLogId;

	@Column(name = "Column_Value")		
	private String columnValue;
	
	@Column(name = "Table_Name")
	private String tableName;

	@Column(name = "Column_Name")		
	private String columnName;	

	@Column(name = "Request_Date")		
	private Date requestDate;

	public int getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(int auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}



}
