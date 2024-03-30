package com.Aforesight.Api.entity;
import lombok.Data;

import javax.persistence.*;

import org.springframework.context.annotation.Role;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "M_location")
public class M_location {
	@Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
	private Long id;
	private String Loc_id;
	private String loc_name;
	
	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoc_id() {
		return Loc_id;
	}

	public void setLoc_id(String loc_id) {
		Loc_id = loc_id;
	}

	
}
