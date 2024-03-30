package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.product_type;

public interface ProductRepo extends JpaRepository<product_type, Long>{
	@Query("select distinct a.Product_type from product_type a ")
	  public List  product_type();


}
