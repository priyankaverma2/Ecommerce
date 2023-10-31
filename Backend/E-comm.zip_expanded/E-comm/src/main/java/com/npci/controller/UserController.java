package com.npci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
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
	

}
