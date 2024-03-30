package com.Aforesight.Api.response;

public class DepartmentResponse {
String Department;
String Count;
public DepartmentResponse(String department, String count) {
	super();
	Department = department;
	Count = count;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
public String getCount() {
	return Count;
}
public void setCount(String count) {
	Count = count;
}
}
