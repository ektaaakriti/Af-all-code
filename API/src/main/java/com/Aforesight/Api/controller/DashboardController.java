package com.Aforesight.Api.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Tuple;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aforesight.Api.EncryptionDecryptionClass;
//import com.Aforesight.Api.payload.Asset_master_payload;
import com.Aforesight.Api.repository.DepartmentRepo;
import com.Aforesight.Api.repository.Discovered_asset_repository;
import com.Aforesight.Api.repository.LocationRepo;
import com.Aforesight.Api.repository.Os_typeRepo;
import com.Aforesight.Api.repository.ProductRepo;
import com.Aforesight.Api.repository.asset_master_repository;
import com.Aforesight.Api.response.CountResponse;
import com.Aforesight.Api.response.DepartmentResponse;
import com.Aforesight.Api.response.LocationResponse;
import com.Aforesight.Api.response.ProductResponse;
import com.Aforesight.Api.response.SoftwareCountResponse;
import com.Aforesight.Api.response.StatusResponse;
import com.Aforesight.Api.response.SwCountResponse;
import com.Aforesight.Api.response.UserResponse;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/assetDashboard")
public class DashboardController {
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	public static Logger log = LogManager.getLogger(DashboardController.class.getName());
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
	@Value ("${AssetCount}")String Assetcount; 
	@Value ("${ErrorAssetCount}")String ErrorAssetcount; 
	@Value ("${SoftwareCount}")String SoftwareCount;
	@Value ("${ErrorSoftwareCount}")String ErrorSoftwareCount;
	@Value ("${ProductCount}") String prdct;
	@Value ("${ErrorProductCount}") String Errorprdct;
	@Value ("${StatusCount}") String stuscount;
	@Value ("${ErrorStatusCount}") String Errorstuscount;
	@Value ("${LocationCount}") String lctcount;
	@Value ("${ErrorLocationCount}") String Errorlctcount;
	@Value ("${DepartmentCount}") String deparcount;
	@Value ("${ErrorDepartmentCount}") String Errordeparcount;
	@PostMapping(value="/department_count")

	public ResponseEntity<CountResponse> department_count()
	{
		List<DepartmentResponse> depreslist = null;
		try {

	List<Tuple> details=astrepo.department_count();
	depreslist=details.stream().map(t->new DepartmentResponse(enc.encryptnew(t.get(0,String.class)),enc.encryptnew(t.get(1,Long.class).toString()))).collect(Collectors.toList());
		

	//return new ResponseEntity<>(e,HttpStatus.OK);
	return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse(enc.encryptnew(deparcount),depreslist,enc.encryptnew("True")));

	}
	catch(Exception e) {
	 System.out.println("error in finding department  details"+e);
	 log.info("error in finding department details"+e);

	 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew(Errordeparcount), depreslist,enc.encryptnew("FALSE")));
	}

	}
	@PostMapping(value="/location_count")

	public ResponseEntity<CountResponse> location_count()
	{
	List<LocationResponse> locreslist = null;
	try {
	//List<LocationResponse> sList1=new ArrayList<>();
	List<Tuple> sList=astrepo.Location_count();
	locreslist=sList.stream().map(t->new LocationResponse(enc.encryptnew(t.get(0,String.class)),enc.encryptnew(t.get(1,BigInteger.class).toString()))).collect(Collectors.toList());
	//List<LocationResponse> locreslist=sList.stream().map(t->new LocationResponse(enc.encryptnew(t.get(0,String.class)),t.get(1,BigInteger.class))).collect(Collectors.toList());
	System.out.println(sList.size());
	locreslist.stream().forEach((LocationResponse loc)->System.out.println(loc.getState()));

	return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse(enc.encryptnew(lctcount),locreslist,enc.encryptnew("True")));

	}
	catch(Exception e) {
	 System.out.println("error in finding Location  details"+e);
	 log.info("error in finding location details"+e);

	 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew(Errorlctcount), locreslist,enc.encryptnew("FALSE")));
	}
	}
	@PostMapping(value="/asset_count")

	 public ResponseEntity<CountResponse> asset_count()
{
		//List details=new ArrayList<>();
		//List astCount=new ArrayList<>();
		
try {
	  Long details=astrepo.asset_count();
	String astCount=enc.encryptnew(details.toString());
	String response="asset Count is "+astCount;
	System.out.println(response);
	 return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse((response),enc.encryptnew("True")));

	}
	catch(Exception e) {
	  System.out.println("error in finding asset count  details"+e);
	  log.info("error in finding asset count details"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew(ErrorAssetcount),enc.encryptnew("FALSE")));
	}}


	
	@PostMapping(value="/getProduct_type_Count")

	public ResponseEntity<CountResponse> getProduct_type(){
		List<ProductResponse> Productlist = null;
	try {
		
	List<Tuple> details=astrepo.product_type_count();
	//List<Tuple> sList=asset_master_repo.Location_count();
	Productlist=details.stream().map(t->new ProductResponse(enc.encryptnew(t.get(0,String.class)),enc.encryptnew(t.get(1,Long.class).toString()))).collect(Collectors.toList());
	 //Productlist=details.stream().map(t->new LocationResponse(enc.encryptnew(t.get(0,String.class)),t.get(1,Long.class).toString())).collect(Collectors.toList());
	return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse(enc.encryptnew(prdct),Productlist,enc.encryptnew("True")));

	}
	catch(Exception e) {
	  System.out.println("error in finding product  details"+e);
	  log.info("error in finding product details"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew(Errorprdct), Productlist,enc.encryptnew("FALSE")));
	}
		
	}
