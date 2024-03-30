//Purpose:This is controller class which defines all the API.
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
package com.Aforesight.Api.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.persistence.Tuple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.hibernate.annotations.common.util.impl.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Aforesight.Api.EncryptionDecryptionClass;
import com.Aforesight.Api.SendMail;
import com.Aforesight.Api.entity.Admin;
import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.Discovered_assets;
import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.M_dept;
import com.Aforesight.Api.entity.M_location;
import com.Aforesight.Api.entity.Report_of_Ticket;
import com.Aforesight.Api.entity.User;
import com.Aforesight.Api.entity.User_Login;
import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.entity.vf_assets;
//import com.Aforesight.Api.payload.Admin_dtls_payload;
//import com.Aforesight.Api.payload.Asset_master_payload;
import com.Aforesight.Api.payload.Discovered_asset_payload;
import com.Aforesight.Api.payload.LoginDto;
import com.Aforesight.Api.payload.Report_of_Ticket_payload;
import com.Aforesight.Api.payload.User_login_payload;
import com.Aforesight.Api.payload.fetchAsset;
import com.Aforesight.Api.payload.ticketcreation;
import com.Aforesight.Api.repository.Admin_dtls_repository;
import com.Aforesight.Api.repository.Asset_master_repo_impl;
import com.Aforesight.Api.repository.Discovered_asset_repository;
import com.Aforesight.Api.repository.Report_of_Ticket_repository;
import com.Aforesight.Api.repository.User_login_Repo;
import com.Aforesight.Api.repository.assetRepository;
import com.Aforesight.Api.repository.asset_master_repository;
import com.Aforesight.Api.repository.qfixRepository;
import com.Aforesight.Api.repository.userRepository;
import com.Aforesight.Api.request.Login_Request;
import com.Aforesight.Api.request.User_login_Request;
import com.Aforesight.Api.response.CountResponse;
import com.Aforesight.Api.response.LocationResponse;
import com.Aforesight.Api.response.TicketResponse;
import com.Aforesight.Api.response.UserResponse;
import com.Aforesight.Api.response.ValidateTokenResponse;
import com.Aforesight.Api.response.Vf_asset;





@CrossOrigin(origins = "*") 
@RestController
@Service
@RequestMapping("/api/auth")
public class AuthController {
	

	    @Autowired
	    private userRepository userrepo;
	    @Autowired
	    private qfixRepository qfix_repo;
	    @Autowired
	    private assetRepository asset_repo;
	    
	    
	    @Autowired
	    private asset_master_repository asset_master_repo;
	    @Autowired
	    private Discovered_asset_repository Discovered_Ast_repo;
	    
	   // @Autowired
	   // private Report_of_Ticket_repository repo8;
	    
	    @Autowired
	    private User_login_Repo loginrepo;
	    SendMail sendMail=new SendMail();

	  
	    @Value("${spring.mail.username}")  String username_mail;
	    @Value("${spring.mail.feedbackurl}")  String feedbackurl;
	    @Value("${ADurl}")
		 String ADurl;
	    @Value("${LogOut}") String Logout;
	    @Value("${usernameerror}")String usernameerror;
	   @Value("${UserAccountLocked}") String UserAccountLocked;
	    @Value("${usernameerror4mAD}") String ADerror;
	    @Value("${loginOK}")String loginOK;
	    @Value("${ErrorLogin}")String ErrorLogin;
	    @Value("${userAlreadyLogin}")String userAlreadyLogin;
	    @Value("${TokenNotValidated}") String TokenNotValidated;
	    @Value("${Validatetoken}") String validateToken;
	   @Value("${usernamedoesnotexist}") String usernamedoesnotexist;
	   @Value("${ErrorLogout}") String ErrorLogout;
	   @Value("${ErrorTokenAuthentication}") String ErrorTokenAuthentication;
	   
