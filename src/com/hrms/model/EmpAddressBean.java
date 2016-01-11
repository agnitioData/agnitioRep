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
@Table(name="EmpAddressDetails")
public class EmpAddressBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="EmpAdd_id")
		   private int empAdd_id;
	
	@Column(name="PresentAdd",nullable = false)
		   private String presentAdd; 
	
	@Column(name="PermanentAdd",nullable = false)
		   private String permanentAdd;
	
	@Column(name="MobileNo",nullable = false)
		   private long mobileNo;
	
	@Column(name="MobNumbertype")
		   private String mobNumbertype;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;
	
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;
	
	@Column(name="future_use3")
	private String future_use3;
		   

		   public EmpAddressBean() {
			   
		   }
		   public EmpAddressBean(String presentAdd, String permanentAdd, long mobileNo, String mobNumbertype) {
			   
			   	  this.presentAdd = presentAdd;
			      this.permanentAdd = permanentAdd;
			      this.mobileNo = mobileNo;
			      this.mobNumbertype = mobNumbertype;
			      
		   }
		   
		   
		   
		   public int getEmpAdd_id() {
		      return empAdd_id;
		   }
		   public void setEmpAdd_id( int empAdd_id ) {
		      this.empAdd_id = empAdd_id;
		   }
		   
		   
		   
		   public String getPresentAdd() {
			   return presentAdd;
		   }
		   public void setPresentAdd(String presentAdd) {
			   this.presentAdd = presentAdd;
		   }
		   
		   public String getPermanentAdd() {
			   return permanentAdd;
		   }
		   public void setPermanentAdd(String permanentAdd) {
			   this.permanentAdd = permanentAdd;
		   }
		  
		   public long getMobileNo() {
			   return mobileNo;
		   }
		   
		   public void setMobileNo(long mobileNo) {
			   this.mobileNo = mobileNo;
		   }
		   
		   public String getMobNumbertype() {
			   return mobNumbertype;
		   }
		   public void setMobNumbertype(String mobNumbertype) {
			   this.mobNumbertype = mobNumbertype;
		   }
		   
		   public EmpMasterBean getEmployees() {
			   return employees;
		   }
		   public void setEmployees(EmpMasterBean employees) {
			   this.employees = employees;
		   }
		   public int getFuture_use1() {
			   return future_use1;
		   }
		   public void setFuture_use1(int future_use1) {
			   this.future_use1 = future_use1;
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
		   
		   
		   
		
		/*public boolean equals(Object obj) {
		      if (obj == null) return false;
		      if (!this.getClass().equals(obj.getClass())) return false;

		      EmpAddressBean obj2 = (EmpAddressBean)obj;
		      if((this.empAdd_id == obj2.getEmpAdd_id()))
		      {
		         return true;
		      }
		      return false;
		   }
		   public int hashCode() {
		      int tmp = 0;
		      //tmp = ( empAdd_id  ).hashCode();
		      return tmp;
		   }*/
		}


