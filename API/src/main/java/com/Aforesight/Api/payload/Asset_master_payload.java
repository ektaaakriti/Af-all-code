package com.Aforesight.Api.payload;

import javax.persistence.Column;

import lombok.Data;
public class Asset_master_payload {
	public long id;
	public String Scan_Date;
	public String System_Make;	
	public String System_form_Factor;
	public String System_Model;
	public String System_Serial_Number;
	public String Product_Type;
	public String System_IP_Address;
	public String System_Hostname;
	public String System_OS_type;
	public String OS_License_details;
	public String OS_Version;
	public String OS_Key;
	public String Total_RAM;
	public String RAM_Available;
	public String RAM_Used;
	public String HD_Make;
	public String HD_Model;
	public String HD_Serial_Number;
	public String HD_Capacity;
	public String Processor_Details;
	public String MBD_Make;
	public String MBD_Model;
	public String MBD_Serial_Number;
	public String Type_of_Chipset;
	public String Monitor_Screen_Make;
	public String Monitor_Model;
	public String Monitor_Serial_Number;
	public String Monitor_Screen_Size;
	public String Assets_Status;
	public String Retired_Date;
	public String Software_list_with_version_and_installed_Date;
	public String Procured_Date;
	public String Procument_ID	;
	public String Warranty_AMC;
	public String Warranty_AMC_Vendor_Name;
	public String Warrenty_AMC_From;
	public String Warrenty_AMC_To;
	public String User_ID	;
	public String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String Department_Name ;
	public String Site_Name;
	public String Sub_Department_Name;
	public String Aforesight_Agent_ID;
	  public String asset_id;
	
	  
	  public String  MS_Office_2010;
		public String MS_Office_2013;
		public String MS_Office_2016;
		public String Adobe_Reader;
		public String  Java8;
		public String Symantec_Antivirus;
		public String Mcafee_Antivirus;
		public String  Trend_Micro_Antivirus;
		public String Microsoft_Teams;
		public String  MS_Office_2007;
		public String Anydesk;
		public String OneDrive;
		public String zip7;
		public String  Mozilla_Firefox;
		public String  Google_Chrome;
		public String  Team_Viewer;
		public String Zoom;
		public String Webex;
		public String AutoCad;
		public String Winrar;
	public String getMS_Office_2010() {
			return MS_Office_2010;
		}
		public void setMS_Office_2010(String mS_Office_2010) {
			MS_Office_2010 = mS_Office_2010;
		}
		public String getMS_Office_2013() {
			return MS_Office_2013;
		}
		public void setMS_Office_2013(String mS_Office_2013) {
			MS_Office_2013 = mS_Office_2013;
		}
		public String getMS_Office_2016() {
			return MS_Office_2016;
		}
		public void setMS_Office_2016(String mS_Office_2016) {
			MS_Office_2016 = mS_Office_2016;
		}
		public String getAdobe_Reader() {
			return Adobe_Reader;
		}
		public void setAdobe_Reader(String adobe_Reader) {
			Adobe_Reader = adobe_Reader;
		}
		public String getJava8() {
			return Java8;
		}
		public void setJava8(String java8) {
			Java8 = java8;
		}
		public String getSymantec_Antivirus() {
			return Symantec_Antivirus;
		}
		public void setSymantec_Antivirus(String symantec_Antivirus) {
			Symantec_Antivirus = symantec_Antivirus;
		}
		public String getMcafee_Antivirus() {
			return Mcafee_Antivirus;
		}
		public void setMcafee_Antivirus(String mcafee_Antivirus) {
			Mcafee_Antivirus = mcafee_Antivirus;
		}
		public String getTrend_Micro_Antivirus() {
			return Trend_Micro_Antivirus;
		}
		public void setTrend_Micro_Antivirus(String trend_Micro_Antivirus) {
			Trend_Micro_Antivirus = trend_Micro_Antivirus;
		}
		public String getMicrosoft_Teams() {
			return Microsoft_Teams;
		}
		public void setMicrosoft_Teams(String microsoft_Teams) {
			Microsoft_Teams = microsoft_Teams;
		}
		public String getMS_Office_2007() {
			return MS_Office_2007;
		}
		public void setMS_Office_2007(String mS_Office_2007) {
			MS_Office_2007 = mS_Office_2007;
		}
		public String getAnydesk() {
			return Anydesk;
		}
		public void setAnydesk(String anydesk) {
			Anydesk = anydesk;
		}
		public String getOneDrive() {
			return OneDrive;
		}
		public void setOneDrive(String oneDrive) {
			OneDrive = oneDrive;
		}
		public String getZip7() {
			return zip7;
		}
		public void setZip7(String zip7) {
			this.zip7 = zip7;
		}
		public String getMozilla_Firefox() {
			return Mozilla_Firefox;
		}
		public void setMozilla_Firefox(String mozilla_Firefox) {
			Mozilla_Firefox = mozilla_Firefox;
		}
		public String getGoogle_Chrome() {
			return Google_Chrome;
		}
		public void setGoogle_Chrome(String google_Chrome) {
			Google_Chrome = google_Chrome;
		}
		public String getTeam_Viewer() {
			return Team_Viewer;
		}
		public void setTeam_Viewer(String team_Viewer) {
			Team_Viewer = team_Viewer;
		}
		public String getZoom() {
			return Zoom;
		}
		public void setZoom(String zoom) {
			Zoom = zoom;
		}
		public String getWebex() {
			return Webex;
		}
		public void setWebex(String webex) {
			Webex = webex;
		}
		public String getAutoCad() {
			return AutoCad;
		}
		public void setAutoCad(String autoCad) {
			AutoCad = autoCad;
		}
		public String getWinrar() {
			return Winrar;
		}
		public void setWinrar(String winrar) {
			Winrar = winrar;
		}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String Delete_status;
	public String getDelete_status() {
		return Delete_status;
	}
	public void setDelete_status(String delete_status) {
		Delete_status = delete_status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getScan_Date() {
		return Scan_Date;
	}
	public void setScan_Date(String scan_Date) {
		Scan_Date = scan_Date;
	}
	public String getSystem_Make() {
		return System_Make;
	}
	public void setSystem_Make(String system_Make) {
		System_Make = system_Make;
	}
	public String getSystem_form_Factor() {
		return System_form_Factor;
	}
	public void setSystem_form_Factor(String system_form_Factor) {
		System_form_Factor = system_form_Factor;
	}
	public String getSystem_Model() {
		return System_Model;
	}
	public void setSystem_Model(String system_Model) {
		System_Model = system_Model;
	}
	public String getSystem_Serial_Number() {
		return System_Serial_Number;
	}
	public void setSystem_Serial_Number(String system_Serial_Number) {
		System_Serial_Number = system_Serial_Number;
	}
	public String getProduct_Type() {
		return Product_Type;
	}
	public void setProduct_Type(String product_Type) {
		Product_Type = product_Type;
	}
	public String getSystem_IP_Address() {
		return System_IP_Address;
	}
	public void setSystem_IP_Address(String system_IP_Address) {
		System_IP_Address = system_IP_Address;
	}
	public String getSystem_Hostname() {
		return System_Hostname;
	}
	public void setSystem_Hostname(String system_Hostname) {
		System_Hostname = system_Hostname;
	}
	public String getSystem_OS_type() {
		return System_OS_type;
	}
	public void setSystem_OS_type(String system_OS_type) {
		System_OS_type = system_OS_type;
	}
	public String getOS_License_details() {
		return OS_License_details;
	}
	public void setOS_License_details(String oS_License_details) {
		OS_License_details = oS_License_details;
	}
	public String getOS_Version() {
		return OS_Version;
	}
	public void setOS_Version(String oS_Version) {
		OS_Version = oS_Version;
	}
	public String getOS_Key() {
		return OS_Key;
	}
	public void setOS_Key(String oS_Key) {
		OS_Key = oS_Key;
	}
	public String getTotal_RAM() {
		return Total_RAM;
	}
	public void setTotal_RAM(String total_RAM) {
		Total_RAM = total_RAM;
	}
	
	public String getRAM_Available() {
		return RAM_Available;
	}
	public void setRAM_Available(String rAM_Available) {
		RAM_Available = rAM_Available;
	}
	public String getRAM_Used() {
		return RAM_Used;
	}
	public void setRAM_Used(String rAM_Used) {
		RAM_Used = rAM_Used;
	}
	public String getHD_Make() {
		return HD_Make;
	}
	public void setHD_Make(String hD_Make) {
		HD_Make = hD_Make;
	}
	public String getHD_Model() {
		return HD_Model;
	}
	public void setHD_Model(String hD_Model) {
		HD_Model = hD_Model;
	}
	public String getHD_Serial_Number() {
		return HD_Serial_Number;
	}
	public void setHD_Serial_Number(String hD_Serial_Number) {
		HD_Serial_Number = hD_Serial_Number;
	}
	public String getHD_Capacity() {
		return HD_Capacity;
	}
	public void setHD_Capacity(String hD_Capacity) {
		HD_Capacity = hD_Capacity;
	}
	public String getProcessor_Details() {
		return Processor_Details;
	}
	public void setProcessor_Details(String processor_Details) {
		Processor_Details = processor_Details;
	}
	public String getMBD_Make() {
		return MBD_Make;
	}
	public void setMBD_Make(String mBD_Make) {
		MBD_Make = mBD_Make;
	}
	public String getMBD_Model() {
		return MBD_Model;
	}
	public void setMBD_Model(String mBD_Model) {
		MBD_Model = mBD_Model;
	}
	public String getMBD_Serial_Number() {
		return MBD_Serial_Number;
	}
	public void setMBD_Serial_Number(String mBD_Serial_Number) {
		MBD_Serial_Number = mBD_Serial_Number;
	}
	public String getType_of_Chipset() {
		return Type_of_Chipset;
	}
	public void setType_of_Chipset(String type_of_Chipset) {
		Type_of_Chipset = type_of_Chipset;
	}
	public String getMonitor_Screen_Make() {
		return Monitor_Screen_Make;
	}
	public void setMonitor_Screen_Make(String monitor_Screen_Make) {
		Monitor_Screen_Make = monitor_Screen_Make;
	}
	public String getMonitor_Model() {
		return Monitor_Model;
	}
	public void setMonitor_Model(String monitor_Model) {
		Monitor_Model = monitor_Model;
	}
	public String getMonitor_Serial_Number() {
		return Monitor_Serial_Number;
	}
	public void setMonitor_Serial_Number(String monitor_Serial_Number) {
		Monitor_Serial_Number = monitor_Serial_Number;
	}
	public String getMonitor_Screen_Size() {
		return Monitor_Screen_Size;
	}
	public void setMonitor_Screen_Size(String monitor_Screen_Size) {
		Monitor_Screen_Size = monitor_Screen_Size;
	}
	public String getAssets_Status() {
		return Assets_Status;
	}
	public void setAssets_Status(String assets_Status) {
		Assets_Status = assets_Status;
	}
	public String getRetired_Date() {
		return Retired_Date;
	}
	public void setRetired_Date(String retired_Date) {
		Retired_Date = retired_Date;
	}
	public String getSoftware_list_with_version_and_installed_Date() {
		return Software_list_with_version_and_installed_Date;
	}
	public void setSoftware_list_with_version_and_installed_Date(String software_list_with_version_and_installed_Date) {
		Software_list_with_version_and_installed_Date = software_list_with_version_and_installed_Date;
	}
	public String getProcured_Date() {
		return Procured_Date;
	}
	public void setProcured_Date(String procured_Date) {
		Procured_Date = procured_Date;
	}
	public String getProcument_ID() {
		return Procument_ID;
	}
	public void setProcument_ID(String procument_ID) {
		Procument_ID = procument_ID;
	}
	public String getWarranty_AMC() {
		return Warranty_AMC;
	}
	public void setWarranty_AMC(String warranty_AMC) {
		Warranty_AMC = warranty_AMC;
	}
	public String getWarranty_AMC_Vendor_Name() {
		return Warranty_AMC_Vendor_Name;
	}
	public void setWarranty_AMC_Vendor_Name(String warranty_AMC_Vendor_Name) {
		Warranty_AMC_Vendor_Name = warranty_AMC_Vendor_Name;
	}
	public String getWarrenty_AMC_From() {
		return Warrenty_AMC_From;
	}
	public void setWarrenty_AMC_From(String warrenty_AMC_From) {
		Warrenty_AMC_From = warrenty_AMC_From;
	}
	public String getWarrenty_AMC_To() {
		return Warrenty_AMC_To;
	}
	public void setWarrenty_AMC_To(String warrenty_AMC_To) {
		Warrenty_AMC_To = warrenty_AMC_To;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
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
	public String getSub_Department_Name() {
		return Sub_Department_Name;
	}
	public void setSub_Department_Name(String sub_Department_Name) {
		Sub_Department_Name = sub_Department_Name;
	}
	public String getAforesight_Agent_ID() {
		return Aforesight_Agent_ID;
	}
	public void setAforesight_Agent_ID(String aforesight_Agent_ID) {
		Aforesight_Agent_ID = aforesight_Agent_ID;
	}
	public Asset_master_payload() {

	  }

	 
	  

}
