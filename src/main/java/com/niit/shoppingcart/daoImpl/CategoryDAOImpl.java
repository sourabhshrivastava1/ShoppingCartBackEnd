package com.niit.shoppingcart.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Category> list() {
		//select * from category  -SQL Query - mention the table name
		//from Category  -> HQL -mention Domain class name not table name
		
		//convert the hibernate query into db specific language
	return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}
	@Transactional
	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
	}
	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//cntrl + O

	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	/**
	 * This method will return Category based on category id.
	 * If the category does not exist with this id, it will return null
	 */
	public Category getCategoryByID(String id) {
		
	return (Category)	sessionFactory.getCurrentSession().get(Category.class, id);
		
	}

	public Category getCategoryByName(String name) {
		// select * from category where name ='mobile'
		
	return	 (Category)sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult();
		
		
	}

	public boolean saveOrUpdate(Category category) {
		
		try {
		
		Session session=	sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
  session.flush();
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}

	public Category get(String id) {
		
		 
		
		// TODO Auto-generated method stub
		return  (Category)sessionFactory.getCurrentSession().createQuery("from Category where id ='"+id+"'").uniqueResult();
	}

	public boolean edit(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	public Logger get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
