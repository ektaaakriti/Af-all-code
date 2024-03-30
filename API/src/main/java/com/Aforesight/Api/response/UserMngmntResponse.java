package com.Aforesight.Api.response;

import java.util.List;

import com.Aforesight.Api.entity.User;

public class UserMngmntResponse {
	public List<User> user;
	public String Message;
	public String status;
	public UserMngmntResponse(List<User> lst, String message, String status) {
		super();
		this.user = lst;
		Message = message;
		this.status = status;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public UserMngmntResponse(String message, String status) {
		super();
		Message = message;
		this.status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
