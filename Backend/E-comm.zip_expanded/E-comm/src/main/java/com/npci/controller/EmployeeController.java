package com.npci.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.dao.LoginLogsDao;
import com.npci.dao.ProductRequestRepo;
import com.npci.dao.ProductsRepo;
import com.npci.entity.EmployeeEntity;
import com.npci.entity.OrdersEntity;
import com.npci.entity.ProductRequestEntity;
import com.npci.entity.ProductsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.EmployeeNotFound;
import com.npci.exceptions.UserNotFound;
import com.npci.service.EmployeeService;
import com.npci.utils.LoginParams;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProductRequestRepo productRequestRepo;

	@Autowired
	ProductsRepo productRepo;

//	@Autowired
//	LoginParams loginparams; 

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginParams loginparams) {
		try {
			return ResponseEntity.status(201)
					.body(employeeService.login(loginparams.getEmail(), loginparams.getPassword()));
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			// e.printStackTrace();
			return ResponseEntity.status(404).body(e.getMessage());
		}

	}

	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> map) {
		EmployeeEntity updatedEmployee = employeeService.EditPassword(Integer.parseInt(map.get("employeeId")),
				map.get("updatePassword"));

		if (updatedEmployee != null) {
			return ResponseEntity.ok("Password updated successfully.");
		} else {
			return ResponseEntity.badRequest().body("Unable to update the password.");
		}
	}

	  @GetMapping("/getallusers")
	  public ResponseEntity<List<UserEntity>> allusers(){
		return  ResponseEntity.status(200).body( employeeService.getAllUsers());
		//  return (ResponseEntity<List<UserEntity>>) employeeService.getAllUsers();
	  }
	  
//	  @GetMapping("/getby{Id}")
//	  public ResponseEntity<UserEntity>> getbyId(@Pathvariable ("id") int id){
//		  return ResponseEntity.status(200).body(employeeService.getByid(id));
//	  }
	  
	  @GetMapping("/getby/{id}")
	  public ResponseEntity<UserEntity> getbyId(@PathVariable("id") int id) {
		  UserEntity user = new UserEntity();
	      try {
	    	  user = employeeService.getByid(id);
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return ResponseEntity.status(200).body(user);
	  }

	@PostMapping("/sendrequest/quantity_change")
	public ResponseEntity<ProductRequestEntity> changeProductQuantity(@RequestBody ProductRequestEntity requestEntity) {

		productRequestRepo.save(requestEntity);

		return ResponseEntity.ok().body(requestEntity);
	}

	@PostMapping("quantity_change/requestResponce/{quantitystatus}")
	public ResponseEntity<String> changeProductQuantity(@RequestBody HashMap<String, Integer> requestMap,
			@PathVariable Boolean quantitystatus , String quantityAction) {

		if (requestMap != null && quantitystatus != null) {
			Integer request_id = requestMap.get("request_id");
			Integer product_id = requestMap.get("product_id_ref");
			Integer quntity = requestMap.get("quantity");
			Boolean status = quantitystatus;
			Integer action =  requestMap.get("action");
		

			if (status == true) {
				Optional<ProductsEntity> product = productRepo.findById(product_id);
				ProductsEntity foundProduct = product.get();
				Integer currentQuantity = foundProduct.getQuantity();
				Optional<ProductRequestEntity> request = productRequestRepo.findById(request_id);

				ProductRequestEntity requestObject = request.get();
				if (product != null && request != null) {
					
					if(action==1) {
						Integer totalQuantity = quntity + currentQuantity;
						foundProduct.setQuantity(totalQuantity);
						
					}else {
						if(quntity>currentQuantity && quntity!=0) {
							Integer totalQuantity = quntity - currentQuantity;
							foundProduct.setQuantity(totalQuantity);
						}else {
							
							Integer totalQuantity = currentQuantity-quntity;
							foundProduct.setQuantity(totalQuantity);
							
						}
					
					}

					requestObject.setStatus(true);
					productRepo.save(foundProduct);
					productRequestRepo.save(requestObject);

				} else {

					return null;

				}

			}

		}

		return ResponseEntity.ok().body("donne");
	}
	
	
	
	  @PostMapping("/tickets")
	  public ResponseEntity<Object> tickets(@RequestBody String email) {
		  UserEntity user = new UserEntity();
		try {
			user = employeeService.getByEmail(email);
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return ResponseEntity.status(200).body(employeeService.getTicketByUser(user));
	  }
	  
      
	  @PutMapping("/tickets/{ticketId}")
	  public ResponseEntity<Object> ticketId(@PathVariable("ticketId") int ticketId) {
		return  ResponseEntity.status(200).body(employeeService.updateTicketStatus(ticketId));
	  }
	  
	  @GetMapping("/getallorders")
	  public ResponseEntity<List<OrdersEntity>> allorders(){
		return  ResponseEntity.status(200).body( employeeService.getAllOrders());
		//  return (ResponseEntity<List<UserEntity>>) employeeService.getAllUsers();
	  }
	  
	  
	  @GetMapping("/getordersby/{order_id}")
	  public ResponseEntity<Optional<OrdersEntity>> getordersbyId(@PathVariable("order_id") int order_id) {
//		  UserEntity user = new UserEntity();
		  Optional<OrdersEntity> orders;
		orders = employeeService.getOrderByid(order_id);
		
	      return ResponseEntity.status(200).body(orders);
	  }
	  
	  

}



