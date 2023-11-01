package com.npci.service;

import java.util.Map;

import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.UserNotFound;

public interface UserService {

	public UserEntity signUp(UserEntity user) throws UserAlreadyExist;

	public UserEntity login(Map<String, String> credentials) throws UserNotFound;

	public TicketsEntity raiseTicket( Map<String, String> ticket) throws UserNotFound;

	public UserEntity editProfile(UserEntity user) throws UserNotFound;

	public UserEntity funds(Map<String, String> userfund) throws UserNotFound;

}
