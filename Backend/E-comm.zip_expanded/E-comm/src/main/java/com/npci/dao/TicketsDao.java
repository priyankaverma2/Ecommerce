package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;

import jakarta.transaction.Transactional;

public interface TicketsDao extends JpaRepository<TicketsEntity, Integer> {
	
	@Query("select a from TicketsEntity a where user_id_ref = ?1")
	public TicketsEntity ticketEntity(UserEntity user);
	
    
    @Transactional
	@Query("UPDATE TicketsEntity a SET a.status = 'True' WHERE a.ticket_id = ?1")
	public TicketsEntity updateTicketStatus(int ticketId);

}
