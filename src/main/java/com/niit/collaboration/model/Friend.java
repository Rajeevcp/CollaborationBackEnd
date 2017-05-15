package com.niit.collaboration.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_FRIEND")
public class Friend extends BaseDomain {

	@Id
	private Integer id;

	@Column(name = "USER_ID")
	private String user_id;

	@Column(name = "FRIEND_ID")
	private String friend_id;

	@Column(name = "STATUS")
	private char status;

	@Column(name = "IS_ONLINE")
	private char is_online;

	@Column(name = "LAST_SEEN")
	private Date last_seen;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getIs_online() {
		return is_online;
	}

	public void setIs_online(char is_online) {
		this.is_online = is_online;
	}

	public Date getLast_seen() {
		return last_seen;
	}

	public void setLast_seen(Date last_seen) {
		this.last_seen = last_seen;
	}

}
