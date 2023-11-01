package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.TicketsEntity;

public interface TicketsDao extends JpaRepository<TicketsEntity, Integer>{

}
