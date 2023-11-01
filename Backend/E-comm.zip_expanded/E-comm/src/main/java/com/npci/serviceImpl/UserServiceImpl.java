package com.npci.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.dao.AuditLogsDao;
import com.npci.dao.CartDao;
import com.npci.dao.ExceptionDao;
import com.npci.dao.LoginLogsDao;
import com.npci.dao.OrdersDao;
import com.npci.dao.ProductDao;
import com.npci.dao.TicketsDao;
import com.npci.dao.UserDao;
import com.npci.entity.AccountEntity;
import com.npci.entity.AuditLogsEntity;
import com.npci.entity.CartEntity;
import com.npci.entity.ExceptionsEntity;
import com.npci.entity.LoginLogsEntity;
import com.npci.entity.OrdersEntity;
import com.npci.entity.ProductsEntity;
import com.npci.entity.TicketsEntity;
import com.npci.entity.UserEntity;
import com.npci.exceptions.UserAlreadyExist;
import com.npci.exceptions.NotFound;
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
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
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
	public UserEntity login(Map<String, String> credentials) throws NotFound {
		ExceptionsEntity e = new ExceptionsEntity();
		e.setEndpoint("user/login");
		e.setRole(UserEntity.class.getSimpleName());
		e.setName(NotFound.class.getSimpleName());
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
			throw new NotFound("Login Credentials null!");
		}

		String email = credentials.get("email");
		String password = credentials.get("password");

		UserEntity user = userDao.findByEmail(email);

		if (user == null) {
			
			loginLogs.setDesc("User with " + email + " doesn't exist");
			loginLogsDao.save(loginLogs);
			
			e.setDesc("User with " + email + " doesn't exist");
			exceptionDao.save(e);
			throw new NotFound("User not found with email " + email);
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
				throw new NotFound("Invalid Password!");
			}
		}else {
			loginLogs.setRole_id(user.getUser_id());
			loginLogs.setDesc("Account locked for user "+user.getUser_id());
			loginLogsDao.save(loginLogs);
			user.setStatus(0);
			userDao.save(user);
			e.setDesc("Account locked for user "+user.getUser_id());
			exceptionDao.save(e);
			throw new NotFound("Account locked for user "+user.getUser_id());
		}
		
	}

	@Override
	public TicketsEntity raiseTicket( Map<String, String> ticket) throws NotFound {
		
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
		throw new NotFound("User not found with email " + email);
		
	}

	@Override
	public UserEntity editProfile(UserEntity user) throws NotFound {
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
		throw new NotFound("User not found with email " + user.getEmail());
	}

	@Override
	public UserEntity funds(Map<String, String> userfund) throws NotFound {
		UserEntity user=userDao.findByEmail(userfund.get("email"));
		if(user==null) {
			throw new NotFound("User not found with email " + userfund.get("email"));
		}
		
		if (user.getAccount_number_ref().getAmount() > Double.parseDouble(userfund.get("fund"))) {
			double balance = user.getAccount_number_ref().getAmount() - Double.parseDouble(userfund.get("fund"));
			user.getAccount_number_ref().setAmount(balance);
			int balanceFund = user.getFunds() + Integer.parseInt(userfund.get("fund"));
			user.setFunds(balanceFund);
			return userDao.save(user);
		} else {
			throw new NotFound("Insufficient Balance!");
		}
		
		
	}

	@Override
	public CartEntity addToCart(Map<String, String> cartitem) throws NotFound {
		String email=cartitem.get("email");
		int productId=Integer.parseInt(cartitem.get("productId"));
		UserEntity newUser=userDao.findByEmail(email);
		ProductsEntity product=productDao.findById(productId).get();
		if(newUser!=null) {
			if(product !=null) {
			CartEntity cart=new CartEntity();
			cart.setUser_id_ref(newUser);
			cart.setProduct_id_ref(product);
			return cartDao.save(cart);
			}else {
				throw new NotFound("Product not found with id " + productId);
			}
		}
		throw new NotFound("User not found with email " + email);
	}

	@Override
	public String deleteFromCart(int cardId, int productId) throws NotFound {
		

		cartDao.deleteCartItem(cardId, productId);

		return "Deleted Successfully";
	}

	@Override
	public List<CartEntity> showCart(int userId) throws NotFound {
		List<CartEntity> list=cartDao.showCart(userId);
		return list;
	}
	
	@Override
	public OrdersEntity checkout(int userId) throws NotFound {
	    List<CartEntity> list = cartDao.showCart(userId);
	    UserEntity user = userDao.findById(userId).orElseThrow(() -> new NotFound("User not found"));
	    int price = 0;

	    for (CartEntity cartEntity : list) {
	        price += cartEntity.getProduct_id_ref().getAmount();
	        int productId=cartEntity.getProduct_id_ref().getProduct_id();
	        ProductsEntity product =productDao.findById(productId).get();
	       int remaining= product.getQuantity()-1;
	       product.setQuantity(remaining);
	       productDao.save(product);
	        cartDao.deleteCartItem(cartEntity.getCart_id(),cartEntity.getProduct_id_ref().getProduct_id());
	    }

	  
	    user = userDao.save(user);
	    if(user.getFunds()>price) {
	    	int bal=user.getFunds()-price;
	    	user.setFunds(bal);
	    	userDao.save(user);
	    	
	    OrdersEntity order = new OrdersEntity();
	    order.setAmount(price);
	    order.setStatus("placed");
	    order.setTime_stamp(LocalDateTime.now());
	    order.setUser_id_ref(userId);

	    return ordersDao.save(order);
	    
	}
	throw new NotFound("Insufficient Amount in funds");
	}

	@Override
	public List<OrdersEntity> orders(int userId) throws NotFound {
		
		return ordersDao.orders(userId);
	}


}
