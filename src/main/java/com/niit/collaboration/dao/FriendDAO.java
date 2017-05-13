package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {

	public List<Friend> listMyFriend(String user_id);

	public Friend get(String friend_id,String user_id);

	public boolean save(Friend friend);

	public boolean update(Friend friend);

	public List<Friend> getNewFriendRequests(String user_id);

	public boolean setOnline(String user_id);

	public boolean setOffLine(String user_id);

	// select * from Friend where userID=? status = 'N'
	public List<Friend> getRequestsSendByMe(String user_id);
}
