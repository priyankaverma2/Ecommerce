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
	private double amount;

	public AccountEntity() {
		super();
	}

	public AccountEntity(int account_number, double amount) {
		super();
		this.account_number = account_number;
		this.amount = amount;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountEntity [account_number=" + account_number + ", amount=" + amount + "]";
	}
	

}
