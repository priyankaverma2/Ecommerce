package com.npci.service;

import java.util.List;


import com.npci.entity.AdminEntity;
import com.npci.entity.EmployeeEntity;
import com.npci.entity.ProductsEntity;
import com.npci.exceptions.AdminNotFoundException;
import com.npci.exceptions.EmployeeNotFoundException;
import com.npci.exceptions.ProductIDNotFoundException;

public interface AdminService {

	AdminEntity createAdmin(AdminEntity adminEntity);
	AdminEntity login(String email, String password) throws AdminNotFoundException;
	ProductsEntity addProduct(ProductsEntity product);
	List<ProductsEntity> allProducts();
	ProductsEntity updateProduct(int product_id, double amount, int quantity) throws ProductIDNotFoundException;
	boolean delProduct(int product_id) throws ProductIDNotFoundException;
	EmployeeEntity addEmployee(EmployeeEntity employee);
	List<EmployeeEntity> allEmployees();
	boolean deleteEmployeeById(int employee_id) throws EmployeeNotFoundException;
	void viewRequests();
	void generateReports();

}
