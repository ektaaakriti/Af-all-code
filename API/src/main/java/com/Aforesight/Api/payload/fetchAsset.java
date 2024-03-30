//Purpose:This is payload for vf_assets.java.
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
package com.Aforesight.Api.payload;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;


public class fetchAsset {
	//public long id;
	public String assetType;
	public String asset_id;
	public String assetDescription;
	public String assetsharedlocation;
	public Date assetcreationdate; 
	public Date assetupdationdate;
	public String createdby;
	public String updatedby;	
	public String PN;	 
	public String sw_install_path;	 
	public String ip_address;	
	public String delete_status;
	public String software_install_choice;
	public String getSoftware_install_choice() {
		return software_install_choice;
	}
	public void setSoftware_install_choice(String software_install_choice) {
		this.software_install_choice = software_install_choice;
	}
	public String getDelete_status() {
		return delete_status;
	}
	public void setDelete_status(String delete_status) {
		this.delete_status = delete_status;
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
	public String UN;
	
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	
}
