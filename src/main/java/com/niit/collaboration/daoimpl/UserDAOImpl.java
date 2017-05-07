package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;
@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	private  SessionFactory  sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	
	public User get(String id) {
		 User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		 
		 return user;
	}

	public List<User> list() {
		 return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
	public User isValidCredentials(String id, String password) {
		User user =  (User) sessionFactory.getCurrentSession().createQuery("from User where id ='"+id+"' and password = '"+password+"' ").uniqueResult();
	
	return user;
		
	
	}

	
	
}
