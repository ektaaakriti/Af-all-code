package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.Admin;
import com.Aforesight.Api.entity.Os_Type;

public interface Os_typeRepo extends JpaRepository<Os_Type, Long> {
	@Query("select distinct a.os_type from Os_Type a")
	  public List os_type();

}
