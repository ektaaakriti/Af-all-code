package com.Aforesight.Api.controller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Tuple;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.Aforesight.Api.EncryptionDecryptionClass;
import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.Discovered_assets;
import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.M_dept;
import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.payload.Asset_master_payload;
import com.Aforesight.Api.repository.DepartmentRepo;
import com.Aforesight.Api.repository.Discovered_asset_repository;
import com.Aforesight.Api.repository.LocationRepo;
import com.Aforesight.Api.repository.Os_typeRepo;
import com.Aforesight.Api.repository.ProductRepo;
import com.Aforesight.Api.repository.asset_master_repository;
import com.Aforesight.Api.request.AssetAllocationRequest;
import com.Aforesight.Api.request.AssetRetireRequest;
import com.Aforesight.Api.request.DeleteAssetPayload;
import com.Aforesight.Api.request.Discovered_asset_Request;
import com.Aforesight.Api.request.GetAsset2UpdateRequest;
import com.Aforesight.Api.request.GetCity4mStateRequest;
import com.Aforesight.Api.response.AssetGroupingResponse;
import com.Aforesight.Api.response.AssetResponse;
import com.Aforesight.Api.response.CountResponse;
import com.Aforesight.Api.response.DepartmentResponse;
import com.Aforesight.Api.response.ListResponse;
import com.Aforesight.Api.response.LocationResponse;
import com.Aforesight.Api.response.ProductResponse;
import com.Aforesight.Api.response.SoftwareCountResponse;
import com.Aforesight.Api.response.UserResponse;
import com.Aforesight.Api.response.Vf_asset;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/auth")
public class AssetController {
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	 public static Logger log = LogManager.getLogger(AssetController.class.getName());
	@Autowired
	private Discovered_asset_repository disrepo;
	@Autowired
	private asset_master_repository astrepo;
	@Autowired
	private DepartmentRepo depaRepo;
	@Autowired
	private LocationRepo lctRepo;
	@Autowired
	private ProductRepo prrepo;
	@Autowired
	private Os_typeRepo osrepo;
	@Value ("${DiscoveredAsset}")String AssetDiscovereddisplayed;
	@Value("${ErrorDiscoveredAsset}") String ErrorDiscoveredAsset;
	@Value ("${AssetImport}")String AssetImport;
	@Value ("${AssetGrouping}")String AssetAllocation;
	@Value ("${AssetRetire}")String AssetRetire; 
	@Value ("${AssetDelocation}")String AssetDeallocation; 
	@Value ("${AssetGroupingDetails}") String AssetGroupingDetails;
	@Value ("${ComboBox}") String ComboBox;
	@Value("${ErrorAssetImport}") String ErrorAssetImport;
	@Value("${City4mState}") String City4mState;
	@Value("${ErrorCity4mState}") String ErrorCity4mState;
	@Value("${ErrorAssetGrouping}") String ErrorAssetGrouping;
	@Value("${DeleteAsset") String DeleteAsset;
	@Value("${ErrorDeleteAsset") String ErrorDeleteAsset;
	@PostMapping(value="/DiscoveredAssetSearch")
	 public ResponseEntity<AssetResponse> AssetBasedonUsername(@RequestBody Discovered_asset_Request DisaAstpayload)
	{List<com.Aforesight.Api.entity.Discovered_assets> details=null;
	List<com.Aforesight.Api.entity.Discovered_assets> enc_details=new ArrayList<>();
	try {
		if(enc.decryptnew(DisaAstpayload.getSearchType()).contains("username")) {
		 details=disrepo.assetBasedOnUsername(enc.decryptnew(DisaAstpayload.getSearchValue()));}
		else {
			 details=disrepo.assetBasedOnSystem_Ip(enc.decryptnew(DisaAstpayload.getSearchValue()));}
		
		// for(int i=0;i<details.size();i++) {
		 for(Discovered_assets dtls:details) {
		Discovered_assets ast=new Discovered_assets();	
		ast.setAdobe_Reader(enc.encryptnew(dtls.getAdobe_Reader()));
		ast.setAforesight_Agent_ID(enc.encryptnew(dtls.getAforesight_Agent_ID()));
		ast.setAnydesk(enc.encryptnew(dtls.getAnydesk()));
		ast.setAssets_Status(enc.encryptnew(dtls.getAssets_Status()));
		ast.setAutoCad(enc.encryptnew(dtls.getAutoCad()));
		ast.setDepartment_Name(enc.encryptnew(dtls.getDepartment_Name()));
		ast.setGoogle_Chrome(dtls.getGoogle_Chrome());
		ast.setHd_capacity(enc.encryptnew(dtls.getHd_capacity()));
		ast.setHd_make(enc.encryptnew(dtls.getHd_make()));
		ast.setHd_model(enc.encryptnew(dtls.getHd_model()));
		ast.setId((dtls.getId()));
		ast.setHd_serial_number(enc.encryptnew(dtls.getHd_serial_number()));
		ast.setJava8(enc.encryptnew(dtls.getJava8()));
		ast.setMBD_make(enc.encryptnew(dtls.getMBD_make()));
		ast.setMBD_model(enc.encryptnew(dtls.getMBD_model()));
		ast.setMBD_serial_no(enc.encryptnew(dtls.getMBD_serial_no()));
		ast.setMcafee_Antivirus(enc.encryptnew(dtls.getMcafee_Antivirus()));
		ast.setMicrosoft_Teams(enc.encryptnew(dtls.getMicrosoft_Teams()));
		ast.setMonitor_make(enc.encryptnew(dtls.getMonitor_make()));
		ast.setMonitor_model(enc.encryptnew(dtls.getMonitor_model()));
		ast.setMonitor_screen_size(enc.encryptnew(dtls.getMonitor_screen_size()));
		ast.setMonitor_serial_number(enc.encryptnew(dtls.getMonitor_serial_number()));
		ast.setMozilla_Firefox(enc.encryptnew(dtls.getMozilla_Firefox()));
		ast.setMS_Office_2007(enc.encryptnew(dtls.getMS_Office_2007()));
		ast.setMS_Office_2010(enc.encryptnew(dtls.getMS_Office_2010()));
		ast.setMS_Office_2013(enc.encryptnew(dtls.getMS_Office_2013()));
		ast.setMS_Office_2016(enc.encryptnew(dtls.getMS_Office_2016()));
		ast.setOneDrive(enc.encryptnew(dtls.getOneDrive()));
		ast.setOS_Key(enc.encryptnew(dtls.getOS_Key()));
		ast.setOS_License_details(enc.encryptnew(dtls.getOS_License_details()));
		ast.setOs_version(enc.encryptnew(dtls.getOs_version()));
		ast.setProccessor(enc.encryptnew(dtls.getProccessor()));
		ast.setProcument_ID(enc.encryptnew(enc.encryptnew(dtls.getProcument_ID())));
		ast.setProcured_Date(enc.encryptnew(dtls.getProcured_Date()));
		ast.setProduct_type(enc.encryptnew(dtls.getProduct_type()));
		ast.setRAM_Available(enc.encryptnew(dtls.getRAM_Available()));
		ast.setRAM_Used(enc.encryptnew(dtls.getRAM_Used()));
		ast.setRetired_Date(enc.encryptnew(dtls.getRetired_Date()));
		ast.setTotal_RAM(enc.encryptnew(dtls.getTotal_RAM()));
		ast.setScan_date(enc.encryptnew(dtls.getScan_date()));
		ast.setSite_Name(enc.encryptnew(dtls.getSite_Name()));
		ast.setSoftware_list_with_version_and_installed_Date(dtls.getSoftware_list_with_version_and_installed_Date());
		ast.setSub_Department_Name(enc.encryptnew(dtls.getSub_Department_Name()));
		ast.setSymantec_Antivirus(enc.encryptnew(dtls.getSymantec_Antivirus()));
		ast.setSystem_form_Factor(enc.encryptnew(dtls.getSystem_form_Factor()));
		ast.setSystem_Hostname(enc.encryptnew(dtls.getSystem_Hostname()));
		ast.setSystem_Ip(enc.encryptnew(dtls.getSystem_Ip()));
		ast.setSystem_make(enc.encryptnew(dtls.getSystem_make()));
		ast.setSystem_Model_no(enc.encryptnew(dtls.getSystem_Model_no()));
		ast.setSystem_Os_type(enc.encryptnew(dtls.getSystem_Os_type()));
		ast.setSystem_serial_no(enc.encryptnew(dtls.getSystem_serial_no()));
		ast.setTeam_Viewer(enc.encryptnew(dtls.getTeam_Viewer()));
		ast.setTrend_Micro_Antivirus(enc.encryptnew(dtls.getTrend_Micro_Antivirus()));
		ast.setType_of_Chipset(enc.encryptnew(dtls.getType_of_Chipset()));
		ast.setUser_ID(enc.encryptnew(dtls.getUser_ID()));
		ast.setUsername(enc.encryptnew(dtls.getUsername()));
		ast.setWarranty_AMC(enc.encryptnew(dtls.getWarranty_AMC()));
		ast.setWarranty_AMC_Vendor_Name(enc.encryptnew(dtls.getWarranty_AMC_Vendor_Name()));
		ast.setWarrenty_AMC_From(enc.encryptnew(dtls.getWarrenty_AMC_From()));
		ast.setWarrenty_AMC_To(enc.encryptnew(dtls.getWarrenty_AMC_To()));
		ast.setWebex(enc.encryptnew(dtls.getWebex()));
		ast.setWinrar(enc.encryptnew(dtls.getWinrar()));
		ast.setZoom(enc.encryptnew(dtls.getZoom()));
		ast.setZip7(enc.encryptnew(dtls.getZip7()));
		enc_details.add(ast);
		
		 }
	if(enc_details==null) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new AssetResponse(enc_details,enc.encryptnew("there are no details to be displayed"), enc.encryptnew("TRUE")));
	}
	else
		{return ResponseEntity.status(HttpStatus.OK)
					.body(new AssetResponse(enc_details,enc.encryptnew(AssetDiscovereddisplayed), enc.encryptnew("TRUE")));
	}}
	catch(Exception e) {
	  System.out.println("error in Discovered assets"+e);
	  log.info("error in "+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new AssetResponse(enc_details,enc.encryptnew(ErrorDiscoveredAsset), enc.encryptnew("FALSE")));
	} 
	}
