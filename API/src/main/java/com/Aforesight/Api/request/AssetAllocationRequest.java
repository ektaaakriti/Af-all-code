package com.Aforesight.Api.request;

public class AssetAllocationRequest {
	  public String asset_id;
	  public String Assets_Status;
	  public String Department_Name ;
		public String Site_Name;
		public String getAsset_id() {
			return asset_id;
		}
		public void setAsset_id(String asset_id) {
			this.asset_id = asset_id;
		}
		public String getAssets_Status() {
			return Assets_Status;
		}
		public void setAssets_Status(String assets_Status) {
			Assets_Status = assets_Status;
		}
		public String getDepartment_Name() {
			return Department_Name;
		}
		public void setDepartment_Name(String department_Name) {
			Department_Name = department_Name;
		}
		public String getSite_Name() {
			return Site_Name;
		}
		public void setSite_Name(String site_Name) {
			Site_Name = site_Name;
		}
}
