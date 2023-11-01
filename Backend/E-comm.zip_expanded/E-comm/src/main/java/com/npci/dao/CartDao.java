package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.CartEntity;

public interface CartDao extends JpaRepository<CartEntity, Integer> {

}
