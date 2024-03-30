package com.Aforesight.Api.payload;

import java.util.Date;

public class License_payload {
	public String Total_License;
	public String Start_date;
	public String validity;
	public String Client_Id;
	public String Client_name;
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
