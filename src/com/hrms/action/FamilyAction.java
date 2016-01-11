package com.hrms.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpFamilyDetails;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class FamilyAction extends ActionSupport {

	
	private static final long serialVersionUID = 6506358200864219560L;
	private EmpFamilyDetails empFamilyDetailsBean;
	String result="error";
	
	public EmpFamilyDetails getEmpFamilyDetailsBean() {
		return empFamilyDetailsBean;
	}


	public void setEmpFamilyDetailsBean(EmpFamilyDetails empFamilyDetailsBean) {
		this.empFamilyDetailsBean = empFamilyDetailsBean;
	}


	public String execute(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			
			Transaction t= session.beginTransaction();
			
			System.out.println("Transaction begin"); 
			System.out.println(empFamilyDetailsBean);
			
			//empFamilyDetailsBean.setEid(1);
			session.save(empFamilyDetailsBean);
			t.commit();//transaction is committed  
			session.close();  
			System.out.println("done");
			result="success";
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
		
	}

}
