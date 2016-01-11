package com.hrms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmpEducationDetails")
public class EmpEducationDetails {
	
	@Id
    @GeneratedValue
    @Column(name="EduDetails_id")
	   private int eduDetails_id;
	
	@Column(name="Tenth")
	   private String tenthDegree;
	
	@Column(name="Tenth_University")
	   private String tenthUniversity;
	
	@Column(name="Tenth_YearOfPass")
	   private String tenthYearOfPass;
	
	@Column(name="Tenth_Grade")
	   private int tenthGrade;
	
	@Column(name="twelfth")
	   private String twelveDegree;
	
	@Column(name="twelfth_University")
	   private String twelveUniversity;
	
	@Column(name="twelfth_YearOfPass")
	   private String twelveYearOfPass;
	
	@Column(name="twelfth_Grade")
	   private int twelveGrade;
	
	@Column(name="Graduation")
	   private String graduationDegree;
	
	@Column(name="Graduation_University")
	   private String graduationUniversity;
	
	@Column(name="Graduation_YearOfPass")
	   private String graduationYearOfPass;
	
	@Column(name="Graduation_Grade")
	   private int graduationGrade;
	
	@Column(name="Post_Graduation")
	   private String pgDegree;
	
	@Column(name="PG_University")
	   private String pgUniversity;
	
	@Column(name="PG_YearOfPass")
	   private String pgYearOfPass;
	
	@Column(name="PG_Grade")
	   private int pgGrade;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;
	
	 public EmpEducationDetails() {}
	   public EmpEducationDetails(String name) {
	      //this.name = name;
	   }
	public int getEduDetails_id() {
		return eduDetails_id;
	}
	public void setEduDetails_id(int eduDetails_id) {
		this.eduDetails_id = eduDetails_id;
	}
	public String getTenthDegree() {
		return tenthDegree;
	}
	public void setTenthDegree(String tenthDegree) {
		this.tenthDegree = tenthDegree;
	}
	public String getTenthUniversity() {
		return tenthUniversity;
	}
	public void setTenthUniversity(String tenthUniversity) {
		this.tenthUniversity = tenthUniversity;
	}
	public String getTenthYearOfPass() {
		return tenthYearOfPass;
	}
	public void setTenthYearOfPass(String tenthYearOfPass) {
		this.tenthYearOfPass = tenthYearOfPass;
	}
	public int getTenthGrade() {
		return tenthGrade;
	}
	public void setTenthGrade(int tenthGrade) {
		this.tenthGrade = tenthGrade;
	}
	public String getTwelveDegree() {
		return twelveDegree;
	}
	public void setTwelveDegree(String twelveDegree) {
		this.twelveDegree = twelveDegree;
	}
	public String getTwelveUniversity() {
		return twelveUniversity;
	}
	public void setTwelveUniversity(String twelveUniversity) {
		this.twelveUniversity = twelveUniversity;
	}
	public String getTwelveYearOfPass() {
		return twelveYearOfPass;
	}
	public void setTwelveYearOfPass(String twelveYearOfPass) {
		this.twelveYearOfPass = twelveYearOfPass;
	}
	public int getTwelveGrade() {
		return twelveGrade;
	}
	public void setTwelveGrade(int twelveGrade) {
		this.twelveGrade = twelveGrade;
	}
	public String getGraduationDegree() {
		return graduationDegree;
	}
	public void setGraduationDegree(String graduationDegree) {
		this.graduationDegree = graduationDegree;
	}
	public String getGraduationUniversity() {
		return graduationUniversity;
	}
	public void setGraduationUniversity(String graduationUniversity) {
		this.graduationUniversity = graduationUniversity;
	}
	public String getGraduationYearOfPass() {
		return graduationYearOfPass;
	}
	public void setGraduationYearOfPass(String graduationYearOfPass) {
		this.graduationYearOfPass = graduationYearOfPass;
	}
	public int getGraduationGrade() {
		return graduationGrade;
	}
	public void setGraduationGrade(int graduationGrade) {
		this.graduationGrade = graduationGrade;
	}
	public String getPgDegree() {
		return pgDegree;
	}
	public void setPgDegree(String pgDegree) {
		this.pgDegree = pgDegree;
	}
	public String getPgUniversity() {
		return pgUniversity;
	}
	public void setPgUniversity(String pgUniversity) {
		this.pgUniversity = pgUniversity;
	}
	public String getPgYearOfPass() {
		return pgYearOfPass;
	}
	public void setPgYearOfPass(String pgYearOfPass) {
		this.pgYearOfPass = pgYearOfPass;
	}
	public int getPgGrade() {
		return pgGrade;
	}
	public void setPgGrade(int pgGrade) {
		this.pgGrade = pgGrade;
	}
	public EmpMasterBean getEmployees() {
		return employees;
	}
	public void setEmployees(EmpMasterBean employees) {
		this.employees = employees;
	}
	   
	
	   

}
