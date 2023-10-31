package com.npci.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductsEntity {

	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int product_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "image_url")
	private String image_url;
	
	@Column(name = "category")
	private String category;
	
}
