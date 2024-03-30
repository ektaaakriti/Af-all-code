package com.Aforesight.Api.controller;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aforesight.Api.EncryptionDecryptionClass;
import com.Aforesight.Api.SendMail;
import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.vf_assets;
import com.Aforesight.Api.payload.LoginDto;
import com.Aforesight.Api.payload.fetchAsset;
import com.Aforesight.Api.payload.ticketcreation;
import com.Aforesight.Api.repository.User_login_Repo;
import com.Aforesight.Api.repository.assetRepository;
import com.Aforesight.Api.repository.qfixRepository;
import com.Aforesight.Api.repository.userRepository;
import com.Aforesight.Api.request.CreateFeedbackRequest;
import com.Aforesight.Api.request.FetchAssetRequest;
import com.Aforesight.Api.request.TicketCreationRequest;
import com.Aforesight.Api.request.TicketDatewiseRequest;
import com.Aforesight.Api.response.TicketResponse;
import com.Aforesight.Api.response.UserResponse;
import com.Aforesight.Api.response.Vf_asset;
import com.Aforesight.Api.service.Mail;
@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/auth")
public class UserPortalController {
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	 @Autowired
	    private userRepository userrepo;
	    @Autowired
	    private qfixRepository qfix_repo;
	 @Autowired
	    private User_login_Repo loginrepo;
	 @Autowired
	    private assetRepository asset_repo;
	    SendMail sendMail=new SendMail();

	    @Value("${spring.mail.host}")  String host;
	    //@Value("${spring.mail.port}")  String port;
	    @Value("${spring.mail.password}")  String password;
	    @Value("${spring.mail.username}")  String username_mail;
	    @Value("${spring.mail.feedbackurl}")  String feedbackurl;
	    @Value("${ADurl}")
		 String ADurl;
	    @Value("${createTicket}") String TicketCreated;
	    @Value("${CreateFeedback}") String FeedbackDone;
	    @Value("${TickeTDtaewise}") String TicketDtaewise;
	    @Value("${DuplicateTicket}") String DuplicateTicket;
	    @Value("${ErrorTicketDatewise}") String ErrorTicketDatewise;
	    @Value("${ErrorGetUsername}") String ErrorGetUsername;
	    @Value("${ErrorCreatingFeedback}") String ErrorCreatingFeedback;
	    String port="";
	    @Autowired
		private Mail sendEmailService;
	    public static Logger log = LogManager.getLogger(AuthController.class.getName());
	    public String get_username(String Email)
		{
			String username="";
			System.out.println("emaIL is"+Email);
			username=userrepo.findusername(Email);
			System.out.println("user name is"+username);
			return username;
			
		}
		
