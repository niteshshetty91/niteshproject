package com.nitesh.spring.project.response;

public class JsonResponse {

	private String status;
	private String token;
	private String refresh;
	private Object data;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefresh() {
		return refresh;
	}
	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
