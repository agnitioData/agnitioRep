package com.hrms.action;

import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.dao.EmpEducationDetailsUpdateDao;
import com.hrms.dao.EmpFamilyDetailsUpdateDao;
import com.hrms.dao.EmpProfessionalDetailsUpdateDao;
import com.hrms.dao.EmpProfileUpdateDao;
import com.hrms.model.EmpEducationDetails;
import com.hrms.model.EmpFamilyDetails;
import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rishabh Porwal
 *
 */
public class EmpProfileUpdateAction extends ActionSupport {
	
	
	private static final long serialVersionUID = -8044205431250923358L;
	private EmpProfileViewBean empProfileViewBean;
	private EmpProfessionalInfoBean empProfessionalInfoBean;
	private EmpFamilyDetails empFamilyDetails;
	private EmpEducationDetails empEducationDetails;
	String result="error";
	
	public String empBasicDetailsUpdate(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		if(validation=="success"){
			try {
				
				EmpProfileUpdateDao empProfileUpdateDao= new EmpProfileUpdateDao();
				
				result=empProfileUpdateDao.empBasicUpdate(empProfileViewBean);
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String empProfDetailsUpdate(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		if(validation=="success"){
			try {
				EmpProfessionalDetailsUpdateDao empProfessionalDetailsUpdateDao= new EmpProfessionalDetailsUpdateDao();
				System.out.println("Action");
				result=empProfessionalDetailsUpdateDao.empProfessionalUpdate(empProfessionalInfoBean);
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String empFamilyDetailsUpdate(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		if(validation=="success"){
			try {
				EmpFamilyDetailsUpdateDao empFamilyDetailsUpdateDao= new EmpFamilyDetailsUpdateDao();
				System.out.println("Action");
				result=empFamilyDetailsUpdateDao.empFamilyUpdate(empFamilyDetails);
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String empEduDetailsUpdate(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		if(validation=="success"){
			try {
				EmpEducationDetailsUpdateDao empFamilyDetailsUpdateDao= new EmpEducationDetailsUpdateDao();
				System.out.println("Action");
				result=empFamilyDetailsUpdateDao.empEduUpdate(empEducationDetails);
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String resetPassword(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		if(validation=="success"){
			try {
				
				EmpProfileUpdateDao empProfileUpdateDao= new EmpProfileUpdateDao();
				System.out.println("Action");
				result= empProfileUpdateDao.empPasswordReset(empProfileViewBean);
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public EmpProfileViewBean getEmpProfileViewBean() {
		return empProfileViewBean;
	}

	public void setEmpProfileViewBean(EmpProfileViewBean empProfileViewBean) {
		this.empProfileViewBean = empProfileViewBean;
	}

	public EmpProfessionalInfoBean getEmpProfessionalInfoBean() {
		return empProfessionalInfoBean;
	}

	public void setEmpProfessionalInfoBean(
			EmpProfessionalInfoBean empProfessionalInfoBean) {
		this.empProfessionalInfoBean = empProfessionalInfoBean;
	}

	public EmpFamilyDetails getEmpFamilyDetails() {
		return empFamilyDetails;
	}

	public void setEmpFamilyDetails(EmpFamilyDetails empFamilyDetails) {
		this.empFamilyDetails = empFamilyDetails;
	}

	public EmpEducationDetails getEmpEducationDetails() {
		return empEducationDetails;
	}

	public void setEmpEducationDetails(EmpEducationDetails empEducationDetails) {
		this.empEducationDetails = empEducationDetails;
	}
	
	

}
