package com.Aforesight.Api.response;

public class SwCountResponse {
SoftwareCountResponse sw;
String message;
String Status;
public SwCountResponse(SoftwareCountResponse sw, String message, String status) {
	super();
	this.sw = sw;
	this.message = message;
	Status = status;
}
public SoftwareCountResponse getSw() {
	return sw;
}
public void setSw(SoftwareCountResponse sw) {
	this.sw = sw;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
}
