package com.npci.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.npci.entity.EmployeeEntity;
import com.npci.entity.OrdersEntity;
import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.EmployeeNotFound;
import com.npci.exceptions.UserNotFound;

public interface EmployeeService  {

	public EmployeeEntity login(String email, String password) throws EmployeeNotFound;
	
	public EmployeeEntity EditPassword(int employee_id , String Updatedpassword);
	
	public List<UserEntity> getAllUsers();
	
	
	public UserEntity getByid(int id) throws UserNotFound;
	
	public UserEntity getByEmail(String email) throws UserNotFound;
	
	public TicketsEntity getTicketByUser(UserEntity user);
	
	public TicketsEntity updateTicketStatus(int ticketId);
	
	public List<OrdersEntity> getAllOrders();
	
	public Optional<OrdersEntity> getOrderByid(int order_id);
	
	public Map<String , String> updateOrderStatus(String order_id , String order_status);
 


}
