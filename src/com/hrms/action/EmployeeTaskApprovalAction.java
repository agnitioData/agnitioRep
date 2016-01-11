package com.hrms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.dao.EmployeeLoginDao;
import com.hrms.model.EmployeeTimeSheetSubmitDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeTaskApprovalAction extends ActionSupport {

	public EmployeeTimeSheetSubmitDetailsBean empTimeSheet;
	private List<EmployeeTimeSheetSubmitDetailsBean> empTimeSheetBeanList = new ArrayList<EmployeeTimeSheetSubmitDetailsBean>();
	
	
	
	public String execute()
	{
		
		List<String> data;
		String result = "error";
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			StringBuilder sb1 = new StringBuilder();
			sb1.append("select MAX(id) from HRD..Emp_TimeSheet_Detail");
			Query query=session.createSQLQuery(sb1.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data1 = query.list();
			String maxId = null;
			Map<String,Object> row1 = null;
			for (Object object : data1) {
				row1= (Map<String,Object>)object;
				maxId = row1.get("").toString();
			}
			StringBuilder sb = new StringBuilder();
			
			sb.append("select * FROM Emp_TimeSheet_Detail where AssignedBy ="+EmployeeLoginDao.EMP_CODE+" and Status = 'Unapproved'");
			Query queryResult=session.createSQLQuery(sb.toString());
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			data = queryResult.list();
			Map<String,Object> row = null;
	 		for (Object object : data) {
	 			row= (Map<String,Object>)object;
	 			empTimeSheet = new EmployeeTimeSheetSubmitDetailsBean();
	 			empTimeSheet.setEmpCode(row.get("Emp_Code").toString());
	 			empTimeSheet.setDate(row.get("Date").toString());
	 			empTimeSheet.setProjectName(row.get("ProjectName").toString());
	 			empTimeSheet.setTaskName(row.get("TaskName").toString());
	 			empTimeSheet.setTaskDescription(row.get("TaskDescription").toString());
	 			empTimeSheet.setHour(row.get("Hour").toString());
	 			empTimeSheet.setStatus(row.get("Status").toString());
	 			empTimeSheet.setAssignedBy(row.get("AssignedBy").toString());
	 			empTimeSheetBeanList.add(empTimeSheet);
	 			
	 		}
			result = "success";
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}



	public List<EmployeeTimeSheetSubmitDetailsBean> getEmpTimeSheetBeanList() {
		return empTimeSheetBeanList;
	}



	public void setEmpTimeSheetBeanList(
			List<EmployeeTimeSheetSubmitDetailsBean> empTimeSheetBeanList) {
		this.empTimeSheetBeanList = empTimeSheetBeanList;
	}
}
