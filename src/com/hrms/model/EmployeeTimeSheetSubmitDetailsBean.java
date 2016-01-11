package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Emp_TimeSheet_Detail")

public class EmployeeTimeSheetSubmitDetailsBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	   private long id;
	
	@Column(name="Emp_Code")
	private String empCode;
	@Column(name="Date")
	private String date;
	@Column(name="ProjectName")
	private String projectName;
	@Column(name="TaskName")
	private String taskName;
	@Column(name="TaskDescription")
	private String taskDescription;
	@Column(name="Hour")
	private String hour;
	@Column(name="AssignedBy")
	private String assignedBy;
	@Column(name="Status")
	private String status;
	public EmployeeTimeSheetSubmitDetailsBean() {
		// TODO Auto-generated constructor stub
	}
	/*public EmployeeTimeSheetSubmitDetailsBean(String date, String projectName, String taskName, String taskDescription, String hour, String assignedBy) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.projectName = projectName;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.hour = hour;
		this.assignedBy = assignedBy;
				
	}
*/
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
		
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

}
