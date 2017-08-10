package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	
	 public List<Product> list();
	   public boolean save(Product product);
	  

		// update category

		public boolean update(Product product);

		// delete category by id

		public boolean delete(long id);

		// delete category by category

		public boolean delete(Product product);

		// get category by id

		public Product getProductByID(long id);

		// get category by name
		public Product getProductByName(String name);
		public boolean saveOrUpdate(Product product);
		public Product get(int id);
		
		public void add(Product Product);
		public Product get(String id);
		

}


