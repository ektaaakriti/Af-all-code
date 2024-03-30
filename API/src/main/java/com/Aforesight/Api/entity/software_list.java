package com.Aforesight.Api.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "software_list")
public class software_list {
	@Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String install_date;
	private String name;
	private String version;

}