	    String port="";
	    EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	    public static Logger log = LogManager.getLogger(AuthController.class.getName());
	    @PostMapping(
	            value = "/signin",
	            consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	 
	    public ResponseEntity<UserResponse> authenticateUser(@RequestBody Login_Request loginDto){
	      //String User_type;
	    	try {
	    	  String usr;
	    	  int loginAttempt=loginDto.getLoginAttempt();
	    	  String Token=generateRandomToken(123);
	    	  log.info("In login function");
	        String response="";
	        String portal_type=enc.decryptnew(loginDto.getPortal_type());
	        String username=get_username(enc.decryptnew(loginDto.getEmail_ID()));
	        User is_locked=userrepo.user_Locked(username);
	        if(loginAttempt<5 && is_locked==null) {
	    	//User usr=userrepo.finduserBynameandpassword(enc.decryptnew(loginDto.getEmail_ID()),enc.decryptnew(loginDto.getPassword()));
	    	String password=enc.decryptnew(userrepo.Password(enc.decryptnew(loginDto.getEmail_ID())));
	    	log.info("password from db"+password);
	    	log.info("password from ui"+enc.decryptnew(loginDto.getPassword()));
	    	if (password.equals(enc.decryptnew(loginDto.getPassword())))
	    	{
	    		usr="password corrct";
	    	}
	    	else
	    	{
	    		usr=null;
	    	}
	    	log.info("usr is"+usr);
	    		if(username==null) {
	    			//response="username doesnot exist";
	    		  	return ResponseEntity.status(HttpStatus.OK)
	  				.body(new UserResponse(enc.encryptnew(usernamedoesnotexist),enc.encryptnew("FALSE"), (Integer.toString(loginAttempt))));
	    			}
	    		else if(usr==null) {
	    			response=usernameerror;
					return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew(usernameerror),enc.encryptnew("FALSE"), (Integer.toString(loginAttempt)) ));	
	    		}
	    		else {
	    			Boolean loginDetail=User_login_details(username,Token);
	    			if(loginDetail==true) {
	    				//response=loginOK;
	    			//	String user_name=get_username();
	    				String User_type=get_usertype((enc.decryptnew(loginDto.getEmail_ID())));
	    				log.info("user account type"+User_type);
	    				if(portal_type.equals("A")) {
	    					if(User_type.equals(portal_type)) {
						return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(username), enc.encryptnew("TRUE"), (Integer.toString(0)),Token,enc.encryptnew(User_type)));
	    					}
	    					else {
	    						return ResponseEntity.status(HttpStatus.OK)
	    								.body(new UserResponse(enc.encryptnew("User not allowed on admin portal"), enc.encryptnew("TRUE"), (Integer.toString(0)),Token,enc.encryptnew(User_type)));
	    					}}
	    				else {
	    					return ResponseEntity.status(HttpStatus.OK)
	    								.body(new UserResponse(enc.encryptnew(username), enc.encryptnew("TRUE"), (Integer.toString(0)),Token,enc.encryptnew(User_type)));
	    					}
	    					}
	    			else
	    			{
	    				//response=userAlreadyLogin;
    					return ResponseEntity.status(HttpStatus.OK)
  					.body(new UserResponse(enc.encryptnew(userAlreadyLogin), enc.encryptnew("FALSE"), (Integer.toString(loginAttempt))));
	    			}
	    			
	    		}
	        }
	    		/*else {
	    	
	    	//if(logindetails==true) {
	    				if (usr==null){	
	    				Boolean logindetails=User_login_details(username);
	    						if(logindetails==true) {
	    							response=usernameerror;
	    							return ResponseEntity.status(HttpStatus.OK)
	    							.body(new UserResponse(response, Boolean.FALSE,loginAttempt));
	    							}	    	
	    						else
	    						{response=loginOK;
	    						return ResponseEntity.status(HttpStatus.OK)
	    						.body(new UserResponse(response, Boolean.TRUE,0));
	    						}
	    				}
	    				else
	    				{
	    					response=userAlreadyLogin;
	    					return ResponseEntity.status(HttpStatus.OK)
	  					.body(new UserResponse(response, Boolean.FALSE,loginAttempt));
	    	}
	    	}}*/
	        else
	        {
	        	//response="User account is locked";
	        	userrepo.user_login_status(username);
	        	log.info("user account is locked for user", username);
	        	 return ResponseEntity.status(HttpStatus.OK)
		  					.body(new UserResponse(enc.encryptnew(UserAccountLocked), enc.encryptnew("FALSE"), (Integer.toString(loginAttempt))));
	        }
	    	/*	Boolean resultAD=authenticateuser(loginDto.getEmail_ID(),loginDto.getPassword(),ADurl);
	    	//Boolean resultAD=true;
	    		 log.info(resultAD);
	    		 Boolean tr=true;
	    		int b3 = Boolean.compare(resultAD,tr);
	    		 log.info(b3);
	    		if(b3==0) {
	    			response=loginOK;
	    		}
	    		else {
	    			response=ADerror;}
	    	}
	    	log.info(loginDto.getEmail_ID());*/
	    	

	     
	      }
	      catch(Exception e) {
	    	  System.out.println("error in login api"+e);
	    	  log.info("error"+e);
	    
	    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew("ErrorLogin"), enc.encryptnew("FALSE")));
	      }
	    }
	    public Boolean User_login_details(String username,String Token) {
	    	String response=null;
	    	Boolean Response=null;
	    	
	    	User_Login loginuser=loginrepo.login(username);
	    	
	    		//response="user is locked, kindly contact admin";
	    		Response=false;
	    	
	    	
	    	
	    
	    	if (loginuser==null) {
	    	
	    	User_Login usr=new User_Login();
	    	usr.setUsername(username);
	    	Date date=new Date();
	    	usr.setLogin_Date_time(date);
	    	 
	    	usr.setToken(Token);
	    	loginrepo.save(usr);
	    	userrepo.login_status(username);
	    	//response="User login successful";
	    	Response=true;
	    	}
	    	else {
	    		//response="user already logged in";
	    		Response=false;
	    	}
	    	return Response;
	    	
	    	
	    }
	    public static String generateRandomToken(int len) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
	          +"lmnopqrstuvwxyz!@#$%&";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			return sb.toString();
		}
	  /*  public static Boolean authenticateuser(String username,String password,String ADurl){
	    	try {
	    		Hashtable env = new Hashtable();
	    		System.out.println(ADurl);
	    		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	    		env.put(Context.PROVIDER_URL, ADurl);
	    		env.put(Context.SECURITY_AUTHENTICATION,"simple");
	    		env.put(Context.SECURITY_PRINCIPAL,username);
	    		env.put(Context.SECURITY_CREDENTIALS,password);
	        DirContext context=new InitialDirContext(env);
	        System.out.println(context.getEnvironment());
	        context.close();
	        return true;
	    	}
	    	catch (Exception e) {
	    	      System.out.println(" bind error: " + e);
	    	      e.printStackTrace();
	    	      return false;
	    	}
	    	}
*/
	   
		@PostMapping(value="/Logout",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<UserResponse> Logout(@RequestBody  Login_Request logindto){
			String response=null;
			try{
				String username=get_username(enc.decryptnew(logindto.getEmail_ID()));
				log.info(username, logindto.getEmail_ID());
			loginrepo.logout(username);
		
			 return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(Logout),enc.encryptnew("TRUE")));
		      }
		      catch(Exception e) {
		    	  System.out.println("error in logout of "+logindto.getEmail_ID() +e);
		    	  log.info("error in logout of "+logindto.getEmail_ID() +e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserResponse(enc.encryptnew(ErrorLogout), enc.encryptnew("FALSE")));
		      }
			
		}
		@PostMapping(value="/validateToken",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<ValidateTokenResponse> validateToken(@RequestBody User_login_Request loginpayload){
		
		
			try {
				String response="";
				User_Login usr=loginrepo.Validate_token(enc.decryptnew(loginpayload.getUsername()),enc.decryptnew( loginpayload.getToken()));
				if (usr==null) {
					
				//response="Token is not authenticated";
					return ResponseEntity.status(HttpStatus.OK)
							.body(new ValidateTokenResponse(enc.encryptnew(TokenNotValidated), enc.encryptnew("FALSE")));
				}
				else {
					
				//response="Token is authenticated";
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ValidateTokenResponse(enc.encryptnew(validateToken), enc.encryptnew("TRUE")));
		      }
			}
		      catch(Exception e) {
		    	  System.out.println("error in token authentication of user "+loginpayload.getUsername() +e);
		    	  log.info("error in token authentication of user "+loginpayload.getUsername() +e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new ValidateTokenResponse(enc.encryptnew(ErrorTokenAuthentication), enc.encryptnew("FALSE")));	
			}
			
		}
		

	/*	@PostMapping(value="/ticketcreation",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<Long> CreateTicket(@RequestBody ticketcreation logindto){
			Long Ticket_id = null;
			try {
			System.out.println("msg_id is"+logindto.getMsg_id());
	        
	        System.out.println("msg_id is"+logindto.getMsg_ticket_Id());
	       
	        Agent_msg_dtls details = new Agent_msg_dtls(); 
		 
		        
		        details.setMsg_id(enc.decryptnew(logindto.getMsg_id()));
		    	System.out.println("msg_id is"+logindto.getMsg_id());
		        details.setMsg_description( enc.decryptnew(logindto.getMsg_description()));
		    	System.out.println("msg_id is"+logindto.getMsg_description());
		        details.setMsg_status_YN(enc.decryptnew( logindto.getMsg_status_YN()));
		    	System.out.println("msg_id is"+logindto.getMsg_status_YN());
		        details.setAsset_Id( enc.decryptnew(logindto.getAsset_Id()));
		    	System.out.println("msg_id is"+logindto.getAsset_Id());
		       // details.setTicket_Id(enc.decryptnew(logindto.getTicket_Id()));
		        details.setUser_id(enc.decryptnew(logindto.getUser_ID()));
		      
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		        Date date = new Date();
	             String tckcrndt = dateFormat.format(date);
	             System.out.println("Date is string"+tckcrndt);
	             Date tckrndt=dateFormat.parse(tckcrndt);
	             System.out.println("Date is"+tckrndt);
		        details.setMsg_datetime(tckrndt);
		        details.setMsg_enqueue_datetime(tckrndt);
		        details.setSoftware_install_choice(enc.decryptnew(logindto.getSoftware_install_choice()));
		      
		        details.setOutlook_email(enc.decryptnew(logindto.getOutlook_email()));
		        System.out.println("email id is"+logindto.getOutlook_email());
		        String username=get_username(enc.decryptnew(logindto.getOutlook_email()));
		        //details.setUser_id(logindto.getUser_ID());
		        System.out.println("user id is"+username);
		      //  qfix_repo.save(details);
		       // Long Ticket_id=(long) 0000;
		        Ticket_id=get_Ticketid(details.getMsg_status_YN(),details.getMsg_id());
			   System.out.println("ticket id is:"+Ticket_id);
			   sendMail.emailToUser(enc.decryptnew(logindto.getOutlook_email()),Ticket_id,enc.decryptnew(logindto.getMsg_status_YN()),enc.decryptnew(logindto.getMsg_description()),username_mail,password,host,port,feedbackurl); 
		       // repo1.save(details);
		        
		        
			 /*  return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew("Ticket Raised successfully with Ticket id"), enc.encryptnew("TRUE")));
		      }
		      catch(Exception e) {
		    	  System.out.println("error in login api"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserResponse(enc.encryptnew("Duplicate Ticket is Raised"), enc.encryptnew("FALSE")));
		  
	  }*/
		/*	   return new ResponseEntity<Long>(Ticket_id,HttpStatus.OK);}
			   
			catch (Exception e) {
				log.error("error in ticket creation api"+e);
		    	  return new ResponseEntity<Long>(Ticket_id, HttpStatus.BAD_GATEWAY);
		      
			}*/

				

	
		public String get_username(String Email)
		{
			String username="";
			System.out.println("emaIL is"+Email);
			username=userrepo.findusername(Email);
			System.out.println("user name is"+username);
			return username;
			
		}
		public String get_usertype(String Email)
		{
			String usertype="";
			System.out.println("emaIL is"+Email);
			usertype=userrepo.findusertype(Email);
			System.out.println("user name is"+usertype);
			return usertype;
			
		}
		
	/*	@PostMapping(value="/ticketcreation",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
	            produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<UserResponse> CreateTicket(@RequestBody ticketcreation logindto){
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
		      
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		        Date date = new Date();
	             String tckcrndt = dateFormat.format(date);
	             System.out.println("Date is string"+tckcrndt);
	             Date tckrndt=dateFormat.parse(tckcrndt);
	             System.out.println("Date is"+tckrndt);
		       // details.setMsg_datetime(tckrndt);
		        details.setMsg_enqueue_datetime(tckrndt);
		        details.setSoftware_install_choice(enc.decryptnew(logindto.getSoftware_install_choice()));
		      
		        details.setOutlook_email(enc.decryptnew(logindto.getOutlook_email()));
		        System.out.println("email id is"+logindto.getOutlook_email());
	
		        qfix_repo.save(details);
		      
		        Ticket_id=get_Ticketid(details.getMsg_status_YN(),details.getMsg_id());
			   System.out.println("ticket id is:"+Ticket_id);
			   //sendMail.emailToUser(enc.decryptnew(logindto.getOutlook_email()),Ticket_id,enc.decryptnew(logindto.getMsg_status_YN()),enc.decryptnew(logindto.getMsg_description()),username_mail,password,host,port,feedbackurl); 
		       // repo1.save(details);
		        
		        String response="Ticket Raised successfully with Ticket id "+Ticket_id.toString();
		        System.out.println(response);
		        System.out.println(enc.encryptnew(response));
			   return ResponseEntity.status(HttpStatus.OK)
						.body(new UserResponse(enc.encryptnew(response), enc.encryptnew("TRUE")));
		      }
		      catch(Exception e) {
		    	  System.out.println("error in login api"+e);
		    	  log.info("error"+e);
		    
		    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserResponse(enc.encryptnew("Duplicate Ticket is Raised"), enc.encryptnew("FALSE")));
		      }
	}
		public Long get_Ticketid(String msg_status,String Msg_id) {
			 System.out.println("in get ticket function status is:"+msg_status);
			 System.out.println("msg id is:"+Msg_id);
				Long Ticket_id= qfix_repo.getTicket_id(msg_status,Msg_id);
			
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
							.body(new UserResponse(enc.encryptnew("Error finding username"), enc.encryptnew("FALSE")));
		  
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
			 details= qfix_repo.getAllusers(enc.decryptnew(fetchticket.getOutlook_email()));
			 for(Agent_msg_dtls var:details) {
				 Agent_msg_dtls dtls=new Agent_msg_dtls();
				 dtls.setMsg_description(enc.encryptnew(var.getMsg_description()));
				 dtls.setMsg_status_YN(enc.encryptnew(var.getMsg_status_YN()));
				 dtls.setItsm_reqid(enc.encryptnew(var.getItsm_reqid()));
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
		  public ResponseEntity<UserResponse> createfeedback(@RequestBody ticketcreation createfeedback)
		  {
		try {
		        Date tckcrndt=new Date();
		        
			 qfix_repo.feedbackstatus(enc.decryptnew(createfeedback.getMsg_status_YN()),tckcrndt,createfeedback.getMsg_ticket_Id());
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
			 
			sendMail.emailToUser(email1,(ticket_id),Status,description,username_mail,password,host,port,feedbackurl);
			
			 //return new ResponseEntity<>("feedback done",HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew("Feedback Done"), enc.encryptnew("TRUE")));
		  
	  }
		 catch(Exception e) {
	    	  System.out.println("error in creating feedback"+e);
	    	  log.info("error in creating feedback"+e);
	    
	    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew("Error in creating feedback"), enc.encryptnew("FALSE")));
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
					
		  public ResponseEntity<Vf_asset> getAsset(@RequestBody fetchAsset fetchasset)
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
		
@PostMapping(value="/find_asset_dtls")

	 public ResponseEntity<Vf_asset>find_asset_dtls(@RequestBody Asset_master_payload payload)
{List<vf_assets> details = null;
		 try {

	details=asset_master_repo.findassetdetails();
//return new ResponseEntity<>(details,HttpStatus.OK);
	vf_assets nvf=new vf_assets();
	//nvf.
	  return ResponseEntity.status(HttpStatus.OK)
				.body(new Vf_asset(enc.encryptnew("Asset details"), enc.encryptnew("TRUE"),details));
	  
}
	 catch(Exception e) {
  	  System.out.println("error in finding assets details"+e);
  	  log.info("error"+e);
  
  	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Vf_asset(enc.encryptnew("Error in finding details"), enc.encryptnew("FALSE"),details));
	 }
}@PostMapping(value="/full_asset_table_report")

	 public ResponseEntity<?>full_asset_table(@RequestBody Asset_master_payload payload)
{

	List<asset_master> details=asset_master_repo.full_asset_table();
return new ResponseEntity<>(details,HttpStatus.OK);	

}@PostMapping(value="/Asset_report_departmentwise")
//consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<?> Asset_report_departmentwise(@RequestBody Asset_master_payload payload)
{

	List<asset_master> details=asset_master_repo. Asset_report_departmentwise();
return new ResponseEntity<>(details,HttpStatus.OK);	

}@PostMapping(value="/Asset_report_Site_Name")
//consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<?> Asset_report_Site_Name(@RequestBody Asset_master_payload payload)
{

	List<asset_master> details=asset_master_repo.Asset_report_Site_Name();
return new ResponseEntity<>(details,HttpStatus.OK);	

}
@PostMapping(value="/Discovered_assets")
//consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<?> Discovered_assets(@RequestBody Discovered_asset_payload payload)
{

	List<Discovered_assets> details=Discovered_Ast_repo.allasset();
return new ResponseEntity<>(details,HttpStatus.OK);	

}

@PostMapping(value="/asset_count")

	 public ResponseEntity<?> asset_count(@RequestBody Asset_master_payload payload)
{
try {
	List details=asset_master_repo.asset_count();
return new ResponseEntity<>(details,HttpStatus.OK);	}
catch(Exception e){
	return new ResponseEntity<>(e,HttpStatus.OK);
	}

}

@PostMapping(value="/getTicketDatewise")

	 public ResponseEntity<TicketResponse> getTicketDatewise(@RequestBody ticketcreation payload)
{List<Agent_msg_dtls> details1=new ArrayList<Agent_msg_dtls>();
	try {
		int i=0;
		
	List<Agent_msg_dtls> details=qfix_repo.getTicketDatewise(payload.getStartdate(),payload.getEnddate(),enc.decryptnew(payload.getOutlook_email()));
	System.out.println(payload.getEnddate());
	System.out.println(payload.getStartdate());
	System.out.println(payload.getOutlook_email());
	 for(Agent_msg_dtls var:details) {
		 Agent_msg_dtls dtls=new Agent_msg_dtls();
		 dtls.setMsg_datetime(var.getMsg_datetime());
		 dtls.setMsg_description(enc.encryptnew(var.getMsg_description()));
		 dtls.setMsg_status_YN(enc.encryptnew(var.getMsg_status_YN()));
		 dtls.setItsm_reqid(enc.encryptnew(var.getItsm_reqid()));
		 dtls.setTicket_Id(enc.encryptnew(var.getMsg_ticket_Id().toString()));
		 details1.add(i, dtls);
		 i++;
	 }
	
	
	
	 return ResponseEntity.status(HttpStatus.OK)
				.body(new TicketResponse(enc.encryptnew("Fetch Ticket"), enc.encryptnew("TRUE"),details1));
	  
}
	 catch(Exception e) {
 	  System.out.println("error in finding ticket details datewise"+e);
 	  log.info("error"+e);
 
 	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new TicketResponse(enc.encryptnew("Error finding ticket details"), enc.encryptnew("FALSE"),details1));
	 }
}


/*@PostMapping(value="/insertAssetFromDiscoveredAsset",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<?> IsertAssetFromDiscoveredAsset(@RequestBody Discovered_asset_payload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
asset_master ast=new asset_master();
try {
	
ast.setRAM_Available(payload.getRAM_Available());
ast.setUsername(payload.getUsername());
ast.setScan_Date(payload.getScan_date());
ast.setOS_Version(payload.getOs_version());
ast.setSystem_Make(payload.getSystem_make());
ast.setHD_Make(payload.getHd_make());
ast.setHD_Model(payload.getHd_model());
ast.setHD_Serial_Number(payload.getHd_serial_number());
ast.setHD_Capacity(payload.getHd_capacity());
ast.setSystem_Hostname(payload.getSystem_Hostname());
ast.setSystem_Serial_Number(payload.getSystem_serial_no());
ast.setMonitor_Screen_Size(payload.getMonitor_screen_size());
ast.setMonitor_Serial_Number(payload.getMonitor_serial_number());
ast.setTotal_RAM(payload.getTotal_RAM());
ast.setMonitor_Screen_Make(payload.getMonitor_make());
ast.setSystem_Model(payload.getSystem_Model_no());
ast.setMBD_Model(payload.getMBD_model());
ast.setProcessor_Details(payload.getProccessor());
ast.setMonitor_Model(payload.getMonitor_model());
ast.setMBD_Serial_Number(payload.getMBD_serial_no());
ast.setMBD_Make(payload.getMBD_make());
ast.setSystem_OS_type(payload.getSystem_Os_type());
ast.setSystem_IP_Address(payload.getSystem_Ip());
ast.setProduct_Type(payload.getProduct_type());
ast.setAdobe_Reader(payload.getAdobe_Reader());
ast.setAnydesk(payload.getAnydesk());
ast.setAutoCad(payload.getAutoCad());
ast.setGoogle_Chrome(payload.getGoogle_Chrome());
ast.setJava8(payload.getJava8());
ast.setMcafee_Antivirus(payload.getMcafee_Antivirus());
ast.setMicrosoft_Teams(payload.getMicrosoft_Teams());
ast.setMozilla_Firefox(payload.getMozilla_Firefox());
ast.setMS_Office_2007(payload.getMS_Office_2007());
ast.setMS_Office_2010(payload.getMS_Office_2010());
ast.setMS_Office_2013(payload.getMS_Office_2013());
ast.setMS_Office_2016(payload.getMS_Office_2016());
ast.setOneDrive(payload.getOneDrive());
ast.setSymantec_Antivirus(payload.getSymantec_Antivirus());
ast.setWebex(payload.getWebex());
ast.setWinrar(payload.getWinrar());
ast.setTeam_Viewer(payload.getTeam_Viewer());
ast.setTrend_Micro_Antivirus(payload.getTrend_Micro_Antivirus());
ast.setZip7(payload.getZip7());
ast.setZoom(payload.getZoom());

asset_master_repo.save(ast);
System.out.println("in insert asset details through discovered asset");

return new ResponseEntity<>("Asset dtls saved",HttpStatus.OK);	
}
catch(Exception e){
	return new ResponseEntity<>(e,HttpStatus.OK);
	}
}
@PutMapping(value="/MailOnStatus_N",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<?> MailOnStatus_N(@RequestBody ticketcreation  payload){
try {
	

String mail=payload.getOutlook_email();
long ticket=payload.getMsg_ticket_Id();

String status1=payload.getMsg_status_YN();
String description=payload.getMsg_description();
sendMail.emailToUser(mail,ticket,status1,description,username_mail,password,host,port,feedbackurl); 	

System.out.println("in mail_send on status API");

return new ResponseEntity<>("mail send",HttpStatus.OK);	
}
catch(Exception e){
	return new ResponseEntity<>(e,HttpStatus.OK);
	}
}*/


}









