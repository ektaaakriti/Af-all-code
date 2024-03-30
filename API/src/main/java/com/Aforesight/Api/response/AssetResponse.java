package com.Aforesight.Api.response;

import java.util.List;

public class AssetResponse {
List lst;
String message;
String Status;
public AssetResponse(List lst, String message, String status) {
	super();
	this.lst = lst;
	this.message = message;
	Status = status;
}
public List getLst() {
	return lst;
}
public void setLst(List lst) {
	this.lst = lst;
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
