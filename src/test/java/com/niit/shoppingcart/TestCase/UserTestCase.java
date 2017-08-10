package com.niit.shoppingcart.TestCase;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {
	@Autowired
	private static ApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired 
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAO");
	}
  
	
	@Test
	public void createUserTestCase(){
		
	
	user.setId("0129");
	user.setName("niitgniit");
	user.setPassword("niit@123");
	user.setEmail("sourabh.shrivastava545@gmail.com");
	user.setContact("9998888877");
	user.setRole("Role_Admin");
	
	boolean flag=userDAO.save(user);
	Assert.assertEquals("createUserTestCase",true,flag);
	}
	
	
	@Test
	public void setUserDetails(){
		
	
	user.setId("72");
	user.setName("Divya");
	user.setPassword("niit@123");
	user.setEmail("singhis king	");
	user.setContact("9998888877");
	user.setRole("ROLE_USER");
	
	boolean flag=userDAO.save(user);
	Assert.assertEquals("setUserDetails",true,flag);
	}
	

/*	@Test
	public void updateUserDetails(){
		
	
	user.setId("0124");
	user.setName("sourabh");
	user.setPassword("niit");
	user.setEmail("sourabh.shrivastava@gmail.com");
	user.setContact("9998888877");
	user.setRole("ROLE_ADMIN");
	boolean flag=userDAO.save(user);
	Assert.assertEquals("updateUserDetails",true,flag);
	}

	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag=userDAO.validate("123", "niit");
		
		Assert.assertEquals("validateCredentialsTestCase",true,flag);
	
	}*/
	
	
	
	
	
}


