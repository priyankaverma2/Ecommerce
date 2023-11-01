package com.npci.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class CartEntity {
	
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cart_id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private UserEntity user_id_ref;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id_ref")
	private ProductsEntity product_id_ref;

	public CartEntity() {
		super();
	}

	public CartEntity(int cart_id, UserEntity user_id_ref, ProductsEntity product_id_ref) {
		super();
		this.cart_id = cart_id;
		this.user_id_ref = user_id_ref;
		this.product_id_ref = product_id_ref;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public UserEntity getUser_id_ref() {
		return user_id_ref;
	}

	public void setUser_id_ref(UserEntity user_id_ref) {
		this.user_id_ref = user_id_ref;
	}

	public ProductsEntity getProduct_id_ref() {
		return product_id_ref;
	}

	public void setProduct_id_ref(ProductsEntity product_id_ref) {
		this.product_id_ref = product_id_ref;
	}

	@Override
	public String toString() {
		return "CartEntity [cart_id=" + cart_id + ", user_id_ref=" + user_id_ref + ", product_id_ref=" + product_id_ref
				+ "]";
	}
	
	
	

}
