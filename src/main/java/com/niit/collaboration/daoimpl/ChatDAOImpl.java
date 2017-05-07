package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;

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

	public List<Chat> getChatByFriend(String id1,String id2) {
	return sessionFactory.getCurrentSession().createQuery("from Chat where user_id = '"+id1+"' AND friend_id = '"+id2+"' ").list();
	}
	

}
