package com.hrms.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.model.EmployeeTimeSheetSubmitDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class AllEmpTimesheetAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 7187250999772058884L;
	List<EmployeeTimeSheetSubmitDetailsBean> empTimesheetInfoList= new LinkedList<EmployeeTimeSheetSubmitDetailsBean>();
	String result="error";
	
	public String allEmpTimeSheet(){
		
		try {
			
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			
			List<EmployeeTimeSheetSubmitDetailsBean> empTimesheetList = new ArrayList<EmployeeTimeSheetSubmitDetailsBean>();
			Query leaveQueryResult = session.createQuery("from EmployeeTimeSheetSubmitDetailsBean ");
			
			empTimesheetList = leaveQueryResult.list();
			System.out.println("time");
			Iterator<EmployeeTimeSheetSubmitDetailsBean> empTimesheetIterator= empTimesheetList.iterator();
			while (empTimesheetIterator.hasNext()) {
				System.out.println("timeshet");
				EmployeeTimeSheetSubmitDetailsBean employeeTimeSheetSubmitDetailsBean = (EmployeeTimeSheetSubmitDetailsBean) empTimesheetIterator.next();
				EmployeeTimeSheetSubmitDetailsBean employeeTimeSheet= new EmployeeTimeSheetSubmitDetailsBean();
				System.out.println(employeeTimeSheetSubmitDetailsBean.getAssignedBy());
				employeeTimeSheet.setAssignedBy(employeeTimeSheetSubmitDetailsBean.getAssignedBy());
				employeeTimeSheet.setDate(employeeTimeSheetSubmitDetailsBean.getDate());
				employeeTimeSheet.setEmpCode(employeeTimeSheetSubmitDetailsBean.getEmpCode());
				employeeTimeSheet.setHour(employeeTimeSheetSubmitDetailsBean.getHour());
				employeeTimeSheet.setProjectName(employeeTimeSheetSubmitDetailsBean.getProjectName());
				employeeTimeSheet.setStatus(employeeTimeSheetSubmitDetailsBean.getStatus());
				employeeTimeSheet.setTaskDescription(employeeTimeSheetSubmitDetailsBean.getTaskDescription());
				employeeTimeSheet.setTaskName(employeeTimeSheetSubmitDetailsBean.getTaskName());
				empTimesheetInfoList.add(employeeTimeSheet);
				System.out.println("sheet");
			}
			System.out.println(empTimesheetInfoList);
			result="success";
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public List<EmployeeTimeSheetSubmitDetailsBean> getEmpTimesheetInfoList() {
		return empTimesheetInfoList;
	}
	public void setEmpTimesheetInfoList(
			List<EmployeeTimeSheetSubmitDetailsBean> empTimesheetInfoList) {
		this.empTimesheetInfoList = empTimesheetInfoList;
	}
	
	

}
