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
@Table(name = "audit_logs")
@Data
public class AuditLogsEntity {

	@Column(name = "audit_log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int audit_log_id;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "endpoint")
	private String endpoint;
	
	@Column(name = "time_stamp")
	private LocalDate time_stamp;
	
}
