package com.npci.entity;

import java.time.LocalDateTime;

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
public class TicketsEntity {

	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int ticket_id;
	
	@Column(name = "time_stamp")
	private LocalDateTime time_stamp;
	
	@Column(name = "description")

	private String desc;

	
	@Column(name = "status")
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_ref")
	private UserEntity user_id_ref;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "approved_by_ref")
	private EmployeeEntity approved_by_ref;

	public TicketsEntity() {
		super();

	}

	public TicketsEntity(int ticket_id, LocalDateTime time_stamp, String desc, int status, UserEntity user_id_ref,

			EmployeeEntity approved_by_ref) {
		super();
		this.ticket_id = ticket_id;
		this.time_stamp = time_stamp;

		this.desc = desc;

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

	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {

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

	@Override
	public String toString() {
		return "TicketsEntity [ticket_id=" + ticket_id + ", time_stamp=" + time_stamp + ", desc=" + desc + ", status="
				+ status + ", user_id_ref=" + user_id_ref + ", approved_by_ref=" + approved_by_ref + "]";
	}

	
	

}
