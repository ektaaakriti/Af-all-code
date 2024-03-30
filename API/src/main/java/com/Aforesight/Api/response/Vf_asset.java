package com.Aforesight.Api.response;

import java.util.List;

import com.Aforesight.Api.entity.vf_assets;

public class Vf_asset {
	private String message;
	private String  status;
	private List asset;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List getAsset() {
		return asset;
	}
	public void setAsset(List asset) {
		this.asset = asset;
	}
	public Vf_asset(String message, String status, List asset) {
		super();
		this.message = message;
		this.status = status;
		this.asset = asset;
	}
	
	
	
	
	

}
