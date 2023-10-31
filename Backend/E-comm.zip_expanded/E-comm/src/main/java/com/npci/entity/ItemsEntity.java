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
@Table(name = "items")
@Data
public class ItemsEntity {
	
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int item_id;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "price")
	private String price;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id_ref")
	private OrdersEntity order_id_ref;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id_ref")
	private ProductsEntity product_id_ref;

}
