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
@Table(name = "account")
@Data
public class UserEntity {

	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private int last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private int password;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "funds")
	private int funds;
	
	@Column(name = "login_counter")
	private String login_counter;
	
	@Column(name = "status")
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_number_ref")
	private AccountEntity account_number_ref;
	
}
