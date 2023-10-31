package com.npci.serviceImpl;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AuditLogsDao;
import com.npci.dao.ExceptionDao;
import com.npci.dao.UserDao;
import com.npci.entity.AccountEntity;
import com.npci.entity.AuditLogsEntity;
import com.npci.entity.ExceptionsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuditLogsDao auditLogsDao;
	@Autowired
	private ExceptionDao exceptionDao;

	@Override
	public UserEntity signUp(UserEntity user) throws UserAlreadyExist {
		 AuditLogsEntity auditLogs = new AuditLogsEntity();
		 auditLogs.setEndpoint("user/signUp");
		    auditLogs.setRole(UserEntity.class.getSimpleName());		 
		    auditLogs.setTime_stamp(LocalDateTime.now());
		UserEntity checkUser=userDao.findByEmail(user.getEmail());
		if(checkUser==null) {
			 AccountEntity account = new AccountEntity(0, 50000);
			    user.setAccount_number_ref(account);
			    
			    UserEntity u=userDao.save(user);
			    auditLogs.setRole_id(u.getUser_id());
			    auditLogs.setDesc("user registered successfully");
			   
			    auditLogsDao.save(auditLogs);

			    return u;
		}
		auditLogs.setRole_id(0);
	    auditLogs.setDesc("user tried to register");
	    auditLogsDao.save(auditLogs);
	    ExceptionsEntity e=new ExceptionsEntity();
	    e.setName(UserAlreadyExist.class.getSimpleName());
	    e.setEndpoint("user/signUp");
	    e.setRole(UserEntity.class.getSimpleName());
	    e.setRole_id(0);
	    e.setDesc("User with "+user.getEmail()+" already exist");
	    e.setTime_stamp(LocalDateTime.now());
	    exceptionDao.save(e);
		    throw new UserAlreadyExist("User with "+user.getEmail()+" already exist");
	}

}
