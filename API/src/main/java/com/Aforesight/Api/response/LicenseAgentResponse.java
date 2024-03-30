package com.Aforesight.Api.response;

public class LicenseAgentResponse {
String License_no;
private String username;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
private String Ip;
private String startDate;
private String EndDate;
private String Status_flag;
private String validity_remaining;
private String deactivate_date;
public String getValidity_remaining() {
	return validity_remaining;
}
public void setValidity_remaining(String validity_remaining) {
	this.validity_remaining = validity_remaining;
}
public String getDeactivate_date() {
	return deactivate_date;
}
public void setDeactivate_date(String deactivate_date) {
	this.deactivate_date = deactivate_date;
}
public LicenseAgentResponse() {
	// TODO Auto-generated constructor stub
}
public String getLicense_no() {
	return License_no;
}
public void setLicense_no(String license_no) {
	License_no = license_no;
}
public String getIp() {
	return Ip;
}
public void setIp(String ip) {
	Ip = ip;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return EndDate;
}
public void setEndDate(String endDate) {
	EndDate = endDate;
}
public String getStatus_flag() {
	return Status_flag;
}
public void setStatus_flag(String status_flag) {
	Status_flag = status_flag;
}


}
