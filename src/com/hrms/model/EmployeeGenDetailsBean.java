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
@Table(name="EmployeeGeneralInfo")
public class EmployeeGenDetailsBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Emp_Genid")
	   private long Emp_Genid;
	
	@Column(name="Email_id", unique=true, nullable = false)
	   private String emailId;
	
	@Column(name="Gender")
	   private String empGender;
	
	@Column(name="Date_of_birth", nullable = false)
	   private String dob;
	
	@Column(name="Date_of_joining", nullable = false)
	   private String doj;
	
	@Column(name="PassportNo")
	   private String passportNo;
	
	@Column(name="PanNo")
	   private String panNo;
	
	/*@Column(name="AccountNo")
	   private String accountNo;*/
	
	@Column(name="Marital_status")
	   private String maritalStatus;
	
	@Column(name="AnniversaryDate")
	   private String anniversaryDate;
	
	//@OneToMany(mappedBy="empGenInfo")
	
	//@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="Emp_id")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;
	
	@Column(name="AccountNo")
	private Long accountNo;
	
	@Column(name="future_use2")
	private String future_use2;
	
	@Column(name="future_use3")
	private String future_use3;
	
	@Column(name="future_use4")
	private String future_use4;
	

	   public EmployeeGenDetailsBean() {}
	   
	   public EmployeeGenDetailsBean(String emailId, String empGender, String dob, String doj, String passportNo, String panNo, String maritalStatus, String anniversaryDate, Long accountNo ) {
	      
	      this.emailId = emailId;
	      this.empGender = empGender;
	      this.dob = dob;
	      this.doj = doj;
	      this.passportNo = passportNo;
	      this.panNo = panNo;
	      this.maritalStatus = maritalStatus;
	      this.anniversaryDate = anniversaryDate;
	      this.accountNo= accountNo;
	      
	   }
	   
		   public String getDoj() {
			   return doj;
		   }
		   
		   public void setDoj(String doj) {
			   this.doj = doj;
		   }
	
		   public long getEmp_Genid() {
			   return Emp_Genid;
		   }
	
		   public void setEmp_Genid(long emp_Genid) {
			   Emp_Genid = emp_Genid;
		   }
	
		   public String getAnniversaryDate() {
			   return anniversaryDate;
		   }
	
		   public void setAnniversaryDate(String anniversaryDate) {
			   this.anniversaryDate = anniversaryDate;
		   }
	
		   public String getEmailId() {
			   return emailId;
		   }
	
		   public void setEmailId(String emailId) {
			   this.emailId = emailId;
		   }
		   
		   public String getDob() {
			   return dob;
		   }
	
		   public void setDob(String dob) {
			   this.dob = dob;
		   }
	
		   public String getPassportNo() {
			   return passportNo;
		   }
	
		   public void setPassportNo(String passportNo) {
			   this.passportNo = passportNo;
		   }
	
		   public String getPanNo() {
			   return panNo;
		   }
	
		   public void setPanNo(String panNo) {
			   this.panNo = panNo;
		   }
	
		   public String getMaritalStatus() {
			   return maritalStatus;
		   }
	
		   public void setMaritalStatus(String maritalStatus) {
			   this.maritalStatus = maritalStatus;
		   }

	    public String getEmpGender() {
			return empGender;
		}
	
		public void setEmpGender(String empGender) {
			this.empGender = empGender;
		}
	
		public EmpMasterBean getEmployees() {
			return employees;
		}
	
		public void setEmployees(EmpMasterBean employees) {
			this.employees = employees;
		}
	
		public Long getAccountNo() {
			return accountNo;
		}
	
		public void setAccountNo(Long accountNo) {
			this.accountNo = accountNo;
		}
	
		public String getFuture_use2() {
			return future_use2;
		}
	
		public void setFuture_use2(String future_use2) {
			this.future_use2 = future_use2;
		}
	
		public String getFuture_use3() {
			return future_use3;
		}
	
		public void setFuture_use3(String future_use3) {
			this.future_use3 = future_use3;
		}
	
		public String getFuture_use4() {
			return future_use4;
		}
	
		public void setFuture_use4(String future_use4) {
			this.future_use4 = future_use4;
		}
	
		/*public Set<EmpMasterBean> getEmployees1() {
			return employees1;
		}
	
		public void setEmployees1(Set<EmpMasterBean> employees1) {
			this.employees1 = employees1;
		}*/
	   
	   
}


