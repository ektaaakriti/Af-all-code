
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
//Purpose:This is repository for entity class Vf_assets.
package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.vf_assets;



public interface assetRepository<S> extends JpaRepository<vf_assets, String> {
	
	@Query("select u From vf_assets u WHERE u.assetType=?1 ORDER BY u.assetDescription ASC")
	  public List<vf_assets> assetDetails(String assetType);
	
	@Transactional
	 @Modifying(clearAutomatically = false) 
	@Query("update  vf_assets a SET a.Delete_status=?1 WHERE a.asset_id=?2")
	void deleteasset(String delete_status,String asset_id);
		
}
