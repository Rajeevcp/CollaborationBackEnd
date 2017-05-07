package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

public class JobTestCase {

	@Autowired
private static Job job;

	@Autowired
private static JobDAO jobDAO;

	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		job = (Job) context.getBean("job");
		jobDAO = (JobDAO) context.getBean("jobDAO");
		
		
	}
	
	
	public void createJob(){
		Long d = System.currentTimeMillis();
		Date today = new Date(d);
		job.setId("j002");
		job.setTitle("Java Developer");
		job.setQualification("CC");
		job.setStatus('N');
		job.setDescription("CCCCC");
		job.setDate_time(today);
		boolean flag = jobDAO.save(job);
		assertEquals("createJob",true,flag);
	}
	
	public void updateJob(){
		Long d = System.currentTimeMillis();
		Date today = new Date(d);
		job.setId("j002");
		job.setTitle("FullStack Developer");
		job.setQualification("CC");
		job.setStatus('N');
		job.setDescription("CCCCC");
		job.setDate_time(today);
		boolean flags = jobDAO.update(job);
		assertEquals("updateJob",true,flags);
	}
	
	public void getJobList(){
		List<Job> jobs = jobDAO.list();
		assertEquals("getJobList",3,jobs.size());
		
	}
	@Test
	public void deleteJob(){
		Job job = jobDAO.getJobById("j002");
		boolean flg = jobDAO.delete(job);
		assertEquals("deleteJob",true,flg);
	}
}
