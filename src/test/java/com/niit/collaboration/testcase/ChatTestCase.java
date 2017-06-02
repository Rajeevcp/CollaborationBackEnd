package com.niit.collaboration.testcase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Chat;

import junit.framework.Assert;

public class ChatTestCase {

	@Autowired
	private static Chat chat;
	
	@Autowired
	private static ChatDAO chatDAO;
	
	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		chat = (Chat) context.getBean("chat");
		chatDAO = (ChatDAO) context.getBean("chatDAO");

	}
	@Test
	public void createChat(){
		//chat.setId("c003");
		chat.setFriend_id("rajeev");
		chat.setUser_id("Niit");
		chat.setMessage("HII HOW ARE YOU");
		boolean flag=chatDAO.save(chat);
		assertEquals("createChat",true,flag);
	}
	/*@Test*/
	public void getFriend(){
	List<Chat> chats = chatDAO.getChatByFriend("b003", "b002");
		assertEquals("getFriend", 1, chats.size());
	}
	
	/*@Test*/
	public void getUserChat(){
		
		List<Chat> chatuser = chatDAO.list("b001");
		assertEquals("getFriend", 2, chatuser.size());
	}
	
	
	public void deleteChat(){
		chat = (Chat) chatDAO.list("b001");
		boolean flag = chatDAO.delete(chat);
		Assert.assertEquals("deleteChat",true,flag);
	}
	
	public void listChat(){
		List<Chat> chats=  chatDAO.getChatByFriend("b003", "b002");
		assertEquals("getFriend", 1, chats.size());
	}
	}
