package com.Aforesight.Api.entity;
import lombok.Data;

import javax.persistence.*;

import org.springframework.context.annotation.Role;

import com.Aforesight.Api.response.LocationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Entity
//@NamedNativeQuery(name="find_state_count",query="SELECT a.Site_Name as state, COUNT(*) as count FROM asset_master a GROUP BY a.Site_Name",resultSetMapping="LocationResponse")
//@SqlResultSetMapping(name="LocationResponse",classes=@ConstructorResult(targetClass=LocationResponse.class,columns = {
//        @ColumnResult(name = "state", type = String.class),
//        @ColumnResult(name = "count", type = Integer.class)}));
 
 
@Table(name = "asset_master")
        
public class asset_master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long asset_id;
    public long getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(long asset_id) {
		this.asset_id = asset_id;
	}
	private  String Scan_Date;
    private  String System_Make;	
  
    private  String System_Model;
    private String System_Serial_Number;
    private String Product_Type;
    private String System_IP_Address;
    private String System_Hostname;
    private String System_OS_type;
 
    private String OS_Version;

    private String Total_RAM;
    private String RAM_Available;
    private String RAM_Used;
    private String HD_Make;
    private String HD_Model;
    private String HD_Serial_Number;
    private String HD_Capacity;
    private String Processor_Details;
    private String MBD_Make;
    private String MBD_Model;
    private String MBD_Serial_Number;
    private String Type_of_Chipset;
    private String Monitor_Screen_Make;
    private String Monitor_Model;
    private String Monitor_Serial_Number;
    private String Monitor_Screen_Size;
    private String Assets_Status;
    private String Retired_Date;
    private String Software_list_with_version_and_installed_Date;
    private String Procured_Date;
    private String Procument_ID	;
    private String count;

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	private String Warranty_AMC;
    private String Warranty_AMC_Vendor_Name;
    private String Warrenty_AMC_From;
    private String Warrenty_AMC_To;
    private String username	;
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String Department_Name ;
    private String Site_Name;
    private String Sub_Department_Name;
    private String Aforesight_Agent_ID;
   
    public String getSystem_form_Factor() {
		return System_form_Factor;
	}
	public void setSystem_form_Factor(String system_form_Factor) {
		System_form_Factor = system_form_Factor;
	}
	public String getOS_Key() {
		return OS_Key;
	}
	public void setOS_Key(String oS_Key) {
		OS_Key = oS_Key;
	}
	public String getOS_License_details() {
		return OS_License_details;
	}
	public void setOS_License_details(String oS_License_details) {
		OS_License_details = oS_License_details;
	}
	public String getRAM_Used() {
		return RAM_Used;
	}
	private String System_form_Factor;
    private String OS_Key;
    private String OS_License_details;
    @Column(length = 3)
    private String  MS_Office_2010;
    @Column(length = 3)
	private String MS_Office_2013;
    @Column(length = 3)
	private String MS_Office_2016;
    @Column(length = 3)
	private String Adobe_Reader;
    @Column(length = 3)
	private String  Java8;
    @Column(length = 3)
	private String Symantec_Antivirus;
    @Column(length = 3)
	private String Mcafee_Antivirus;
    @Column(length = 3)
	private String  Trend_Micro_Antivirus;
    @Column(length = 3)
	private String Microsoft_Teams;
    @Column(length = 3)
	private String  MS_Office_2007;
    @Column(length = 3)
	private String Anydesk;
    @Column(length = 3)
	private String OneDrive;
    @Column(length = 3)
	private String zip7;
    @Column(length = 3)
	private String  Mozilla_Firefox;
    @Column(length = 3)
	private String  Google_Chrome;
    @Column(length = 3)
	private String  Team_Viewer;
    @Column(length = 3)
	private String Zoom;
    @Column(length = 3)
	private String Webex;
    @Column(length = 3)
	private String AutoCad;
    @Column(length = 3)
	private String Winrar;

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
	public String getRAM_Available() {
		return RAM_Available;
	}
	@Column(columnDefinition = "varchar(255) default 'NO'")
	private String Delete_status;
	public String getDelete_status() {
		return Delete_status;
	}
	public void setDelete_status(String delete_status) {
		Delete_status = delete_status;
	}
	
	public String getScan_Date() {
		return Scan_Date;
	}
	public void setScan_Date(String scan_Date) {
		Scan_Date = scan_Date;
	}
	public  String getSystem_Make() {
		return System_Make;
	}
	public void setSystem_Make(String system_Make) {
		System_Make = system_Make;
	}
	
	public  String getSystem_Model() {
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
	
	public String getOS_Version() {
		return OS_Version;
	}
	public void setOS_Version(String oS_Version) {
		OS_Version = oS_Version;
	}
	
	public String getTotal_RAM() {
		return Total_RAM;
	}
	public void setTotal_RAM(String total_RAM) {
		Total_RAM = total_RAM;
	}
	public String getRAM_Available(String string) {
		return RAM_Available;
	}
	public void setRAM_Available(String rAM_Available) {
		RAM_Available = rAM_Available;
	}
	public String getRAM_Slots_Used() {
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
    
	public void Asset_master(long asset_id,String Scan_Date, String System_Make,String System_Model, String System_Serial_Number, String Product_Type, String System_IP_Address, String System_Hostname, String System_OS_type, String OS_License_details, String OS_Version, String OS_Key, String Total_RAM,
			String RAM_Available, String RAM_Used, String HD_Make, String HD_Model, String HD_Serial_Number, String HD_Capacity, String Processor_Details, String MBD_Make, String MBD_Model, String MBD_Serial_Number, String Type_of_Chipset, String Monitor_Screen_Make,String Monitor_Model, String Monitor_Serial_Number, String Monitor_Screen_Size, String Assets_Status, String Retired_Date,String Software_list_with_version_and_installed_Date, String Procured_Date, String Procument_ID, String Warranty_AMC, String Warranty_AMC_Vendor_Name, String Warrenty_AMC_From, String Warrenty_AMC_To, String username, String Department_Name, String Site_Name, String Sub_Department_Name,String Aforesight_Agent_ID) {
			  this.asset_id=asset_id;
			  this.Scan_Date=Scan_Date;
			  this.System_Make=System_Make;
			  
			  this.System_Model= System_Model;
			  this.System_Serial_Number=System_Serial_Number;
			  this.Product_Type=Product_Type;
			  this.System_IP_Address=System_IP_Address;
			  
			this.System_Hostname=System_Hostname;
			this.System_OS_type=System_OS_type;
			
			this.OS_Version=OS_Version;
		
			this.Total_RAM=Total_RAM;
			this.RAM_Available=RAM_Available;
			this.RAM_Used=RAM_Used;
			this.HD_Make=HD_Make;
			this.HD_Model=HD_Model;
			this.HD_Serial_Number=HD_Serial_Number;
			this.HD_Capacity=HD_Capacity;
			this.Processor_Details=Processor_Details;
			this.MBD_Make=MBD_Make;
			this.MBD_Model=MBD_Model;
			this.MBD_Serial_Number=MBD_Serial_Number;
			this.Type_of_Chipset=Type_of_Chipset;
			this.Monitor_Screen_Make=Monitor_Screen_Make;
			this.Monitor_Model=Monitor_Model;
			this.Monitor_Serial_Number=Monitor_Serial_Number;
			this.Monitor_Screen_Size=Monitor_Screen_Size;
			this.Assets_Status=Assets_Status;
			this.Retired_Date=Retired_Date;
			this.Software_list_with_version_and_installed_Date=Software_list_with_version_and_installed_Date;
			this.Procured_Date=Procured_Date;
			this.Procument_ID=Procument_ID;
			this.Warranty_AMC=Warranty_AMC;
			this.Warranty_AMC_Vendor_Name=Warranty_AMC_Vendor_Name;
			this.Warrenty_AMC_From=Warrenty_AMC_From;
			this.Warrenty_AMC_To=Warrenty_AMC_To;
			this.username=username;
			this.Department_Name=Department_Name;
			this.Site_Name=Site_Name;
			this.Sub_Department_Name=Sub_Department_Name;
			this.Aforesight_Agent_ID=Aforesight_Agent_ID;
		  }
		/*  @Override
		  public String toString() {
		    return "Tutorial [asset_id=" + asset_id + ", Scan_Date=" + Scan_Date + ",System_Make =" + System_Make + ",System_Serial_Number =" + System_Serial_Number + ", Product_Type="+ Product_Type +",System_IP_Address=" + System_IP_Address +",System_Hostname="+ System_Hostname +" , System_OS_type="+ System_OS_type + " , OS_Version="+ OS_Version +"  ,Total_RAM="+ Total_RAM +" , RAM_Slots_Available="+ RAM_Slots_Available +" , RAM_Slots_Used="+ RAM_Slots_Used +" , HD_Make="+ HD_Make +" , HD_Model=" + HD_Model +" , HD_Serial_Number=" + HD_Serial_Number +" , HD_Capacity=" + HD_Capacity +" , Processor_Details=" +Processor_Details +" , MBD_Make="+ MBD_Make +" , MBD_Model=" + MBD_Model +" , MBD_Serial_Number=" + MBD_Serial_Number +" , Type_of_Chipset=" + Type_of_Chipset +" , Monitor_Screen_Make=" + Monitor_Screen_Make +" , Monitor_Model="+ Monitor_Model +" , Monitor_Serial_Number=" + Monitor_Serial_Number +" , Monitor_Screen_Size=" + Monitor_Screen_Size + ", Assets_Status=" + Assets_Status + " , Retired_Date=" + Retired_Date + " , Software_list_with_version_and_installed_Date=" + Software_list_with_version_and_installed_Date +", Procured_Date=" + Procured_Date +", Procument_ID=" +Procument_ID +", Warranty_AMC="+ Warranty_AMC +" , Warranty_AMC_Vendor_Name=" + Warranty_AMC_Vendor_Name +", Warrenty_AMC_From="+ Warrenty_AMC_From +" , Warrenty_AMC_To=" +Warrenty_AMC_To +" , User_ID="+ User_ID +", Department_Name="+ Department_Name +", Site_Name="+ Site_Name +", Sub_Department_Name="+ Sub_Department_Name +" , Aforesight_Agent_ID="+ Aforesight_Agent_ID +"]";
		  }
		  public String findByFilter(String System_Serial_Number,String System_Make, String System_Model, String Product_Type,String System_OS_type) {
			       List<asset_master> peticiones = new ArrayList<asset_master>();
			        String consulta = "select a from asset_master a ";
			        if(System_Serial_Number!=null || System_Make!=null || System_Model!=null ||Product_Type !=null ||System_OS_type !=null){
			            consulta=consulta+" where ";
			        }
			        if(System_Serial_Number!=null){
			            consulta = consulta+"a.System_Serial_Number=:System_Serial_Number";
			        }
			        if(System_Make!=null){
			            consulta = consulta+",a.System_Make=:System_Make,";
			        }
			        if(System_Model!=null){
			            consulta = consulta+",a.System_Model =:System_Model";
			        }
			        if(Product_Type!=null){
			            consulta = consulta+",a.Product_Type=:Product_Type,";
			        }
			        if(System_OS_type!=null){
			            consulta = consulta+",a.System_OS_type=:System_OS_type";
			        }

			       // peticiones = (List<asset_master>) em.createQuery(consulta).getResultList();
			       return consulta;
			    }
		 /* Query jpaQuery = entityManager.createNativeQuery(consulta.toString(), asset_master.class);

		  for(String key :paramaterMap.keySet()) {
		    jpaQuery.setParameter(key, paramaterMap.get(key));
		  }

		  List<asset_master> bookEntities = (List<asset_master>)jpaQuery.getResultList();*/
		  
		  public String findByFilter1(String System_Serial_Number,String System_Make, String System_Model, String Product_Type,String System_OS_type) {
		        List<asset_master> peticiones = new ArrayList<asset_master>();
		      
		      String consulta ="select a from asset_master a ";
		        if(System_Serial_Number!=null || System_Make!=null || System_Model!=null ||Product_Type !=null ||System_OS_type !=null){
		            consulta=consulta+" where ";
		        }
		        if(System_Serial_Number!=null){
		            consulta = consulta+"a.System_Serial_Number=:System_Serial_Number";
		        }
		        if(System_Make!=null){
		            consulta = consulta+",a.System_Make=:System_Make,";
		        }
		        if(System_Model!=null){
		            consulta = consulta+",a.System_Model =:System_Model";
		        }
		        if(Product_Type!=null){
		            consulta = consulta+",a.Product_Type=:Product_Type,";
		        }
		        if(System_OS_type!=null){
		            consulta = consulta+",a.System_OS_type=:System_OS_type";
		        }
				return consulta;}

		       // peticiones = (List<asset_master>) em.createQuery(consulta).getResultList();
		        //return consulta;
		    

}
