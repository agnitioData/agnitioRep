package com.agni.hrms.bean;

public class EmpLeaveManagingBean {
	
	private long leaveId;
	private String empCode;
	private String empName;
	private float totalLeaves;
	private float remainLeaves;
	private float usedLeaves;
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
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
	public float getRemainLeaves() {
		return remainLeaves;
	}
	public void setRemainLeaves(float remainLeaves) {
		this.remainLeaves = remainLeaves;
	}
	public float getUsedLeaves() {
		return usedLeaves;
	}
	public void setUsedLeaves(float usedLeaves) {
		this.usedLeaves = usedLeaves;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	

}
