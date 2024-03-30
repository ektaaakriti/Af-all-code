package com.Aforesight.Api.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.User;
import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.payload.LoginDto;
import com.Aforesight.Api.repository.User_login_Repo;
import com.Aforesight.Api.repository.userRepository;

import com.Aforesight.Api.request.FindUserRequest;
import com.Aforesight.Api.request.UnlockUserRequest;
import com.Aforesight.Api.request.UserCreationRequest;
import com.Aforesight.Api.request.UserDetailsRequest;
import com.Aforesight.Api.response.UnlockUsersResponse;
import com.Aforesight.Api.response.UserMngmntResponse;
import com.Aforesight.Api.response.UserResponse;
import com.Aforesight.Api.response.Vf_asset;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/userManagment")
public class UserController {
	// @Value("${spring.mail.host}")  String host;
	@Value ("${UserCreation}") String UserCreated;
	@Value ("${DeleteUser}")String UserDeleted;
	@Value ("${ImportUser}")String UserImported;
	@Value ("${ModifyUser}")String userModified;
	@Value("${updateUser}") String updateUser;
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	 public static Logger log = LogManager.getLogger(UserController.class.getName());
	 @Autowired
	 private User_login_Repo loginRepo;
	 @Autowired
	    private userRepository usrrepo;
	@PostMapping("/uploadUsers")
	public ResponseEntity<UserResponse> uploadData(@RequestParam("file") MultipartFile file) throws IOException {
		try{
			List<LicenseDetails> list1=new ArrayList<>();
		
		InputStream inputstream=file.getInputStream();
		System.out.println("inputstream size is"+inputstream.toString());
		writeToFile(inputstream);
		 return ResponseEntity.status(HttpStatus.OK)
					.body(new UserResponse(enc.encryptnew(UserImported), enc.encryptnew("TRUE")));
		  
	}
		 catch(Exception e) {
		  System.out.println("error in finding users details"+e);
		  log.info("error"+e);

		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new UserResponse(enc.encryptnew("Error in user upload"), enc.encryptnew("FALSE")));
		 }
	}
	public void writeToFile(InputStream stream) {
		try {
			    File targetFile = new File("C://Agent//UploadFiles//UsersCSV.csv");

			    FileUtils.copyInputStreamToFile(stream, targetFile);	
		
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	@PostMapping(value="/AllUsers")

	 public ResponseEntity<UserMngmntResponse> user1()
{
		List<User> list=new ArrayList<User>();
	try {
	List<User> lst=usrrepo.AllUsers();
	int i=0;
	for (User usr:lst) {
		User user=new User();
		user.setFirst_Name(enc.encryptnew(usr.getFirst_Name()));
		user.setLast_Name(enc.encryptnew(usr.getLast_Name()));
		user.setEmail_ID(enc.encryptnew(usr.getEmail_ID()));
		user.setUsername(enc.encryptnew(usr.getUsername()));
		user.setDepartment(enc.encryptnew(usr.getDepartment()));
		user.setLocation(enc.encryptnew(usr.getLocation()));
		user.setMobile(enc.encryptnew(usr.getMobile()));
		user.setAD_User_login_ID(enc.encryptnew(usr.getAD_User_login_ID()));
		user.setManager_Name(enc.encryptnew(usr.getManager_Name()));
		user.setManager_User_ID(enc.encryptnew(usr.getManager_User_ID()));
		user.setEmp_Code(enc.encryptnew(usr.getEmp_Code()));
		user.setUser_group_id(enc.encryptnew(usr.getUser_group_id()));
		user.setUser_ID(enc.encryptnew(usr.getUser_ID()));
		list.add(i, user);
		i++;
		
	}
	if (list==null)
	{return ResponseEntity.status(HttpStatus.OK)
			.body(new UserMngmntResponse(enc.encryptnew(" users doesnot exist"),enc.encryptnew("TRUE")));}
else
	{
	 return ResponseEntity.status(HttpStatus.OK)
				.body(new UserMngmntResponse(list,enc.encryptnew("All Users Details"), enc.encryptnew("TRUE")));
	  
}}
	 catch(Exception e) {
	  System.out.println("error in finding users details"+e);
	  log.info("error"+e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new UserMngmntResponse(list,enc.encryptnew("Error in finding all users"), enc.encryptnew("FALSE")));
	 }
}
	@PostMapping(value="/Usercreation",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
			public ResponseEntity<UserMngmntResponse> userCreate(@RequestBody UserCreationRequest payload){
try {
				User details=new User();
			//	details.setUser_ID((payload.getUser_ID()));
				System.out.println("Dummy1");
				details.setUsername(enc.decryptnew(payload.getUsername()));
				details.setFirst_Name(enc.decryptnew(payload.getFirst_Name()));
				details.setLast_Name(enc.decryptnew(payload.getLast_Name()));
				details.setAD_User_login_ID(enc.decryptnew(payload.getAD_User_login_ID()));
				details.setPassword_enc((payload.getPassword_enc()));
				details.setMobile(enc.decryptnew(payload.getMobile()));
				System.out.println("Dummy2");
				details.setUser_ID(enc.decryptnew(payload.getUser_ID()));
				details.setEmail_ID(enc.decryptnew(payload.getEmail_ID()));
				details.setPassword((payload.getPassword()));
				details.setDepartment(enc.decryptnew(payload.getDepartment()));
				details.setLocation(enc.decryptnew(payload.getLocation()));
				details.setManager_Name(enc.decryptnew(payload.getManager_Name()));
				details.setManager_User_ID(enc.decryptnew(payload.getManager_User_ID()));
				details.setEmp_Code(enc.decryptnew(payload.getEmp_Code()));
				System.out.println("Dummy2");
				details.setUser_Type(enc.decryptnew(payload.getUser_Type()));
				details.setUser_group_id(enc.decryptnew(payload.getUser_group_id()));
				String delete_status="NO";
				details.setDelete_status(delete_status);
				System.out.println("Dummy3");
				String pass1=enc.decryptnew(payload.getPassword());
				String pass2=enc.decryptnew(payload.getPassword_enc());
				System.out.println(pass1);
				System.out.println(pass2);
				System.out.println(pass1);
				System.out.println(pass2);
				 String response="";
				if(pass1.equals(pass2)) {
					usrrepo.save(details);
					 response="details saved in database";
					 System.out.println(response);
				}else {
					response="password doesnt match";
					System.out.println(response);
				}
				 return ResponseEntity.status(HttpStatus.OK)
							.body(new UserMngmntResponse(enc.encryptnew(response), enc.encryptnew("TRUE")));
				  
			}
				 catch(Exception e) {
				  System.out.println("error in saving users details"+e);
				  log.info("error"+e);

				  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(new UserMngmntResponse(enc.encryptnew("error in saving details"), enc.encryptnew("FALSE")));
				 }	
					
			}



			@PostMapping(value="/findusernamenID")

				 public ResponseEntity<?> findusernamenID(@RequestBody FindUserRequest findUserpayload)
			{List<User> list=new ArrayList<User>();
				try {
				int i=0;	
				System.out.println("user is"+enc.decryptnew(findUserpayload.getUsername()));
				List<User> details=usrrepo.findusernamenID(enc.decryptnew(findUserpayload.getUsername()));
				System.out.println("details are"+details);
				if (details.isEmpty())
				{
					System.out.println("details are not exist");
					return ResponseEntity.status(HttpStatus.OK)
						.body(new UserMngmntResponse(enc.encryptnew("username doesnot exist"),enc.encryptnew("TRUE")));}
				else {
				for (User usr:details) {
					User user=new User();
					user.setFirst_Name(enc.encryptnew(usr.getFirst_Name()));
					user.setLast_Name(enc.encryptnew(usr.getLast_Name()));
					user.setEmail_ID(enc.encryptnew(usr.getEmail_ID()));
					user.setUsername(enc.encryptnew(usr.getUsername()));
					user.setDepartment(enc.encryptnew(usr.getDepartment()));
					user.setLocation(enc.encryptnew(usr.getLocation()));
					user.setMobile(enc.encryptnew(usr.getMobile()));
					user.setAD_User_login_ID(enc.encryptnew(usr.getAD_User_login_ID()));
					user.setManager_Name(enc.encryptnew(usr.getManager_Name()));
					user.setManager_User_ID(enc.encryptnew(usr.getManager_User_ID()));
					user.setEmp_Code(enc.encryptnew(usr.getEmp_Code()));
					user.setUser_group_id(enc.encryptnew(usr.getUser_group_id()));
					user.setUser_ID(enc.encryptnew(usr.getUser_ID()));
					user.setUser_Type(enc.encryptnew(usr.getUser_Type()));
					list.add(i, user);
					i++;
					
				}
				
			
				
				 return ResponseEntity.status(HttpStatus.OK)
							.body(new UserMngmntResponse(list,enc.encryptnew("Users Details"), enc.encryptnew("TRUE")));
				  
			}}
				 catch(Exception e) {
				  System.out.println("error in finding users details"+e);
				  log.info("error"+e);

				  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(new UserMngmntResponse(list,enc.encryptnew("Error in finding  users"), enc.encryptnew("FALSE")));
				 }
			
			}
			@PostMapping(value="/delete_user")

				 public ResponseEntity<?> delete_status(@RequestBody UserDetailsRequest payload)
			{try {
				

				String Delete="YES";
				usrrepo.delete_status(Delete,enc.decryptnew(payload.getUsername()),enc.decryptnew(payload.getUser_ID()));
				System.out.println(payload.getUsername());
				return ResponseEntity.status(HttpStatus.OK)
						.body(new UserMngmntResponse(enc.encryptnew(UserDeleted), enc.encryptnew("TRUE")));
			  
		}
			 catch(Exception e) {
			  System.out.println("error in deleting  users details"+e);
			  log.info("error"+e);

			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserMngmntResponse(enc.encryptnew("error in deleting user details"), enc.encryptnew("FALSE")));
			 }	

			}
			@PostMapping(value="/getUserToUpdate")

				 public ResponseEntity<UserMngmntResponse> getUserToUpdate(@RequestBody UserDetailsRequest payload)
			{List<User> list=new ArrayList<User>();
				try 
			
			{
				
				List<User> details=usrrepo.getUserToUpdate(payload.getUser_ID(),enc.encryptnew(payload.getUsername()));
				System.out.println(payload.getUsername());
				System.out.println(details);
				int i=0;
				for (User usr:details) {
					User user=new User();
					user.setFirst_Name(enc.encryptnew(usr.getFirst_Name()));
					user.setLast_Name(enc.encryptnew(usr.getLast_Name()));
					user.setEmail_ID(enc.encryptnew(usr.getEmail_ID()));
					user.setUsername(enc.encryptnew(usr.getUsername()));
					user.setDepartment(enc.encryptnew(usr.getDepartment()));
					user.setLocation(enc.encryptnew(usr.getLocation()));
					user.setMobile(enc.encryptnew(usr.getMobile()));
					user.setAD_User_login_ID(enc.encryptnew(usr.getAD_User_login_ID()));
					user.setManager_Name(enc.encryptnew(usr.getManager_Name()));
					user.setManager_User_ID(enc.encryptnew(usr.getManager_User_ID()));
					user.setEmp_Code(enc.encryptnew(usr.getEmp_Code()));
					user.setUser_group_id(enc.encryptnew(usr.getUser_group_id()));
					user.setUser_ID(enc.encryptnew(usr.getUser_ID()));
					list.add(i, user);
					i++;
					
				}
				if (details.isEmpty())
					{return ResponseEntity.status(HttpStatus.OK)
							.body(new UserMngmntResponse(enc.encryptnew(" username doesnot exist"),enc.encryptnew("TRUE")));}
				else
					{return ResponseEntity.status(HttpStatus.OK)
							.body(new UserMngmntResponse(list,enc.encryptnew(" Users Details"),enc.encryptnew("TRUE")));
				  
			}}
				 catch(Exception e) {
				  System.out.println("error in finding users details"+e);
				  log.info("error"+e);

				  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(new UserMngmntResponse(list,enc.encryptnew("Error in finding  users"), enc.encryptnew("FALSE")));
				 }
			

			}
			@PostMapping(value="/update_user")

				 public ResponseEntity<UserMngmntResponse> update_user(@RequestBody UserCreationRequest userPayload)
			{
				try {
				usrrepo.update_user(enc.decryptnew(userPayload.getEmail_ID()),enc.decryptnew(userPayload.getFirst_Name()),
						enc.decryptnew(userPayload.getLast_Name()),enc.decryptnew(userPayload.getMobile()),
						enc.decryptnew(userPayload.getDepartment()),enc.decryptnew(userPayload.getLocation()),
						enc.decryptnew(userPayload.getManager_Name()),enc.decryptnew(userPayload.getManager_User_ID()),
						enc.decryptnew(userPayload.getEmp_Code()),enc.decryptnew(userPayload.getUser_Type()),
						enc.decryptnew(userPayload.getUser_group_id()),enc.decryptnew(userPayload.getAD_User_login_ID()),
						enc.decryptnew(userPayload.getUsername()));
				System.out.println("username encryptted"+userPayload.getUsername());
				System.out.println("username"+enc.decryptnew(userPayload.getUsername()));
				System.out.println("lastname"+userPayload.getLast_Name());
				System.out.println(enc.decryptnew(userPayload.getLast_Name()));
				
				return ResponseEntity.status(HttpStatus.OK)
						.body(new UserMngmntResponse(enc.encryptnew(updateUser), enc.encryptnew("TRUE")));
			  
		}
			 catch(Exception e) {
			  System.out.println("error in updating users details"+e);
			  log.info("error"+e);

			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new UserMngmntResponse(enc.encryptnew("Error in"+updateUser),enc.encryptnew("FALSE")));
			 }

			}/*@PostMapping(value="/allDepartmentInUser")

				 public ResponseEntity<?> alldepartment(@RequestBody LoginDto payload)
			{try {
				
				List details=usrrepo.alldepartment();
				
				
			return new ResponseEntity<>(details,HttpStatus.OK);	}
			catch(Exception e){
				return new ResponseEntity<>(e,HttpStatus.OK);
				}

			}@PostMapping(value="/userByDepartment")

				 public ResponseEntity<?> userByDepartment(@RequestBody LoginDto payload)
			{try {
				System.out.println("dummy1");
				System.out.println(payload.getDepartment());
				List details=usrrepo.userByDepartment(payload.getDepartment());
				System.out.println(details);
				System.out.println("dummy1");
			return new ResponseEntity<>(details,HttpStatus.OK);	
			}
			catch(Exception e){
				return new ResponseEntity<>(e,HttpStatus.OK);
				}

			}@PostMapping(value="/createUserGroup")

				 public ResponseEntity<?> createUserGroup(@RequestBody LoginDto payload)
			{
				try {
				usrrepo.createUserGroup(payload.getUser_group_id(),payload.getDepartment());
				
				
			return new ResponseEntity<>("Group created",HttpStatus.OK);	
			}
			catch(Exception e){
				return new ResponseEntity<>(e,HttpStatus.OK);
				}
			}@PostMapping(value="/deleteUserGroup")

				 public ResponseEntity<?> deleteUserGroup(@RequestBody LoginDto payload)
			{
				try 
				{
				String user_gr_id="";
				usrrepo.DeleteUserGroup(user_gr_id,payload.getDepartment());
				
				
			return new ResponseEntity<>("Group deleted",HttpStatus.OK);	
				}
				catch(Exception e){
					return new ResponseEntity<>(e,HttpStatus.OK);
					}

			}*/
	
@GetMapping(path = "/downloadAllUsersReportcsv")
public void downloadUser(HttpServletResponse servletResponse)  {
    try{servletResponse.setContentType("text/csv");
    
    servletResponse.addHeader("Content-Disposition","attachment; filename=\"report.csv\"");
   List<User> lst= usrrepo.AllUsers();
   ICsvBeanWriter csvwriter=new CsvBeanWriter(servletResponse.getWriter(),CsvPreference.STANDARD_PREFERENCE);
   //{String[] csvHeader = {crosoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
   String[] csvHeader = {"First_Name","Last_Name","AD_User_login_ID","Password_enc","Mobile","Email_ID","Password","Department","Location","Manager_Name","Manager_User_ID","Emp_Code","username","User_Type","user_group_id","user_id"};
   String[] nameMapping ={"First_Name","Last_Name","AD_User_login_ID","Password_enc","Mobile","Email_ID","Password","Department","Location","Manager_Name","Manager_User_ID","Emp_Code","username","User_Type","user_group_id","user_id"};
   csvwriter.writeHeader(csvHeader);
for (User msg:lst) {
	
	 
	 csvwriter.write(msg, nameMapping);
}
csvwriter.close();

}
catch (Exception e) {
	 log.error(e);
}}
@PostMapping(value="/allLockedUser")

public ResponseEntity<?> allLockedUser()
{List<User> list=new ArrayList<User>();
	try {

List<User> lst=usrrepo.AllLockedandloggedUser();
int i=0;
for (User usr:lst) {
	User user=new User();
	//user.setFirst_Name(enc.encryptnew(usr.getFirst_Name()));
	//user.setLast_Name(enc.encryptnew(usr.getLast_Name()));
	//user.setEmail_ID(enc.encryptnew(usr.getEmail_ID()));
	user.setUsername(enc.encryptnew(usr.getUsername()));
//	user.setDepartment(enc.encryptnew(usr.getDepartment()));
	//user.setLocation(enc.encryptnew(usr.getLocation()));
	//user.setMobile(enc.encryptnew(usr.getMobile()));
	//user.setAD_User_login_ID(enc.encryptnew(usr.getAD_User_login_ID()));
	//user.setManager_Name(enc.encryptnew(usr.getManager_Name()));
	//user.setManager_User_ID(enc.encryptnew(usr.getManager_User_ID()));
	//user.setEmp_Code(enc.encryptnew(usr.getEmp_Code()));
	//user.setUser_Type(enc.encryptnew(usr.getUser_Type()));
	//user.setUser_group_id(enc.encryptnew(usr.getUser_group_id()));
	user.setUser_ID(enc.encryptnew(usr.getUser_ID()));
	//user.setUser_locked(enc.encryptnew(usr.getUser_locked()));
	//user.setUser_login(enc.encryptnew(usr.getUser_login()));
	list.add(i, user);
	i++;
	
}
if (list.isEmpty())
{return ResponseEntity.status(HttpStatus.OK)
		.body(new UserMngmntResponse(enc.encryptnew(" locked users doesnot exist"),enc.encryptnew("TRUE")));}
else
{
return ResponseEntity.status(HttpStatus.OK)
		.body(new UserMngmntResponse(list,enc.encryptnew(" Users Details of locked Users"),enc.encryptnew("TRUE")));

}}
catch(Exception e) {
System.out.println("error in finding  Locked users details"+e);
log.info("error"+e);

return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new UserMngmntResponse(list,enc.encryptnew("Error in finding Locked users"), enc.encryptnew("FALSE")));
}


}

@PostMapping(value="/UnlockMultipleUser")

public ResponseEntity<UnlockUsersResponse> UnlockMultipleUser(@RequestBody UnlockUserRequest UnlockUserRequest)
{List list=new ArrayList<>();
	try {

List list1=UnlockUserRequest.getUsername();
for(int i=0;i<list1.size();i++) {
	String user1=(list1.get(i).toString());
	System.out.println(user1);
	String user=enc.decryptnew(list1.get(i).toString());
	System.out.println(user);
	list.add(i, user);
}
usrrepo.unlockmultipleUsers(list);
loginRepo.deleteloggedUsers(list);
return ResponseEntity.status(HttpStatus.OK)
		.body(new UnlockUsersResponse(list,enc.encryptnew(" Users unlocked"),enc.encryptnew("TRUE")));

}
catch(Exception e) {
System.out.println("error in updating  Locked users details"+e);
log.info("error"+e);

return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new UnlockUsersResponse(list,("Error in updating Locked users"), enc.encryptnew("FALSE")));
}


}


}
