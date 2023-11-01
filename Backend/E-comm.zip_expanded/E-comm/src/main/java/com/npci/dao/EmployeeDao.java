package com.npci.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.npci.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

	@Query("select e from EmployeeEntity e where e.email= ?1")
	public EmployeeEntity getEmployee(String email);
}
