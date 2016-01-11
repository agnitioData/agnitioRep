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
@Table(name="Employee_FamilyDetails")
public class EmpFamilyDetails {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="fdetails_id")
	   private int fdetails_id;
	   
	@Column(name="Father_Name")
	   private String fname;
	
	/*@Column(name="Relationship")
	   private String relationship;*/
	
	@Column(name="Father_Occupation")
	   private String foccupation;
	
	@Column(name="Father_MobileNo")
	   private long fmobileNo;
	
	@Column(name="Mother_Name")
	   private String name;
	
	/*@Column(name="Relationship")
	   private String relationship;*/
	
	@Column(name="Mother_Occupation")
	   private String occupation;
	
	@Column(name="Mother_MobileNo")
	   private long mobileNo;
	
	@Column(name="Total_Siblings")
	   private int noOfSiblings;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;

	   public EmpFamilyDetails() {}
	   public EmpFamilyDetails(String name, String occupation, long mobileNo, int noOfSiblings) {
	      
		  this.name = name;
	      //this.relationship = relationship;
	      this.occupation = occupation;
	      this.mobileNo = mobileNo;
	      this.noOfSiblings = noOfSiblings;
	      
	   }
	public int getFdetails_id() {
		return fdetails_id;
	}
	public void setFdetails_id(int fdetails_id) {
		this.fdetails_id = fdetails_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFoccupation() {
		return foccupation;
	}
	public void setFoccupation(String foccupation) {
		this.foccupation = foccupation;
	}
	public long getFmobileNo() {
		return fmobileNo;
	}
	public void setFmobileNo(long fmobileNo) {
		this.fmobileNo = fmobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getNoOfSiblings() {
		return noOfSiblings;
	}
	public void setNoOfSiblings(int noOfSiblings) {
		this.noOfSiblings = noOfSiblings;
	}
	public EmpMasterBean getEmployees() {
		return employees;
	}
	public void setEmployees(EmpMasterBean employees) {
		this.employees = employees;
	}
	
	
	
	   
	   
	   
	  
	   
	   
	   
	   
	   /*public boolean equals(Object obj) 
	   {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      EmpFamilyDetails obj2 = (EmpFamilyDetails)obj;
	      if((this.fdetails_id == obj2.getFdetails_id()) && (this.name.equals(obj2.getName())))
	      {
	         return true;
	      }
	      return false;
	   }
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( fdetails_id + name ).hashCode();
	      return tmp;
	   }*/

}
