package com.Aforesight.Api.payload;

import lombok.Data;


public class DepartmentPayload {
public Long ID;
public String Department_Name;
public Long getID() {
	return ID;
}
public void setID(Long iD) {
	ID = iD;
}
public String getDepartment_Name() {
	return Department_Name;
}
public void setDepartment_Name(String department_Name) {
	Department_Name = department_Name;
}
}
