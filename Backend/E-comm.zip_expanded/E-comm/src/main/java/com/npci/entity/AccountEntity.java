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

public class AccountEntity {
	
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int account_number;
	
	@Column(name = "amount")
	private String amount;

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountEntity [account_number=" + account_number + ", amount=" + amount + "]";
	}
	
	
	

}
