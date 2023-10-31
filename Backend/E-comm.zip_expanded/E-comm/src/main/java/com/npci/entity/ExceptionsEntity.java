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
@Table(name = "exceptions")
@Data
public class ExceptionsEntity {

	
	@Column(name = "exception_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int exception_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "role")
	private int role;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "endpoint")
	private String endpoint;
	
	@Column(name = "time_stamp")
	private LocalDate time_stamp;
	
	
}
