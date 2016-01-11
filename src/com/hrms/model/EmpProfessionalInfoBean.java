package com.hrms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Employee_ProfessionalInfo")
public class EmpProfessionalInfoBean {
	
	@Id
    @GeneratedValue
    @Column(name="ProfInfoid")
	   private int profInfoid;
	
	@Column(name="Department")
	   private String department;
	
	@Column(name="Designation")
	   private String designation;
	
	@Column(name="Employee_Manager")
	   private String empManager;
	
	@Column(name="Date_Of_Joining")
	   private String doj;
	
	@Column(name="Total_Experience")
	   private String totalExp;
	
	@Column(name="Employee_Status")
	   private String empStatus;
	
	@Column(name="CTC_Lakhs")
	   private String ctc;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;
	
	@Column(name="future_use2")
	private String future_use2;
	
	@Column(name="future_use3")
	private int future_use3;
	
	
	public EmpProfessionalInfoBean(){
		
	}
	
	public EmpProfessionalInfoBean(String department, String designation, String empManager, String doj, String totalExp, String empStatus, String ctc){
		
		this.department= department;
		this.designation= designation;
		this.empManager= empManager;
		this.doj= doj;
		this.totalExp= totalExp;
		this.empStatus= empStatus;
		this.ctc= ctc;
		
	}
	public int getProfInfoid() {
		return profInfoid;
	}
	public void setProfInfoid(int profInfoid) {
		this.profInfoid = profInfoid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmpManager() {
		return empManager;
	}
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(String totalExp) {
		this.totalExp = totalExp;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public EmpMasterBean getEmployees() {
		return employees;
	}
	public void setEmployees(EmpMasterBean employees) {
		this.employees = employees;
	}
	public String getFuture_use2() {
		return future_use2;
	}
	public void setFuture_use2(String future_use2) {
		this.future_use2 = future_use2;
	}
	public int getFuture_use3() {
		return future_use3;
	}
	public void setFuture_use3(int future_use3) {
		this.future_use3 = future_use3;
	}
	
	
	

}
