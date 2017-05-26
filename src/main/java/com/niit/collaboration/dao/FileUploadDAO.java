package com.niit.collaboration.dao;

import com.niit.collaboration.model.UploadFile;

public interface FileUploadDAO {

	void save(UploadFile uploadFile);

	UploadFile getFile(int username);
}
