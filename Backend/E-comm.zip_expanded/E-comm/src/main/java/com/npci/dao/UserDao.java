package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
	
	

}
