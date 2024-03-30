package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.Discovered_assets;
import com.Aforesight.Api.entity.vf_assets;

public interface Discovered_asset_repository extends JpaRepository<Discovered_assets, Long>{
	@Query("select a from Discovered_assets a")
	List<Discovered_assets> allasset();
	 @Query("select count(distinct a.username) from Discovered_assets a")
	    Long maachineCountAgent();
	 @Query("Select a from Discovered_assets a where a.username=?1")
	 List<Discovered_assets> assetBasedOnUsername(String username);
	 @Query("Select a from Discovered_assets a where a.System_Ip=?1")
	 List<Discovered_assets> assetBasedOnSystem_Ip(String System_Ip);
}