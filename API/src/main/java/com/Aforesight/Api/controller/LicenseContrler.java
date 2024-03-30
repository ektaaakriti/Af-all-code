package com.Aforesight.Api.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;       
import javax.crypto.spec.SecretKeySpec;
//import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.Aforesight.Api.EncryptionDecryptionClass;
import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.LicenseEntity;
import com.Aforesight.Api.payload.LicenseDetailsPayload;
import com.Aforesight.Api.payload.License_payload;
import com.Aforesight.Api.repository.LicenseDetailsRepository;
import com.Aforesight.Api.repository.License_repository;
import com.Aforesight.Api.repository.userRepository;
import com.Aforesight.Api.response.LicenseAgentResponse;
import com.Aforesight.Api.response.LicenseCounterResponse;
import com.Aforesight.Api.response.LicenseCounterRpnse;
import com.Aforesight.Api.response.LicenseResponse;
import com.Aforesight.Api.response.TicketResponse;
import com.Aforesight.Api.response.UserResponse;
import com.univocity.parsers.common.AbstractParser;
@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/License")
public class LicenseContrler {
	@Value ("${LicenseAgent}")String Licenseagent;
	@Value ("${LicenseCounter}") String LicenseCounter;
	@Value ("${LicenseActivate}")String LicenseDetails;
	@Value ("${LicenseDeactivate}")String LicenseDeactivated;
	@Value ("${LicenseActivateAgain}")String LicenseActivated;
	@Value("${LicenseUpload}") String UploadLicense;
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	 @Autowired
	    private License_repository repo;
	 @Autowired
	 private LicenseDetailsRepository licenserepsitory;
	 
	 
		
	
	 @PostMapping(value="/saveLicenseDetails",
				consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	    public ResponseEntity<UserResponse> LicenseDetails(@RequestBody License_payload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
		    LicenseEntity le=new LicenseEntity();
		  try {
		    String Total_License=(payload.getTotal_License());
		    String StartDate=(payload.getStart_date());
		    String validity=(payload.getValidity());
		    String Client_Id=(payload.getClient_Id());
		    String Client_name=(payload.getClient_name());
		    System.out.println("total license"+Total_License);
		    System.out.println("start date"+StartDate);
		    System.out.println("validity"+validity);
		    repo.deleteAll();
		    le.setTotal_License(Total_License);
		    le.setStart_date(StartDate);
		    le.setValidity(validity);
		    le.setClient_Id(Client_Id);
		    le.setClient_name(Client_name);
		    repo.save(le);
						//return new ResponseEntity<>("details saved",HttpStatus.OK);
		    return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew(Licenseagent), enc.encryptnew("TRUE")));
		  
	}
		 catch(Exception e) {
	 	  System.out.println("error in finding ticket details datewise"+e);
	 	  
	 
	 	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew("Error finding ticket details"), enc.encryptnew("FALSE")));
		 }
		}
 public List<com.Aforesight.Api.entity.LicenseEntity> Licensedetails() {
	 List<com.Aforesight.Api.entity.LicenseEntity> dtls=repo.LicenseDetails();
	 System.out.println(dtls);
	 System.out.println(dtls.get(0).getStart_date());
	return dtls;
	 
	 
 }@PostMapping(value="/saveLicenseAgentDtls",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<UserResponse> LicenseAgentdtls(@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException{
			try {
				String response;
				List<LicenseEntity> dtls=Licensedetails();
			
			 System.out.println(dtls.get(0).getTotal_License());
			 String totalli=enc.decryptnew(dtls.get(0).getTotal_License());
			 int totalLicense=Integer.parseInt(totalli);
			int licenseUsed=licenserepsitory.LicenseUsed_count();
			 //String StartDate=dtls.get(0).getStart_date();
			// String Startdate1=enc.decryptnew(StartDate);
			
			 String Startdate1=enc.decryptnew(payload.getStartDate());
			 String StartDate=enc.encryptnew(Startdate1);
			 String validity=dtls.get(0).getValidity();
			 String validity2=enc.decryptnew(validity);
			 String[] stdt=Startdate1.split("-",2);
			 String year=stdt[0];
			 int year1=Integer.parseInt(year);
			 int validity1=Integer.parseInt(validity2);
			 int endyear=year1+validity1;
			 String endyr=Integer.toString(endyear);
			 String Enddate=endyr+"-"+stdt[1];
			 System.out.println(Enddate);
			 String enddate=enc.encryptnew(Enddate);
			 String ip=(payload.getIp());
			 //String uname=enc.encryptnew(payload.getUsername());
			 String flagstatus=enc.encryptnew("activated");
			// String ActivatedBy=enc.encryptnew(payload.getAvtivated_by());
			 
			 
			 com.Aforesight.Api.entity.LicenseDetails ld= new com.Aforesight.Api.entity.LicenseDetails();
			 if (licenseUsed<=totalLicense) {
			 ld.setStartDate(StartDate);
			 ld.setEndDate(enddate);
			 ld.setIp(ip);
			 ld.setStatus_flag(flagstatus);
			 ld.setUsername(payload.getUsername());
				 licenserepsitory.save(ld);
				 response="dtls saved";}
			 else
			 {
				  response="dtls not saved as license allocated are full";
			 }
			 return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(response), enc.encryptnew("TRUE")));}
			
			 catch(Exception e) {
			 	  System.out.println("error saving License details"+e);
			 	  
			 
			 	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(new UserResponse(enc.encryptnew("Error in saving details"), enc.encryptnew("FALSE")));
				 }
}
 @PostMapping(value="/LicenseCounter",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<?> LicenseCounter(@RequestBody LicenseDetailsPayload payload)
{
	 LicenseCounterResponse lst=new LicenseCounterResponse();
	try {
		String authorisedby=licenserepsitory.authorisedby();
		 List<LicenseEntity> dtls=Licensedetails();
		 String date=(dtls.get(0).getStart_date());
		 //List<LicenseEntity> dtls1=Licensedetails();
		 String total=(dtls.get(0).getTotal_License());
		 int used=licenserepsitory.LicenseUsed_count();
		 String usedLicense=enc.encryptnew(String.valueOf(used));
		 
		 lst.setAuthorised_by(authorisedby);
		 lst.setDateOfIssue(date);
		 lst.setTotalLicense(total);
		 lst.setUsedLicense(usedLicense);
		 return ResponseEntity.status(HttpStatus.OK)
					.body(new LicenseCounterRpnse(lst,enc.encryptnew(LicenseCounter), enc.encryptnew("TRUE")));}
		
		 catch(Exception e) {
		 	  System.out.println("error saving License details"+e);
		 	  
		 
		 	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new LicenseCounterRpnse(lst,enc.encryptnew("Error in License Counter details"), enc.encryptnew("FALSE")));
			 }
		 
		
	}
 @PostMapping(value="/AddmoreLicense",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<UserResponse> addmorelicense(@RequestBody License_payload payload) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException{
String response;
	 try {
	String morelicense=enc.decryptnew(payload.getTotal_License());
int morelicense1=Integer.parseInt(morelicense);	
List<LicenseEntity> dtls=Licensedetails();
String total=enc.decryptnew(dtls.get(0).getTotal_License());
int result=Integer.parseInt(total);
int total_license=result+morelicense1;
System.out.println(total_license);
String total_license2=String.valueOf(total_license);
String total_license3=enc.encryptnew(total_license2);
String client_id=(payload.getClient_Id());
repo.updateLicensenumber(total_license3,client_id);
	response="Total license after addition are"+total_license2;
	 //return new ResponseEntity<>(total_license,HttpStatus.OK);
return ResponseEntity.status(HttpStatus.OK)
		.body(new UserResponse(enc.encryptnew(response), enc.encryptnew("TRUE")));}

catch(Exception e) {
	  System.out.println("error in adding more License details"+e);
	  

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new UserResponse(enc.encryptnew("Error in adding more license details"), enc.encryptnew("FALSE")));
}
 }
	 @PostMapping(value="/AllLicenseAgentDetails",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LicenseResponse>AllLicenseAgentDetails (@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException{
		 List<com.Aforesight.Api.entity.LicenseDetails> list = new ArrayList<>();
		 List<LicenseAgentResponse> list1=new ArrayList<LicenseAgentResponse>();
		 try {
			
			 list=licenserepsitory.details();
			 System.out.println("status is  "+enc.decryptnew(list.get(0).getStatus_flag()));
			
		System.out.println(list);

		 String ip="";
		 String start_date="";
		 String EndDate="";
		 String status="";
		 int i=0;

		 int size=list.size();
		 //for(int i=0;i<=size;i++)
		
		 for(com.Aforesight.Api.entity.LicenseDetails var:list) {
			 LicenseAgentResponse lic=new LicenseAgentResponse();
			 String status1=enc.decryptnew(var.getStatus_flag());
				 if(status1.equals("activated"))  {
		 System.out.println(list);
		 System.out.println(size);
		  ip=(var.getIp());
		  start_date=(var.getStartDate());
		  EndDate=(var.getEndDate());
		  status=(var.getStatus_flag());
		
		 lic.setUsername(var.getUsername());
		  lic.setIp(ip);
		  lic.setStartDate(start_date);
		  lic.setEndDate(EndDate);
		  lic.setStatus_flag(status);
		  lic.setLicense_no((enc.encryptnew(Long.toString(var.getLicense_No()))));
		 // lic.setStatus_flag(status);
		 list1.add(i, lic);
		 System.out.println(ip);
		 System.out.println(i);
		 i++;
		 }}
		 
		
		 System.out.println(list1);
		 return ResponseEntity.status(HttpStatus.OK)
					.body(new LicenseResponse(list1,enc.encryptnew( LicenseDetails), enc.encryptnew("TRUE")));
		 }

			catch(Exception e) {
				  System.out.println("error in  License details"+e);
				  

				  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new LicenseResponse(list1,enc.encryptnew("Error in returning license details"), enc.encryptnew("FALSE")));
			 }
		 //return new ResponseEntity<>(list1,HttpStatus.OK);
	}
	 @PostMapping(value="/UpdatelicenseAgentDetails",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?>updateLicenseAgentDetails (@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
		 String ip=enc.encryptnew(payload.getIp());
		 licenserepsitory.updateLicensenumber(ip, payload.getLicense_No());
		 return new ResponseEntity<>("update done",HttpStatus.OK);}
 

public  String calculate_remainingvalidity(String startdate, String endDate) throws ParseException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dateBefore = sdf.parse(startdate);
    Date dateAfter = sdf.parse(endDate);
System.out.println(startdate);
System.out.println(endDate);
System.out.println("Startdate"+dateBefore+"enddate"+endDate);
// Calculate the number of days between dates
    long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
    System.out.println("The number of days between dates: " + daysDiff);
    List<LicenseEntity> dtls=Licensedetails();
    System.out.println("validity new"+dtls.get(0).getValidity());
    String validity=enc.decryptnew(dtls.get(0).getValidity());
    Long validity1=Long.parseLong(validity)*365;
    System.out.println("validity total"+validity);
    System.out.println("validity in days"+validity1);
    
    Long remaining_validity=validity1-daysDiff;
    String validity2=String.valueOf(remaining_validity)+ " days";
    System.out.println(validity2);
    String remaining_validity2=enc.encryptnew(validity2);
    return remaining_validity2;
}

		
	 @PostMapping(value="/UpdatelicenseAgentStatus",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
				public ResponseEntity<UserResponse>updateLicenseAgentstatus (@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, ParseException{

					try{
						String status=enc.encryptnew("deactivated");
						System.out.println("License_no is"+payload.getLicense_number());
				Long License_no=Long.parseLong(enc.decryptnew(payload.getLicense_number()));
				System.out.println("License_no is"+License_no);
				licenserepsitory.updatestatus(status, License_no);
				List<LicenseDetails> list=licenserepsitory.detailsdeactivateAgent(License_no);
				String startdate=enc.decryptnew(list.get(0).getStartDate());
				System.out.println("start date 1 date"+startdate);
				Date tckcrndt=new Date();
				System.out.println("today date"+tckcrndt);
				//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String endDate = dateFormat.format(tckcrndt);
				Date startDate1=dateFormat.parse(startdate);

				System.out.println("today date 1 date"+endDate);
				System.out.println("end date"+endDate);
				System.out.println("start date"+startDate1);
				String deactivatedate=enc.encryptnew(endDate);
				//String enddate=tckcrndt;
				String remaining_validity=calculate_remainingvalidity(startdate,endDate);
				System.out.println("remaining validity"+remaining_validity);
				licenserepsitory.updateremainingValidity(remaining_validity,deactivatedate, License_no);
				return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(LicenseDeactivated), enc.encryptnew("TRUE")));}

				catch(Exception e) {
					  System.out.println("error in- status changed to deactivate and remaining validity updated"+e);
					  

					  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(new UserResponse(enc.encryptnew("Error in- status changed to deactivate and remaining validity updated"), enc.encryptnew("FALSE")));
				 }
				//return new ResponseEntity<>("status changed to deactivate and remaining validity updated",HttpStatus.OK);
				}
	 @PostMapping(value="/AllLicenseAgentDetailsDeactivate",
			 consumes = {MediaType.APPLICATION_JSON_VALUE},
			 produces = {MediaType.APPLICATION_JSON_VALUE})
			 public ResponseEntity<LicenseResponse>AllLicenseAgentDetailsdeactivate (@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException{
			 	List<com.Aforesight.Api.entity.LicenseDetails> list = new ArrayList<>();
			 	 List<LicenseAgentResponse> list1=new ArrayList<LicenseAgentResponse>();
			 	
			 	try{
			 		//String status1=enc.encryptnew("deactivated");
			 		//System.out.println("status is"+status1);
			 	 list=licenserepsitory.details();
			 	 System.out.println(enc.decryptnew(list.get(0).getStatus_flag()));
			 	 
			 			 
			 String ip="";
			 String start_date="";
			 String EndDate="";
			 String status="";
			 int i=0;
			 String remaining_validity="";
			 String deactivate_date="";
			 //List<LicenseDetails> list1=new ArrayList<LicenseDetails>();
			 int size=list.size();
			 //for(int i=0;i<=size;i++)

			 for(LicenseDetails var:list) {
			 	LicenseAgentResponse lic=new LicenseAgentResponse();
			 	String status1=enc.decryptnew(var.getStatus_flag());
			 	 if(status1.equals("deactivated"))  {
			 System.out.println(list);
			 System.out.println(size);
			 ip=(var.getIp());
			 start_date=(var.getStartDate());
			 EndDate=(var.getEndDate());
			 status=(var.getStatus_flag());
			 remaining_validity=(var.getValidity_remaining());
			 deactivate_date=(var.getDeactivate_date());
			 lic.setUsername(var.getUsername());
			 lic.setIp(ip);
			 lic.setStartDate(start_date);
			 lic.setEndDate(EndDate);
			 lic.setStatus_flag(status);
			 //lic.setLicense_no(var.getLicense_No());
			 lic.setLicense_no((enc.encryptnew(Long.toString(var.getLicense_No()))));
			 lic.setStatus_flag(status);
			 lic.setValidity_remaining(remaining_validity);
			 lic.setDeactivate_date(deactivate_date);
			 list1.add(i, lic);
			 System.out.println(ip);
			 System.out.println(i);
			 i++;
			 }

			 //list1.add(i,lic);
			 		 }
			 	 
			 System.out.println(list1);
			 	 

			  
			 	 return ResponseEntity.status(HttpStatus.OK)
			 				.body(new LicenseResponse(list1,enc.encryptnew(LicenseDetails), enc.encryptnew("TRUE")));}

			 		catch(Exception e) {
			 			  System.out.println("error in License details"+e);
			 			  

			 			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			 						.body(new LicenseResponse(list,enc.encryptnew("Error in returning license details"), enc.encryptnew("FALSE")));
			 //return new ResponseEntity<>(list1,HttpStatus.OK);
			 }
			 }
		@PostMapping(value="/UpdatedeactivateToActivate",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
				public ResponseEntity<?>updatedeactivateToActivate (@RequestBody LicenseDetailsPayload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
					try{
						Date tckcrndt=new Date();
					
					System.out.println("today date"+tckcrndt);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
					String startDate = dateFormat.format(tckcrndt);
					System.out.println("start date"+startDate);
					String startdate=enc.encryptnew(startDate);
					Long License_no=Long.parseLong(enc.decryptnew(payload.getLicense_number()));
					List<LicenseDetails> list=licenserepsitory.detailsdeactivateAgent(License_no);
					String validity=enc.decryptnew(list.get(0).getValidity_remaining());
					System.out.println("validity is"+validity);
					String[] val=validity.split(" ");
					//int validity1=Integer.parseInt(validity);
					long validity1=Long.parseLong(val[0]);
					System.out.println("validity is 1"+validity1);
					int i=(int)validity1; 
					System.out.println("validity is"+i);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				    
				   
				    Calendar cal = Calendar.getInstance();  
				      
				    System.out.println(sdf.format(cal.getTime())+" is the date before adding days");  
				      
				    // use add() method to add the days to the given date  
				    cal.add(Calendar.DATE,i); 
				    
				    String enddate = sdf.format(cal.getTime());  
					System.out.println("end date is"+enddate);
				    enddate=enc.encryptnew(enddate);
				    String status=enc.encryptnew("activated");
				    String ip=(payload.getIp());
				    startDate=enc.encryptnew(startDate);
					licenserepsitory.updateDeactivateToActivate(startDate,enddate,status, ip, License_no);
					return ResponseEntity.status(HttpStatus.OK)
							.body(new UserResponse(enc.encryptnew(LicenseActivated), enc.encryptnew("TRUE")));}

					catch(Exception e) {
						  System.out.println("error in- Agent license activated again"+e);
						  

						  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
									.body(new UserResponse(enc.encryptnew("Error in-  Agent license activated again"), enc.encryptnew("FALSE")));
					 }
					//return new ResponseEntity<>("Agent license activated again",HttpStatus.OK);	
				}
		
		@PostMapping("/upload")
		public ResponseEntity<UserResponse> uploadData(@RequestParam("file") MultipartFile file) throws IOException {
			try{
				List<LicenseDetails> list1=new ArrayList<>();
			
			InputStream inputstream=file.getInputStream();
			System.out.println("inputstream size is"+inputstream.toString());
			writeToFile(inputstream);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew(UploadLicense), enc.encryptnew("TRUE")));
		  
		}
		 catch(Exception e) {
		  System.out.println("error in finding License details"+e);
		  

		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew("Error in license upload"), enc.encryptnew("FALSE")));
		 }
		}
		public void writeToFile(InputStream stream) {
			try {
				    File targetFile = new File("C://Agent//UploadFiles//LicenseCSV.csv");

				    FileUtils.copyInputStreamToFile(stream, targetFile);	
			
		}
			catch (Exception e) {
				System.out.println(e);
			}
		}

}
 

