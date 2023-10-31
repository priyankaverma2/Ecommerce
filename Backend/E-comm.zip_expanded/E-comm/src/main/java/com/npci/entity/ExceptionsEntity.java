package com.npci.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "exceptions")
public class ExceptionsEntity {

	
	@Column(name = "exception_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int exception_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description ")
	private String desc;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "endpoint")
	private String endpoint;
	
	@Column(name = "time_stamp")
	private LocalDateTime time_stamp;

	public ExceptionsEntity() {
		super();
	}

	public ExceptionsEntity(int exception_id, String name, String desc, String role, int role_id, String endpoint,
			LocalDateTime time_stamp) {
		super();
		this.exception_id = exception_id;
		this.name = name;
		this.desc = desc;
		this.role = role;
		this.role_id = role_id;
		this.endpoint = endpoint;
		this.time_stamp = time_stamp;
	}

	public int getException_id() {
		return exception_id;
	}

	public void setException_id(int exception_id) {
		this.exception_id = exception_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "ExceptionsEntity [exception_id=" + exception_id + ", name=" + name + ", desc=" + desc + ", role=" + role
				+ ", role_id=" + role_id + ", endpoint=" + endpoint + ", time_stamp=" + time_stamp + "]";
	}
	
	
}
