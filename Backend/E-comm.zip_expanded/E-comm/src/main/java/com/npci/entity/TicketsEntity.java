package com.npci.entity;

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
@Table(name = "tickets")
@Data
public class TicketsEntity {

	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int ticket_id;
	
	@Column(name = "time_stamp")
	private String time_stamp;
	
	@Column(name = "desc")
	private int desc;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private UserEntity user_id_ref;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "approved_by_ref")
	private EmployeeEntity approved_by_ref;
	
	

}
