package com.Aforesight.Api.response;

import java.util.List;

public class StandardResponse {
	List list;
	String message;
	String status;
	public StandardResponse(List list, String message, String status) {
		super();
		this.list = list;
		this.message = message;
		this.status = status;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
