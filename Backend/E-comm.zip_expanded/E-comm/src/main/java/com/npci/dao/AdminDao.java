package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.npci.entity.AdminEntity;

public interface AdminDao extends JpaRepository<AdminEntity, Integer> {

	@Query("select a from AdminEntity a where a.email= ?1")
	public AdminEntity getAdmin(String email);
	

}
