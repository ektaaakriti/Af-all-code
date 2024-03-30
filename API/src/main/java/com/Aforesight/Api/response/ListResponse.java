package com.Aforesight.Api.response;

import java.util.List;

public class ListResponse {
List list;
String Status;
String Message;
public ListResponse(List list, String status, String message) {
	super();
	this.list = list;
	Status = status;
	Message = message;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
}
