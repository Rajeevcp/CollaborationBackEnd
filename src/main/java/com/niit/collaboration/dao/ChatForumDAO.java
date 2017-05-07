package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ChatForum;

public interface ChatForumDAO {

	public List<ChatForum> list(String id);
	
	public boolean save(ChatForum chatForum);
	
	//This is id of particular row of table
	public ChatForum getChatForumById(String id);
	
	public boolean delete(ChatForum chatForum);
}
