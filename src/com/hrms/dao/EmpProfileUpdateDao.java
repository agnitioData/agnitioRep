package com.hrms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.model.EmpAddressBean;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeGenDetailsBean;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.util.HibernateUtils;

/**
 * 
 * @author Rishabh Porwal
 *
 */
public class EmpProfileUpdateDao {
	
	String result="error";
	//private EmpProfileViewBean empProfileViewBean;
	public String empBasicUpdate(EmpProfileViewBean empValue){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			long id=EmployeeLoginDao.userId;
			int eid=(int)id;
			//empProfileViewBean= new EmpProfileViewBean();
			
			EmpMasterBean employeeMasterVal = (EmpMasterBean) session.get(EmpMasterBean.class, id);
			employeeMasterVal.setFirstName(empValue.getFirstName());
			employeeMasterVal.setLastName(empValue.getLastName());
			session.saveOrUpdate(employeeMasterVal);
			
			EmployeeGenDetailsBean employeeGenVal = (EmployeeGenDetailsBean) session.get(EmployeeGenDetailsBean.class, id);
			employeeGenVal.setAccountNo(empValue.getAccountNumber());
			employeeGenVal.setAnniversaryDate(empValue.getAnniversaryDate());
			employeeGenVal.setDob(empValue.getDob());
			employeeGenVal.setEmailId(empValue.getEmailId());
			employeeGenVal.setMaritalStatus(empValue.getMarritalStatus());
			employeeGenVal.setPanNo(empValue.getPanNumber());
			employeeGenVal.setPassportNo(empValue.getPassportNumber());
			session.saveOrUpdate(employeeGenVal);
			
			EmpAddressBean employeeAddressVal = (EmpAddressBean) session.get(EmpAddressBean.class, eid);
			employeeAddressVal.setMobileNo(empValue.getMobileNumber());
			employeeAddressVal.setPermanentAdd(empValue.getPermanenetAddress());
			employeeAddressVal.setPresentAdd(empValue.getPresentAddress());
			session.saveOrUpdate(employeeAddressVal);
			System.out.println(empValue.getFirstName());
			System.out.println(empValue.getPassportNumber());
			t.commit();//transaction is committed  
			result="success";
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String empPasswordReset(EmpProfileViewBean empValue){
		String result="error";
		try {
			System.out.println("h");
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			long id=EmployeeLoginDao.userId;
			int eid=(int)id;
			
			EmpMasterBean employeeMasterVal = (EmpMasterBean) session.get(EmpMasterBean.class, id);
			String pwd= employeeMasterVal.getPassword();
			String empCode= employeeMasterVal.getEmpCode();
			
			String prevPwd= empValue.getPassword();
			String newPwd= empValue.getNewPassword();
			String confirmPwd= empValue.getConfirmPassword();
			if(prevPwd.equals(pwd)&& confirmPwd.equals(newPwd)){
				
				employeeMasterVal.setPassword(newPwd);
				session.saveOrUpdate(employeeMasterVal);
				result="success";
				t.commit();//transaction is committed  
				
				
			}
			else{
				System.out.println("Sorry! Password is not matched");
			}
			
			
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
