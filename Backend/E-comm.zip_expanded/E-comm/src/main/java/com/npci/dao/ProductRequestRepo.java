package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.ProductRequestEntity;

public interface ProductRequestRepo extends JpaRepository<ProductRequestEntity, Integer> {

}
