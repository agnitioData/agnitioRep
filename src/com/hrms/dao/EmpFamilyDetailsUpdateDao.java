package com.hrms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpFamilyDetails;
import com.hrms.util.HibernateUtils;

public class EmpFamilyDetailsUpdateDao {
	
	String result="error";
	public String empFamilyUpdate(EmpFamilyDetails empFamily){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			long id=EmployeeLoginDao.userId;
			int eid=(int)id;
			EmpFamilyDetails empFamilyVal = (EmpFamilyDetails) session.get(EmpFamilyDetails.class, eid);
			
			empFamilyVal.setFmobileNo(empFamily.getFmobileNo());
			empFamilyVal.setFname(empFamily.getFname());
			empFamilyVal.setFoccupation(empFamily.getFoccupation());
			empFamilyVal.setMobileNo(empFamily.getMobileNo());
			empFamilyVal.setName(empFamily.getName());
			empFamilyVal.setOccupation(empFamily.getOccupation());
			empFamilyVal.setNoOfSiblings(empFamily.getNoOfSiblings());
			session.saveOrUpdate(empFamilyVal);
			System.out.println("success");
			result="success";
			t.commit();//transaction is committed  
			session.close(); 
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
