package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long>{
	@Query("select distinct a.Department_name from Department a")
	  public List department();

}
