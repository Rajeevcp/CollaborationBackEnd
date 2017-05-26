package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

public class EventTestCase {

	@Autowired
	private static Event event;
	
	@Autowired
	private static EventDAO eventDAO;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		event = (Event) context.getBean("event");
		
		eventDAO = (EventDAO) context.getBean("eventDAO");
		
		
	}
	@Test
	public void createEvent(){
		event.setName("New Ideas");
		event.setDescription("Lorem ipsum");
		event.setUser_id("rajeev");
		event.setVenue("USA");
		boolean flag = eventDAO.save(event);
		assertEquals("createEvent",true,flag);
	}
	

}
