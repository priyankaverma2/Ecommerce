package com.npci.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "login_logs")
@Data
public class LoginLogsEntity {

	@Column(name = "log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int log_id;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "time_stamp")
	private LocalDate time_stamp;
	
}
