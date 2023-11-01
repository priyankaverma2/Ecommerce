package com.npci.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.npci.entity.AdminEntity;
import com.npci.entity.EmployeeEntity;
import com.npci.entity.ProductsEntity;
import com.npci.exceptions.AdminNotFoundException;
import com.npci.exceptions.EmployeeNotFoundException;
import com.npci.exceptions.ProductIDNotFoundException;
import com.npci.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;

	// saving-admin
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveAdmin(@RequestBody AdminEntity admin) {
		AdminEntity a = adminservice.createAdmin(admin);
		return ResponseEntity.status(200).body(a);
	}

	// admin-login with email and password
	@GetMapping(path ="/login/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		try {
			return ResponseEntity.status(200).body(adminservice.login(email, password));
		} catch (AdminNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(200).body(map);
		}
	}

	// admin-adding products
	@PostMapping(path = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addProduct(@RequestBody ProductsEntity product) {
		ProductsEntity p = adminservice.addProduct(product);
		return ResponseEntity.status(200).body(p);
	}

	// admin-deleting products
	@DeleteMapping(path = "/deleteproduct/{product_id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int product_id) {

		try {
			boolean result = adminservice.delProduct(product_id);
			return ResponseEntity.status(200).body(result);
		} catch (ProductIDNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(200).body(map);
		}

	}

	// admin-getting all the products
	@GetMapping(path = "/productsList")
	public ResponseEntity<Object> getAllProducts() {
		List<ProductsEntity> products = adminservice.allProducts();
		return ResponseEntity.status(200).body(products);
	}

	// admin-adding the employee
	@PostMapping(path = "/addemployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity emp = adminservice.addEmployee(employee);
		return ResponseEntity.status(200).body(emp);
	}

	// admin-delete employee
	@DeleteMapping("/deleteemployee/{employee_id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("employee_id") int employee_id) {
		try {
			boolean emp = adminservice.deleteEmployeeById(employee_id);
			return ResponseEntity.status(200).body(emp);
		} catch (EmployeeNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(200).body(map);
		}
	}

	// admin-getting all the employees
	@GetMapping(path = "/getallemployees")
	public ResponseEntity<Object> getAllEmployees() {
		List<EmployeeEntity> employees = adminservice.allEmployees();
		return ResponseEntity.status(200).body(employees);
	}
	
	 @PutMapping("/updateproduct/{product_id}")
	    public ResponseEntity<Object> updateProduct(@PathVariable int product_id, @RequestParam double amount, @RequestParam int quantity) {
	        try {
				ProductsEntity p=adminservice.updateProduct(product_id, amount, quantity);
				return ResponseEntity.status(200).body(p);
			} catch (ProductIDNotFoundException e) {
				Map<String, String> map = new HashMap<>();
				map.put("error", e.getMessage());
				return ResponseEntity.status(200).body(map);
			}
	    }
}
