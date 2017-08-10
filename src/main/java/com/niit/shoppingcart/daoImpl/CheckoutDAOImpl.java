package com.niit.shoppingcart.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CheckoutDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Checkout;

@Transactional
@Repository("checkoutDAO")
public class CheckoutDAOImpl implements CheckoutDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CheckoutDAOImpl(SessionFactory sessionFactory) 
	{
		log.info("Checkout Session");
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Checkout checkout) {
		
		log.debug("Starting of the method saveOrUpdate checkout");
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(checkout);
				log.debug("Ending of the method saveOrUpdate checkout");
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				log.error("Exception occurred while saveOrUpdate checkout");
				log.error(e.getMessage());
				return false;
			}
	}

	@Transactional
	public boolean delete(Checkout checkout) {
		
		log.debug("Starting of the method delete checkout");
			try {
				sessionFactory.getCurrentSession().delete(checkout);
				log.debug("Ending of the method delete checkout");
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				log.error("Exception occurred while deleting checkout");
				log.error(e.getMessage());
				return false;
			}
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Checkout> list() {
		
		log.debug("Starting of the method list checkout");
		String hql ="from Checkout";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list Checkout");
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public Checkout get(int id) {
		
		log.debug("Starting of the method get checkout");
		String hql = "from Checkout where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Checkout>list= query.list();
		
		if(list.isEmpty())
		{
			log.debug("Ending of the method get checkout");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public Checkout getCheckoutByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	
		@Transactional
		public boolean save(Checkout checkout) {
			try
			{
			sessionFactory.getCurrentSession().save(checkout);
			return true;
			} catch(Exception e)
			{
				e.printStackTrace(); //it will print the error in the console - similar to SOP
				          //package, class, method line number from which place you are calling
				return false;
			}
			
	}
}