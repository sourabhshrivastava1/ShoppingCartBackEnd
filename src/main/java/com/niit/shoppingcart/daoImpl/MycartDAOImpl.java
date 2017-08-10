package com.niit.shoppingcart.daoImpl;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Mycart;



@Transactional
@Repository("mycartDAO")
public class MycartDAOImpl implements MycartDAO {

	private static org.jboss.logging.Logger log = LoggerFactory.logger(MycartDAOImpl.class);
	

	@Autowired
	private SessionFactory sessionFactory;
	


	
	public List<Mycart> list() {
		
		return	sessionFactory.getCurrentSession().createQuery("from Mycart").list();
	}

	public boolean save(Mycart mycart) {
		
		
		try
		{
		sessionFactory.getCurrentSession().save(mycart);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	/*public boolean delete(Mycart mycart) {

		mycart.setStatus('X');
		
		return update(mycart);
*/



	@Transactional
	public Long getTotalAmount(String userId) {
		
		log.debug("Starting of the method getTotalAmount");
		
		String hql = "select sum(price*quantity) from MyCart where user_id=" + "'" + userId + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Long) ((Query) query).uniqueResult();

	}

	@Transactional
	private Long getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			log.debug("hql" + hql);
			maxID = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return maxID + 1;

	}

	
		@Transactional
		public List<Mycart> list(String userID) { {
			log.debug("Starting of the method list");
			String hql = "from MyCart where user_id=" + "'" + userID + "'  and status = " + "'N'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			log.debug("Ending of the method list");
			return query.list();

		}

	}

	public Mycart getSupplier(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public boolean update(Mycart mycart) {
		
		try {
			sessionFactory.getCurrentSession().update(mycart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	public Object getproduct(int productid, int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(long id) {
		try {
			sessionFactory.getCurrentSession().delete(getMycartByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	}


	
}

	public boolean delete(Mycart mycart) {
		// TODO Auto-generated method stub
		return false;
	}

	public Mycart getMycartByID(long id) {
		return (Mycart)	sessionFactory.getCurrentSession().get(Mycart.class, id);
	}
}