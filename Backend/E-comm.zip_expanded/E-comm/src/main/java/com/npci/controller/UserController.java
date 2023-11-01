package com.npci.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.NotFound;
import com.npci.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/signUp")
	public ResponseEntity<Object> signUp(@RequestBody UserEntity user){
		try {
			return ResponseEntity.status(201).body(userService.signUp(user));
		} catch (UserAlreadyExist e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(409).body(e.getMessage());
		}
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials){
		try {
			return ResponseEntity.status(200).body(userService.login(credentials));
		} catch (NotFound e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping(path="/raiseTicket")
	public ResponseEntity<Object> raiseTicket(@RequestBody  Map<String, String> ticket){
		try {
			return ResponseEntity.status(201).body(userService.raiseTicket(ticket));
		} catch (NotFound e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping(path="/editProfile")
	public ResponseEntity<Object> editProfile(@RequestBody UserEntity user){
		try {
			return ResponseEntity.status(201).body(userService.editProfile(user));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(409).body(e.getMessage());
		}
	}
	
	
	@PostMapping(path="/funds")
	public ResponseEntity<Object> funds(@RequestBody Map<String, String> userfund ){
		try {
			return ResponseEntity.status(200).body(userService.funds(userfund));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@PostMapping(path="/addToCart")
	public ResponseEntity<Object> addToCart(@RequestBody Map<String, String> cartitem ){
		try {
			return ResponseEntity.status(200).body(userService.addToCart(cartitem));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@DeleteMapping(path="/deleteFromCart/{cartId}/{productId}")
	public ResponseEntity<Object> deleteFromCart(@PathVariable("cartId") int cardId,@PathVariable("productId") int productId){
		try {
			return ResponseEntity.status(200).body(userService.deleteFromCart(cardId,productId));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@GetMapping(path="/showCart/{userId}")
	public ResponseEntity<Object> showCart(@PathVariable("userId") int userId){
		try {
			return ResponseEntity.status(200).body(userService.showCart(userId));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@PostMapping(path="/checkout/{userId}")
	public ResponseEntity<Object> checkout(@PathVariable("userId") int userId){
		try {
			return ResponseEntity.status(200).body(userService.checkout(userId));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@GetMapping(path="/orders/{userId}")
	public ResponseEntity<Object> orders(@PathVariable("userId") int userId){
		try {
			return ResponseEntity.status(200).body(userService.orders(userId));
		} catch (NotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
