package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "os_type_master", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"}),})
public class Os_Type {
@Id
private Long id;
private String os_type;
private String os_version;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getOs_type() {
	return os_type;
}
public void setOs_type(String os_type) {
	this.os_type = os_type;
}
public String getOs_version() {
	return os_version;
}
public void setOs_version(String os_version) {
	this.os_version = os_version;
}

}