/*	@PostMapping(value="/DiscoveredAssetBasedOnIP")
	 public ResponseEntity<AssetResponse> AssetBasedonIP(@RequestBody Discovered_asset_payload DisaAstpayload)
	{List<com.Aforesight.Api.entity.Discovered_assets> details=null;
	List<com.Aforesight.Api.entity.Discovered_assets> enc_details=new ArrayList<>();
	try {
		 details=disrepo.assetBasedOnSystem_Ip(enc.decryptnew(DisaAstpayload.getSystem_Ip()));
		// for(int i=0;i<details.size();i++) {
		 for(Discovered_assets dtls:details) {
		Discovered_assets ast=new Discovered_assets();	
		ast.setAdobe_Reader(enc.encryptnew(dtls.getAdobe_Reader()));
		ast.setAforesight_Agent_ID(enc.encryptnew(dtls.getAforesight_Agent_ID()));
		ast.setAnydesk(enc.encryptnew(dtls.getAnydesk()));
		ast.setAssets_Status(enc.encryptnew(dtls.getAssets_Status()));
		ast.setAutoCad(enc.encryptnew(dtls.getAutoCad()));
		ast.setDepartment_Name(enc.encryptnew(dtls.getDepartment_Name()));
		ast.setGoogle_Chrome(dtls.getGoogle_Chrome());
		ast.setHd_capacity(enc.encryptnew(dtls.getHd_capacity()));
		ast.setHd_make(enc.encryptnew(dtls.getHd_make()));
		ast.setHd_model(enc.encryptnew(dtls.getHd_model()));
		ast.setId((dtls.getId()));
		ast.setHd_serial_number(enc.encryptnew(dtls.getHd_serial_number()));
		ast.setJava8(enc.encryptnew(dtls.getJava8()));
		ast.setMBD_make(enc.encryptnew(dtls.getMBD_make()));
		ast.setMBD_model(enc.encryptnew(dtls.getMBD_model()));
		ast.setMBD_serial_no(enc.encryptnew(dtls.getMBD_serial_no()));
		ast.setMcafee_Antivirus(enc.encryptnew(dtls.getMcafee_Antivirus()));
		ast.setMicrosoft_Teams(enc.encryptnew(dtls.getMicrosoft_Teams()));
		ast.setMonitor_make(enc.encryptnew(dtls.getMonitor_make()));
		ast.setMonitor_model(enc.encryptnew(dtls.getMonitor_model()));
		ast.setMonitor_screen_size(enc.encryptnew(dtls.getMonitor_screen_size()));
		ast.setMonitor_serial_number(enc.encryptnew(dtls.getMonitor_serial_number()));
		ast.setMozilla_Firefox(enc.encryptnew(dtls.getMozilla_Firefox()));
		ast.setMS_Office_2007(enc.encryptnew(dtls.getMS_Office_2007()));
		ast.setMS_Office_2010(enc.encryptnew(dtls.getMS_Office_2010()));
		ast.setMS_Office_2013(enc.encryptnew(dtls.getMS_Office_2013()));
		ast.setMS_Office_2016(enc.encryptnew(dtls.getMS_Office_2016()));
		ast.setOneDrive(enc.encryptnew(dtls.getOneDrive()));
		ast.setOS_Key(enc.encryptnew(dtls.getOS_Key()));
		ast.setOS_License_details(enc.encryptnew(dtls.getOS_License_details()));
		ast.setOs_version(enc.encryptnew(dtls.getOs_version()));
		ast.setProccessor(enc.encryptnew(dtls.getProccessor()));
		ast.setProcument_ID(enc.encryptnew(enc.encryptnew(dtls.getProcument_ID())));
		ast.setProcured_Date(enc.encryptnew(dtls.getProcured_Date()));
		ast.setProduct_type(enc.encryptnew(dtls.getProduct_type()));
		ast.setRAM_Available(enc.encryptnew(dtls.getRAM_Available()));
		ast.setRAM_Used(enc.encryptnew(dtls.getRAM_Used()));
		ast.setRetired_Date(enc.encryptnew(dtls.getRetired_Date()));
		ast.setTotal_RAM(enc.encryptnew(dtls.getTotal_RAM()));
		ast.setScan_date(enc.encryptnew(dtls.getScan_date()));
		ast.setSite_Name(enc.encryptnew(dtls.getSite_Name()));
		ast.setSoftware_list_with_version_and_installed_Date(dtls.getSoftware_list_with_version_and_installed_Date());
		ast.setSub_Department_Name(enc.encryptnew(dtls.getSub_Department_Name()));
		ast.setSymantec_Antivirus(enc.encryptnew(dtls.getSymantec_Antivirus()));
		ast.setSystem_form_Factor(enc.encryptnew(dtls.getSystem_form_Factor()));
		ast.setSystem_Hostname(enc.encryptnew(dtls.getSystem_Hostname()));
		ast.setSystem_Ip(enc.encryptnew(dtls.getSystem_Ip()));
		ast.setSystem_make(enc.encryptnew(dtls.getSystem_make()));
		ast.setSystem_Model_no(enc.encryptnew(dtls.getSystem_Model_no()));
		ast.setSystem_Os_type(enc.encryptnew(dtls.getSystem_Os_type()));
		ast.setSystem_serial_no(enc.encryptnew(dtls.getSystem_serial_no()));
		ast.setTeam_Viewer(enc.encryptnew(dtls.getTeam_Viewer()));
		ast.setTrend_Micro_Antivirus(enc.encryptnew(dtls.getTrend_Micro_Antivirus()));
		ast.setType_of_Chipset(enc.encryptnew(dtls.getType_of_Chipset()));
		ast.setUser_ID(enc.encryptnew(dtls.getUser_ID()));
		ast.setUsername(enc.encryptnew(dtls.getUsername()));
		ast.setWarranty_AMC(enc.encryptnew(dtls.getWarranty_AMC()));
		ast.setWarranty_AMC_Vendor_Name(enc.encryptnew(dtls.getWarranty_AMC_Vendor_Name()));
		ast.setWarrenty_AMC_From(enc.encryptnew(dtls.getWarrenty_AMC_From()));
		ast.setWarrenty_AMC_To(enc.encryptnew(dtls.getWarrenty_AMC_To()));
		ast.setWebex(enc.encryptnew(dtls.getWebex()));
		ast.setWinrar(enc.encryptnew(dtls.getWinrar()));
		enc_details.add(ast);
		
		 }
	//return new ResponseEntity<>(details,HttpStatus.OK);
		 return ResponseEntity.status(HttpStatus.OK)
					.body(new AssetResponse(enc_details,enc.encryptnew(AssetDiscovereddisplayed), enc.encryptnew("TRUE")));
	}
	catch(Exception e) {
	  System.out.println("error in Discovered assets"+e);
	  log.info("error in "+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new AssetResponse(enc_details,enc.encryptnew("Error in Discovered assets"), enc.encryptnew("FALSE")));
	} }*/
	@PostMapping(value="/Full_asset_table")
	 public ResponseEntity<AssetResponse>full_asset_table()
{List<asset_master> details=null;
try {
	 details=astrepo.full_asset_table();
//return new ResponseEntity<>(details,HttpStatus.OK);
	 return ResponseEntity.status(HttpStatus.OK)
				.body(new AssetResponse(details,enc.encryptnew(AssetDiscovereddisplayed), enc.encryptnew("TRUE")));
}
catch(Exception e) {
  System.out.println("error in Discovered assets"+e);
  log.info("error"+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new AssetResponse(details,enc.encryptnew(ErrorDiscoveredAsset), enc.encryptnew("FALSE")));
} 
}
	@GetMapping(path = "/downloadDiscoveredAssetcsv")
	 public void getAllEmployeesInCsv(HttpServletResponse servletResponse)  {
	     try{servletResponse.setContentType("text/csv");
	     //Agent_msg_dtls msg=new Agent_msg_dtls();
	     servletResponse.addHeader("Content-Disposition","attachment; filename=\"report.csv\"");
	    List<Discovered_assets> lst= disrepo.allasset();
	    ICsvBeanWriter csvwriter=new CsvBeanWriter(servletResponse.getWriter(),CsvPreference.STANDARD_PREFERENCE);
	    String[] csvHeader = {"Scan_Date","System_Make","System_form_Factor","System_Model","System_Serial_Number","Product_Type",	"System_IP_Address","System_Hostname","System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","Processor_Details","MBD_Make","MBD_Model","MBD_Serial_Number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
	    //String[] csvHeader= { "adobe_reader", "aforesight_agent_id", "anydesk", "assets_status", "AutoCad", "department_name", "google_chrome", "java8", "mbd_make", "mbd_model", "mbd_serial_no", "ms_office_2007", "ms_office_2010", "ms_office_2013", "ms_office_2016", "mcafee_antivirus","microsoft_teams", "monitor_make", "monitor_model", "monitor_screen_size", "monitor_serial_number", "mozilla_firefox", "OneDrive", "proccessor", "procument_id", "procured_date", "ram_available", "ram_used", "retired_date", "site_name", "software_list_with_version_and_installed_date", "sub_department_name", "symantec_antivirus", "system_hostname", "system_ip", "system_model_no", "system_os_type", "system_serial_no", "team_viewer", "total_ram", "trend_micro_antivirus", "type_of_chipset", "user_id", "warranty_amc", "warranty_amc_vendor_name", "warrenty_amc_from", "warrenty_amc_to", "webex", "winrar", "zoom", "hd_capacity", "hd_make", "hd_model", "hd_serial_number", "os_version", "product_type", "scan_date", "system_make", "username", "zip7","os_key","os_license_details","type_of_chipset","system_form_factor"};
	    //String[] nameMapping= { "adobe_reader", "aforesight_agent_id", "anydesk", "assets_status", "AutoCad", "department_name", "google_chrome", "java8", "mbd_make", "mbd_model", "mbd_serial_no", "ms_office_2007", "ms_office_2010", "ms_office_2013", "ms_office_2016", "mcafee_antivirus","microsoft_teams", "monitor_make", "monitor_model", "monitor_screen_size", "monitor_serial_number", "mozilla_firefox", "OneDrive", "proccessor", "procument_id", "procured_date", "ram_available", "ram_used", "retired_date", "site_name", "software_list_with_version_and_installed_date", "sub_department_name", "symantec_antivirus", "system_hostname", "system_ip", "system_model_no", "system_os_type", "system_serial_no", "team_viewer", "total_ram", "trend_micro_antivirus", "type_of_chipset", "user_id", "warranty_amc", "warranty_amc_vendor_name", "warrenty_amc_from", "warrenty_amc_to", "webex", "winrar", "zoom", "hd_capacity", "hd_make", "hd_model", "hd_serial_number", "os_version", "product_type", "scan_date", "system_make", "username", "zip7","os_key","os_license_details","type_of_chipset","system_form_factor"};
	    String[] nameMapping = {"Scan_Date","System_Make","System_form_Factor","system_model_no","system_serial_no","Product_Type",	"system_ip","System_Hostname","System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","proccessor","MBD_Make","MBD_Model","mbd_serial_no","Type_of_Chipset","Monitor_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
	    csvwriter.writeHeader(csvHeader);
	 for (Discovered_assets msg:lst) {
		
		 
		 csvwriter.write(msg, nameMapping);
	 }
	 csvwriter.close();
	 
	 }
	 catch (Exception e) {
		 log.error(e);
	 }}
	@PostMapping("/uploadAssetCSV")
	public ResponseEntity<UserResponse> uploadData(@RequestParam("file") MultipartFile file) throws IOException {
		try{
			List<LicenseDetails> list1=new ArrayList<>();
		
		InputStream inputstream=file.getInputStream();
		System.out.println("inputstream size is"+inputstream.toString());
		writeToFile(inputstream);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new UserResponse(enc.encryptnew(AssetImport), enc.encryptnew("TRUE")));
	  
}
	 catch(Exception e) {
	  System.out.println("error in uploading asset details"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new UserResponse(enc.encryptnew(ErrorAssetImport), enc.encryptnew("FALSE")));
	 }
	}
	
	public void writeToFile(InputStream stream) {
		try {
			    File targetFile = new File("C://Agent//UploadFiles//AssetCSV.csv");

			    FileUtils.copyInputStreamToFile(stream, targetFile);	
		
	}
		catch (Exception e) {
			log.error(e);
		}
	}
	@GetMapping(path = "/downloadAssetReportcsv")
	 public void downloadasset(HttpServletResponse servletResponse)  {
	     try{servletResponse.setContentType("text/csv");
	     //Agent_msg_dtls msg=new Agent_msg_dtls();
	     System.out.println("in download asset");
	     servletResponse.addHeader("Content-Disposition","attachment; filename=\"report.csv\"");
	    List<asset_master> lst= astrepo.full_asset_table();
	    ICsvBeanWriter csvwriter=new CsvBeanWriter(servletResponse.getWriter(),CsvPreference.STANDARD_PREFERENCE);
	    String[] csvHeader = {"Scan_Date","System_Make","System_form_Factor","System_Model","System_Serial_Number","Product_Type",	"System_IP_Address","System_Hostname","System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","Processor_Details","MBD_Make","MBD_Model","MBD_Serial_Number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
	    //String[] csvHeader= { "adobe_reader", "aforesight_agent_id", "anydesk", "assets_status", "AutoCad", "department_name", "google_chrome", "java8", "mbd_make", "mbd_model", "mbd_serial_no", "ms_office_2007", "ms_office_2010", "ms_office_2013", "ms_office_2016", "mcafee_antivirus","microsoft_teams", "monitor_make", "monitor_model", "monitor_screen_size", "monitor_serial_number", "mozilla_firefox", "OneDrive", "proccessor", "procument_id", "procured_date", "ram_available", "ram_used", "retired_date", "site_name", "software_list_with_version_and_installed_date", "sub_department_name", "symantec_antivirus", "system_hostname", "system_ip", "system_model_no", "system_os_type", "system_serial_no", "team_viewer", "total_ram", "trend_micro_antivirus", "type_of_chipset", "user_id", "warranty_amc", "warranty_amc_vendor_name", "warrenty_amc_from", "warrenty_amc_to", "webex", "winrar", "zoom", "hd_capacity", "hd_make", "hd_model", "hd_serial_number", "os_version", "product_type", "scan_date", "system_make", "username", "zip7","os_key","os_license_details","type_of_chipset","system_form_factor"};
	    //String[] nameMapping= { "adobe_reader", "aforesight_agent_id", "anydesk", "assets_status", "AutoCad", "department_name", "google_chrome", "java8", "mbd_make", "mbd_model", "mbd_serial_no", "ms_office_2007", "ms_office_2010", "ms_office_2013", "ms_office_2016", "mcafee_antivirus","microsoft_teams", "monitor_make", "monitor_model", "monitor_screen_size", "monitor_serial_number", "mozilla_firefox", "OneDrive", "proccessor", "procument_id", "procured_date", "ram_available", "ram_used", "retired_date", "site_name", "software_list_with_version_and_installed_date", "sub_department_name", "symantec_antivirus", "system_hostname", "system_ip", "system_model_no", "system_os_type", "system_serial_no", "team_viewer", "total_ram", "trend_micro_antivirus", "type_of_chipset", "user_id", "warranty_amc", "warranty_amc_vendor_name", "warrenty_amc_from", "warrenty_amc_to", "webex", "winrar", "zoom", "hd_capacity", "hd_make", "hd_model", "hd_serial_number", "os_version", "product_type", "scan_date", "system_make", "username", "zip7","os_key","os_license_details","type_of_chipset","system_form_factor"};
	    String[] nameMapping = {"Scan_Date","System_Make","System_form_Factor","System_Model","system_serial_number","Product_Type",	"system_ip_address","System_Hostname","System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","processor_details","MBD_Make","MBD_Model","mbd_serial_number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
	    csvwriter.writeHeader(csvHeader);
	 for (asset_master msg:lst) {
		
		 
		 csvwriter.write(msg, nameMapping);
	 }
	 csvwriter.close();
	 
	 }
	 catch (Exception e) {
		 log.error(e);
	 }}
	@PostMapping(value="/assetGrouping")
	
 public ResponseEntity<AssetGroupingResponse> getAsset()
{List enc_Department=new ArrayList<>();
List enc_Location=new ArrayList<>();
List enc_asset_id=new ArrayList<>();
List Department= depaRepo.department(); 
HashMap<String,List> map=new HashMap<>();
try {
for (int i=0;i<Department.size();i++) {
	
	String dep=enc.encryptnew((String) Department.get(i)).toString();
	enc_Department.add(i,dep);
}
List Location=lctRepo.StateLocation();
for (int i=0;i<Location.size();i++) {
	
	String loc=enc.encryptnew((String) Location.get(i)).toString();
	enc_Location.add(i,loc);
}
List asset_id=astrepo.asset_id();
for (int i=0;i<asset_id.size();i++) {
	
	String asset=enc.encryptnew( asset_id.get(i).toString());
	System.out.println(asset);
	enc_asset_id.add(i,asset);
}
map.put("Department", enc_Department);
map.put("Location", enc_Location);
map.put("Asset_id", enc_asset_id);

return ResponseEntity.status(HttpStatus.OK)
		.body(new AssetGroupingResponse(enc.encryptnew(AssetGroupingDetails), enc.encryptnew("TRUE"),map));

}
catch(Exception e) {
  System.out.println("error in finding assets details"+e);
  log.info("error"+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new AssetGroupingResponse(enc.encryptnew("Error in finding asset grouping details"), enc.encryptnew("FALSE"),map));
}  
}
	@PostMapping(value="/assetSearchComboBox")
	
	 public ResponseEntity<AssetGroupingResponse> getComboBox()
	 { List enc_System_make=new ArrayList<>();
		List enc_Model_no=new ArrayList<>();
		List enc_Serial_no=new ArrayList<>();
		List enc_os=new ArrayList<>();
		List enc_Product=new ArrayList<>();
		HashMap<String,List>map=new HashMap();
		try {
		List System_make=astrepo.findSystem_Make();
		for (int i=0;i<System_make.size();i++) {
			
			String system=enc.encryptnew((String) System_make.get(i)).toString();
			enc_System_make.add(i,system);
		}
		List Model_no=astrepo.findSystem_Model();
for (int i=0;i<Model_no.size();i++) {
			
			String no=enc.encryptnew((String) Model_no.get(i)).toString();
			enc_Model_no.add(i,no);
		}
		List Serial_no=astrepo.findsystemserialnumber();
for (int i=0;i<Serial_no.size();i++) {
			
			String serialno=enc.encryptnew((String) Serial_no.get(i)).toString();
			enc_Serial_no.add(i,serialno);
		}
		List os=osrepo.os_type();
for (int i=0;i<os.size();i++) {
			
			String oss=enc.encryptnew((String) os.get(i)).toString();
			enc_os.add(i,oss);
		}
		List Product=prrepo.product_type();
for (int i=0;i<Product.size();i++) {
			
			String prdct=enc.encryptnew((String) Product.get(i)).toString();
			enc_Product.add(i,prdct);
		}
	
log.info("Asset search combo box");
	map.put("System_make", enc_System_make);
	map.put("Model_no",enc_Model_no);
	map.put("Serial_no", enc_Serial_no);
	map.put("Os_type", enc_os);
	map.put("product_type",enc_Product);
	return ResponseEntity.status(HttpStatus.OK)
			.body(new AssetGroupingResponse(enc.encryptnew(ComboBox), enc.encryptnew("TRUE"),map));

	}
	catch(Exception e) {
	  System.out.println("error in finding asset combo box details"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new AssetGroupingResponse(enc.encryptnew(ComboBox), enc.encryptnew("FALSE"),map));
	}  
	}
	@PostMapping(value="/getCityFromState")
	
	 public ResponseEntity<ListResponse> getCity(@RequestBody GetCity4mStateRequest payload)
	 {List enc_city=new ArrayList<>();
		try {
		List City=lctRepo.CityLocation(enc.decryptnew(payload.getState()));
for (int i=0;i<City.size();i++) {
			
			String city=enc.encryptnew((String) City.get(i)).toString();
			enc_city.add(i,city);
		}
	
return ResponseEntity.status(HttpStatus.OK)
		.body(new ListResponse(enc_city, enc.encryptnew("TRUE"),enc.encryptnew(City4mState)));

}
catch(Exception e) {
  System.out.println("error in finding city corresponding to state"+e);
  log.info("error"+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ListResponse(enc_city, enc.encryptnew("FALSE"),enc.encryptnew(ErrorCity4mState)));
  
}  	
	}
	@PostMapping(value="/RetireAsset",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> Retireasset(@RequestBody AssetRetireRequest assetRetirepayload){
		try {
		Date retiredate=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String RetiredDate = dateFormat.format(retiredate); 
	 astrepo.retirestatus(enc.decryptnew(assetRetirepayload.getAssets_Status()),RetiredDate,Long.parseLong(enc.decryptnew(assetRetirepayload.getAsset_id())));
	System.out.println(assetRetirepayload.getAssets_Status());
	System.out.println(RetiredDate);
	System.out.println(assetRetirepayload.getAsset_id());
	return ResponseEntity.status(HttpStatus.OK)
			.body(new UserResponse(enc.encryptnew(AssetRetire), enc.encryptnew("TRUE")));

	}
	catch(Exception e) {
	  System.out.println("error in changing asset status"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new UserResponse(enc.encryptnew(ErrorAssetGrouping), enc.encryptnew("FALSE")));
	}  
	}
/* @PostMapping(value="/findlocation",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findlocation(@RequestBody Asset_master_payload payload){
	
	 List details=astrepo.findlocation();
	
	 return new ResponseEntity<>(details,HttpStatus.OK);
	 
  @PostMapping(value="/findDepartment",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findDepartment(@RequestBody Asset_master_payload payload){
	
	 List details=astrepo.finddepartment();
	
	 return new ResponseEntity<>(details,HttpStatus.OK);
	 
 }*/
 
 @PostMapping(value="/allocateAsset",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse>allocateAsset(@RequestBody AssetAllocationRequest allocationPayload){
	try {
	 astrepo.allocateAsset(enc.decryptnew(allocationPayload.getAssets_Status()),enc.decryptnew(allocationPayload.getSite_Name()),enc.decryptnew(allocationPayload.getDepartment_Name()),Long.parseLong(enc.decryptnew((allocationPayload.getAsset_id()))));
	System.out.println(allocationPayload.getAssets_Status());
	
	System.out.println(allocationPayload.getAsset_id());
	return ResponseEntity.status(HttpStatus.OK)
			.body(new UserResponse(enc.encryptnew(AssetAllocation), enc.encryptnew("TRUE")));

	}
	catch(Exception e) {
	  System.out.println("error in changing asset allocation"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new UserResponse(enc.encryptnew(ErrorAssetGrouping+e), enc.encryptnew("FALSE")));
	}  
	 //return new ResponseEntity<>("asset allocation  done",HttpStatus.OK);
	 
 }
 @PostMapping(value="/deallocateAsset",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> deallocateAsset(@RequestBody AssetAllocationRequest deallocationPayload){
	try{
		String location="NA";
	String department="Store";
	 astrepo.deallocateAsset(enc.decryptnew(deallocationPayload.getAssets_Status()),Long.parseLong(enc.decryptnew((deallocationPayload.getAsset_id()))),department);
	System.out.println(deallocationPayload.getAssets_Status());
	
	System.out.println(deallocationPayload.getAsset_id());
	// return new ResponseEntity<>("asset deallocation  done",HttpStatus.OK);
	return ResponseEntity.status(HttpStatus.OK)
			.body(new UserResponse(enc.encryptnew(AssetDeallocation), enc.encryptnew("TRUE")));

	}
	catch(Exception e) {
	  System.out.println("error in changing asset status"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new UserResponse(enc.encryptnew(ErrorAssetGrouping+e), enc.encryptnew("FALSE")));
	}   
 }
/* @PostMapping(value="/Searchasset")
	
public ResponseEntity<?> SearchAsset(@RequestBody Asset_master_payload payload)
{


//List<asset_master> details1=  astimpl.findAsset1(payload.getSystem_Serial_Number(),payload.getSystem_Make(),payload.getSystem_Model(),payload.getProduct_Type(),payload.getSystem_OS_type());
List<asset_master> details=astrepo.findAsset(payload.getSystem_Serial_Number(),payload.getSystem_Make(),payload.getSystem_Model(),payload.getProduct_Type(),payload.getSystem_OS_type());
System.out.println("in asset search");
return new ResponseEntity<>(details,HttpStatus.OK);

}
/* @PostMapping(value="/Getasset")
	//consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 public ResponseEntity<?> getAsset(@RequestBody M_dept payload)
{
List<M_dept> details1=  repo4.getAsset();
return new ResponseEntity<>(details1,HttpStatus.OK);}	*/ 
 
 @PostMapping(value="/Deleteasset")
public ResponseEntity<?> DeleteAsset(@RequestBody DeleteAssetPayload deleteAssetPayload)
{
	 try {
String delete_status="YES";
System.out.println("in delete api");
astrepo.deleteAsset(delete_status,Long.parseLong((deleteAssetPayload.getAsset_id())));
return ResponseEntity.status(HttpStatus.OK)
		.body(new UserResponse(enc.encryptnew(DeleteAsset), enc.encryptnew("TRUE")));

}
catch(Exception e) {
  System.out.println("error in deleting asset status"+e);
  log.info("error"+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new UserResponse(enc.encryptnew(ErrorDeleteAsset), enc.encryptnew("FALSE")));
}   
//System.out.println(payload.getSystem_Serial_Number());
//return new ResponseEntity<>("deletion done",HttpStatus.OK);	}
	 
}
 @PostMapping(value="/GetAssetToUpdate")

public ResponseEntity<AssetResponse>GetAssettoupdate(@RequestBody GetAsset2UpdateRequest GetAsset2Updatepayload)
{List<asset_master> details=null;
List<asset_master> enc_details=new ArrayList<>();
	 try {

System.out.println("inselect update api");
System.out.println(GetAsset2Updatepayload.getAsset_id());
System.out.println((enc.decryptnew(GetAsset2Updatepayload.getAsset_id())));
System.out.println("Asset id is"+Long.parseLong(enc.decryptnew(GetAsset2Updatepayload.getAsset_id())));
 details=astrepo.assetToUpdate(Long.parseLong(enc.decryptnew(GetAsset2Updatepayload.getAsset_id())));
System.out.println(details.get(0).getDepartment_Name());
for(asset_master dtls:details) {
	asset_master ast=new asset_master();	
	ast.setAdobe_Reader(enc.encryptnew(dtls.getAdobe_Reader()));
	ast.setAforesight_Agent_ID(enc.encryptnew(dtls.getAforesight_Agent_ID()));
	ast.setAnydesk(enc.encryptnew(dtls.getAnydesk()));
	ast.setAssets_Status(enc.encryptnew(dtls.getAssets_Status()));
	ast.setAutoCad(enc.encryptnew(dtls.getAutoCad()));
	ast.setDepartment_Name(enc.encryptnew(dtls.getDepartment_Name()));
	ast.setGoogle_Chrome(dtls.getGoogle_Chrome());
	ast.setHD_Capacity(enc.encryptnew(dtls.getHD_Capacity()));
	ast.setHD_Make(enc.encryptnew(dtls.getHD_Make()));
	ast.setHD_Model(enc.encryptnew(dtls.getHD_Model()));
	ast.setAsset_id(((dtls.getAsset_id())));
	ast.setHD_Serial_Number(enc.encryptnew(dtls.getHD_Serial_Number()));
	ast.setJava8(enc.encryptnew(dtls.getJava8()));
	ast.setMBD_Make(enc.encryptnew(dtls.getMBD_Make()));
	ast.setMBD_Model(enc.encryptnew(dtls.getMBD_Model()));
	ast.setMBD_Serial_Number(enc.encryptnew(dtls.getMBD_Serial_Number()));
	ast.setMcafee_Antivirus(enc.encryptnew(dtls.getMcafee_Antivirus()));
	ast.setMicrosoft_Teams(enc.encryptnew(dtls.getMicrosoft_Teams()));
	ast.setMonitor_Screen_Make(enc.encryptnew(dtls.getMonitor_Screen_Make()));
	ast.setMonitor_Model(enc.encryptnew(dtls.getMonitor_Model()));
	ast.setMonitor_Screen_Size(enc.encryptnew(dtls.getMonitor_Screen_Size()));
	ast.setMonitor_Serial_Number(enc.encryptnew(dtls.getSystem_Serial_Number()));
	ast.setMozilla_Firefox(enc.encryptnew(dtls.getMozilla_Firefox()));
	ast.setMS_Office_2007(enc.encryptnew(dtls.getMS_Office_2007()));
	ast.setMS_Office_2010(enc.encryptnew(dtls.getMS_Office_2010()));
	ast.setMS_Office_2013(enc.encryptnew(dtls.getMS_Office_2013()));
	ast.setMS_Office_2016(enc.encryptnew(dtls.getMS_Office_2016()));
	ast.setOneDrive(enc.encryptnew(dtls.getOneDrive()));
	ast.setOS_Key(enc.encryptnew(dtls.getOS_Key()));
	ast.setOS_License_details(enc.encryptnew(dtls.getOS_License_details()));
	ast.setOS_Version(enc.encryptnew(dtls.getOS_Version()));
	ast.setProcessor_Details(enc.encryptnew(dtls.getProcessor_Details()));
	ast.setProcument_ID(enc.encryptnew(enc.encryptnew(dtls.getProcument_ID())));
	ast.setProcured_Date(enc.encryptnew(dtls.getProcured_Date()));
	ast.setProduct_Type(enc.encryptnew(dtls.getProduct_Type()));
	ast.setRAM_Available(enc.encryptnew(dtls.getRAM_Available()));
	ast.setRAM_Used(enc.encryptnew(dtls.getRAM_Used()));
	ast.setRetired_Date(enc.encryptnew(dtls.getRetired_Date()));
	ast.setTotal_RAM(enc.encryptnew(dtls.getTotal_RAM()));
	ast.setScan_Date(enc.encryptnew(dtls.getScan_Date()));
	ast.setSite_Name(enc.encryptnew(dtls.getSite_Name()));
	ast.setSoftware_list_with_version_and_installed_Date(dtls.getSoftware_list_with_version_and_installed_Date());
	ast.setSub_Department_Name(enc.encryptnew(dtls.getSub_Department_Name()));
	ast.setSymantec_Antivirus(enc.encryptnew(dtls.getSymantec_Antivirus()));
	ast.setSystem_form_Factor(enc.encryptnew(dtls.getSystem_form_Factor()));
	ast.setSystem_Hostname(enc.encryptnew(dtls.getSystem_Hostname()));
	ast.setSystem_IP_Address(enc.encryptnew(dtls.getSystem_IP_Address()));
	ast.setSystem_Make(enc.encryptnew(dtls.getSystem_Make()));
	ast.setSystem_Model(enc.encryptnew(dtls.getSystem_Model()));
	ast.setSystem_OS_type(enc.encryptnew(dtls.getSystem_OS_type()));
	ast.setSystem_Serial_Number(enc.encryptnew(dtls.getSystem_Serial_Number()));
	ast.setTeam_Viewer(enc.encryptnew(dtls.getTeam_Viewer()));
	ast.setTrend_Micro_Antivirus(enc.encryptnew(dtls.getTrend_Micro_Antivirus()));
	ast.setType_of_Chipset(enc.encryptnew(dtls.getType_of_Chipset()));
	//ast.setUser_ID(enc.encryptnew(dtls.getUsername()));
	ast.setUsername(enc.encryptnew(dtls.getUsername()));
	ast.setWarranty_AMC(enc.encryptnew(dtls.getWarranty_AMC()));
	ast.setWarranty_AMC_Vendor_Name(enc.encryptnew(dtls.getWarranty_AMC_Vendor_Name()));
	ast.setWarrenty_AMC_From(enc.encryptnew(dtls.getWarrenty_AMC_From()));
	ast.setWarrenty_AMC_To(enc.encryptnew(dtls.getWarrenty_AMC_To()));
	ast.setWebex(enc.encryptnew(dtls.getWebex()));
	ast.setWinrar(enc.encryptnew(dtls.getWinrar()));
	ast.setZoom(enc.encryptnew(dtls.getZoom()));
	ast.setZip7(enc.encryptnew(dtls.getZip7()));
	enc_details.add(ast);
	
	 }
//return new ResponseEntity<>(details,HttpStatus.OK);
	 return ResponseEntity.status(HttpStatus.OK)
				.body(new AssetResponse(enc_details,enc.encryptnew(AssetDiscovereddisplayed), enc.encryptnew("TRUE")));
}
catch(Exception e) {
  System.out.println("error in Discovered assets"+e);
  log.info("error in "+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new AssetResponse(enc_details,enc.encryptnew("Error in Discovered assets"), enc.encryptnew("FALSE")));
} }

//return new ResponseEntity<>(details,HttpStatus.OK);	  


@PostMapping(value="/UpdateAsset")

public ResponseEntity<?>updateAsset(@RequestBody Asset_master_payload payload)
{
try {
System.out.println("in update api");
//Scan_Date=?1, a.System_Make=?2, a.System_form_Factor=?3, a.System_Model=?4,a.Product_Type=?5,a.System_IP_Address=?6, a.System_Hostname=?7,a.System_OS_type=?8,a.OS_License_details=?9,a.OS_Version=?10, a.OS_Key=?11,a.Total_RAM=?12, a.RAM_Slots_Available=?13,a.RAM_Slots_Used=?14, a.HD_Make=?15,a.HD_Model=?16,a.HD_Serial_Number=?17,a.HD_Capacity=?18,a.Processor_Details=?19,a.MBD_Make=?20,a.MBD_Model=?21,a.MBD_Serial_Number=?22, a.Type_of_Chipset=?23, a.Monitor_Screen_Make=?24,a.Monitor_Model=?25, a.Monitor_Serial_Number=?26,a.Monitor_Screen_Size=?27,a.Assets_Status=?28,"
//+ "a.Retired_Date=?29,a.Software_list_with_version_and_installed_Date=?30, a.Procured_Date=?31, a.Procument_ID=?32, a.Warranty_AMC=?33, a.Warranty_AMC_Vendor_Name=?34, a.Warrenty_AMC_From=?35,  a.Warrenty_AMC_To=?36,a.User_ID=?37,a.Department_Name=?38, a.Site_Name=?39,a.Sub_Department_Name=?40, a.Aforesight_Agent_ID=?41,a.System_Serial_Number=?42 where a.asset_id=?43")
/*astrepo.updateAsset(enc.decryptnew(payload.getScan_Date()),enc.decryptnew(payload.getSystem_Make()),enc.decryptnew(payload.getSystem_Model()),
		enc.decryptnew(payload.getProduct_Type()),enc.decryptnew(payload.getSystem_IP_Address()),enc.decryptnew(payload.getSystem_Hostname()),enc.decryptnew(payload.getSystem_OS_type()),enc.decryptnew(payload.getOS_Version()),enc.decryptnew(payload.getTotal_RAM()),enc.decryptnew(payload.getRAM_Available()),
		enc.decryptnew(payload.getRAM_Used()),enc.decryptnew(payload.getHD_Make()),
		enc.decryptnew(payload.getHD_Model()),enc.decryptnew(payload.getHD_Serial_Number()),
		enc.decryptnew(payload.getHD_Capacity()),enc.decryptnew(payload.getProcessor_Details()),enc.decryptnew(payload.getMBD_Make()),
		enc.decryptnew(payload.getMBD_Model()),enc.decryptnew(payload.getMBD_Serial_Number()),enc.decryptnew(payload.getType_of_Chipset()),enc.decryptnew(payload.getMonitor_Screen_Make()),enc.decryptnew(payload.getMonitor_Model()),
		enc.decryptnew(payload.getMonitor_Serial_Number()),enc.decryptnew(payload.getMonitor_Screen_Size()),enc.decryptnew(payload.getAssets_Status()),enc.decryptnew(payload.getRetired_Date()),enc.decryptnew(payload.getSoftware_list_with_version_and_installed_Date()),enc.decryptnew(payload.getProcured_Date()),enc.decryptnew(payload.getProcument_ID()),enc.decryptnew(payload.getWarranty_AMC()),enc.decryptnew(payload.getWarranty_AMC_Vendor_Name()),
		enc.decryptnew(payload.getWarrenty_AMC_From()),enc.decryptnew(payload.getWarrenty_AMC_To()),enc.decryptnew(payload.getUser_ID()),enc.decryptnew(payload.getDepartment_Name()),enc.decryptnew(payload.getSite_Name()),enc.decryptnew(payload.getSub_Department_Name()),
		enc.decryptnew(payload.getAforesight_Agent_ID()),enc.decryptnew(payload.getSystem_Serial_Number()),enc.decryptnew(payload.getMS_Office_2010()),enc.decryptnew(payload.getMS_Office_2013()),enc.decryptnew(payload.getMS_Office_2016()),enc.decryptnew(payload.getAdobe_Reader()),enc.decryptnew(payload.getJava8()),enc.decryptnew(payload.getSymantec_Antivirus()),enc.decryptnew(payload.getMcafee_Antivirus()),enc.decryptnew(payload.getTrend_Micro_Antivirus()),enc.decryptnew(payload.getMicrosoft_Teams()),enc.decryptnew(payload.getMS_Office_2007()),
		enc.decryptnew(payload.getAnydesk()),enc.decryptnew(payload.getOneDrive()),enc.decryptnew(payload.getZip7()),enc.decryptnew(payload.getMozilla_Firefox()),enc.decryptnew(payload.getGoogle_Chrome()),enc.decryptnew(payload.getTeam_Viewer()),enc.decryptnew(payload.getZoom()),enc.decryptnew(payload.getWebex()),enc.decryptnew(payload.getAutoCad()),enc.decryptnew(payload.getWinrar()),Long.parseLong((payload.getAsset_id())));*/
System.out.println(enc.decryptnew(payload.getProcument_ID()));
System.out.println(enc.decryptnew(payload.getRAM_Available()));
System.out.println(enc.decryptnew(payload.getRAM_Used()));
System.out.println(enc.decryptnew(payload.getTotal_RAM()));
System.out.println(enc.decryptnew(payload.getSystem_Serial_Number()));
System.out.println(Long.parseLong((payload.getAsset_id())));
System.out.println(enc.decryptnew(payload.getAssets_Status()));
System.out.println(enc.decryptnew(payload.getType_of_Chipset()));
System.out.println(enc.decryptnew(payload.getHD_Model()));
System.out.println(enc.decryptnew(payload.getHD_Serial_Number()));
System.out.println(enc.decryptnew(payload.getMBD_Model()));
System.out.println(enc.decryptnew(payload.getMonitor_Serial_Number()));
System.out.println(enc.decryptnew(payload.getMonitor_Screen_Size()));
System.out.println("Username is"+enc.decryptnew(payload.getUsername()));
astrepo.updateAsset(enc.decryptnew(payload.getScan_Date()),enc.decryptnew(payload.getSystem_Make()),enc.decryptnew(payload.getSystem_Model()),
		enc.decryptnew(payload.getProduct_Type()),enc.decryptnew(payload.getSystem_IP_Address()),enc.decryptnew(payload.getSystem_Hostname()),enc.decryptnew(payload.getSystem_OS_type()),enc.decryptnew(payload.getOS_Version()),enc.decryptnew(payload.getTotal_RAM()),enc.decryptnew(payload.getRAM_Available()),
		enc.decryptnew(payload.getRAM_Used()),enc.decryptnew(payload.getHD_Make()),
		enc.decryptnew(payload.getHD_Model()),enc.decryptnew(payload.getHD_Serial_Number()),
		enc.decryptnew(payload.getHD_Capacity()),enc.decryptnew(payload.getProcessor_Details()),enc.decryptnew(payload.getMBD_Make()),
		enc.decryptnew(payload.getMBD_Model()),enc.decryptnew(payload.getMBD_Serial_Number()),enc.decryptnew(payload.getType_of_Chipset()),enc.decryptnew(payload.getMonitor_Screen_Make()),enc.decryptnew(payload.getMonitor_Model()),
		enc.decryptnew(payload.getMonitor_Serial_Number()),enc.decryptnew(payload.getMonitor_Screen_Size()),enc.decryptnew(payload.getAssets_Status()),enc.decryptnew(payload.getRetired_Date()),enc.decryptnew(payload.getSoftware_list_with_version_and_installed_Date()),enc.decryptnew(payload.getProcured_Date()),
		enc.decryptnew(payload.getProcument_ID()),enc.decryptnew(payload.getWarranty_AMC()),enc.decryptnew(payload.getWarranty_AMC_Vendor_Name()),
		enc.decryptnew(payload.getWarrenty_AMC_From()),enc.decryptnew(payload.getWarrenty_AMC_To()),enc.decryptnew(payload.getUsername()),enc.decryptnew(payload.getDepartment_Name()),enc.decryptnew(payload.getSite_Name()),enc.decryptnew(payload.getSub_Department_Name()),
		enc.decryptnew(payload.getAforesight_Agent_ID()),enc.decryptnew(payload.getSystem_Serial_Number()),Long.parseLong((payload.getAsset_id())));
//String Scan_Date, String System_Make,String System_form_Factor,String System_Model, String Product_Type, String System_IP_Address, String System_Hostname, String System_OS_type, String OS_License_details, String OS_Version, String OS_Key, String Total_RAM,String RAM_Slots_Available, String RAM_Slots_Used, String HD_Make, String HD_Model, String HD_Serial_Number, String HD_Capacity, String Processor_Details, String MBD_Make, String MBD_Model, String MBD_Serial_Number, String Type_of_Chipset, String Monitor_Screen_Make,String Monitor_Model, String Monitor_Serial_Number, String Monitor_Screen_Size, String Assets_Status, String Retired_Date,String Software_list_with_version_and_installed_Date, String Procured_Date, String Procument_ID, String Warranty_AMC, String Warranty_AMC_Vendor_Name, String Warrenty_AMC_From, String Warrenty_AMC_To, String User_ID, String Department_Name, String Site_Name, String Sub_Department_Name,String Aforesight_Agent_ID, String System_Serial_Number, long asset_id);
System.out.println(enc.decryptnew(payload.getSystem_Serial_Number()));
return ResponseEntity.status(HttpStatus.OK)
		.body(new UserResponse(enc.encryptnew("Asset updation is done"), enc.encryptnew("TRUE")));

}
catch(Exception e) {
  System.out.println("error in updating asset status"+e);
  log.info("error"+e);

  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new UserResponse(enc.encryptnew("Error in updating asset "), enc.encryptnew("FALSE")));
}   

}
/*@PostMapping(value="/find_system_serial_number")

public ResponseEntity<?>findsystemserialnumber(@RequestBody Asset_master_payload payload)
{

List details=astrepo.findsystemserialnumber();
return new ResponseEntity<>(details,HttpStatus.OK);	

}
@PostMapping(value="/find_System_Make")

public ResponseEntity<?>findSystem_Make(@RequestBody Asset_master_payload payload)
{

List details=astrepo.findSystem_Make();
return new ResponseEntity<>(details,HttpStatus.OK);	

}@PostMapping(value="/find_System_OS_type")

public ResponseEntity<?>findSystem_OS_type(@RequestBody Asset_master_payload payload)
{

List details=astrepo.findSystem_OS_type();
return new ResponseEntity<>(details,HttpStatus.OK);	

}@PostMapping(value="/find_Product_Type")

public ResponseEntity<?>findProduct_Type(@RequestBody Asset_master_payload payload)
{

List details=astrepo.findProduct_Type();
return new ResponseEntity<>(details,HttpStatus.OK);	

}@PostMapping(value="/find_System_Model")

public ResponseEntity<?>findSystem_Model(@RequestBody Asset_master_payload payload)
{

List details=astrepo.findSystem_Model();
return new ResponseEntity<>(details,HttpStatus.OK);	

}





*/	
@GetMapping(value="/downloadAssetReportPDF")

	public void downloadAssetReportPDF(HttpServletResponse response)  {
try{
	response.setContentType("application/pdf");
	DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	String currentDateTime = dateFormat.format(new Date());
	String headerkey = "Content-Disposition";
	String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
	response.setHeader(headerkey, headervalue);

		// Creating the Object of Document
		Document document = new Document(PageSize.A5);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Asset Report", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(62);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 10, 10, 10,10,10,10,10,3,3,3,3, 3, 10,10,10,10,10,3,3,3,3, 3, 10,10,10,10,10,3,3,3,3, 3, 10,10,10,10,10,3,3,3,3, 3, 10,10,10,10,10,3,3,3,3, 3, 10,10,10,10,10,10,10,10,10,10 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		//,"MBD_Serial_Number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC",
		cell.setPhrase(new Phrase("Scan_Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_form_Factor", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_Model", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_Serial_Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Product_Type", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_IP_Address", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_Hostname", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("System_OS_type", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("OS_License_details", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("OS_Version", font));
		table.addCell(cell);
		// "OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","Processor_Details","","MBD_Model"
		cell.setPhrase(new Phrase("OS_Key", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Total_RAM", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("RAM_Available", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("RAM_Used", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("HD_Make", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("HD_Model", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("HD_Serial_Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("HD_Capacity", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Processor_Details", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MBD_Make", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MBD_Model", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MBD_Serial_Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Type_of_Chipset", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Monitor_Screen_Make", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Monitor_Model", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Monitor_Serial_Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Monitor_Screen_Size", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Assets_Status", font));
		table.addCell(cell);
		//"","","","","","","","","","","","","
		cell.setPhrase(new Phrase("Retired_Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Procured_Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Software_list_with_version_and_installed_Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Procument_ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Warranty_AMC", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Warranty_AMC_Vendor_Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Warrenty_AMC_From", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Warrenty_AMC_To", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("username", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Department_Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Site_Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Sub_Department_Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Aforesight_Agent_ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MS_Office_2010", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MS_Office_2013", font));
		table.addCell(cell);
		//"","","","","","","","","", "", "","", "", "", "", "", "", "", "", "","","", "","Team_Viewer","","Webex","","Winrar"
		cell.setPhrase(new Phrase("MS_Office_2016", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Adobe_Reader", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Java8", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Symantec_Antivirus", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Mcafee_Antivirus", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Trend_Micro_Antivirus", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Microsoft_Teams", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("MS_Office_2007", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Anydesk", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("OneDrive", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("zip7", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Mozilla_Firefox", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Google_Chrome", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Team_Viewer", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Zoom", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Webex", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("AutoCad", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Winrar", font));
		table.addCell(cell);
		
		
		List<asset_master> lst= astrepo.full_asset_table();
		// Iterating over the list of students
		for (asset_master asset : lst) {
			//"Scan_Date","System_Make","System_form_Factor","System_Model","System_Serial_Number","Product_Type",	"System_IP_Address","System_Hostname",
			//"System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity"
			//,"Processor_Details","MBD_Make","MBD_Model","MBD_Serial_Number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size",
			//"Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"
			table.addCell(String.valueOf(asset.getScan_Date()));
			// Adding student name
			table.addCell(asset.getSystem_Make());
			table.addCell(asset.getSystem_form_Factor());
			table.addCell(asset.getSystem_Model());
			table.addCell(asset.getSystem_Serial_Number());
			table.addCell(asset.getProduct_Type());
			table.addCell(asset.getSystem_IP_Address());
			table.addCell(asset.getSystem_Hostname());
			table.addCell(asset.getSystem_OS_type());
			table.addCell(asset.getOS_License_details());
			table.addCell(asset.getOS_Version());
			table.addCell(asset.getOS_Key());
			table.addCell(asset.getTotal_RAM());
			table.addCell(asset.getRAM_Available());
			table.addCell(asset.getRAM_Used());
			table.addCell(asset.getHD_Make());
			table.addCell(asset.getHD_Model());
			table.addCell(asset.getHD_Serial_Number());
			table.addCell(asset.getHD_Capacity());
			table.addCell(asset.getHD_Capacity());
			table.addCell(asset.getProcessor_Details());
			table.addCell(asset.getMBD_Make());
			table.addCell(asset.getMBD_Model());
			table.addCell(asset.getMBD_Serial_Number());
			table.addCell(asset.getType_of_Chipset());
			table.addCell(asset.getMonitor_Screen_Make());
			table.addCell(asset.getMonitor_Model());
			table.addCell(asset.getMonitor_Serial_Number());
			table.addCell(asset.getMonitor_Screen_Size());
			table.addCell(asset.getAssets_Status());
			table.addCell(asset.getRetired_Date());
			table.addCell(asset.getSoftware_list_with_version_and_installed_Date());
			table.addCell(asset.getProcured_Date());
			table.addCell(asset.getProcument_ID());
			table.addCell(asset.getWarranty_AMC());
			table.addCell(asset.getWarranty_AMC_Vendor_Name());
			table.addCell(asset.getWarrenty_AMC_From());
			table.addCell(asset.getWarrenty_AMC_To());
			table.addCell(asset.getUsername());
			table.addCell(asset.getDepartment_Name());
			table.addCell(asset.getSite_Name());
			table.addCell(asset.getSub_Department_Name());
			table.addCell(asset.getAforesight_Agent_ID());
			table.addCell(asset.getMS_Office_2010());
			table.addCell(asset.getMS_Office_2013());
			table.addCell(asset.getMS_Office_2016());
			//"Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name",
			//"Warrenty_AMC_From","Warrenty_AMC_To","username","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010",
			//"MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", 
			//"Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"
			table.addCell(asset.getAdobe_Reader());
			table.addCell(asset.getJava8());
			table.addCell(asset.getSymantec_Antivirus());
			table.addCell(asset.getMcafee_Antivirus());
			table.addCell(asset.getTrend_Micro_Antivirus());
			table.addCell(asset.getMicrosoft_Teams());
			table.addCell(asset.getMS_Office_2007());
			table.addCell(asset.getAnydesk());
			table.addCell(asset.getOneDrive());
			table.addCell(asset.getZip7());
			table.addCell(asset.getMozilla_Firefox());
			table.addCell(asset.getGoogle_Chrome());
			table.addCell(asset.getTeam_Viewer());
			table.addCell(asset.getZoom());
			table.addCell(asset.getWebex());
			table.addCell(asset.getAutoCad());
			table.addCell(asset.getWinrar());
			
			
		}
		// Adding the created table to document
		document.add(table);

		// Closing the document
		document.close();
		
		
		}
		catch(Exception e){
			log.error( e);
			}

	}
@PostMapping(value="/Searchasset")

public ResponseEntity<?> SearchAsset(@RequestBody Asset_master_payload payload)
{


//List<asset_master> details1=  astimpl.findAsset1(payload.getSystem_Serial_Number(),payload.getSystem_Make(),payload.getSystem_Model(),payload.getProduct_Type(),payload.getSystem_OS_type());
List<asset_master> details=astrepo.findAsset(payload.getSystem_Serial_Number(),payload.getSystem_Make(),payload.getSystem_Model(),payload.getProduct_Type(),payload.getSystem_OS_type());
System.out.println("in asset search");
return new ResponseEntity<>(details,HttpStatus.OK);

}
@PostMapping(value="/Discovered_assets")
//consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<AssetResponse> Discovered_assets()
{List<Discovered_assets> details=null;
List<Discovered_assets> enc_details=new ArrayList<>();

try {
	 details=disrepo.allasset();
	 for(Discovered_assets dtls:details) {
			Discovered_assets ast=new Discovered_assets();	
			ast.setAdobe_Reader(enc.encryptnew(dtls.getAdobe_Reader()));
			ast.setAforesight_Agent_ID(enc.encryptnew(dtls.getAforesight_Agent_ID()));
			ast.setAnydesk(enc.encryptnew(dtls.getAnydesk()));
			ast.setAssets_Status(enc.encryptnew(dtls.getAssets_Status()));
			ast.setAutoCad(enc.encryptnew(dtls.getAutoCad()));
			ast.setDepartment_Name(enc.encryptnew(dtls.getDepartment_Name()));
			ast.setGoogle_Chrome(dtls.getGoogle_Chrome());
			ast.setHd_capacity(enc.encryptnew(dtls.getHd_capacity()));
			ast.setHd_make(enc.encryptnew(dtls.getHd_make()));
			ast.setHd_model(enc.encryptnew(dtls.getHd_model()));
			ast.setId((dtls.getId()));
			ast.setHd_serial_number(enc.encryptnew(dtls.getHd_serial_number()));
			ast.setJava8(enc.encryptnew(dtls.getJava8()));
			ast.setMBD_make(enc.encryptnew(dtls.getMBD_make()));
			ast.setMBD_model(enc.encryptnew(dtls.getMBD_model()));
			ast.setMBD_serial_no(enc.encryptnew(dtls.getMBD_serial_no()));
			ast.setMcafee_Antivirus(enc.encryptnew(dtls.getMcafee_Antivirus()));
			ast.setMicrosoft_Teams(enc.encryptnew(dtls.getMicrosoft_Teams()));
			ast.setMonitor_make(enc.encryptnew(dtls.getMonitor_make()));
			ast.setMonitor_model(enc.encryptnew(dtls.getMonitor_model()));
			ast.setMonitor_screen_size(enc.encryptnew(dtls.getMonitor_screen_size()));
			ast.setMonitor_serial_number(enc.encryptnew(dtls.getMonitor_serial_number()));
			ast.setMozilla_Firefox(enc.encryptnew(dtls.getMozilla_Firefox()));
			ast.setMS_Office_2007(enc.encryptnew(dtls.getMS_Office_2007()));
			ast.setMS_Office_2010(enc.encryptnew(dtls.getMS_Office_2010()));
			ast.setMS_Office_2013(enc.encryptnew(dtls.getMS_Office_2013()));
			ast.setMS_Office_2016(enc.encryptnew(dtls.getMS_Office_2016()));
			ast.setOneDrive(enc.encryptnew(dtls.getOneDrive()));
			ast.setOS_Key(enc.encryptnew(dtls.getOS_Key()));
			ast.setOS_License_details(enc.encryptnew(dtls.getOS_License_details()));
			ast.setOs_version(enc.encryptnew(dtls.getOs_version()));
			ast.setProccessor(enc.encryptnew(dtls.getProccessor()));
			ast.setProcument_ID(enc.encryptnew(enc.encryptnew(dtls.getProcument_ID())));
			ast.setProcured_Date(enc.encryptnew(dtls.getProcured_Date()));
			ast.setProduct_type(enc.encryptnew(dtls.getProduct_type()));
			ast.setRAM_Available(enc.encryptnew(dtls.getRAM_Available()));
			ast.setRAM_Used(enc.encryptnew(dtls.getRAM_Used()));
			ast.setRetired_Date(enc.encryptnew(dtls.getRetired_Date()));
			ast.setTotal_RAM(enc.encryptnew(dtls.getTotal_RAM()));
			ast.setScan_date(enc.encryptnew(dtls.getScan_date()));
			ast.setSite_Name(enc.encryptnew(dtls.getSite_Name()));
			ast.setSoftware_list_with_version_and_installed_Date(dtls.getSoftware_list_with_version_and_installed_Date());
			ast.setSub_Department_Name(enc.encryptnew(dtls.getSub_Department_Name()));
			ast.setSymantec_Antivirus(enc.encryptnew(dtls.getSymantec_Antivirus()));
			ast.setSystem_form_Factor(enc.encryptnew(dtls.getSystem_form_Factor()));
			ast.setSystem_Hostname(enc.encryptnew(dtls.getSystem_Hostname()));
			ast.setSystem_Ip(enc.encryptnew(dtls.getSystem_Ip()));
			ast.setSystem_make(enc.encryptnew(dtls.getSystem_make()));
			ast.setSystem_Model_no(enc.encryptnew(dtls.getSystem_Model_no()));
			ast.setSystem_Os_type(enc.encryptnew(dtls.getSystem_Os_type()));
			ast.setSystem_serial_no(enc.encryptnew(dtls.getSystem_serial_no()));
			ast.setTeam_Viewer(enc.encryptnew(dtls.getTeam_Viewer()));
			ast.setTrend_Micro_Antivirus(enc.encryptnew(dtls.getTrend_Micro_Antivirus()));
			ast.setType_of_Chipset(enc.encryptnew(dtls.getType_of_Chipset()));
			ast.setUser_ID(enc.encryptnew(dtls.getUser_ID()));
			ast.setUsername(enc.encryptnew(dtls.getUsername()));
			ast.setWarranty_AMC(enc.encryptnew(dtls.getWarranty_AMC()));
			ast.setWarranty_AMC_Vendor_Name(enc.encryptnew(dtls.getWarranty_AMC_Vendor_Name()));
			ast.setWarrenty_AMC_From(enc.encryptnew(dtls.getWarrenty_AMC_From()));
			ast.setWarrenty_AMC_To(enc.encryptnew(dtls.getWarrenty_AMC_To()));
			ast.setWebex(enc.encryptnew(dtls.getWebex()));
			ast.setWinrar(enc.encryptnew(dtls.getWinrar()));
			ast.setZoom(enc.encryptnew(dtls.getZoom()));
			ast.setZip7(enc.encryptnew(dtls.getZip7()));
			enc_details.add(ast);
	 }
//return new ResponseEntity<>(details,HttpStatus.OK);	
	return ResponseEntity.status(HttpStatus.OK)
			.body(new AssetResponse(enc_details,enc.encryptnew("Discovered assets"), enc.encryptnew("TRUE")));

	}
	catch(Exception e) {
	  System.out.println("error in Discovered assets"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new AssetResponse(enc_details,enc.encryptnew("Error in Discovered assets"), enc.encryptnew("FALSE")));
	} 
}

	}
