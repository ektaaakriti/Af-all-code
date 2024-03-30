package com.Aforesight.Api.response;

public class StatusResponse {
String status;
String Count;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCount() {
	return Count;
}
public void setCount(String count) {
	Count = count;
}
public StatusResponse(String status, String count) {
	super();
	this.status = status;
	Count = count;
}
}
