package com.Aforesight.Api.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
//import org.apache.tomcat.util.codec.binary.Base64;
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
import com.Aforesight.Api.entity.Admin;
import com.Aforesight.Api.payload.Admin_dtls_payload;
import com.Aforesight.Api.repository.Admin_dtls_repository;
import com.Aforesight.Api.request.Admin_dtls_Resquest;
import com.Aforesight.Api.response.AdminDetailsResponse;
import com.Aforesight.Api.response.AssetResponse;
@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api/auth")
public class AdminDetailsController {
	EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
	@Autowired
    private Admin_dtls_repository admin_dtls_repo;
	@PostMapping(value="/Admindtls",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AdminDetailsResponse> Admindtls(@RequestBody Admin_dtls_Resquest payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
		try {
		Admin admin=new Admin();
		admin_dtls_repo.deleteDetails();
		String username=(payload.getParameter_username());
		String password=(payload.getParameter_password());
		
		admin.setParameter_Username(username);
		admin.setParameter_password(password);
		
		System.out.println(payload.getParameter_username());
		System.out.println(payload.getParameter_password());
		System.out.println(enc.decryptnew(username));
		System.out.println(enc.decryptnew(password));
		
	admin_dtls_repo.save(admin);
		System.out.println("in admin dtls api");
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new AdminDetailsResponse(enc.encryptnew("Admin details saved"), enc.encryptnew("TRUE")));

		}
		catch(Exception e) {
		  System.out.println("error in saving admin details"+e);
		 // log.info("error"+e);

		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new AdminDetailsResponse(enc.encryptnew("Error in saving admin details"), enc.encryptnew("FALSE")));
		} 
	}
	}

