package com.npci.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "audit_logs")

public class AuditLogsEntity {

	@Column(name = "audit_log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int audit_log_id;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "endpoint")
	private String endpoint;
	
	@Column(name = "time_stamp")
	private LocalDateTime time_stamp;

	public AuditLogsEntity() {
		super();
	}

	public AuditLogsEntity(int audit_log_id, String desc, String role, int role_id, String endpoint,
			LocalDateTime time_stamp) {
		super();
		this.audit_log_id = audit_log_id;
		this.desc = desc;
		this.role = role;
		this.role_id = role_id;
		this.endpoint = endpoint;
		this.time_stamp = time_stamp;
	}

	public int getAudit_log_id() {
		return audit_log_id;
	}

	public void setAudit_log_id(int audit_log_id) {
		this.audit_log_id = audit_log_id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
	}

	@Override
	public String toString() {
		return "AuditLogsEntity [audit_log_id=" + audit_log_id + ", desc=" + desc + ", role=" + role + ", role_id="
				+ role_id + ", endpoint=" + endpoint + ", time_stamp=" + time_stamp + "]";
	}
	
	
}
