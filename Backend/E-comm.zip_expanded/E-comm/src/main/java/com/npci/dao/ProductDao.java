package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.npci.entity.ProductsEntity;

public interface ProductDao extends JpaRepository<ProductsEntity, Integer> {

	@Query("select p from ProductsEntity p where p.product_id= ?1")
	public ProductsEntity getProductId(int product_id);
	
}
