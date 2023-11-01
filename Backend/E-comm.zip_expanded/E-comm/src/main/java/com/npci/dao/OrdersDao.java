package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.entity.OrdersEntity;

public interface OrdersDao extends JpaRepository<OrdersEntity, Integer> {
	
	

}
