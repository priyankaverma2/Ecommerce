package com.npci.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class AdminEntity {

	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int admin_id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private int name;
	
	@Column(name = "password")
	private String password;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminEntity(int admin_id, String email, int name, String password) {
		super();
		this.admin_id = admin_id;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdminEntity [admin_id=" + admin_id + ", email=" + email + ", name=" + name + ", password=" + password
				+ "]";
	}
	
	
}
