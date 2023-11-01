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
	
	@Column(name = "description")
	private int description;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private UserEntity user_id_ref;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "approved_by_ref")
	private EmployeeEntity approved_by_ref;

	public TicketsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketsEntity(int ticket_id, String time_stamp, int description, String status, UserEntity user_id_ref,
			EmployeeEntity approved_by_ref) {
		super();
		this.ticket_id = ticket_id;
		this.time_stamp = time_stamp;
		this.description = description;
		this.status = status;
		this.user_id_ref = user_id_ref;
		this.approved_by_ref = approved_by_ref;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getUser_id_ref() {
		return user_id_ref;
	}

	public void setUser_id_ref(UserEntity user_id_ref) {
		this.user_id_ref = user_id_ref;
	}

	public EmployeeEntity getApproved_by_ref() {
		return approved_by_ref;
	}

	public void setApproved_by_ref(EmployeeEntity approved_by_ref) {
		this.approved_by_ref = approved_by_ref;
	}
	
	
	
	
	

}
