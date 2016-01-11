package com.hrms.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Employee_Documents") 
public class EmoloyeeDocumentDetailsBean {  
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Emp_id")
	   private long id;
	
	@Column(name="Document")
    private String userFile;  
    @Column(name="Emp_Code")
    private String empCode;
    @Column(name="Doc_Type")
    private String docType;
    
    public EmoloyeeDocumentDetailsBean(String empCode, String docType, String userFile) {
		// TODO Auto-generated constructor stub
		this.docType = docType;
		 this.empCode = empCode;
		 this.userFile = userFile;
	}
    
    public String getUserFile() {
		return userFile;
	}

	public void setUserFile(String userFile) {
		this.userFile = userFile;
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
}  