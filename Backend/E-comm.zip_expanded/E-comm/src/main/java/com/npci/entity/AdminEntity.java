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
}
