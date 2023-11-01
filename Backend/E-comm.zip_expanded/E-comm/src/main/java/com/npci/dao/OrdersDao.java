package com.npci.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.entity.OrdersEntity;

public interface OrdersDao extends JpaRepository<OrdersEntity, Integer> {

	@Query("select o from OrdersEntity o where o.user_id_ref=?1")
	public List<OrdersEntity> orders(int orderId);


}
