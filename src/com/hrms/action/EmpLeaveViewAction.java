package com.hrms.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpLeaveManagingBean;
import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.dao.EmployeeLoginDao;
import com.hrms.model.EmpLeaveApplyBean;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.util.HibernateUtils;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EmpLeaveViewAction  extends ActionSupport{
	
	
	private static final long serialVersionUID = -2767741078841213578L;
	private List<EmployeeLeaveManagementBean> leaveViewData = new LinkedList<EmployeeLeaveManagementBean>();
	List<EmpLeaveManagingBean> allEmpLeaveDetailsList= new LinkedList<EmpLeaveManagingBean>();
	List<EmpLeaveApplyBean> empLeaveApplyDetailList;
	List<EmpMasterBean> empNameList = new LinkedList<EmpMasterBean>();
	String empName;
	//private EmpLeaveManagingBean empLeaveManagingBean;
	String validation;
	//@SuppressWarnings("unchecked")
	public String employeeLeaveInfo(){
		
		EmployeeLeaveManagementBean empLeaveManagingBean = null;
		
		
		validation= SessionTreckingCheckUtil.SessionCheck(); 
	
		if(validation=="success"){
		
			try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				List<EmployeeLeaveManagementBean> empLeaveInfoList = new ArrayList<EmployeeLeaveManagementBean>();
				String empCode = null;
				long empId;
				try {
					
					empId= EmployeeLoginDao.userId;
					empCode = EmployeeLoginDao.EMP_CODE;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean where empCode= " + empCode);
				 empLeaveInfoList = leaveQueryResult.list();
				 System.out.println(empLeaveInfoList);
				 
				 
				 Map<String,Object> row = null;
				 
				 Iterator<EmployeeLeaveManagementBean> allUsersListIterator = empLeaveInfoList.iterator();
					while(allUsersListIterator.hasNext())
				    {
						//EmployeeLeaveManagementBean emp = null;
						
						empLeaveManagingBean = allUsersListIterator.next();
						/*float totalLeaveVal= empLeaveManagingBean.getTotalLeaves();
						float remainLeaveVal= empLeaveManagingBean.getRemainingLeaves();
						float usedLeaveVal= empLeaveManagingBean.getUsedLeaves();*/
						leaveViewData.add(empLeaveManagingBean);
						/*System.out.println(totalLeaveVal + "-->" +   "-->" + usedLeaveVal);*/
				    }
				 /*for (Object object : empLeaveInfoList) {
						
				EmployeeLeaveManagementBean employeeLeaveManagementBeanVal = new EmployeeLeaveManagementBean();
				employeeLeaveManagementBeanVal.setTotalLeaves(row.get("Emp_Code").toString());
				System.out.println(employeeLeaveManagementBeanVal.getTotalLeaves());
				System.out.println(employeeLeaveManagementBeanVal.getRemainingLeaves());
				System.out.println(employeeLeaveManagementBeanVal.getUsedLeaves());
				StringBuilder sb = new StringBuilder();
				sb.append("select em.*, egi.*, ead.* ");
				sb.append("from Employee_Master em, EmployeeGeneralInfo egi, EmpAddressDetails ead ");
				sb.append("where em.Emp_id = ead.Emp_id and em.Emp_id = egi.Emp_Genid ");
				sb.append("and em.Emp_id="+ empId);
				Query queryResult=session.createSQLQuery(sb.toString());
				//Query queryResult = session.createQuery("from EmpMasterBean");
			
				 }*/
				//profileViewData = new ArrayList<>();
				}
			
			catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
	}
	
	public String leaveDetailsInfo(){
		
		validation= SessionTreckingCheckUtil.SessionCheck(); 
		
		if(validation=="success"){
			
			try {
				
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				List<EmpLeaveApplyBean> empLeaveDetailList = new ArrayList<EmpLeaveApplyBean>();
				String empCode = null;
				empLeaveApplyDetailList= new LinkedList<>();
				empCode = EmployeeLoginDao.EMP_CODE;
				 Query leaveQueryResult = session.createQuery("from EmpLeaveApplyBean where empCode= " + empCode);
				 empLeaveDetailList = leaveQueryResult.list();
				 
				 Iterator<EmpLeaveApplyBean> empLeaveIterator= empLeaveDetailList.iterator();
				 while (empLeaveIterator.hasNext()) {
					EmpLeaveApplyBean empLeaveApplyBean = (EmpLeaveApplyBean) empLeaveIterator.next();
					System.out.println(empLeaveApplyBean.getApplyDate());
					System.out.println(empLeaveApplyBean.getLeaveReason());
					empLeaveApplyDetailList.add(empLeaveApplyBean);
				}
				System.out.println("Leave History details");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return "success";
		
	}
	
	public String allEmpLeaveDetails(){
		String result="error";
		validation= SessionTreckingCheckUtil.SessionCheck();
		
		if(validation=="success"){
			try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				List<EmployeeLeaveManagementBean> empLeaveInfoList = new ArrayList<EmployeeLeaveManagementBean>();
				Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean ");
				 empLeaveInfoList = leaveQueryResult.list();
				 Iterator<EmployeeLeaveManagementBean> empLeaveInfoIterator= empLeaveInfoList.iterator();
				 while (empLeaveInfoIterator.hasNext()) {
					EmployeeLeaveManagementBean employeeLeaveManagementBean = (EmployeeLeaveManagementBean) empLeaveInfoIterator.next();
					EmpLeaveManagingBean empLeaveManagingBean= new EmpLeaveManagingBean();
					String empCode= employeeLeaveManagementBean.getEmpCode();
					empLeaveManagingBean.setEmpCode(employeeLeaveManagementBean.getEmpCode());
					empLeaveManagingBean.setRemainLeaves(employeeLeaveManagementBean.getRemainingLeaves());
					empLeaveManagingBean.setTotalLeaves(employeeLeaveManagementBean.getTotalLeaves());
					empLeaveManagingBean.setUsedLeaves(employeeLeaveManagementBean.getUsedLeaves());
					
					Query empAttendanceDetailsVal = session.createQuery("from EmpMasterBean where Emp_Code= " + empCode);
					empNameList = empAttendanceDetailsVal.list();
					empName=null;
					if(empNameList.size()>0){
						Iterator<EmpMasterBean> empNameIterator= empNameList.iterator();
						while (empNameIterator.hasNext()) {
							EmpMasterBean empMasterBean = (EmpMasterBean) empNameIterator.next();
							
							empName= empMasterBean.getFirstName() + " "+empMasterBean.getLastName();
							//empNameListVal.add(empName);
						}
					}
					empLeaveManagingBean.setEmpName(empName);
					allEmpLeaveDetailsList.add(empLeaveManagingBean);
				}
				 
				System.out.println();
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public List<EmpLeaveManagingBean> getAllEmpLeaveDetailsList() {
		return allEmpLeaveDetailsList;
	}

	public void setAllEmpLeaveDetailsList(
			List<EmpLeaveManagingBean> allEmpLeaveDetailsList) {
		this.allEmpLeaveDetailsList = allEmpLeaveDetailsList;
	}

	public List<EmpLeaveApplyBean> getEmpLeaveApplyDetailList() {
		return empLeaveApplyDetailList;
	}

	public void setEmpLeaveApplyDetailList(
			List<EmpLeaveApplyBean> empLeaveApplyDetailList) {
		this.empLeaveApplyDetailList = empLeaveApplyDetailList;
	}

	public List<EmployeeLeaveManagementBean> getLeaveViewData() {
		return leaveViewData;
	}

	public void setLeaveViewData(List<EmployeeLeaveManagementBean> leaveViewData) {
		this.leaveViewData = leaveViewData;
	}

	
	/*public EmpLeaveManagingBean getEmpLeaveManagingBean() {
		return empLeaveManagingBean;
	}

	public void setEmpLeaveManagingBean(EmpLeaveManagingBean empLeaveManagingBean) {
		this.empLeaveManagingBean = empLeaveManagingBean;
	}*/

	
}
