package com.hrms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EmployeeProfessionalInfo")
public class EmpProfInfoBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="EmpProfInfoId")
	   private int EmpprofInfoid;
	
	@Column(name="Employee Department")
	   private String department;
	   
	@Column(name="Employee Designation")
	   private String designation;
	
	@Column(name="Employee Manager")
	   private String empManager;
	
	@Column(name="Date of joining")
	   private String doj;
	   
	@Column(name="Employee Status")
	   private String empStatus;
	
	@Column(name="CTC (Lakhs)")
	   private String ctc;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;
	
	@Column(name="future_use2")
	private String future_use2;
	
	@Column(name="future_use3")
	private String future_use3;
	
	 public EmpProfInfoBean() {}
	   
	 public EmpProfInfoBean(String department, String designation, String empManager, String doj, String empStatus, String ctc) {
	      
	      this.department = department;
	      this.designation = designation;
	      this.empManager = empManager;
	      this.doj = doj;
	      this.empStatus = empStatus;
	      this.ctc = ctc;
	      /*this.maritalStatus = maritalStatus;
	      this.anniversaryDate = anniversaryDate;
	      this.accountNo= accountNo;*/
	      
	   }

	

	

	public int getEmpprofInfoid() {
		return EmpprofInfoid;
	}

	public void setEmpprofInfoid(int empprofInfoid) {
		EmpprofInfoid = empprofInfoid;
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

	
	
	
	

}
