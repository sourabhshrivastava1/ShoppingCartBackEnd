package com.niit.shoppingcart.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;


import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;

	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		product = (Product) context.getBean("product");

		productDAO = (ProductDAO) context.getBean("productDAO");

	}
	@Test
	public void createProductTestCase() {
		product.setID("101");
		product.setName("MOBILE");
		product.setPrice("10000");
		product.setCategory_id("1");
		product.setSupplier_id("1");

		boolean flag = productDAO.save(product);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createProductTestCase", true, flag);

	}

	 @Test
	   public void deleteProductByIDTestCase()
	   {
		   
		   boolean flag = productDAO.delete("101");
		   
		   Assert.assertEquals( "deleteCategoryByIDTestCase" ,true, flag);
		   
		   
		   
	   }

	 @Test
	   public void deleteProduct()
	   {
		   product.setID("101");
		   
		   boolean flag = productDAO.delete(product);
		   
		   Assert.assertEquals( "deleteProductTestCase" ,true, flag);
		   
		   
		   
	   }
	   
}


