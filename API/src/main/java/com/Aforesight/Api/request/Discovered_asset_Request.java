package com.Aforesight.Api.request;

public class Discovered_asset_Request {
	public String username;
	public String System_Ip;
	public String SearchType;
	public String SearchValue;
	public String getSearchValue() {
		return SearchValue;
	}
	public void setSearchValue(String searchValue) {
		SearchValue = searchValue;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSystem_Ip() {
		return System_Ip;
	}
	public void setSystem_Ip(String system_Ip) {
		System_Ip = system_Ip;
	}
	public String getSearchType() {
		return SearchType;
	}
	public void setSearchType(String searchType) {
		SearchType = searchType;
	}
}
