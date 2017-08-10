package com.niit.shoppingcart.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Orders;



@Transactional
@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO {

	private static org.jboss.logging.Logger log = LoggerFactory.logger(OrdersDAOImpl.class);
	

	@Autowired
	private SessionFactory sessionFactory;
	 
	/*@Transactional
	public boolean save(Orders orders) {
		try
		{
			if(get(orders.getOrderID())!=null)
			{
				Session session=sessionFactory.openSession();
				session.save(orders);
				session.flush();
				return true;
			}
			return false;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
		}
	}

	*/
	@Transactional
	private Object get(String orderID) {
		// TODO Auto-generated method stub
		return (Orders)	sessionFactory.getCurrentSession().get(Orders.class, orderID);
	}



	@Transactional
	public boolean update(Orders orders) {
		
		try {
			sessionFactory.getCurrentSession().update(orders);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	@Transactional
	public boolean delete(long id) {
		try {
			sessionFactory.getCurrentSession().delete(getOrdersByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	}


	
}

	@Transactional
	public Orders getOrdersByID(long id) {
		return (Orders)	sessionFactory.getCurrentSession().get(Orders.class, id);
	}


	/*@Transactional
	public boolean delete(long id) {
		try {
			sessionFactory.getCurrentSession().delete(getMyOrderByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	}*/



	



	@Transactional
	public Orders get(long id) {
		return (Orders) sessionFactory.openSession().get(Orders.class,id);
	}


	@Transactional
	public boolean save(Orders order) {

		try
		{
		sessionFactory.getCurrentSession().save(order);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}



	

		
	}



	public boolean delete(Orders orders) {
		// TODO Auto-generated method stub
		return false;
	}
}


	
