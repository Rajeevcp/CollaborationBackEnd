package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;
import com.niit.collaboration.model.Friend;

@Transactional
@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Chat> list(String id) {
		return sessionFactory.getCurrentSession().createQuery("from Chat where user_id= '"+id+"' ").list(); 
	}

	public boolean save(Chat chat) {
		try {
			chat.setId(getMaxId() + 1);
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Chat chat) {
		try {
			sessionFactory.getCurrentSession().delete(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Chat> getChatByFriend(String user_id,String friend_id) {
		
		String hql1 = "select user_id,friend_id,date_time,message from Chat where user_id='" + user_id + "' and friend_id = '"+friend_id+"'  ";

		/* + " union  " + */

		String hql2 = "select user_id,friend_id,date_time,message from Chat where user_id='" + friend_id + "' and friend_id = '"+user_id+"'  ";
		
		List<Chat> list1 = sessionFactory.openSession().createQuery(hql1).list();
		List<Chat> list2 = sessionFactory.openSession().createQuery(hql2).list();

		list1.addAll(list2);
       
		return list1;
		
	
	}
	

	private Integer getMaxId() {

		String hql = "select max(id) from Chat";
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

	

}
