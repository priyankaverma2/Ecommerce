package com.npci.service;

import java.util.List;
import java.util.Map;

import com.npci.entity.CartEntity;
import com.npci.entity.OrdersEntity;
import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.NotFound;

public interface UserService {

	public UserEntity signUp(UserEntity user) throws UserAlreadyExist;

	public UserEntity login(Map<String, String> credentials) throws NotFound;

	public TicketsEntity raiseTicket( Map<String, String> ticket) throws NotFound;

	public UserEntity editProfile(UserEntity user) throws NotFound;

	public UserEntity funds(Map<String, String> userfund) throws NotFound;

	public CartEntity addToCart(Map<String, String> cartitem) throws NotFound;

	public String deleteFromCart(int cardId, int productId) throws NotFound;

	public List<CartEntity> showCart(int userId) throws NotFound;

	public OrdersEntity checkout(int userId) throws NotFound;

	public List<OrdersEntity> orders(int userId) throws NotFound;

}
