package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

public class FriendTestCase {

	@Autowired
	private static Friend friend;
	@Autowired
	private static FriendDAO friendDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friend = (Friend) context.getBean("friend");
		friendDAO = (FriendDAO) context.getBean("friendDAO");

	}

	
	public void friednSave() {
		friend.setUser_id("rajeev");
		friend.setFriend_id("Niit");
		friend.setStatus('R');
		boolean flag = friendDAO.save(friend);
		assertEquals("friednSave", true, flag);
	}
	
	public void friendUpdate() {
		//friend.setUser_id("rajeev");
		//friend.setFriend_id("Niit");
		friend.setId(101);
		friend.setFriend_id("Naresh");
		friend.setUser_id("rajeev");
		friend.setStatus('Y');
		boolean flag = friendDAO.update(friend);
		assertEquals("friendUpdate", true, flag);
	}
	
	public void getMyFrinds(){
		List<Friend>friend = friendDAO.listMyFriend("rajeev");
		assertEquals("getMyFrinds",2,friend.size());
		
	}
	
	public void getNewFriendRequest(){
		List<Friend> friend = friendDAO.getNewFriendRequests("Niit");
		assertEquals("getNewFriendRequest" ,1, friend.size());
	}
	
	public void  getRequestSendByMe(){
		List<Friend> friend = friendDAO.getRequestsSendByMe("rajeev");
		assertEquals("getRequestSendByMe",2,friend.size());
	}
	
	public void getMyFriendsDetails(){
	friend = friendDAO.get("Naresh", "rajeev");
	assertEquals("getMyFriendsDetails",null,friend);
	}
	
	public void setOnline(){
		boolean flag = friendDAO.setOnline("rajeev");
		assertEquals("setOnline",true ,flag);
	}
	@Test
	public void setOffLine(){
		boolean flag = friendDAO.setOffLine("Naresh");
		assertEquals("setOffLine",true,flag);
	}
}
