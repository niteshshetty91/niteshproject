package com.nitesh.spring.project.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Temp_User")
public class TempUser {
	
	@Id
	@Column(name = "Mobile_Number")
	private String mobileNumber;
	
	@Column(name = "Otp")
	private String otp;
	
	@Column(name = "Expire_Time")
	private Date expireTime;
	
	@Column(name = "Created_Time")
	private Date createdTime;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}