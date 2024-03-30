package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "dept_master", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ID"}),})
public class Department {
	@Id
	private Long ID;
	private String Department_name;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}

}
