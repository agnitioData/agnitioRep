package com.hrms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.dao.EmployeeLoginDao;
import com.hrms.model.EmpViewTimeSheetBean;
import com.hrms.model.EmployeeNotification;
import com.hrms.model.EmployeeTimeSheetSubmitDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;


public class EmployeeTimeSheetSubmitAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1284189674865920837L;

	EmployeeTimeSheetSubmitDetailsBean empTimeSheetDetailBean = new EmployeeTimeSheetSubmitDetailsBean();
	
	public EmployeeTimeSheetSubmitDetailsBean empViewTimeSheetBean;
	private List<EmployeeTimeSheetSubmitDetailsBean> empTimeSheetBeanList = new ArrayList<EmployeeTimeSheetSubmitDetailsBean>();
	public List<EmployeeTimeSheetSubmitDetailsBean> getEmpTimeSheetBeanList() {
		return empTimeSheetBeanList;
	}



	public void setEmpTimeSheetBeanList(
			List<EmployeeTimeSheetSubmitDetailsBean> empTimeSheetBeanList) {
		this.empTimeSheetBeanList = empTimeSheetBeanList;
	}
	

	
	EmployeeTimeSheetSubmitDetailsBean empTimeSheet;
	public EmployeeTimeSheetSubmitDetailsBean getEmpTimeSheet() {
		return empTimeSheet;
	}

	public void setEmpTimeSheet(EmployeeTimeSheetSubmitDetailsBean empTimeSheet) {
		this.empTimeSheet = empTimeSheet;
	}

	EmployeeNotification employeeNotification = new EmployeeNotification();
	public EmployeeNotification getEmployeeNotification() {
		return employeeNotification;
	}

	public void setEmployeeNotification(EmployeeNotification employeeNotification) {
		this.employeeNotification = employeeNotification;
	}

	
	public EmployeeTimeSheetSubmitDetailsBean getEmpTimeSheetDetailBean() {
		return empTimeSheetDetailBean;
	}

	public void setEmpTimeSheetDetailBean(
			EmployeeTimeSheetSubmitDetailsBean empTimeSheetDetailBean) {
		this.empTimeSheetDetailBean = empTimeSheetDetailBean;
	}
	
	private String empCode;
	private String date;
	private String projectName;
	private String taskName;
	private String hour;
	private String taskDescription;
	private String assignedBy;
	
	private boolean status;
	

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	String result="error";

	public String submitTimeSheet(){
         
		 	try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.openSession();  
				Transaction t= session.beginTransaction();
				empTimeSheetDetailBean.setStatus("Unapproved");
				empTimeSheetDetailBean.setEmpCode(EmployeeLoginDao.EMP_CODE);
				System.out.println(empTimeSheetDetailBean.getAssignedBy());
				employeeNotification.setEmpCode(empTimeSheetDetailBean.getAssignedBy());
				employeeNotification.setMsg("Task Approval Pending");
				Long EmpId = (Long) session.save(empTimeSheetDetailBean);
				Long res = (Long) session.save(employeeNotification);
				t.commit();//transaction is committed  
				session.close();
				
			if(EmpId!=0 && res!=0){  
				System.out.println("successfully saved");
				result="success";
				}
			
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result; 
		    
		    
	 }
	public void getStatus()
	{
		System.out.println("-------------------------------------------------------");
		System.out.println(getDate());
		System.out.println(getProjectName());

	 	try {
	 		Query query;
	 		String sql;
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb = new StringBuilder();
			sb.append("UPDATE Emp_TimeSheet_Detail SET Status='Approved'");
			sb.append(" where Emp_Code ='"+empTimeSheet.getEmpCode()+"' and Date ='"+empTimeSheet.getDate()+"' and ProjectName ='"+empTimeSheet.getProjectName()+"' and TaskName ='"+empTimeSheet.getTaskName()+"' and TaskDescription ='"+empTimeSheet.getTaskDescription()+"' and Hour ='"+empTimeSheet.getHour()+"' and AssignedBy ='"+empTimeSheet.getAssignedBy()+"'");
			query=session.createSQLQuery(sb.toString());
	        int row = query.executeUpdate();
	        
	        sb = new StringBuilder();
	        sb.append("select MAX(id) from HRD..Employee_Notification");
	        query=session.createSQLQuery(sb.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List dataNotification = query.list();
			//List dataNotification = query.list();
			String idNotification = null;
			Map<String,Object> row2 = null;
			for (Object object : dataNotification) {
				row2= (Map<String,Object>)object;
				idNotification = row2.get("").toString();
			}
			
			sb = new StringBuilder();
			sb.append("DELETE FROM HRD..Employee_Notification WHERE id ="+idNotification);
			query=session.createSQLQuery(sb.toString());
	        int row3 = query.executeUpdate();
			t.commit();//transaction is committed  
			session.close();
			if(row!=0)
			{
				System.out.println("Deleted from Employee TimeSheet");
			}
			if(row3!=0)
			{
				System.out.println("Deleted from Notification");
			}
			
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public String viewTimeSheet()
	{
		String res = "error";
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select * FROM Emp_TimeSheet_Detail where Emp_Code ="+EmployeeLoginDao.EMP_CODE);
			Query queryResult=session.createSQLQuery(sb.toString());
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data = queryResult.list();
			Map<String,Object> row = null;
			for (Object object : data) {
	 			row= (Map<String,Object>)object;
	 			empViewTimeSheetBean = new EmployeeTimeSheetSubmitDetailsBean();
	 			empViewTimeSheetBean.setEmpCode(row.get("Emp_Code").toString());
	 			empViewTimeSheetBean.setDate(row.get("Date").toString());
	 			empViewTimeSheetBean.setProjectName(row.get("ProjectName").toString());
	 			empViewTimeSheetBean.setTaskName(row.get("TaskName").toString());
	 			empViewTimeSheetBean.setTaskDescription(row.get("TaskDescription").toString());
	 			empViewTimeSheetBean.setHour(row.get("Hour").toString());
	 			empViewTimeSheetBean.setAssignedBy(row.get("AssignedBy").toString());
	 			empViewTimeSheetBean.setStatus(row.get("Status").toString());
	 			empTimeSheetBeanList.add(empViewTimeSheetBean);
	 		}
			
			res = "success";
			t.commit();//transaction is committed  
			session.close();
			
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	
	
	

}
