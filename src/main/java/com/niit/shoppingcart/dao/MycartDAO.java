package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Mycart;

public interface MycartDAO {

	
	
	public List<Mycart>list();
	
    public 	boolean save(Mycart mycart);
    
    public boolean delete(Mycart mycart);
    public List<Mycart> list(String userID);
	public Mycart getSupplier(String id);

	public boolean update(Mycart cart);
	public boolean delete(long id);
	public Object getTotalAmount(String loggedInUserid);
	public Object getproduct(int productid, int userid);
	public Mycart getMycartByID(long id);
}
