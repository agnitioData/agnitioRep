package com.hrms.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hrms.model.EmoloyeeDocumentDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;
  

public class EmpDocUploadAction extends ActionSupport implements  ServletRequestAware{
	/**
	 * @author Agni
	 */
	private static final long serialVersionUID = 1L;
	private EmoloyeeDocumentDetailsBean fileUploadBean;
	String result = "error";
	
	private String empCode;
	private String docType;
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	

	public String execute() {
		System.out.println("Hello-------");
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			
			Transaction t= session.beginTransaction();
			
			String filePath = "c:/Myuploads";  // Path where uploaded file will be stored
			File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
		    String selectedFilePath = filePath+"/"+uploadFileFileName;
		    
		    try {
				FileUtils.copyFile(uploadFile, fileToCreate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Just copy temp file content tos this file		
		 		
		    fileUploadBean = new EmoloyeeDocumentDetailsBean(getEmpCode(), getDocType(), selectedFilePath);
		    
		    Long EmpId = (Long) session.save(fileUploadBean);
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
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
 
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
 
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
 
	

	
	public EmoloyeeDocumentDetailsBean getFileUploadBean() {
		return fileUploadBean;
	}
	public void setFileUploadBean(EmoloyeeDocumentDetailsBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
	}




	private HttpServletRequest servletRequest; 

	

	public void setServletRequest(HttpServletRequest servletRequest) {  
        this.servletRequest = servletRequest;  
  
    }
}
