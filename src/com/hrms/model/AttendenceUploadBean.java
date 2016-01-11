package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Rishabh Porwal
 * this class is responsible to creating the table structure in  DB
 */
@Entity
@Table(name="Employee_AttendenceDetails")
public class AttendenceUploadBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Attd_Id")
	   private long attd_Id;
	
	@Column(name="EmpCode")
	   private String empCode;
	
	@Column(name="EmpName")
	   private String empName;
	
	@Column(name="DateTime")
	   private String dateTime;
	
	@Column(name="In_Time")
	   private String empInTime;
	
	@Column(name="Out_Time")
	   private String empOutTime;
	
	@Column(name="Working_duration")
	   private String workingDuration;
	
	@Column(name="Status")
	   private String status;
	
	 public AttendenceUploadBean() {
		   
	   }
	   public AttendenceUploadBean(String empCode, String empName, String dateTime, String empInTime, String empOutTime, String workingDuration, String status) {
		   
		   	  this.empCode = empCode;
		      this.dateTime = dateTime;
		      this.empInTime = empInTime;
		      this.empOutTime = empOutTime;
		      this.empName= empName;
		      this.workingDuration = workingDuration;
		      this.status = status;
		      
	   }

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getAttd_Id() {
		return attd_Id;
	}

	public void setAttd_Id(long attd_Id) {
		this.attd_Id = attd_Id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	

	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getEmpInTime() {
		return empInTime;
	}

	public void setEmpInTime(String empInTime) {
		this.empInTime = empInTime;
	}

	public String getEmpOutTime() {
		return empOutTime;
	}

	public void setEmpOutTime(String empOutTime) {
		this.empOutTime = empOutTime;
	}

	public String getWorkingDuration() {
		return workingDuration;
	}

	public void setWorkingDuration(String workingDuration) {
		this.workingDuration = workingDuration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
