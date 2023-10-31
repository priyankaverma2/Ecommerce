package com.npci.entity;

import java.time.LocalDate;

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
@Data
public class OrdersEntity {

	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int order_id;
	
	@Column(name = "time_stamp")
	private LocalDate time_stamp;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "amount")
	private String amount;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private UserEntity user_id_ref;
	
}
