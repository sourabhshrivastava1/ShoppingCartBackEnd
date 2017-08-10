package com.niit.shoppingcart.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;


public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		category = (Category) context.getBean("category");

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	// TEST CASES
	 
	 	@Test
	public void createCategoryTestCase() {
		category.setId("06032017");
		category.setName("Electronics Category");
		category.setDescription("This is Eloectronics ");

		boolean flag = categoryDAO.save(category);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createCategoryTestCase", true, flag);
	}
	 

	@Test
	   public void updateCategoryTestCase()
	   {
		   
		   category.setId("05032017");
		   category.setName("new Category");
		   category.setDescription("This is Women category");
		   
		   boolean flag = categoryDAO.update(category);
		   
		   Assert.assertEquals( "updateCategoryTestCase" ,true, flag);
		   
		   
	   }

	   
	 @Test
	   public void deleteCategoryByIDTestCase()
	   {
		   
		   boolean flag = categoryDAO.delete("02032017");
		   
		   Assert.assertEquals( "deleteCategoryByIDTestCase" ,true, flag);
		   
		   
	   
	   }
	  
	  @Test
	   public void deleteCategory()
	   {
		   category.setId("CG02032017");
		   
		   boolean flag = categoryDAO.delete(category);
		   
		   Assert.assertEquals( "deleteCategoryTestCase" ,true, flag);
		   
		   
		   
	   }
	   
	   
	   @Test
	   public void getCategoryByIDTestCase()
	   {
		   
		  category = categoryDAO.getCategoryByID("CG01032017ABCD");
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  assertEquals("getCategoryByIDTestCase", null, category);
		   
	   }
	   
	   
	   @Test
	   public void getCategoryByNameTestCase()
	   {
		   
		  category = categoryDAO.getCategoryByName("Mobile Category");
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  assertEquals("getCategoryByNameTestCase", null, category);
		   
	   }
	   
	   
	   @Test
	   public void getAllCategoriesTestCase()
	   
	   {
		   
		  int recordsFromDAO =  categoryDAO.list().size();
		  
		  assertEquals("getAllCategoriesTestCase" ,7 , recordsFromDAO);
		   
	   }
	   
}  
