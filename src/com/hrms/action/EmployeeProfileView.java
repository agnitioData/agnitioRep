package com.hrms.action;

import java.util.List;

import com.agni.hrms.bean.EmpFamilyDetailsBean;
import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.dao.EmpEducationDetailsDao;
import com.hrms.dao.EmpFamilyDetailsDao;
import com.hrms.dao.EmpProfessionalInfoDao;
import com.hrms.model.EmpEducationDetails;
import com.hrms.model.EmpFamilyDetails;
import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rishabh Porwal
 * This class is responsible to retrieve employee information from DB.
 */
public class EmployeeProfileView extends ActionSupport {

	
	private static final long serialVersionUID = 3755240802315228897L;
	private List<EmpFamilyDetails> empFamilyDetailsList1;
	private List<EmpFamilyDetails> empFamilyDetailsList2;
	private List<EmpProfessionalInfoBean> empProfessionalInfoList;
	private List<EmpProfileViewBean> empProfileViewBeanList;
	private List<EmpEducationDetails> empEducationDetailsList;
	List<EmpFamilyDetails> empFamilyDetailsList;
	String result= "error";

	/*Method to view employee basic Details*/
	public String empBasicDetails(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck(); 
		
		if(validation=="success"){
			try {
				
				EmpProfileInfoViewDao empProfileInfoViewDao= new EmpProfileInfoViewDao();
				empProfileViewBeanList= empProfileInfoViewDao.employeeProfileInfo();
				result= "success";
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;  
		
	}
	
	/*Method to view employee Professional Details*/
	public String empProfessionalInfo(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck(); 
		
		if(validation=="success"){
			try {
				
				EmpProfessionalInfoDao empProfessionalInfoDao= new EmpProfessionalInfoDao();
				empProfessionalInfoList= empProfessionalInfoDao.empProfInfo();
				result= "success";
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;  
		
	} 
	
	/*Method to view employee Family Details*/
	public String empFamilyDetails(){
		//EmpFamilyDetails EmpFamilyDetails;
		String validation= SessionTreckingCheckUtil.SessionCheck(); 
		
		if(validation=="success"){
			try {
				
				EmpFamilyDetailsDao empFamilyDetailsDao =new EmpFamilyDetailsDao();
				empFamilyDetailsList= empFamilyDetailsDao.familyInfo();
				/*for(int i=0; i<=empFamilyDetailsList.size(); i++){
					empFamilyDetailsList1= empFamilyDetailsList.get(0);
					empFamilyDetailsList2= empFamilyDetailsList.get(1);
				}*/
				result= "success";
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	return result;
		
	}
	
	public String empEducationDetails(){
		//EmpFamilyDetails EmpFamilyDetails;
		String validation= SessionTreckingCheckUtil.SessionCheck(); 
		
		if(validation=="success"){
			try {
				
				EmpEducationDetailsDao empFamilyDetailsDao =new EmpEducationDetailsDao();
				empEducationDetailsList= empFamilyDetailsDao.educationInfo();
				/*for(int i=0; i<=empFamilyDetailsList.size(); i++){
					empFamilyDetailsList1= empFamilyDetailsList.get(0);
					empFamilyDetailsList2= empFamilyDetailsList.get(1);
				}*/
				result= "success";
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	return result;
		
	}

	public List<EmpFamilyDetails> getEmpFamilyDetailsList1() {
		return empFamilyDetailsList1;
	}

	public void setEmpFamilyDetailsList1(
			List<EmpFamilyDetails> empFamilyDetailsList1) {
		this.empFamilyDetailsList1 = empFamilyDetailsList1;
	}

	public List<EmpFamilyDetails> getEmpFamilyDetailsList2() {
		return empFamilyDetailsList2;
	}

	public void setEmpFamilyDetailsList2(
			List<EmpFamilyDetails> empFamilyDetailsList2) {
		this.empFamilyDetailsList2 = empFamilyDetailsList2;
	}

	public List<EmpProfessionalInfoBean> getEmpProfessionalInfoList() {
		return empProfessionalInfoList;
	}

	public void setEmpProfessionalInfoList(
			List<EmpProfessionalInfoBean> empProfessionalInfoList) {
		this.empProfessionalInfoList = empProfessionalInfoList;
	}

	public List<EmpProfileViewBean> getEmpProfileViewBeanList() {
		return empProfileViewBeanList;
	}

	public void setEmpProfileViewBeanList(
			List<EmpProfileViewBean> empProfileViewBeanList) {
		this.empProfileViewBeanList = empProfileViewBeanList;
	}

	public List<EmpEducationDetails> getEmpEducationDetailsList() {
		return empEducationDetailsList;
	}

	public void setEmpEducationDetailsList(
			List<EmpEducationDetails> empEducationDetailsList) {
		this.empEducationDetailsList = empEducationDetailsList;
	}

	public List<EmpFamilyDetails> getEmpFamilyDetailsList() {
		return empFamilyDetailsList;
	}

	public void setEmpFamilyDetailsList(List<EmpFamilyDetails> empFamilyDetailsList) {
		this.empFamilyDetailsList = empFamilyDetailsList;
	}

	
	

	
	
	
}
