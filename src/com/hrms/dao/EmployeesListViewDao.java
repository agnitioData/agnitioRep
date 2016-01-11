package com.hrms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmployeesListBean;
import com.hrms.util.HibernateUtils;

public class EmployeesListViewDao {

	private List<EmployeesListBean> empViewData;
	String firstName = null;
	String lastName = null;
	String ecode = null;
	String empStatus = null;

	public List<EmployeesListBean> empListDetails(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			List allUsersList;
			//long empId= employeeLoginDao.userId;
			StringBuilder sb = new StringBuilder();
			sb.append("select em.Emp_Code, em.First_name, em.Last_name, epi.Employee_Status ");
			sb.append("from Employee_Master em, Employee_ProfessionalInfo epi ");
			sb.append("where em.Emp_id = epi.Emp_id ");
			//sb.append("and em.Emp_id="+ empId);
			Query queryResult=session.createSQLQuery(sb.toString());
			//Query queryResult = session.createQuery("from EmpMasterBean");
			empViewData = new ArrayList<>();
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			Map<String,Object> row = null;
			List data = queryResult.list();
			
			
			for (Object object : data) {
				
				EmployeesListBean empListViewBean = new EmployeesListBean();
			
				row= (Map<String,Object>)object;
				//ecode= String.valueOf(row.get("Emp_Code"));
		     
				empListViewBean.setEmpCode(row.get("Emp_Code").toString());
				empListViewBean.setFirstName(row.get("First_name").toString());
				empListViewBean.setLastName(row.get("Last_name").toString());
				empListViewBean.setEmpStatus(row.get("Employee_Status").toString());
				System.out.println(row.get("Emp_Code").toString());
				System.out.println(row.get("First_name").toString());
				System.out.println(row.get("Last_name").toString());
				System.out.println(row.get("Employee_Status").toString());
				empViewData.add(empListViewBean);
			}
			
			return empViewData;
			
			//System.out.println(data);
			//profileViewData = new ArrayList<>();
			 
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
