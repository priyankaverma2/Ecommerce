package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.npci.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity , Integer> {
	
		@Query("select p from EmployeeEntity p where p.email=?1")
		public EmployeeEntity login(String email);

}
