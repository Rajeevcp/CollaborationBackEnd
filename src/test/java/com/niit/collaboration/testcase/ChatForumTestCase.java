package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;

public class ChatForumTestCase {

	@Autowired
	private static ChatForum chatForum;
	
	@Autowired
	private static ChatForumDAO chatForumDAO;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		chatForum = (ChatForum) context.getBean("chatForum");
		chatForumDAO = (ChatForumDAO) context.getBean("chatForumDAO");
	}
	
	
	public void createChatForum(){
		chatForum.setId("ch001");
		chatForum.setUser_id("b001");
		chatForum.setMessage("abcdefgh");
		boolean flag = chatForumDAO.save(chatForum);
		assertEquals("createChatForum", true,flag);
	}
	
	public void getChatForum(){
		List<ChatForum> chatF = chatForumDAO.list("b001");
		assertEquals("getChatForum",1,chatF.size());
	}
	@Test
	public void deleteChatForun(){
		ChatForum chats = chatForumDAO.getChatForumById("ch001");
		boolean flag = chatForumDAO.delete(chats);
		assertEquals("deleteChatForun",true,flag);
	}

}
