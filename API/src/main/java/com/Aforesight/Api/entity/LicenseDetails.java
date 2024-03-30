package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "License_details", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"License_No"}),})


public class LicenseDetails {
	
	@Id
	 @GeneratedValue
	private long License_No;
	public long getLicense_No() {
		return License_No;
	}
	public void setLicense_No(long license_No) {
		License_No = license_No;
	}
	private String Ip;
	private String startDate;
	private String EndDate;
	private String username;
	private String Status_flag;
	private String avtivated_by;
	private String validity_remaining;
	private String deactivate_date;
	private String src;
	
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	

}
