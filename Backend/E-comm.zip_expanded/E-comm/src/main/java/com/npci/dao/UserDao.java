package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
	@Query("select u from UserEntity u where u.email=?1")
	public UserEntity findByEmail(String email);
	
	

}
