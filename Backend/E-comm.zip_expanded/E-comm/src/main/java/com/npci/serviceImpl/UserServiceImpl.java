package com.npci.serviceImpl;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AuditLogsDao;
import com.npci.dao.UserDao;
import com.npci.entity.AccountEntity;
import com.npci.entity.AuditLogsEntity;
import com.npci.entity.UserEntity;
import com.npci.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Autowired
	private AuditLogsDao auditLogsDao;

	@Override
	public UserEntity signUp(UserEntity user) {
		AccountEntity account=new AccountEntity(0,50000);
		user.setAccount_number_ref(account);
		AuditLogsEntity auditLogs = new AuditLogsEntity();
		auditLogs.setDesc("user registered successfully");
		auditLogs.setEndpoint("signUp");
		auditLogs.setRole("user");
		auditLogs.setTime_stamp(LocalDateTime.now());
//		UserEntity u =userDao.save(user);
		auditLogs.setRole_id(user.getUser_id());
		auditLogsDao.save(auditLogs);
		return userDao.save(user);
	}

}
