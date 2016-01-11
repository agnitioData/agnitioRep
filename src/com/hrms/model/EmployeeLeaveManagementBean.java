package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EmployeeLeaveInformation")
public class EmployeeLeaveManagementBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Leave_ID")
	   private long leave_ID;
	
	@Column(name="Employee_Code")
	   private String empCode;
	
	/*@Column(name="Date")
	   private String date;*/
	
	@Column(name="Total_Leaves")
	   private float totalLeaves;
	
	@Column(name="Remaining_Leaves")
	   private float remainingLeaves;
	
	@Column(name="Used_Leaves")
	   private float usedLeaves;
	
	@Column(name="CF_Leaves")
	   private float carryFwdLeaves;
	
	/*@ManyToOne(fetch = FetchType.LAZY)*/
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Emp_id")
   /* @Column(name="Emp_id")
	private long empID;*/
	/*
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;*/
	
	
	public EmployeeLeaveManagementBean(){
	}
	
	
	public EmployeeLeaveManagementBean(String empCode, float totalLeaves, float remainingLeaves, float usedLeaves, float carryFwdLeaves){
		
		this.empCode = empCode;
		this.totalLeaves = totalLeaves;
        this.remainingLeaves = remainingLeaves;
        this.usedLeaves = usedLeaves;
        this.carryFwdLeaves = carryFwdLeaves;
        
	}

	public long getLeave_ID() {
		return leave_ID;
	}


	public void setLeave_ID(long leave_ID) {
		this.leave_ID = leave_ID;
	}


	public String getEmpCode() {
		return empCode;
	}


	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}


	public float getTotalLeaves() {
		return totalLeaves;
	}


	public void setTotalLeaves(float totalLeaves) {
		this.totalLeaves = totalLeaves;
	}


	public float getRemainingLeaves() {
		return remainingLeaves;
	}


	public void setRemainingLeaves(float remainingLeaves) {
		this.remainingLeaves = remainingLeaves;
	}


	public float getUsedLeaves() {
		return usedLeaves;
	}


	public void setUsedLeaves(float usedLeaves) {
		this.usedLeaves = usedLeaves;
	}

	public float getCarryFwdLeaves() {
		return carryFwdLeaves;
	}


	public void setCarryFwdLeaves(float carryFwdLeaves) {
		this.carryFwdLeaves = carryFwdLeaves;
	}
	


}
