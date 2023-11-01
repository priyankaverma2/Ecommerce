package com.npci.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "orders")

public class OrdersEntity {

	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int order_id;
	
	@Column(name = "time_stamp")
	private LocalDateTime time_stamp;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "amount")
	private double amount;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private int user_id_ref;

	public OrdersEntity() {
		super();
	}

	public OrdersEntity(int order_id, LocalDateTime time_stamp, String status, double amount, int user_id_ref) {
		super();
		this.order_id = order_id;
		this.time_stamp = time_stamp;
		this.status = status;
		this.amount = amount;
		this.user_id_ref = user_id_ref;
	}


	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {

		this.time_stamp = time_stamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getUser_id_ref() {
		return user_id_ref;
	}

	public void setUser_id_ref(int user_id_ref) {
		this.user_id_ref = user_id_ref;
	}

	@Override
	public String toString() {
		return "OrdersEntity [order_id=" + order_id + ", time_stamp=" + time_stamp + ", status=" + status + ", amount="
				+ amount + ", user_id_ref=" + user_id_ref + "]";
	}

	
	
}
