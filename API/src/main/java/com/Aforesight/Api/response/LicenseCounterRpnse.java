package com.Aforesight.Api.response;

import java.util.List;

public class LicenseCounterRpnse {
LicenseCounterResponse lst;
String message;
String Status;
public LicenseCounterResponse getLst() {
	return lst;
}
public void setLst(LicenseCounterResponse lst) {
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
public LicenseCounterRpnse(LicenseCounterResponse lst, String message, String status) {
	super();
	this.lst = lst;
	this.message = message;
	Status = status;
}
}