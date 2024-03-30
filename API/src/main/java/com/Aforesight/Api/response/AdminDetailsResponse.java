package com.Aforesight.Api.response;

public class AdminDetailsResponse {
String Message;
String Status;
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public AdminDetailsResponse(String message, String status) {
	super();
	Message = message;
	Status = status;
}

}
