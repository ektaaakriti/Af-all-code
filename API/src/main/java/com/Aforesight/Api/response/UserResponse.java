package com.Aforesight.Api.response;

import com.Aforesight.Api.entity.User;

public class UserResponse {
	private String message;
	private String status;
	private String loginAttempt;
	private String Token;
	private String User_Type;
	
	


	public UserResponse(String message, String status, String loginAttempt, String token, String user_Type) {
		super();
		this.message = message;
		this.status = status;
		this.loginAttempt = loginAttempt;
		Token = token;
		User_Type = user_Type;
	}


	


	public String getUser_Type() {
		return User_Type;
	}





	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}





	public String getToken() {
		return Token;
	}


	public void setToken(String token) {
		Token = token;
	}


	public UserResponse(String message, String status, String loginAttempt) {
		super();
		this.message = message;
		this.status = status;
		this.loginAttempt = loginAttempt;
	}


	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLoginAttempt() {
		return loginAttempt;
	}


	public void setLoginAttempt(String loginAttempt) {
		this.loginAttempt = loginAttempt;
	}


	public UserResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
		
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	
	
	

}
