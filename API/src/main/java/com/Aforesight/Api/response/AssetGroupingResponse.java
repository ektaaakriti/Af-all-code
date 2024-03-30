package com.Aforesight.Api.response;

import java.util.HashMap;

public class AssetGroupingResponse {
	HashMap map;
	String Status;
	String Message;
	public AssetGroupingResponse(String message, String status, HashMap map) {
		super();
		this.map = map;
		Status = status;
		Message = message;
	}
	public HashMap getMap() {
		return map;
	}
	public void setMap(HashMap map) {
		this.map = map;
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
