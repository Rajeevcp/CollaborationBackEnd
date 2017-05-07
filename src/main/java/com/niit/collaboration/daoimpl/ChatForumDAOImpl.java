package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;

@Transactional
@Repository("chatForumDAO")
public class ChatForumDAOImpl implements ChatForumDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<ChatForum> list(String id) {
		return sessionFactory.getCurrentSession().createQuery("from ChatForum where user_id = '"+id+"' ").list();
	}

	public boolean save(ChatForum chatForum) {
		try {
			sessionFactory.getCurrentSession().save(chatForum);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ChatForum getChatForumById(String id) {
		ChatForum chatForum = (ChatForum) sessionFactory.getCurrentSession().get(ChatForum.class,id);
		return chatForum;
	}

	public boolean delete(ChatForum chatForum) {
		try {
			sessionFactory.getCurrentSession().delete(chatForum);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
}
