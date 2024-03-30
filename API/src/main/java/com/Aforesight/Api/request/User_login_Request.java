package com.Aforesight.Api.request;

import java.util.Date;

public class User_login_Request {
	public String username;
	public Date login_Date_time;
	public String Token;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLogin_Date_time() {
		return login_Date_time;
	}
	public void setLogin_Date_time(Date login_Date_time) {
		this.login_Date_time = login_Date_time;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
}
