package com.hrms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.util.HibernateUtils;

public class EmpProfessionalInfoDao {
	
	private EmpProfessionalInfoBean empProfessionalInfoBean= null;
	private List<EmpProfessionalInfoBean> empProfessionalInfoBeanList;
	private List<EmpProfessionalInfoBean> empProfessionalInfoList;
	private List<EmpProfessionalInfoBean> result;
	public static String empManager="";
	public List<EmpProfessionalInfoBean> empProfInfo(){
		
		try {
			long empId= EmployeeLoginDao.userId;
			empProfessionalInfoBeanList= new ArrayList<EmpProfessionalInfoBean>();
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			Query empProfessionalDetailsVal = session.createQuery("from EmpProfessionalInfoBean where Emp_id= " + empId);
			empProfessionalInfoList = empProfessionalDetailsVal.list();

			Iterator<EmpProfessionalInfoBean> allUsersListIterator = empProfessionalInfoList.iterator();
			while(allUsersListIterator.hasNext())
			{
				EmpProfessionalInfoBean empProfessionalInfoBean= allUsersListIterator.next();
				empManager= empProfessionalInfoBean.getEmpManager();
				empProfessionalInfoBeanList.add(empProfessionalInfoBean);
				result= empProfessionalInfoBeanList;
				System.out.println(empProfessionalInfoBean);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
