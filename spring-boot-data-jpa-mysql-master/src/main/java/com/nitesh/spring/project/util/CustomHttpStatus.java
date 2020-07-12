package com.nitesh.spring.project.util;

public enum CustomHttpStatus {


	OLD_USER("1001","OLD_USER"),
	NEW_USER("1001","NEW_USER"),
	OTP_SENT("1001","OTP_SENT"),
	REQUEST("1001","REQUEST"),
	VALIDATION("1001","VALIDATION"),
	GET("1001","GET");

	private String statusCode;
	private String statusDesc;

	CustomHttpStatus(String statusCode,String statusDesc) {
		this.statusCode=statusCode;
		this.statusDesc=statusDesc;
	}
	
	public String statusCode(){
		return this.statusCode;
	}
	
	public String statusDesc(){
		return this.statusDesc;
	}

}
