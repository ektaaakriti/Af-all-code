//Purpose:This class is used to create entity for vf_Assets table, which stores details of the assets.
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
package com.Aforesight.Api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "vf_assets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"asset_id"}),})
public class vf_assets {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String software_install_choice;
	public String getSoftware_install_choice() {
		return software_install_choice;
	}
	public void setSoftware_install_choice(String software_install_choice) {
		this.software_install_choice = software_install_choice;
	}
	@Column(name="asset_id")
	private String asset_id;
	 @Column(name="asset_description")
	private String assetDescription;
	 @Column(name="asset_type")
	 private String assetType;
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	
	 @Column(name=" assetSharedLocation")
	private String assetsharedlocation;
	 @Column(name="assetCreationDate")
	private Date assetcreationdate;
	 @Column(name="assetUpdationDate")
	private Date assetupdationdate;
	 @Column(name="createdBy ")
	private String createdby;
		 @Column(name="updatedBy")
	private String updatedby;
		 @Column(name="PN")
	private String PN;
		 @Column(name="sw_install_path ")
	private String sw_install_path;
		 @Column(name="ip_address ")
	private String ip_address;
		 @Column(name="UN")
	private String UN;
		 @Column(columnDefinition = "varchar(255) default 'NO'")
	private String Delete_status;
	 public String getDelete_status() {
		return Delete_status;
	}
	public void setDelete_status(String delete_status) {
		Delete_status = delete_status;
	}
	public String getAssetsharedlocation() {
		return assetsharedlocation;
	}
	public void setAssetsharedlocation(String assetsharedlocation) {
		this.assetsharedlocation = assetsharedlocation;
	}
	public Date getAssetcreationdate() {
		return assetcreationdate;
	}
	public void setAssetcreationdate(Date assetcreationdate) {
		this.assetcreationdate = assetcreationdate;
	}
	public Date getAssetupdationdate() {
		return assetupdationdate;
	}
	public void setAssetupdationdate(Date assetupdationdate) {
		this.assetupdationdate = assetupdationdate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public String getPN() {
		return PN;
	}
	public void setPN(String pN) {
		PN = pN;
	}
	public String getSw_install_path() {
		return sw_install_path;
	}
	public void setSw_install_path(String sw_install_path) {
		this.sw_install_path = sw_install_path;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getUN() {
		return UN;
	}
	public void setUN(String uN) {
		UN = uN;
	}

	
	
	
	
	
	
}