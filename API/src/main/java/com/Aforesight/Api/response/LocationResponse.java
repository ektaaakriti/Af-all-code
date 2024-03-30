package com.Aforesight.Api.response;

import java.math.BigInteger;

public class LocationResponse {
	String state;
	String count;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public LocationResponse(String state, String count) {
		super();
		this.state = state;
		this.count = count;
	}
	
	

}
