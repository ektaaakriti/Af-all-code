package com.Aforesight.Api.response;

import java.util.List;

public class UnlockUsersResponse {
List UpdatedUsers;
String Message;
String Status;
public UnlockUsersResponse(List updatedUsers, String message, String status) {
	super();
	UpdatedUsers = updatedUsers;
	Message = message;
	Status = status;
}
public List getUpdatedUsers() {
	return UpdatedUsers;
}
public void setUpdatedUsers(List updatedUsers) {
	UpdatedUsers = updatedUsers;
}
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
}}
