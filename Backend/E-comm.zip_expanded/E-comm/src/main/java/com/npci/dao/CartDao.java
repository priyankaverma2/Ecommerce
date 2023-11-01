package com.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.npci.entity.CartEntity;


import jakarta.transaction.Transactional;

public interface CartDao extends JpaRepository<CartEntity, Integer> {

	 	@Modifying
	    @Transactional
	    @Query("DELETE FROM CartEntity c WHERE c.cart_id = :cartId AND c.product_id_ref.product_id = :productId")
	    void deleteCartItem(@Param("cartId") int cartId, @Param("productId") int productId);
	 	@Query("SELECT c FROM CartEntity c WHERE c.user_id_ref.user_id = :userId")
	 	public List<CartEntity> showCart(@Param("userId") int userId);



}
