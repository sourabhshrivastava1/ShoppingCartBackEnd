package com.niit.shoppingcart.TestCase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Orders;


import junit.framework.Assert;

public class OrdersTestCase {

	//private static final MultipartFile image = null;

	@Autowired
	private static Orders orders;

	@Autowired
	private static OrdersDAO ordersDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		orders = (Orders) context.getBean("orders");

		ordersDAO = (OrdersDAO) context.getBean("ordersDAO");

	}
	
	@Test
	public void createOrdersTestCase() {
		
		
		orders.setUser_id("0123");
		orders.setHouse_no("57");
		orders.setStreet("Regal town");
	    orders.setCity("BHOPAL");
	    orders.setPincode("462021");
	    orders.setState("M.P");
	    orders.setCountry("INDIA");
	    orders.setCard_type("Visa");
	    orders.setCard_no("123456789");
	    orders.setCard_cvv("437");
	    orders.setExpirydate("26/12/12");
	    
    
		//Order.setFile(image);
		boolean flag = ordersDAO.save(orders);

		// compare what you are excepting VS what you are getting from save
		// method

		assertEquals("createOrdersTestCase",true,flag);
	
	}



	/*@Test
	   public void deleteOrderByIDTestCase()
	   {
		   
		   boolean flag = orders.delete();
		   
		   Assert.assertEquals( "deleteOrderByIDTestCase" ,true, flag);
		   
		   
		   
	   }

	 @Test
	   public void deleteOrder()
	   {
		   Order.setId(4);
		   
		   boolean flag = OrderDAO.delete(Order);
		   
		   Assert.assertEquals( "deleteOrder" ,true, flag);
		   
		   
		   
	   }
	   */
}


