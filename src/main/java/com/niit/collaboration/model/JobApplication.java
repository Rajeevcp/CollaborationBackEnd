package com.niit.collaboration.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="C_JOB_APPLICATION")
public class JobApplication extends BaseDomain {
	
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

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Id
	private Integer id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="DATE_APPLIED")
	private Date date_time;
	
	@Column(name="JOB_ID")
	private String job_id;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="STATUS")
	private char status;

}
