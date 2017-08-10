package com.niit.shoppingcart.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CheckoutDAO;
import com.niit.shoppingcart.domain.Checkout;

import junit.framework.Assert;


public class CheckoutTestCase {

	@Autowired
	private static Checkout Checkout;

	@Autowired
	private static CheckoutDAO CheckoutDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		Checkout = (Checkout) context.getBean("Checkout");

		CheckoutDAO = (CheckoutDAO) context.getBean("CheckoutDAO");

	}

	// TEST CASES
	 
	 	@Test
	public void createCheckoutTestCase() {
		Checkout.setId(1);
		Checkout.setAddress("c9-bittan market bhopal");
		Checkout.setCart_id(1);
		Checkout.setUser_id("1");
		Checkout.setStatus("Done");
		

		boolean flag = CheckoutDAO.save(Checkout);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createCheckoutTestCase", true, flag);
	}
}
/*
	@Test
	   public void updateCheckoutTestCase()
	   {
		   
		   Checkout.setId("05032017");
		   Checkout.setName("new Checkout");
		   Checkout.setDescription("This is Women Checkout");
		   
		   boolean flag = CheckoutDAO.update(Checkout);
		   
		   Assert.assertEquals( "updateCheckoutTestCase" ,true, flag);
		   
		   
	   }

	   
	 @Test
	   public void deleteCheckoutByIDTestCase()
	   {
		   
		   boolean flag = CheckoutDAO.delete("02032017");
		   
		   Assert.assertEquals( "deleteCheckoutByIDTestCase" ,true, flag);
		   
		   
	   
	   }
	  
	  @Test
	   public void deleteCheckout()
	   {
		   Checkout.setId("CG02032017");
		   
		   boolean flag = CheckoutDAO.delete(Checkout);
		   
		   Assert.assertEquals( "deleteCheckoutTestCase" ,true, flag);
		   
		   
		   
	   }
	   
	   
	   @Test
	   public void getCheckoutByIDTestCase()
	   {
		   
		  Checkout = CheckoutDAO.getCheckoutByID("CG01032017ABCD");
		  
		  
		 // Assert.assertNotNull("getCheckoutByIDTestCase", Checkout);
		  
		  
		  assertEquals("getCheckoutByIDTestCase", null, Checkout);
		   
	   }
	   
	   
	   @Test
	   public void getCheckoutByNameTestCase()
	   {
		   
		  Checkout = CheckoutDAO.getCheckoutByName("Mobile Checkout");
		  
		  
		 // Assert.assertNotNull("getCheckoutByIDTestCase", Checkout);
		  
		  
		  assertEquals("getCheckoutByNameTestCase", null, Checkout);
		   
	   }
	   
	   
	   @Test
	   public void getAllCategoriesTestCase()
	   
	   {
		   
		  int recordsFromDAO =  CheckoutDAO.list().size();
		  
		  assertEquals("getAllCategoriesTestCase" ,7 , recordsFromDAO);
		   
	   }
	   
}  
*/