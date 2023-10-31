package com.npci.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
	
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int account_number;
	
	@Column(name = "amount")
	private String amount;

}
