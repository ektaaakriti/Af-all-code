package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.Location;

public interface LocationRepo extends JpaRepository<Location, Long>  {
	@Query("select distinct a.State from Location a")
	  public List StateLocation();
	@Query("select distinct a.City from Location a where a.State=?1")
	  public List CityLocation(String State);
	@Query("select distinct a.City from Location a")
	public List AllLocation();
}
