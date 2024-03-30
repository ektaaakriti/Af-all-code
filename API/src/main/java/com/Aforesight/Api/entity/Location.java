package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "location_master", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ID"}),})
public class Location {
	@Id
	private Long ID;
	private String Location_Name;
	private String City;
	private String State;
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
	private String Country;

}
