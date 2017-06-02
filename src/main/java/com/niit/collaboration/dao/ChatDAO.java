package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Chat;

public interface ChatDAO {
	
	public List<Chat> list(String id);
	
	public boolean save(Chat chat);
	
	public boolean delete(Chat chat);
	
	public List<Chat> getChatByFriend(String user_id,String friend_id);

}
