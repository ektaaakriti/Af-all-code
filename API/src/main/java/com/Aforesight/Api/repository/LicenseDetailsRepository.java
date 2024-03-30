package com.Aforesight.Api.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Aforesight.Api.entity.Admin;
import com.Aforesight.Api.entity.LicenseDetails;
import com.Aforesight.Api.entity.vf_assets;

public interface LicenseDetailsRepository extends JpaRepository<LicenseDetails, Long> {
	 @Query("  SELECT COUNT(*) FROM LicenseDetails a")
	   int LicenseUsed_count();
	 @Query("select distinct a.avtivated_by from LicenseDetails a")
	   String authorisedby();
	 @Query("Select a from LicenseDetails a ")
	 List<LicenseDetails> details();
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  LicenseDetails a SET a.Ip=?1 WHERE a.License_No=?2")
	 void updateLicensenumber(String Ip,Long License_No);
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  LicenseDetails a SET a.Status_flag=?1 WHERE a.License_No=?2")
	 void updatestatus(String Status_flag,Long License_No);
	 @Query("Select a from LicenseDetails a where a.Status_flag=?1")
	 List<LicenseDetails> detailsdeactivate(String Status_flag);
	 @Query("Select a from LicenseDetails a where a.License_No=?1")
	 List<LicenseDetails> detailsdeactivateAgent(Long License_no);
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  LicenseDetails a SET a.validity_remaining=?1, a.deactivate_date=?2 WHERE a.License_No=?3")
	 void updateremainingValidity(String remaining_validity,String deactivate_date,Long License_No);
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  LicenseDetails a SET a.startDate=?1, a.EndDate=?2,a.Status_flag=?3,a.Ip=?4 WHERE a.License_No=?5")
	 void updateDeactivateToActivate(String start_date,String end_date,String Status_flag,String Ip,Long License_No);
	 
}

