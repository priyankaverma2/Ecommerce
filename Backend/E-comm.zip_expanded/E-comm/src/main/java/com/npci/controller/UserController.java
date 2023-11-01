package com.npci.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.UserNotFound;
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
		} catch (UserNotFound e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping(path="/raiseTicket")
	public ResponseEntity<Object> raiseTicket(@RequestBody  Map<String, String> ticket){
		try {
			return ResponseEntity.status(201).body(userService.raiseTicket(ticket));
		} catch (UserNotFound e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping(path="/editProfile")
	public ResponseEntity<Object> editProfile(@RequestBody UserEntity user){
		try {
			return ResponseEntity.status(201).body(userService.editProfile(user));
		} catch (UserNotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(409).body(e.getMessage());
		}
	}
	@PostMapping(path="/funds")
	public ResponseEntity<Object> funds(@RequestBody Map<String, String> userfund ){
		try {
			return ResponseEntity.status(200).body(userService.funds(userfund));
		} catch (UserNotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@PostMapping(path="/addToCart")
	public ResponseEntity<Object> addToCart(@RequestBody Map<String, String> cartitem ){
		try {
			return ResponseEntity.status(200).body(userService.addToCart(cartitem));
		} catch (UserNotFound e) {
			
			System.err.println(e.getMessage());
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
