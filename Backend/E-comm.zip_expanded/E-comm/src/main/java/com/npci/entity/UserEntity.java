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
@Table(name = "user")

public class UserEntity {

	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "funds")
	private int funds;
	
	@Column(name = "login_counter")
	private int login_counter;
	
	@Column(name = "status")
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_number_ref")
	private AccountEntity account_number_ref;

	public UserEntity() {
		super();
	}

	public UserEntity(int user_id, String first_name, String last_name, String email, String password, String phone,
			LocalDate dob, String address, int funds, int login_counter, int status,
			AccountEntity account_number_ref) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
		this.funds = funds;
		this.login_counter = login_counter;
		this.status = status;
		this.account_number_ref = account_number_ref;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public int getLogin_counter() {
		return login_counter;
	}

	public void setLogin_counter(int login_counter) {
		this.login_counter = login_counter;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AccountEntity getAccount_number_ref() {
		return account_number_ref;
	}

	public void setAccount_number_ref(AccountEntity account_number_ref) {
		this.account_number_ref = account_number_ref;
	}

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + ", phone=" + phone + ", dob=" + dob + ", address=" + address
				+ ", funds=" + funds + ", login_counter=" + login_counter + ", status=" + status
				+ ", account_number_ref=" + account_number_ref + "]";
	}
	
	
}
