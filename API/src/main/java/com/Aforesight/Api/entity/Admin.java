package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "system_data", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Parameter_Username"}),})
        
public class Admin {

	  @Id
    public String getParameter_Username() {
		return Parameter_Username;
	}
	public void setParameter_Username(String parameter_Username) {
		Parameter_Username = parameter_Username;
	}
	public String getParameter_password() {
		return Parameter_password;
	}
	public void setParameter_password(String parameter_password) {
		Parameter_password = parameter_password;
	}
	private String Parameter_Username;
    private String Parameter_password;
	
}
