package com.niit.collaboration.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

import junit.framework.Assert;

public class BlogTestCase {

	@Autowired
	private static Blog blog;

	@Autowired
	private static BlogDAO blogDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blog = (Blog) context.getBean("blog");
		blogDAO = (BlogDAO) context.getBean("blogDAO");

	}

	public void createBlog() {
		blog.setId("b005");
		;
		blog.setTitle("Test");
		blog.setUser_id("u001");
		boolean flag = blogDAO.save(blog);
		Assert.assertEquals("createBlog", true, flag);

	}

	public void updateBlog() {
		String var = "Hello world";
		// java.sql.Blob blob =
		// org.hibernate.Hibernate.createBlob(var.getBytes());
		blog.setId("b001");
		blog.setTitle("Testss");
		blog.setUser_id("u001");
		blog.setReason("abcdefg");
		blog.setStatus('Y');
		blog.setDescription("Testvxcvxcvcvxcv");

		boolean flags = blogDAO.update(blog);
		Assert.assertEquals("updateBlog", true, flags);
	}

	@Test
	public void listBlogs() {
		blog = blogDAO.getBlogById("b0041");
		Assert.assertEquals("listBlogs", null, blog);
	}

	@Test
	public void deleteBlog() {
		blog = blogDAO.getBlogById("b004");
		boolean blogs = blogDAO.delete(blog);
		Assert.assertEquals("deleteBlog", true, blogs);
	}
}
