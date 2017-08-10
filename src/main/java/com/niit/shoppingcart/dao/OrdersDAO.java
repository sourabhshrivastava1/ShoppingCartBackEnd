package com.niit.shoppingcart.dao;

import javax.persistence.criteria.Order;

import com.niit.shoppingcart.domain.Mycart;
import com.niit.shoppingcart.domain.Orders;

public interface OrdersDAO {

	// declare the methods related to CRUD operations
	// access_specifier return_type method_name(parameter_list) throws
	// exception_list

	// get all categories

	// update user

	public boolean save(Orders orders);
	// delete user by id

	public boolean update(Orders orders);
	// delete user by user

	public boolean delete(Orders orders);

	public Orders getOrdersByID(long id);

	public boolean delete(long id);

}

