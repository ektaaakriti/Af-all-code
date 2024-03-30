package com.Aforesight.Api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "user_login", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),})
public class User_Login {
	@Id
	private String username;
	private Date login_Date_time;
	private String Token;
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLogin_Date_time() {
		return login_Date_time;
	}
	public void setLogin_Date_time(Date login_Date_time) {
		this.login_Date_time = login_Date_time;
	}

}
