package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.Admin;
import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.entity.vf_assets;
import com.Aforesight.Api.payload.Admin_dtls_payload;

public interface Admin_dtls_repository extends JpaRepository<Admin, Long> {


	@Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("delete from Admin u")
	  public void deleteDetails();
}
