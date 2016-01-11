package com.hrms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.util.HibernateUtils;

public class EmpProfessionalDetailsUpdateDao {
	
	String result="error";
	
	public String empProfessionalUpdate(EmpProfessionalInfoBean empProfVal){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			long id=EmployeeLoginDao.userId;
			int eid=(int)id;
			
			EmpProfessionalInfoBean empProfessionalVal = (EmpProfessionalInfoBean) session.get(EmpProfessionalInfoBean.class, eid);
			
			System.out.println("DaoSession");
			System.out.println(empProfVal.getCtc());
			empProfessionalVal.setCtc(empProfVal.getCtc());
			empProfessionalVal.setDepartment(empProfVal.getDepartment());
			empProfessionalVal.setDesignation(empProfVal.getDesignation());
			//empProfessionalVal.setDoj(doj);
			empProfessionalVal.setEmpManager(empProfVal.getEmpManager());
			empProfessionalVal.setEmpStatus(empProfVal.getEmpStatus());
			empProfessionalVal.setTotalExp(empProfVal.getTotalExp());
			
			session.saveOrUpdate(empProfessionalVal);
			System.out.println("success");
			result="success";
			t.commit();//transaction is committed  
			
			result="success";
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}

}
