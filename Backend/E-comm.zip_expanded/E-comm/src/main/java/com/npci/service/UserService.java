package com.npci.service;

import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;

public interface UserService {

	public UserEntity signUp(UserEntity user) throws UserAlreadyExist;

}
