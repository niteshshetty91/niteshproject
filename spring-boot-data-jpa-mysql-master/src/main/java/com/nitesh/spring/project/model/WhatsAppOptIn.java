package com.nitesh.spring.project.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Whats_App_Opt_In")
public class WhatsAppOptIn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Optin_Id")
	private int optinId;

	@Column(name = "Mobile_Number")
	private String mobileNumber;

	@Column(name = "Policy_Number",unique = true)
	private int policyNumber;

	@Column(name = "Optin_Date")
	private Date optinDate;

	public int getOptinId() {
		return optinId;
	}

	public void setOptinId(int optinId) {
		this.optinId = optinId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getOptinDate() {
		return optinDate;
	}

	public void setOptinDate(Date optinDate) {
		this.optinDate = optinDate;
	}

	
}
