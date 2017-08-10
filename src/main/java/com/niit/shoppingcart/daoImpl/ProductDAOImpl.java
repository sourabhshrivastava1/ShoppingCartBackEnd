package com.niit.shoppingcart.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	
	}

	/*public boolean save(Product product) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
		
	}*/

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	
	/*public boolean save (Product product) 
	{
     try
     {
    	 if (get(Product.getId()) !=null){
    			sessionFactory.getCurrentSession().save(product);
    			return true;
    	 }
    	 return false;
     }catch (Exception e){
    	 e.printStackTrace();
    	 return false;
     }*/
	}
	@Transactional
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	
	}
	@Transactional
	public boolean delete(long id) {
		
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	@Transactional
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	public boolean saveOrUpdate(Product product){ 
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
		}

	/*public Product get(String id) {
		// TODO Auto-generated method stub
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where id=?").setString(0, id).uniqueResult();
	}
*/
	@Transactional
	public Product get(String id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = ?")
				.setString(0, id).uniqueResult();
	}
	@Transactional
	public Product getProductByID(int id) {
		
		try {
			return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Transactional
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		//logger.info("Starting getProductByName method of ProductDao");
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Product where name= '" + name + "'");
			Product product = (Product) query.uniqueResult();

			return product;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.error("Exception occured" + e);
			throw e;
		}
	}

	
	

	public void add(Product Product) {
		// TODO Auto-generated method stub
		
	}

	public Product getProductByID(String id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
		}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(long id) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
	}

	public Product get(int id) {
		// TODO Auto-generated method stub
		return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
	}
	}