		@PostMapping(value="/ticketcreation",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<UserResponse> CreateTicket(@RequestBody TicketCreationRequest logindto){
			Long Ticket_id = null;
			 
			try {
				 Agent_msg_dtls details = new Agent_msg_dtls();
			System.out.println("msg_id is"+logindto.getMsg_id());
	        
	        //System.out.println("msg_id is"+logindto.getMsg_ticket_Id());
	       
	       
		 
		        
		        details.setMsg_id(enc.decryptnew(logindto.getMsg_id()));
		    	System.out.println("msg_id is"+logindto.getMsg_id());
		        details.setMsg_description( enc.decryptnew(logindto.getMsg_description()));
		    	System.out.println("msg_description is"+enc.decryptnew(logindto.getMsg_description()));
		        details.setMsg_status_YN(enc.decryptnew( logindto.getMsg_status_YN()));
		    	System.out.println("msg_status is"+logindto.getMsg_status_YN());
		        details.setAsset_Id( enc.decryptnew(logindto.getAsset_Id()));
		    	System.out.println("asset_id is"+logindto.getAsset_Id());
		       // details.setTicket_Id(enc.decryptnew(logindto.getTicket_Id()));
		        details.setUser_id(enc.decryptnew(logindto.getUser_ID()));
		    	System.out.println("asset_id is 1");
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		        Date date = new Date();
	             String tckcrndt = dateFormat.format(date);
	             System.out.println("Date is string"+tckcrndt);
	             Date tckrndt=dateFormat.parse(tckcrndt);
	             System.out.println("Date is"+tckrndt);
		       // details.setMsg_datetime(tckrndt);
	             details.setMsg_datetime(tckrndt);
		        details.setMsg_enqueue_datetime(tckrndt);
		        details.setSoftware_install_choice(enc.decryptnew(logindto.getSoftware_install_choice()));
		      
		        details.setOutlook_email(enc.decryptnew(logindto.getOutlook_email()));
		        System.out.println("email id is"+logindto.getOutlook_email());
		        Ticket_id=get_Ticketid(details.getMsg_status_YN(),details.getMsg_id(),details.getSoftware_install_choice(),enc.decryptnew(logindto.getOutlook_email()));
				   System.out.println("ticket id is:"+Ticket_id);
				  if(Ticket_id==null) { 
		        qfix_repo.save(details);
		        System.out.println("Ticket is to be created");
		       Ticket_id=get_Ticketid(details.getMsg_status_YN(),details.getMsg_id(),details.getSoftware_install_choice(),enc.decryptnew(logindto.getOutlook_email()));
		      
		       sendEmailService.emailToUser(enc.decryptnew(logindto.getOutlook_email()),Ticket_id,enc.decryptnew(logindto.getMsg_status_YN()),enc.decryptnew(logindto.getMsg_description()),username_mail,password,host,port,feedbackurl,enc.decryptnew(logindto.getUser_ID()));
			  // sendEmailService
		       // repo1.save(details);
		       System.out.println("ticket created"+Ticket_id);
		        String response=TicketCreated+Ticket_id.toString();
		        System.out.println(response);
		        System.out.println(enc.encryptnew(response));
		        
			   return ResponseEntity.status(HttpStatus.OK)
	  					.body(new UserResponse(enc.encryptnew(response), enc.encryptnew("TRUE")));}
				  else {
					  return ResponseEntity.status(HttpStatus.OK)
								.body(new UserResponse(enc.encryptnew(DuplicateTicket), enc.encryptnew("TRUE")));
				  }
		      }
		      catch(Exception e) {
		    	  System.out.println("error in Ticket creation api"+e);
		    	  log.info("error in ticket creation api"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserResponse(enc.encryptnew("Error in Ticket creation"), enc.encryptnew("FALSE")));
		      }
	}
		

@PostMapping(value="/getTicketDatewise")

	 public ResponseEntity<TicketResponse> getTicketDatewise(@RequestBody TicketDatewiseRequest TicketDatewisePayload)
{List<Agent_msg_dtls> details1=new ArrayList<Agent_msg_dtls>();
	try {
		int i=0;
		Date date = TicketDatewisePayload.getStartdate();
	//	c.setTime(new Date()); // Using today's date
		//c.add(Calendar.DATE, 5);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		//String dateInString = "22-01-2015 10:20:56";
		//Date date = sdf.parse(dateInString);
               // DateAndCalendar obj = new DateAndCalendar();

		//2. Test - Convert Date to Calendar
		Calendar c = dateToCalendar(date);
		System.out.println(c.getTime());
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 1);
		//3. Test - Convert Calendar to Date
		Date newEndDate = calendarToDate(c);
		System.out.println("new date is"+newEndDate);
		
	List<Agent_msg_dtls> details=qfix_repo.getTicketDatewise(TicketDatewisePayload.getStartdate(),newEndDate,enc.decryptnew(TicketDatewisePayload.getOutlook_email()));
	System.out.println(TicketDatewisePayload.getEnddate());
	System.out.println(TicketDatewisePayload.getStartdate());
	//System.out.println(enc.decryptnew(TicketDatewisePayload.getOutlook_email()));
	System.out.println(details);
	
	 for(Agent_msg_dtls var:details) {
		 Agent_msg_dtls dtls=new Agent_msg_dtls();
		 dtls.setMsg_datetime(var.getMsg_datetime());
		 dtls.setMsg_description(enc.encryptnew(var.getMsg_description()));
		 dtls.setMsg_status_YN(enc.encryptnew(var.getMsg_status_YN()));
		// dtls.setItsm_reqid(enc.encryptnew(var.getItsm_reqid()));
		 dtls.setTicket_Id(enc.encryptnew(var.getMsg_ticket_Id().toString()));
		 details1.add(i, dtls);
		 i++;
	 }
	 return ResponseEntity.status(HttpStatus.OK)
				.body(new TicketResponse(enc.encryptnew(TicketDtaewise), enc.encryptnew("TRUE"),details1));
	  
}
	 catch(Exception e) {
	  System.out.println("error in finding ticket details datewise"+e);
	  log.info(ErrorTicketDatewise+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new TicketResponse(enc.encryptnew(ErrorTicketDatewise), enc.encryptnew("FALSE"),details1));
	 }
}
private Calendar dateToCalendar(Date date) {

	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	return calendar;

}

//Convert Calendar to Date
private Date calendarToDate(Calendar calendar) {
	return calendar.getTime();
}
		public Long get_Ticketid(String msg_status,String Msg_id,String software_install_choice,String Email) {
			 System.out.println("in get ticket function status is:"+msg_status);
			 System.out.println("msg id is:"+Msg_id);
			 System.out.println("email is id is:"+Email);
				Long Ticket_id= qfix_repo.getTicket_id(msg_status,Msg_id, software_install_choice,(Email));
			
			return Ticket_id;
			
			
		}@PostMapping(value="/getUser",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	  public ResponseEntity<UserResponse> getuser(@RequestBody LoginDto loginDto )
	  {
			String username="";
			try {
			username=userrepo.findusername(enc.decryptnew(loginDto.getEmail_ID()));
		 // return new ResponseEntity<String>(username,HttpStatus.OK);
			 return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(username), enc.encryptnew("TRUE")));
		      }
		      catch(Exception e) {
		    	  System.out.println("error in login api"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserResponse(enc.encryptnew(ErrorGetUsername), enc.encryptnew("FALSE")));
		  
	  }
	  }
		
		 @PostMapping(value="/fetch ticket forfeedback",
					consumes = {MediaType.APPLICATION_JSON_VALUE},
		            produces = {MediaType.APPLICATION_JSON_VALUE})
		  public ResponseEntity<TicketResponse> fetchticketforfeedback(@RequestBody ticketcreation fetchticket)
		  {
			 List<Agent_msg_dtls> details = null;
			 List<Agent_msg_dtls> details1 = new ArrayList<Agent_msg_dtls>();
			 int i=0;
			 try {
			 System.out.println(fetchticket);
			 details= qfix_repo.getAusersAllTicket((fetchticket.getOutlook_email()));
			 for(Agent_msg_dtls var:details) {
				 Agent_msg_dtls dtls=new Agent_msg_dtls();
				 dtls.setMsg_description(enc.encryptnew(var.getMsg_description()));
				 dtls.setMsg_status_YN(enc.encryptnew(var.getMsg_status_YN()));
				// dtls.setItsm_reqid(enc.encryptnew(var.getItsm_reqid()));
				 dtls.setTicket_Id(enc.encryptnew(var.getMsg_ticket_Id().toString()));
				 details1.add(i, dtls);
				 i++;
			 }
			 
			 
			 //return new ResponseEntity<>(details,HttpStatus.OK);
			 return ResponseEntity.status(HttpStatus.OK)
						.body(new TicketResponse(enc.encryptnew("Fetch Ticket"), enc.encryptnew("TRUE"),details1));
			  
		  }
			 catch(Exception e) {
		    	  System.out.println("error in finding ticket details"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new TicketResponse(enc.encryptnew("Error finding ticket details"), enc.encryptnew("FALSE"),details1));
			 }
		  }
		
		 @PostMapping(value="/fetch ticket",
					consumes = {MediaType.APPLICATION_JSON_VALUE},
		            produces = {MediaType.APPLICATION_JSON_VALUE})
		  public ResponseEntity<TicketResponse> fetchticket(@RequestBody ticketcreation fetchticket)
		  {
			 List<Agent_msg_dtls> details = null;
			 List<Agent_msg_dtls> details1 = new ArrayList<Agent_msg_dtls>();
			 int i=0;
			 try {
			 System.out.println(fetchticket);
			 details= qfix_repo.getAllusers((fetchticket.getOutlook_email()));
			 for(Agent_msg_dtls var:details) {
				 Agent_msg_dtls dtls=new Agent_msg_dtls();
				 dtls.setMsg_description(enc.encryptnew(var.getMsg_description()));
				 dtls.setMsg_status_YN(enc.encryptnew(var.getMsg_status_YN()));
				// dtls.setItsm_reqid(enc.encryptnew(var.getItsm_reqid()));
				 dtls.setTicket_Id(enc.encryptnew(var.getMsg_ticket_Id().toString()));
				 details1.add(i, dtls);
				 i++;
			 }
			 
			 
			 //return new ResponseEntity<>(details,HttpStatus.OK);
			 return ResponseEntity.status(HttpStatus.OK)
						.body(new TicketResponse(enc.encryptnew("Fetch Ticket"), enc.encryptnew("TRUE"),details1));
			  
		  }
			 catch(Exception e) {
		    	  System.out.println("error in finding ticket details"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new TicketResponse(enc.encryptnew("Error finding ticket details"), enc.encryptnew("FALSE"),details1));
			 }
		  }
			 
		 @PostMapping("/createfeedback")
		  public ResponseEntity<UserResponse> createfeedback(@RequestBody CreateFeedbackRequest createfeedback)
		  {
		try {
		        Date tckcrndt=new Date();
		        
			 qfix_repo.feedbackstatus(enc.decryptnew(createfeedback.getMsg_status_YN()),tckcrndt,enc.decryptnew(createfeedback.getCsat_rating()),createfeedback.getMsg_ticket_Id());
			 List<Agent_msg_dtls> details1=qfix_repo.getticketdetails(createfeedback.getMsg_ticket_Id());
			 System.out.println(details1.get(0).getMsg_description());
			 
	 String user_id=details1.get(0).getUser_id();
	 Long ticket_id=details1.get(0).getMsg_ticket_Id();
			 System.out.println(ticket_id);
		 String Status=details1.get(0).getMsg_status_YN();
		 System.out.println(Status);
		 String description=details1.get(0).getMsg_description();
			String email1=details1.get(0).getOutlook_email();
			 System.out.println("host is"+host);
			 String username=get_username(email1);
			 
			 sendEmailService.emailToUser(email1,(ticket_id),Status,description,username_mail,password,host,port,feedbackurl,username);
			
			 //return new ResponseEntity<>("feedback done",HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew(FeedbackDone), enc.encryptnew("TRUE")));
		  
	  }
		 catch(Exception e) {
	    	  System.out.println("error in creating feedback"+e);
	    	  log.info("error in creating feedback"+e);
	    
	    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew(ErrorCreatingFeedback), enc.encryptnew("FALSE")));
		 }
			  
		  }
		 public String get_Email(String username)
		 {
			 System.out.println("username is"+username);
			 String email=userrepo.findemail(username);
			 System.out.println("email is"+email);
			return email;
			 
		 }
		 
		 @PostMapping(value="/fetchasset")
					
		  public ResponseEntity<Vf_asset> getAsset(@RequestBody FetchAssetRequest fetchasset)
		  { List<vf_assets> details = new ArrayList<vf_assets>();
		  int i=0;
			try {
			  System.out.println("asset type is "+fetchasset.getAssetType());
			  System.out.println("asset type is "+fetchasset);
			  List <vf_assets>details1=  asset_repo.assetDetails(enc.decryptnew(fetchasset.getAssetType()));
			 System.out.println("asset type is "+fetchasset.getAssetType());
			  System.out.println(details1);
			  System.out.println(fetchasset);
			  for(vf_assets var:details1) {
				  vf_assets vfast=new vf_assets();
				  vfast.setAssetDescription(enc.encryptnew(var.getAssetDescription()));
				  vfast.setAsset_id(enc.encryptnew(var.getAsset_id()));
				  vfast.setSoftware_install_choice(enc.encryptnew(var.getSoftware_install_choice()));
				  details.add(i, vfast);
				  i++;
				  
			  }
			 //return new ResponseEntity<>(details1,HttpStatus.OK);
			  return ResponseEntity.status(HttpStatus.OK)
						.body(new Vf_asset(enc.encryptnew("Asset details based on asset type"), enc.encryptnew("TRUE"),details));
			  
		  }
			 catch(Exception e) {
		    	  System.out.println("error in finding assets details"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new Vf_asset(enc.encryptnew("Error in finding asset details"), enc.encryptnew("FALSE"),details));
			 }
			  
		  }
		  
		  @PostMapping(value="/MailOnStatus_N",
				  consumes = {MediaType.APPLICATION_JSON_VALUE},
				  produces = {MediaType.APPLICATION_JSON_VALUE})
				  public ResponseEntity<?> MailOnStatus_N(@RequestBody ticketcreation  payload){
				  try {
				  	

				  String mail=payload.getOutlook_email();
				  long ticket=payload.getMsg_ticket_Id();

				  String status1=payload.getMsg_status_YN();
				  String description=payload.getMsg_description();
				  String username=get_username(payload.getOutlook_email());

				  sendEmailService.emailToUser(mail,ticket,status1,description,username_mail,password,host,port,feedbackurl,username); 	

				  System.out.println("in mail_send on status API");

				  return new ResponseEntity<>("mail send",HttpStatus.OK);	
				  }
				  catch(Exception e){
				  	return new ResponseEntity<>(e,HttpStatus.OK);
				  	}
				  }
}
