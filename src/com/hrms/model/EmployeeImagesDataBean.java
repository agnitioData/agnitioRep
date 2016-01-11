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

@Entity
@Table(name = "EmpImages_DataTable")
public class EmployeeImagesDataBean {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
     
    @Column(name = "IMAGE_NAME", unique = false, nullable = false, length = 100)
    private String imageName;
    
    @Column(name = "IMAGE_Address", unique = false, nullable = false, length = 100)
    private String imageAddress;
     
    @Column(name = "DATA", unique = false, nullable = false, length = 100000)
    private byte[] data;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id")
	private EmpMasterBean employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public EmpMasterBean getEmployees() {
		return employees;
	}

	public void setEmployees(EmpMasterBean employees) {
		this.employees = employees;
	}
    
    

}
