package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;
@Transactional
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Event event) {
		try {
			event.setId(getMaxId() + 1);
			sessionFactory.getCurrentSession().save(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Event> listEvent() {
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}
	
	private Integer getMaxId() {

		String hql = "select max(id) from Event";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

	public boolean update(Event event) {
		try {
			sessionFactory.getCurrentSession().update(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
