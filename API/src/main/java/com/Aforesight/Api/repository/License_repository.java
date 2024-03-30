package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.LicenseEntity;
import com.Aforesight.Api.entity.vf_assets;
import com.Aforesight.Api.payload.ticketcreation;

public interface License_repository extends JpaRepository<LicenseEntity,String>  {
	
	@Query("select u From LicenseEntity u")
	  public List<LicenseEntity> LicenseDetails();
	@Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  LicenseEntity a SET a. Total_License=?1 WHERE a.Client_Id=?2")
	 void updateLicensenumber(String Total_License,String Client_Id);
}
