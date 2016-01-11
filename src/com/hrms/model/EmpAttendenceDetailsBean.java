package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Rishabh Porwal
 *
 *This class is responsible to create the Attendence table structure
 */

@Entity
@Table(name="Employee_Attendence_Details")
public class EmpAttendenceDetailsBean {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Attd_Id")
	   private long attd_Id;
	
	@Column(name="DateTime")
	   private String dateTime;
	
	@Column(name="In_Time")
	   private String empInTime;
	
	@Column(name="Out_Time")
	   private String empOutTime;
	
	@Column(name="Working_hours")
	   private String workingHours;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)*/
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Emp_id")
    @Column(name="Emp_id")
	private long empID;
	
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;
	
	
	public EmpAttendenceDetailsBean(){
	}
	
	
	public EmpAttendenceDetailsBean(String dateTime, String empInTime, String empOutTime, String workingHours, long empID){
		
		this.dateTime = dateTime;
		this.empInTime = empInTime;
        this.empOutTime = empOutTime;
        this.workingHours = workingHours;
        this.empID = empID;
	}

	public long getAttd_Id() {
		return attd_Id;
	}

	public void setAttd_Id(long attd_Id) {
		this.attd_Id = attd_Id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	

	public String getEmpInTime() {
		return empInTime;
	}


	public void setEmpInTime(String empInTime) {
		this.empInTime = empInTime;
	}


	public String getEmpOutTime() {
		return empOutTime;
	}


	public void setEmpOutTime(String empOutTime) {
		this.empOutTime = empOutTime;
	}


	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	

	public long getEmpID() {
		return empID;
	}


	public void setEmpID(long empID) {
		this.empID = empID;
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
	
	

}
