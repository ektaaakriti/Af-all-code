package com.Aforesight.Api.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.entity.vf_assets;
@Repository
public  class Asset_master_repo_impl implements JpaRepository<asset_master, Long> {
	 @Autowired
	   private static EntityManager em;
	 public List<asset_master> findAsset1( String System_Serial_Number,String System_Make, String System_Model, String Product_Type, String System_OS_type) {
			
		  
		   CriteriaBuilder cb = em.getCriteriaBuilder();
	       CriteriaQuery<asset_master> cq = cb.createQuery(asset_master.class);

	       Root<asset_master> ast = cq.from(asset_master.class);
	       Predicate systemName = cb.equal(ast.get("System_Serial_Number"), System_Serial_Number);
	       Predicate SystemMake = cb.equal(ast.get("System_Make"), System_Make);
	       Predicate SystemModel=cb.equal(ast.get("System_Model"), System_Model);
	       Predicate ProductType=cb.equal(ast.get("Product_Type"), Product_Type);
	       Predicate SystemOStype=cb.equal(ast.get("System_OS_type"),System_OS_type);
	       cq.where(systemName,SystemMake,SystemModel,ProductType,SystemOStype);

	       TypedQuery<asset_master> query = em.createQuery(cq);
	       return query.getResultList();}
	@Override
	public Page<asset_master> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<asset_master> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(asset_master entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends asset_master> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends asset_master> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends asset_master> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <S extends asset_master, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<asset_master> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<asset_master> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<asset_master> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends asset_master> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInBatch(Iterable<asset_master> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public asset_master getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public asset_master getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends asset_master> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
}
