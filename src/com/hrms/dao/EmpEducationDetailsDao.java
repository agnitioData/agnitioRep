package com.hrms.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpEducationDetails;
import com.hrms.util.HibernateUtils;

public class EmpEducationDetailsDao {
	
	List<EmpEducationDetails> empEducationInfoList= new LinkedList<EmpEducationDetails>();
	List<EmpEducationDetails> result;
	
	public List<EmpEducationDetails> educationInfo(){
		
		try {
			List<EmpEducationDetails> empEducationValList= new LinkedList<EmpEducationDetails>();
			long empId= EmployeeLoginDao.userId;
			empEducationInfoList= new LinkedList<>();
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			Query empProfessionalDetailsVal = session.createQuery("from EmpEducationDetails where Emp_id= " + empId);
			empEducationInfoList = empProfessionalDetailsVal.list();
			Iterator<EmpEducationDetails> empEducationDetailsIterator= empEducationInfoList.iterator();
			while (empEducationDetailsIterator.hasNext()) {
				EmpEducationDetails empEducationDetails = (EmpEducationDetails) empEducationDetailsIterator.next();
				System.out.println(empEducationDetails.getGraduationDegree());
				System.out.println(empEducationDetails.getGraduationUniversity());
				System.out.println(empEducationDetails.getGraduationGrade());
				empEducationValList.add(empEducationDetails);
				result= empEducationValList;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
