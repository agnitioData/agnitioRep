package com.hrms.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.HRPolicyDetailsBean;
import com.hrms.model.ProjectDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ProjectUploadAction extends ActionSupport {

	ProjectDetailsBean projectDetailsBean = new ProjectDetailsBean();
	public ProjectDetailsBean getProjectDetailsBean() {
		return projectDetailsBean;
	}
	public void setProjectDetailsBean(ProjectDetailsBean projectDetailsBean) {
		this.projectDetailsBean = projectDetailsBean;
	}
	String result = "error";
	private File uploadFile;
	private String uploadFileFileName;	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String execute()
	{
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			String filePath = "c:/Agnitio_Projects";  // Path where uploaded file will be stored
			File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
		    String selectedFilePath = filePath+"/"+uploadFileFileName;
		    try {
				FileUtils.copyFile(uploadFile, fileToCreate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Just copy temp file content tos this file		
		 		
		    
		    projectDetailsBean.setDocuments(selectedFilePath);
		    Long EmpId = (Long) session.save(projectDetailsBean);
			t.commit();//transaction is committed  
			session.close();  
			
		if(EmpId!=0){  
			System.out.println("successfully saved");
			result="success";
			}
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
