package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Leave_ApplyInfo")
public class EmpLeaveApplyBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="leaveDetailsId")
	   private long leaveDetailsId;
	
	@Column(name="Emp_Code")
	   private String empCode;
	
	@Column(name="ApplyDate")
	   private String applyDate;
	
	@Column(name="No_Of_Days")
	   private int noOfDays;
	
	@Column(name="From_Date")
	   private String fromDate;
	
	@Column(name="To_Date")
	   private String toDate;
	
	@Column(name="Leave_Reason")
	   private String leaveReason;
	
	@Column(name="status")
	   private String status;
	
	public EmpLeaveApplyBean(){
		
	}
	
	public EmpLeaveApplyBean(String empCode, String applyDate, int noOfDays, String fromDate, String toDate, String leaveReason, String status){
		this.empCode= empCode;
		this.applyDate= applyDate;
		this.noOfDays= noOfDays;
		this.fromDate= fromDate;
		this.toDate= toDate;
		this.leaveReason= leaveReason;
		this.status= status;
	}

	public long getLeaveDetailsId() {
		return leaveDetailsId;
	}

	public void setLeaveDetailsId(long leaveDetailsId) {
		this.leaveDetailsId = leaveDetailsId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	
	
	

}
