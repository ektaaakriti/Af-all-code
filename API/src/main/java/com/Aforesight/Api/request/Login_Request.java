package com.Aforesight.Api.request;

public class Login_Request {
	public String username;
    public String password;
    public String Email_ID;
    public Integer loginAttempt;
    public String portal_type;
	
	public String getPortal_type() {
		return portal_type;
	}
	public void setPortal_type(String portal_type) {
		this.portal_type = portal_type;
	}
	public Integer getLoginAttempt() {
		return loginAttempt;
	}
	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
}
