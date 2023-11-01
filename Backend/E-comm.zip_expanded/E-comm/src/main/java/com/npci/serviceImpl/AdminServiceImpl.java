package com.npci.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AdminDao;
import com.npci.dao.EmployeeDao;
import com.npci.dao.ProductDao;
import com.npci.entity.AdminEntity;
import com.npci.entity.EmployeeEntity;
import com.npci.entity.ProductsEntity;
import com.npci.exceptions.AdminNotFoundException;
import com.npci.exceptions.EmployeeNotFoundException;
import com.npci.exceptions.ProductIDNotFoundException;
import com.npci.service.AdminService;

import jakarta.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService{


	@Autowired
	private AdminDao admindao;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private EmployeeDao employeedao;

	public AdminServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	// creating-admin
	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}


	public void setProductdao(ProductDao productdao) {
		this.productdao = productdao;
	}


	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}


	@Override
	@Transactional
	public AdminEntity createAdmin(AdminEntity admin) {
		return admindao.save(admin);//saving-admin
	}

	// admin-login
	@Override
	@Transactional
	public AdminEntity login(String email, String password) throws AdminNotFoundException {
		//getting email from the database
		 AdminEntity admin = admindao.getAdmin(email);
		//check if password is correct or not -if correct return admin-object
		if (admin.getPassword().equals(password)) {
			return admin;
		}
		//throws exception if admin-email not found
		throw new AdminNotFoundException("Admin not found with this email " + email + " (or) Incorrect Password");
	}

	// admin-adding product
	@Override
	@Transactional
	public ProductsEntity addProduct(ProductsEntity product) {
		return productdao.save(product);//saving product into the database
	}

	// admin-list of all products
	@Override
	@Transactional
	public List<ProductsEntity> allProducts() {
		return productdao.findAll();//finding all the products in the database
	}

	// admin-updating products - price and quantity
	@Override
	public ProductsEntity updateProduct(int product_id,double amount,int quantity) throws ProductIDNotFoundException {
		 ProductsEntity product = productdao.findById(product_id).orElse(null);
	        if (product != null) {
	            product.setAmount(amount);
	            product.setQuantity(quantity);
	            return productdao.save(product);
	        } 
	       //throws exception if product_id not found
			throw new ProductIDNotFoundException("Product with the id " + product_id + " Not Found"); 
	}

	// admin-delete products
	@Override
	public boolean delProduct(int product_id) throws ProductIDNotFoundException {

		//delete only if id exists in the database
		if (productdao.existsById(product_id)) {
			productdao.deleteById(product_id);
			return true;
		}
		//throws exception if product_id not found
		throw new ProductIDNotFoundException("Product with the id " + product_id + " Not Found");

	}

	// admin-add employees
	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		return employeedao.save(employee);//saving employee
	}
	
	//admin-list of all employees
	@Override
	@Transactional
	public List<EmployeeEntity> allEmployees() {
		return employeedao.findAll();//finding all the employees in the database 
	}
	

	// admin-delete employee
	public boolean deleteEmployeeById(int employee_id) throws EmployeeNotFoundException {
		//delete employee only if employee-id is present in the database
		if (employeedao.existsById(employee_id)) {
			employeedao.deleteById(employee_id);
			return true;
		}
		//throws exception if employee_id not found
		throw new EmployeeNotFoundException("Employee with the id " + employee_id + " Not Found");
	}

	// admin-view all employees
	@Override
	public void viewRequests() {
		// TODO Auto-generated method stub

	}

	//generate reports
	@Override
	public void generateReports() {
		// TODO Auto-generated method stub
	}

}
