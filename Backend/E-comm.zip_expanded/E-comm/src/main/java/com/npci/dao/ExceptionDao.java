package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.ExceptionsEntity;

public interface ExceptionDao extends JpaRepository<ExceptionsEntity, Integer>{

}
