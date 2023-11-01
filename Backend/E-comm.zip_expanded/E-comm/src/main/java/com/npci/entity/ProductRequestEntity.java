package com.npci.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_requests")


public class ProductRequestEntity {
	
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer request_id;
	
	@Column(name = "product_id_ref")
	private Integer product_id_ref;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	

	@Column(name = "action")
	private String action;
	
	@Column(name = "status")
	private Boolean status;

	public ProductRequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductRequestEntity(Integer request_id, Integer product_id_ref, Integer quantity, String action,
			Boolean status) {
		super();
		this.request_id = request_id;
		this.product_id_ref = product_id_ref;
		this.quantity = quantity;
		this.action = action;
		this.status = status;
	}

	public Integer getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}

	public Integer getProduct_id_ref() {
		return product_id_ref;
	}

	public void setProduct_id_ref(Integer product_id_ref) {
		this.product_id_ref = product_id_ref;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductRequestEntity [request_id=" + request_id + ", product_id_ref=" + product_id_ref + ", quantity="
				+ quantity + ", action=" + action + ", status=" + status + "]";
	}
	
	
	
	


	
	
}