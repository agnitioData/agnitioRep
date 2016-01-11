package com.hrms.model;

import java.io.File;


public class EmpAttendenceFileUploadBean {
	
	private File uploadFile;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public EmpAttendenceFileUploadBean(){}
	public EmpAttendenceFileUploadBean(File uploadFile, String fileUploadContentType, String fileUploadFileName)
	{
			this.uploadFile = uploadFile;
			this.fileUploadContentType = fileUploadContentType;
			this.fileUploadFileName = fileUploadFileName;
			//this.mobNumbertype = mobNumbertype;
	}
	
	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	
	

}
