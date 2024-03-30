package com.Aforesight.Api.payload;

import lombok.Data;


public class LocationPayload {
	public Long ID;
	public String Location_Name;
	public String City;
	public String State;
	public String Country;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getLocation_Name() {
		return Location_Name;
	}
	public void setLocation_Name(String location_Name) {
		Location_Name = location_Name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
