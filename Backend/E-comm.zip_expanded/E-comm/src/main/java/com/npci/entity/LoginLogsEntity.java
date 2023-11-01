package com.npci.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "login_logs")

public class LoginLogsEntity {

	@Column(name = "log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int log_id;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "time_stamp")
	private LocalDateTime time_stamp;


	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
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


	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
	}


  

	public LoginLogsEntity(int log_id, String desc, String role, int role_id, LocalDateTime time_stamp) {
		super();
		this.log_id = log_id;
		this.desc = desc;
		this.role = role;
		this.role_id = role_id;
		this.time_stamp = time_stamp;
	}

	public LoginLogsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "LoginLogsEntity [log_id=" + log_id + ", desc=" + desc + ", role=" + role + ", role_id=" + role_id
				+ ", time_stamp=" + time_stamp + "]";
	}
	

	
}
