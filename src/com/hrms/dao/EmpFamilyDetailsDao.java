package com.hrms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hrms.model.EmpFamilyDetails;
import com.hrms.util.HibernateUtils;

/**
 * 
 * @author Rishabh Porwal
 * this class is responsible to fetch emp family details
 *
 */
public class EmpFamilyDetailsDao {
	
	private EmpFamilyDetails empFamilyDetails1 = null;
	private List<EmpFamilyDetails> familyViewData= new LinkedList<EmpFamilyDetails>();
	List<List<EmpFamilyDetails>>resultVal = new LinkedList<List<EmpFamilyDetails>>();
	List<EmpFamilyDetails> result;
	public List<EmpFamilyDetails> familyInfo(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			session.beginTransaction();
			long empId= EmployeeLoginDao.userId;
			List<EmpFamilyDetails> empFamilyDetailsList1 = new ArrayList<EmpFamilyDetails>();
			new ArrayList<EmpFamilyDetails>();
			 Query empFamilyDetailsVal = session.createQuery("from EmpFamilyDetails where Emp_id= " + empId);
			 empFamilyDetailsList1 = empFamilyDetailsVal.list();
			 System.out.println(empFamilyDetailsList1);
			 Iterator<EmpFamilyDetails> allUsersListIterator1 = empFamilyDetailsList1.iterator();
				while(allUsersListIterator1.hasNext())
			    {
					empFamilyDetails1 = allUsersListIterator1.next();
					
					familyViewData.add(empFamilyDetails1);
					
					
					result= familyViewData;
			    }
				
				
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
