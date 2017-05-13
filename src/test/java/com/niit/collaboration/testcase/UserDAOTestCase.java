package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserDAOTestCase {

@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	
	@BeforeClass
	public static  void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("Niit");
		user.setName("Niit");
		user.setRole("admin");
		user.setAddress("Andheri W");
		user.setEmail("niit@gmail.com");
		user.setMobile("999999999");
		user.setPassword("123");
	       boolean flag =	userDAO.save(user);
	       
	       assertEquals("createUserTestCase ",true, flag);
	}
	/*@Test*/
	public void updateUserTestCase()
	{
		user.setId("manish2");
		user.setName("sudhi");
		user.setName("manish");
		user.setRole("Student");
		user.setAddress("Andheri W");
		user.setEmail("manish@gmail.com");
		user.setMobile("xxxx");
		user.setPassword("11");
	       boolean flag =	userDAO.update(user);
	       
	       assertEquals("updateUserTestCase ",true, flag);
	}
	
	public void getUserTestCase()
	{
		user =  userDAO.get("manis");
		
		assertEquals("getUserTestCase", null, user);
		
		
		
	}
	
	public void isValidUserTest(){
	
	user = userDAO.isValidCredentials("rajeev","gggg");
	assertEquals("isValidUserTest",null,user);
	}
	
	
	
	public void getAllUsersTestCase()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase", 2, users.size());
	}
}
