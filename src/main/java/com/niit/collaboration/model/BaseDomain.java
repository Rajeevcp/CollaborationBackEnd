package com.niit.collaboration.model;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDomain {

	@Transient
	private String errorCode;
	
	@Transient
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
