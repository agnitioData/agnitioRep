package com.hrms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpEducationDetails;
import com.hrms.model.EmpFamilyDetails;
import com.hrms.util.HibernateUtils;

public class EmpEducationDetailsUpdateDao {
	
	String result="error";
	public String empEduUpdate(EmpEducationDetails empEducation){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			long id=EmployeeLoginDao.userId;
			int eid=(int)id;
			EmpEducationDetails empEduVal = (EmpEducationDetails) session.get(EmpEducationDetails.class, eid);
			
			empEduVal.setGraduationDegree(empEducation.getGraduationDegree());
			empEduVal.setGraduationGrade(empEducation.getGraduationGrade());
			empEduVal.setGraduationUniversity(empEducation.getGraduationUniversity());
			empEduVal.setGraduationYearOfPass(empEducation.getGraduationYearOfPass());
			
			empEduVal.setPgDegree(empEducation.getPgDegree());
			empEduVal.setPgGrade(empEducation.getPgGrade());
			empEduVal.setPgUniversity(empEducation.getPgUniversity());
			empEduVal.setPgYearOfPass(empEducation.getPgYearOfPass());
			
			empEduVal.setTenthDegree(empEducation.getTenthDegree());
			empEduVal.setTenthGrade(empEducation.getTenthGrade());
			empEduVal.setTenthUniversity(empEducation.getTenthUniversity());
			empEduVal.setTenthYearOfPass(empEducation.getTenthYearOfPass());
			
			empEduVal.setTwelveDegree(empEducation.getTwelveDegree());
			empEduVal.setTwelveGrade(empEducation.getTwelveGrade());
			empEduVal.setTwelveUniversity(empEducation.getTwelveUniversity());
			empEduVal.setTwelveYearOfPass(empEducation.getTwelveYearOfPass());
			session.saveOrUpdate(empEduVal);
			result="success";
			t.commit();//transaction is committed  
			session.close(); 
			System.out.println("success");
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
