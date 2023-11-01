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

	public ProductsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsEntity(int product_id, String name, Integer quantity, String desc, String amount, int status,
			String image_url) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.quantity = quantity;
		this.desc = desc;
		this.amount = amount;
		this.status = status;
		this.image_url = image_url;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public String toString() {
		return "ProductsEntity [product_id=" + product_id + ", name=" + name + ", quantity=" + quantity + ", desc="
				+ desc + ", amount=" + amount + ", status=" + status + ", image_url=" + image_url + "]";
	}
	


	
	
