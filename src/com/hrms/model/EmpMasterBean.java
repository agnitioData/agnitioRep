package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Rishabh Porwal
 *
 *@this class create the master table Structure and also responsible for mapping
 */

@Entity
@Table(name="Employee_Master")
public class EmpMasterBean {
	 
	/*private EmployeeGenDetailsBean employeeGenDetailsBean;
	private EmpAddressBean empAddressBean;*/
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Emp_id")
	   private long id;
	
	 /*@Column(name = "IMAGE_NAME", unique = false, nullable = false, length = 100)
	    private String imageName;
	    
	 @Column(name = "EmpImage", unique = false, nullable = false, length = 100)
	    private File empImage;
	     
	 @Column(name = "DATA", unique = false, nullable = false, length = 100000)
	    private byte[] data;*/

    @Column(name="Emp_Code", unique=true, nullable = false)
	   private String empCode;
	
	@Column(name="First_name", nullable = false)
	   private String firstName;
	   
	@Column(name="Last_name", nullable = false)
	   private String lastName;
	
	@Column(name="User_name", nullable = false, unique=true)
	   private String userName;
	   
	@Column(name="User_Password", nullable = false)
	   private String password;
	
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;
	
	@Column(name="future_use3")
	private String future_use3;
	
	@Column(name="future_use4")
	private String future_use4;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	private Set<EmpAttendenceDetailsBean> empAttendence = new HashSet<EmpAttendenceDetailsBean>(
			0);*/
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Emp_Genid")*/
	
	/*@OneToOne(mappedBy="employees1")
    private EmployeeGenDetailsBean empGenInfo;*/
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="empAdd_id")
    private EmpAddressBean empAdd;*/
	
	/*@ManyToOne
    @JoinColumn(name="fdetails_id")
		private EmpFamilyDetails familyDetails;
	
	@ManyToOne
    @JoinColumn(name="eduDetails_id")
	   private EmpEducationDetails educationDetails;
	
	@ManyToOne
    @JoinColumn(name="Emp_profInfoid")
	   private EmpProfInfoBean empProfInfoBean;
	*/
	public EmpMasterBean(){
		
	}
	
	public EmpMasterBean(String empCode, String firstname, String lastname, String userName, String password) {
		this.empCode = empCode;
		this.firstName = firstname;
        this.lastName = lastname;
        this.userName = userName;
        this.password = password;
        //this.empGenInfo = empGenInfo;
    }

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getFuture_use4() {
		return future_use4;
	}

	public void setFuture_use4(String future_use4) {
		this.future_use4 = future_use4;
	}

	
	

	/*public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	

	public File getEmpImage() {
		return empImage;
	}

	public void setEmpImage(File empImage) {
		this.empImage = empImage;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}*/
	
	

	/*public EmployeeGenDetailsBean getEmployeeGenDetailsBean() {
		return employeeGenDetailsBean;
	}

	public void setEmployeeGenDetailsBean(
			EmployeeGenDetailsBean employeeGenDetailsBean) {
		this.employeeGenDetailsBean = employeeGenDetailsBean;
	}

	public EmpAddressBean getEmpAddressBean() {
		return empAddressBean;
	}

	public void setEmpAddressBean(EmpAddressBean empAddressBean) {
		this.empAddressBean = empAddressBean;
	}*/

	
	/*public EmployeeGenDetailsBean getEmpGenInfo() {
		return empGenInfo;
	}

	public void setEmpGenInfo(EmployeeGenDetailsBean empGenInfo) {
		this.empGenInfo = empGenInfo;
	}*/

	/*public EmpAddressBean getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(EmpAddressBean empAdd) {
		this.empAdd = empAdd;
	}*/

	/*public EmpFamilyDetails getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(EmpFamilyDetails familyDetails) {
		this.familyDetails = familyDetails;
	}

	public EmpEducationDetails getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(EmpEducationDetails educationDetails) {
		this.educationDetails = educationDetails;
	}

	public EmpProfInfoBean getEmpProfInfoBean() {
		return empProfInfoBean;
	}

	public void setEmpProfInfoBean(EmpProfInfoBean empProfInfoBean) {
		this.empProfInfoBean = empProfInfoBean;
	}*/
	
	/*public String execute()
    {
		RegisterAction registerUser=new RegisterAction();
		registerUser.insertDetails();
    	return "success";
    }*/
	
	
	

}
