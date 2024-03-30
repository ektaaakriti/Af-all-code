package com.Aforesight.Api.payload;

public class LicenseDetailsPayload {
	public long License_No;
	public String Ip;
	public String startDate;
	public String EndDate;
	public String username;
	public String Status_flag;
	public String avtivated_by;
	public String validity_remaining;
	public String deactivate_date;
	public String src;
	public String license_number;
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDeactivate_date() {
		return deactivate_date;
	}
	public void setDeactivate_date(String deactivate_date) {
		this.deactivate_date = deactivate_date;
	}
	public String getValidity_remaining() {
		return validity_remaining;
	}
	public void setValidity_remaining(String validity_remaining) {
		this.validity_remaining = validity_remaining;
	}
	public long getLicense_No() {
		return License_No;
	}
	public void setLicense_No(long license_No) {
		License_No = license_No;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus_flag() {
		return Status_flag;
	}
	public void setStatus_flag(String status_flag) {
		Status_flag = status_flag;
	}
	public String getAvtivated_by() {
		return avtivated_by;
	}
	public void setAvtivated_by(String avtivated_by) {
		this.avtivated_by = avtivated_by;
	}

}
