package com.Aforesight.Api.controller;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.Aforesight.Api.payload.*;
import com.Aforesight.Api.repository.DepartmentRepo;
import com.Aforesight.Api.repository.LocationRepo;
import com.Aforesight.Api.repository.Os_typeRepo;
import com.Aforesight.Api.response.StandardResponse;
import com.Aforesight.Api.response.ValidateTokenResponse;
@CrossOrigin ()
@RestController
@Service
@RequestMapping("/api/auth")
public class Setup_dataController {
	@Autowired
	private LocationRepo locationRepo;
	@Autowired
	private DepartmentRepo deparRepo;
	@Autowired 
	private Os_typeRepo Osrepo;
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	 public static Logger log = LogManager.getLogger(Setup_dataController.class.getName());
@PostMapping(value="/getstate",
		consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<?> getstate(@RequestBody LocationPayload payload )
{ List lst=null;
	try{
	List State=locationRepo.StateLocation();
	
  return new ResponseEntity<>(State,HttpStatus.OK);
  
}
catch(Exception e){
	log.error("state not found");
	return new ResponseEntity<>("error in finding states", HttpStatus.BAD_REQUEST);
}
}
@PostMapping(value="/getdepartment",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<?> getDepartment(@RequestBody DepartmentPayload payload )
{try{
	List Department=deparRepo.department();
  return new ResponseEntity<>(Department,HttpStatus.OK);
  
}
catch(Exception e){
	log.error("department not found");
	return new ResponseEntity<>("error in finding department", HttpStatus.BAD_REQUEST);
}
}
@PostMapping(value="/getOsType",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<?> getOs(@RequestBody DepartmentPayload payload )
{try{
List Os=Osrepo.os_type();
return new ResponseEntity<>(Os,HttpStatus.OK);

}
catch(Exception e){
log.error("Os not found");
return new ResponseEntity<>("error in finding os", HttpStatus.BAD_REQUEST);
}
}
@PostMapping(value="/AllLocation")

public ResponseEntity<StandardResponse> getCity(@RequestBody LocationPayload payload)
{List enc_city = new ArrayList<>();
	try {
	List City=locationRepo.AllLocation();
	System.out.println(City);
	for(int i=0;i<City.size();i++)
	{
		String city=enc.encryptnew((String) City.get(i)).toString();
		enc_city.add(i,city);
	}
	return ResponseEntity.status(HttpStatus.OK)
			.body(new StandardResponse(enc_city,enc.encryptnew("TRUE"),enc.encryptnew("Location details")));
  }

  catch(Exception e) {
	  System.out.println("error in location details " +e);
	  log.info("error in location details " +e);

	  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StandardResponse(enc_city,enc.encryptnew("Eror in location details"), enc.encryptnew("FALSE")));	
}
	
}



}
