package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.AuditLogsEntity;

public interface AuditLogsDao extends JpaRepository<AuditLogsEntity, Integer>{

}
