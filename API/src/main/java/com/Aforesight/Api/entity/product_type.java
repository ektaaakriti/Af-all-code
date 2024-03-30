package com.Aforesight.Api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "product_type_master", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"}),})
public class product_type {
	@Id
	private Long id;
	private String Product_type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct_type() {
		return Product_type;
	}
	public void setProduct_type(String product_type) {
		Product_type = product_type;
	}

}
