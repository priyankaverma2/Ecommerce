package com.npci.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.entity.ProductsEntity;
@Repository
public interface ProductsRepo extends JpaRepository<ProductsEntity, Integer> {
	


}
