package com.npci.entity;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {

	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int product_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "image_url")
	private String image_url;
	
	@Column(name = "category")
	private String category;

	public ProductsEntity(int product_id, String name, int quantity, String description, double amount, boolean status,
			String image_url, String category) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.image_url = image_url;
		this.category = category;
	}

	public ProductsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
