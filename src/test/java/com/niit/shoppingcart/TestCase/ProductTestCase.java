package com.niit.shoppingcart.TestCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;


import junit.framework.Assert;

public class ProductTestCase {

	//private static final MultipartFile image = null;

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
	/*@Test
	public void CreateProductTestCase() {
		
		product.setName("TEST");
		product.setPrice("1000");
		product.setCategory_id("3");
	    product.setSupplier_id("02");
	    product.setDescription("mobile");
     
		//product.setFile(image);
		boolean flag = productDAO.save(product);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("CreateProductTestCase",true,flag);
	
	}
*/

	@Test
	   public void deleteProductByIDTestCase()
	   {
		   
		   boolean flag = productDAO.delete(4);
		   
		   Assert.assertEquals( "deleteProductByIDTestCase" ,true, flag);
		   
		   
		   
	   }

	/* @Test
	   public void deleteProduct()
	   {
		   product.setID(4);
		   
		   boolean flag = productDAO.delete(product);
		   
		   Assert.assertEquals( "deleteProduct" ,true, flag);
		   
		   
		   
	   }*/
	   
}


