package com.npci.serviceImpl;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AuditLogsDao;
import com.npci.dao.ExceptionDao;
import com.npci.dao.LoginLogsDao;
import com.npci.dao.TicketsDao;
import com.npci.dao.UserDao;
import com.npci.entity.AccountEntity;
import com.npci.entity.AuditLogsEntity;
import com.npci.entity.ExceptionsEntity;
import com.npci.entity.LoginLogsEntity;
import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.UserNotFound;
import com.npci.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private AuditLogsDao auditLogsDao;
	
	@Autowired
	private ExceptionDao exceptionDao;
	
	@Autowired
	private LoginLogsDao loginLogsDao;
	
	@Autowired
	private TicketsDao ticketDao;
	
	@Override
	public UserEntity signUp(UserEntity user) throws UserAlreadyExist {
		AuditLogsEntity auditLogs = new AuditLogsEntity();
		auditLogs.setEndpoint("user/signUp");
		auditLogs.setRole(UserEntity.class.getSimpleName());
		auditLogs.setTime_stamp(LocalDateTime.now());
		UserEntity checkUser = userDao.findByEmail(user.getEmail());
		if (checkUser == null) {
			AccountEntity account = new AccountEntity(0, 50000);
			user.setAccount_number_ref(account);
			user.setFunds(1000);
			user.setLogin_counter(0);
			user.setStatus(1);
			UserEntity u = userDao.save(user);
			auditLogs.setRole_id(u.getUser_id());
			auditLogs.setDesc("user registered successfully");

			auditLogsDao.save(auditLogs);

			return u;
		}
		auditLogs.setRole_id(0);
		auditLogs.setDesc("user tried to register");
		auditLogsDao.save(auditLogs);
		ExceptionsEntity e = new ExceptionsEntity();
		e.setName(UserAlreadyExist.class.getSimpleName());
		e.setEndpoint("user/signUp");
		e.setRole(UserEntity.class.getSimpleName());
		e.setRole_id(0);
		e.setDesc("User with " + user.getEmail() + " already exist");
		e.setTime_stamp(LocalDateTime.now());
		exceptionDao.save(e);
		throw new UserAlreadyExist("User with " + user.getEmail() + " already exist");
	}

	@Override
	public UserEntity login(Map<String, String> credentials) throws UserNotFound {
		ExceptionsEntity e = new ExceptionsEntity();
		e.setEndpoint("user/login");
		e.setRole(UserEntity.class.getSimpleName());
		e.setName(UserNotFound.class.getSimpleName());
		e.setRole_id(0);
		e.setTime_stamp(LocalDateTime.now());
		
		LoginLogsEntity loginLogs=new LoginLogsEntity();
		loginLogs.setRole(UserEntity.class.getSimpleName());
		loginLogs.setTime_stamp(LocalDateTime.now());
		loginLogs.setRole_id(0);
		

		if (credentials == null) {
			
			loginLogs.setDesc("Login Credentials null!");
			loginLogsDao.save(loginLogs);
			
			e.setDesc("Login Credentials null!");
			exceptionDao.save(e);
			throw new UserNotFound("Login Credentials null!");
		}

		String email = credentials.get("email");
		String password = credentials.get("password");

		UserEntity user = userDao.findByEmail(email);

		if (user == null) {
			
			loginLogs.setDesc("User with " + email + " doesn't exist");
			loginLogsDao.save(loginLogs);
			
			e.setDesc("User with " + email + " doesn't exist");
			exceptionDao.save(e);
			throw new UserNotFound("User not found with email " + email);
		}
		if ( user.getLogin_counter()<=3) {
			if(user.getPassword().equals(password) && user.getStatus()==1) {
				
			loginLogs.setRole_id(user.getUser_id());
			loginLogs.setDesc("Logged In Successfully");
			loginLogsDao.save(loginLogs);
			return user;
			}else {
				user.setLogin_counter(user.getLogin_counter()+1);
				userDao.save(user);
				loginLogs.setRole_id(user.getUser_id());
				loginLogs.setDesc("Invalid password for " + user.getEmail());
				loginLogsDao.save(loginLogs);
				
				e.setDesc("Invalid password for " + user.getEmail());
				exceptionDao.save(e);
				throw new UserNotFound("Invalid Password!");
			}
		}else {
			loginLogs.setRole_id(user.getUser_id());
			loginLogs.setDesc("Account locked for user "+user.getUser_id());
			loginLogsDao.save(loginLogs);
			user.setStatus(0);
			userDao.save(user);
			e.setDesc("Account locked for user "+user.getUser_id());
			exceptionDao.save(e);
			throw new UserNotFound("Account locked for user "+user.getUser_id());
		}
		
	}

	@Override
	public TicketsEntity raiseTicket( Map<String, String> ticket) throws UserNotFound {
		
		String email=ticket.get("email");
		String desc=ticket.get("desc");
		UserEntity checkUser = userDao.findByEmail(email);
		TicketsEntity tickets=new TicketsEntity();
		if (checkUser != null) {
			tickets.setApproved_by_ref(null);
			tickets.setDesc(desc);
			tickets.setStatus(0);
			tickets.setTime_stamp(LocalDateTime.now());
			tickets.setUser_id_ref(checkUser);
			return ticketDao.save(tickets);
		}
		throw new UserNotFound("User not found with email " + email);
		
	}

	@Override
	public UserEntity editProfile(UserEntity user) throws UserNotFound {
		UserEntity newUser=userDao.findByEmail(user.getEmail());
		if(newUser!=null) {
			newUser.setAddress(user.getAddress());
			newUser.setDob(user.getDob());
			newUser.setEmail(user.getEmail());
			newUser.setFirst_name(user.getFirst_name());
			newUser.setLast_name(user.getLast_name());
			newUser.setPassword(user.getPassword());
			newUser.setPhone(user.getPhone());
			return userDao.save(newUser);
		}
		throw new UserNotFound("User not found with email " + user.getEmail());
	}

	@Override
	public UserEntity funds(Map<String, String> userfund) throws UserNotFound {
		UserEntity user=userDao.findByEmail(userfund.get("email"));
		if(user==null) {
			throw new UserNotFound("User not found with email " + userfund.get("email"));
		}
		
		if (user.getAccount_number_ref().getAmount() > Double.parseDouble(userfund.get("fund"))) {
			double balance = user.getAccount_number_ref().getAmount() - Double.parseDouble(userfund.get("fund"));
			user.getAccount_number_ref().setAmount(balance);
			int balanceFund = user.getFunds() + Integer.parseInt(userfund.get("fund"));
			user.setFunds(balanceFund);
			return userDao.save(user);
		} else {
			throw new UserNotFound("Insufficient Balance!");
		}
		
		
	}

}