/*	@PostMapping(value="/getProduct_type_Count1")

	public ResponseEntity<CountResponse> getProduct_type_Count(){
		List<ProductResponse> Productlist = null;
	try {
		
	List<Tuple> details=astrepo.product_type_count();
	//List<Tuple> sList=asset_master_repo.Location_count();
	Productlist=details.stream().map(t->new ProductResponse(enc.encryptnew(t.get(0,String.class)),enc.encryptnew(t.get(1,Long.class).toString()))).collect(Collectors.toList());
	 //Productlist=details.stream().map(t->new LocationResponse(enc.encryptnew(t.get(0,String.class)),t.get(1,Long.class).toString())).collect(Collectors.toList());
	return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse(enc.encryptnew(prdct),Productlist,enc.encryptnew("True")));

	}
	catch(Exception e) {
	  System.out.println("error in finding product  details"+e);
	  log.info("error in finding product details"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew("Error in finding  Product count details"), Productlist,enc.encryptnew("FALSE")));
	}*/
		
	
	@PostMapping(value="/getsoftwareCount_dashboard",
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SwCountResponse> softwarecount_dashboard(){
		SoftwareCountResponse swCount=new SoftwareCountResponse();
		List<SwCountResponse> swlist=new ArrayList<>();
	try {
		
		
		String adobe=astrepo.adobe_count();
		swCount.setAdobe_Reader(enc.encryptnew(astrepo.adobe_count()));
		swCount.setAnydesk(enc.encryptnew(astrepo.AnydeskCount()));
		swCount.setAutoCad(enc.encryptnew(astrepo.Autocad_count()));
		swCount.setGoogle_Chrome(enc.encryptnew(astrepo.google_count()));
		swCount.setJava8(enc.encryptnew(astrepo.java_count()));
		swCount.setMcafee_Antivirus(enc.encryptnew(astrepo.Mcafee_count()));
		swCount.setMicrosoft_Teams(enc.encryptnew(astrepo.teams_count()));
		swCount.setMozilla_Firefox(enc.encryptnew(astrepo.mozilla_count()));
		swCount.setMS_Office_2007(enc.encryptnew(astrepo.offive7_count()));
		swCount.setMS_Office_2010(enc.encryptnew(astrepo.office10Count()));
		swCount.setMS_Office_2013(enc.encryptnew(astrepo.office13Count()));
		swCount.setMS_Office_2016(enc.encryptnew(astrepo.office16Count()));
		swCount.setOneDrive(enc.encryptnew(astrepo.oneDrive_Count()));
		swCount.setSymantec_Antivirus(enc.encryptnew(astrepo.SymantecCount()));
		swCount.setTeam_Viewer(enc.encryptnew(astrepo.Team_viewerCount()));
		swCount.setTrend_Micro_Antivirus(enc.encryptnew(astrepo.TrendAntivirusCount()));
		swCount.setWebex(enc.encryptnew(astrepo.webex()));
		swCount.setWinrar(enc.encryptnew(astrepo.winrar_count()));
		swCount.setZip7(enc.encryptnew(astrepo.mozilla_count()));
		swCount.setZoom(enc.encryptnew(astrepo.Zoom_Count()));
		
	//List<Tuple> details=astrepo.softwareCount_dashboard();
	//Swlist=details.stream().map(t->new SoftwareCountResponse(enc.encryptnew(t.get(0,Long.class).toString()),enc.encryptnew(t.get(1,Long.class).toString()),enc.encryptnew(t.get(3,Long.class).toString()),enc.encryptnew(t.get(4,Long.class).toString()),enc.encryptnew(t.get(5,Long.class).toString()),enc.encryptnew(t.get(6,Long.class).toString()),enc.encryptnew(t.get(7,Long.class).toString()),enc.encryptnew(t.get(8,Long.class).toString()),enc.encryptnew(t.get(9,Long.class).toString()),enc.encryptnew(t.get(10,Long.class).toString()),enc.encryptnew(t.get(11,Long.class).toString()),enc.encryptnew(t.get(12,Long.class).toString()),enc.encryptnew(t.get(13,Long.class).toString()),enc.encryptnew(t.get(14,Long.class).toString()),enc.encryptnew(t.get(15,Long.class).toString()),enc.encryptnew(t.get(16,Long.class).toString()),enc.encryptnew(t.get(17,Long.class).toString()),enc.encryptnew(t.get(18,Long.class).toString()),enc.encryptnew(t.get(19,Long.class).toString()),enc.encryptnew(t.get(20,Long.class).toString()))).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new SwCountResponse(swCount,enc.encryptnew(SoftwareCount),enc.encryptnew("True")));

		}
		catch(Exception e) {
		  System.out.println("error in finding software  details"+e);
		  log.info("error in finding software details"+e);

		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new SwCountResponse(swCount, enc.encryptnew(ErrorSoftwareCount),enc.encryptnew("FALSE")));
		}
	}
	@PostMapping(value="/status_count")

	public ResponseEntity<CountResponse> status_countt()
	{
		List<StatusResponse> statusreslist = null;
		try {

	List<Tuple> details=astrepo.status_count();
	statusreslist=details.stream().map(t->new StatusResponse(enc.encryptnew(t.get(0,String.class)),enc.encryptnew(t.get(1,Long.class).toString()))).collect(Collectors.toList());
		

	//return new ResponseEntity<>(e,HttpStatus.OK);
	return ResponseEntity.status(HttpStatus.OK)
			.body(new CountResponse(enc.encryptnew(stuscount),statusreslist,enc.encryptnew("True")));

	}
	catch(Exception e) {
	 System.out.println("error in finding status  details"+e);
	 log.info("error in finding status details"+e);

	 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CountResponse(enc.encryptnew(Errorstuscount), statusreslist,enc.encryptnew("FALSE")));
	}
	
	
}
}
