package com.Aforesight.Api.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "M_dept")
public class M_dept {
	@Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
	private Long id;
	private String Loc_id;
	private Date allocate_datetime;
	private Date deallocate_datetime;
	private String Dept_name;
	private String Is_active; 
	private String Asset_alloc;
	private String Aseet_id; 
	private String Dept_id;

	private String  Is_dealloc;

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

	public Date getAllocate_datetime() {
		return allocate_datetime;
	}

	public void setAllocate_datetime(Date allocate_datetime) {
		this.allocate_datetime = allocate_datetime;
	}

	public Date getDeallocate_datetime() {
		return deallocate_datetime;
	}

	public void setDeallocate_datetime(Date deallocate_datetime) {
		this.deallocate_datetime = deallocate_datetime;
	}

	public String getDept_name() {
		return Dept_name;
	}

	public void setDept_name(String dept_name) {
		Dept_name = dept_name;
	}

	public String getIs_active() {
		return Is_active;
	}

	public void setIs_active(String is_active) {
		Is_active = is_active;
	}

	public String getAsset_alloc() {
		return Asset_alloc;
	}

	public void setAsset_alloc(String asset_alloc) {
		Asset_alloc = asset_alloc;
	}

	public String getAseet_id() {
		return Aseet_id;
	}

	public void setAseet_id(String aseet_id) {
		Aseet_id = aseet_id;
	}

	public String getDept_id() {
		return Dept_id;
	}

	public void setDept_id(String dept_id) {
		Dept_id = dept_id;
	}

	public String getIs_dealloc() {
		return Is_dealloc;
	}

	public void setIs_dealloc(String is_dealloc) {
		Is_dealloc = is_dealloc;
	}
}
