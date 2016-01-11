package com.hrms.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.HRPolicyDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class HRPolicyAction extends ActionSupport{
	
	/**
	 * @author Agni
	 */
	private static final long serialVersionUID = 1L;
	HRPolicyDetailsBean hrPolicy;
	public HRPolicyDetailsBean getHrPolicy() {
		return hrPolicy;
	}

	public void setHrPolicy(HRPolicyDetailsBean hrPolicy) {
		this.hrPolicy = hrPolicy;
	}

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

	String result = "error";
	private File uploadFile;
	private String uploadFileFileName;	
	
	public String execute() {
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			String filePath = "c:/HRPolicy";  // Path where uploaded file will be stored
			File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
		    String selectedFilePath = filePath+"/"+uploadFileFileName;
		    try {
				FileUtils.copyFile(uploadFile, fileToCreate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Just copy temp file content tos this file		
		 		
		    
		    hrPolicy = new HRPolicyDetailsBean(selectedFilePath);
		    Long EmpId = (Long) session.save(hrPolicy);
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

	