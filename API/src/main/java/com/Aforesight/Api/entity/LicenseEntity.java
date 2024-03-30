package com.Aforesight.Api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "License_data", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Total_License"}),})
        
public class LicenseEntity {

	@Id
	private String Total_License;
	private String Start_date;
	private String validity;
	private String Client_Id;
	private String Client_name;
	public String getClient_name() {
		return Client_name;
	}
	public void setClient_name(String client_name) {
		Client_name = client_name;
	}
	public String getClient_Id() {
		return Client_Id;
	}
	public void setClient_Id(String client_Id) {
		Client_Id = client_Id;
	}
	public String getTotal_License() {
		return Total_License;
	}
	public void setTotal_License(String total_License) {
		Total_License = total_License;
	}
	public String getStart_date() {
		return Start_date;
	}
	public void setStart_date(String start_date) {
		Start_date = start_date;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	

}
