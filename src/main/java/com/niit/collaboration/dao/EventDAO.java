package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {

	public boolean save(Event event);
	public boolean update(Event event);
	public Event getEventById(String event_id);
	public List<Event> listEvent();
}
