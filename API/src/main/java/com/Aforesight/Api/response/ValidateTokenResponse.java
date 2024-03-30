package com.Aforesight.Api.response;

public class ValidateTokenResponse {
	String Message;
	String Status;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public ValidateTokenResponse(String message, String status) {
		super();
		Message = message;
		Status = status;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
