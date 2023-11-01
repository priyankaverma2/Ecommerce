package com.npci.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AuditLogsDao;
import com.npci.dao.EmployeeDao;
import com.npci.dao.ExceptionDao;
import com.npci.dao.LoginLogsDao;
import com.npci.dao.OrdersDao;
import com.npci.dao.TicketsDao;
import com.npci.dao.UserDao;
import com.npci.entity.AccountEntity;
import com.npci.entity.AuditLogsEntity;
import com.npci.entity.EmployeeEntity;
import com.npci.entity.ExceptionsEntity;
import com.npci.entity.LoginLogsEntity;
import com.npci.entity.OrdersEntity;
import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.EmployeeNotFound;
import com.npci.exceptions.UserNotFound;
import com.npci.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
    @Autowired
	LoginLogsDao loginLogsDao;
    
    @Autowired
    AuditLogsDao auditlogsDao;
    
    @Autowired
    TicketsDao ticketDao;
    
    @Autowired 
    UserDao userDao;
    
    @Autowired
    OrdersDao ordersDao;
    
    LoginLogsEntity loginLogsEntity = new LoginLogsEntity(); 
    
    ExceptionsEntity ex = new ExceptionsEntity(); 
    
    @Autowired
    private ExceptionDao exceptionDao;
   
	@Override
	public EmployeeEntity login(String email, String password) throws EmployeeNotFound {
		EmployeeEntity e = employeeDao.login(email);
		
		 loginLogsEntity.setRole(EmployeeEntity.class.getSimpleName());
		 
		 loginLogsEntity.setTime_stamp(LocalDateTime.now());
		 
		 
		if(e!=null) {
			
		 if(e.getPassword().equals(password)) {
			 
			 loginLogsEntity.setDesc("employee is registered successfully");
			 loginLogsEntity.setRole_id(e.getEmployee_id());
			 loginLogsDao.save(loginLogsEntity);
			 return e;
	      }else{
				 loginLogsEntity.setDesc("Unauthorized! password is not correct");
				 loginLogsEntity.setRole_id(0);
				 loginLogsDao.save(loginLogsEntity);
				 throw new EmployeeNotFound("Unauthorized! password is not correct");
	      }
		}
		
		ex.setDesc("Employee is not valid");
		ex.setEndpoint("/employee/login");
		ex.setRole(0);
		ex.setTime_stamp(LocalDateTime.now());
		ex.setRole_id(0);
		ex.setName("Credentials are not valid");
		exceptionDao.save(ex);
		throw new EmployeeNotFound("Credentials are not valid");
	}

	@Override
	public EmployeeEntity EditPassword(int employee_id, String Updatedpassword) {
		EmployeeEntity e = employeeDao.findById(employee_id).orElse(null);
		 
		AuditLogsEntity aud = new AuditLogsEntity(); 
		
		if(e!=null) {
			e.setPassword(Updatedpassword);
			return employeeDao.save(e);
		}
		
		return null;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public UserEntity getByid(int id) throws UserNotFound {
		Optional<UserEntity> op = userDao.findById(id);
		return op.orElseThrow(()-> new UserNotFound("user is not avaliable"));
		
	}

	@Override
	public UserEntity getByEmail(String email) throws UserNotFound {
		UserEntity user = userDao.getByEmail(email);
		return user;
	}

	@Override
	public TicketsEntity getTicketByUser(UserEntity user) {
		TicketsEntity ticket = ticketDao.ticketEntity(user);
		return ticket;
	}

	@Transactional
	@Override
	public TicketsEntity updateTicketStatus(int ticketId) {
		return ticketDao.updateTicketStatus(ticketId);
		
		
		//return null;
	}

	@Override
	public List<OrdersEntity> getAllOrders() {
		return ordersDao.findAll();
	}

	@Override
	public Optional<OrdersEntity> getOrderByid(int order_id) {
		
		 return ordersDao.findById(order_id);
		
	}

	@Override
	public Map<String, String> updateOrderStatus(String order_id, String order_status) {
		                  
		int orderId = Integer.parseInt(order_id);
		OrdersEntity order = ordersDao.findById(orderId).get();
		if(order.getStatus() == "shipped") {
			order.setStatus("out for deliverey");
	    if(order.getStatus() == "out for delivery") {
				order.setStatus("delivered");
		}if(order.getStatus() == "Delivered") {
			order.setStatus("cancelled");
		}if(order.getStatus() == "cancelled") {
			
			AccountEntity account = new AccountEntity();
		}
		
		}
		
		

		
		
		
		      
		return null; 
	}


	
	
	
}
