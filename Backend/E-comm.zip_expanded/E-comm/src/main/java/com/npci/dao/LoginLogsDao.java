package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.LoginLogsEntity;

public interface LoginLogsDao extends JpaRepository<LoginLogsEntity, Integer>{

}
