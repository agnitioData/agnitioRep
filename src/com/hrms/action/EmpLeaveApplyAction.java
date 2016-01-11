package com.hrms.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.LeaveMailBean;
import com.hrms.dao.EmpProfessionalInfoDao;
import com.hrms.dao.EmployeeLoginDao;
import com.hrms.model.EmpLeaveApplyBean;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeGenDetailsBean;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.model.EmployeeNotification;
import com.hrms.util.EmailSend;
import com.hrms.util.HibernateUtils;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EmpLeaveApplyAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 8179780573921022378L;
	private EmpLeaveApplyBean empLeaveApplyBean= new EmpLeaveApplyBean();
	private LeaveMailBean leaveMailBean = new LeaveMailBean();
	EmployeeNotification employeeNotification = new EmployeeNotification();
	List<EmployeeLeaveManagementBean> empLeaveInfoList;
	String result= "error";
	float remainLeaveVal;
	float usedLeaveVal;
	float totalLeaveVal;
	long attd_Id;
	String email;
	public EmpLeaveApplyBean getEmpLeaveApplyBean() {
		return empLeaveApplyBean;
	}

	public void setEmpLeaveApplyBean(EmpLeaveApplyBean empLeaveApplyBean) {
		this.empLeaveApplyBean = empLeaveApplyBean;
	}
	
	public LeaveMailBean getLeaveMailBean() {
		return leaveMailBean;
	}

	public void setLeaveMailBean(LeaveMailBean leaveMailBean) {
		this.leaveMailBean = leaveMailBean;
	}

	public String empLeaveApply(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		
		if(validation=="success"){
			try{
				
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				
				int date = Calendar.getInstance().get(Calendar.DATE);
				int month = Calendar.getInstance().get(Calendar.MONTH);
				int year = Calendar.getInstance().get(Calendar.YEAR);
				month= month+1;
				String dateString= date+"-"+month+"-"+year;
				System.out.println(dateString);
				//long empId= EmployeeLoginDao.userId;
				String empCode = EmployeeLoginDao.EMP_CODE;
				empLeaveApplyBean.setApplyDate(dateString);
				empLeaveApplyBean.setEmpCode(empCode);
				empLeaveApplyBean.setStatus("Pending");
				//EmpLeaveApplyBean empLeaveApplyBeanVal =new EmpLeaveApplyBean(empCode, empLeaveApplyBean.getApplyDate(), empLeaveApplyBean.getNoOfDays(), empLeaveApplyBean.getLeaveReason());
				session.save(empLeaveApplyBean);
				
				Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean where empCode= " + empCode);
				empLeaveInfoList = leaveQueryResult.list();
				Iterator<EmployeeLeaveManagementBean> allUsersListIterator = empLeaveInfoList.iterator();
				while(allUsersListIterator.hasNext())
			    {
					EmployeeLeaveManagementBean emp = null;
					
					emp = allUsersListIterator.next();
					totalLeaveVal= emp.getTotalLeaves();
					remainLeaveVal= emp.getRemainingLeaves();
					usedLeaveVal= emp.getUsedLeaves();
					attd_Id= emp.getLeave_ID();
					//leaveViewData.add(empLeaveManagingBean);
					System.out.println(totalLeaveVal + "-->" +   "-->" + usedLeaveVal);
			    }
				
				if(remainLeaveVal<=(empLeaveApplyBean.getNoOfDays())){
					addActionError("You can't apply for more than Remaining leaves!");
					return result;
					
				}
				else{
					
					float remainingLeaves= remainLeaveVal - (empLeaveApplyBean.getNoOfDays());
					float usedLeaves= usedLeaveVal + (empLeaveApplyBean.getNoOfDays());
					EmployeeLeaveManagementBean employeeLeaveManagementVal = (EmployeeLeaveManagementBean) session.get(EmployeeLeaveManagementBean.class, attd_Id);
					 employeeLeaveManagementVal.setEmpCode(empCode);
			    	 employeeLeaveManagementVal.setTotalLeaves(totalLeaveVal);
			    	 employeeLeaveManagementVal.setRemainingLeaves(remainingLeaves);
			    	 employeeLeaveManagementVal.setUsedLeaves(usedLeaves);
			    	 session.saveOrUpdate(employeeLeaveManagementVal);
				}
				try {
					List<EmpMasterBean> empMasterBeanList= new LinkedList<EmpMasterBean>();
					String empMngr=EmpProfessionalInfoDao.empManager;
					employeeNotification.setEmpCode(empMngr);
					employeeNotification.setMsg("Task Approval Pending");
					session.save(employeeNotification);
					Query empMasterDetailsVal = session.createQuery("from EmpMasterBean where Emp_Code= " + empMngr);
					empMasterBeanList= empMasterDetailsVal.list();
					Iterator<EmpMasterBean> empMasterBeanIterator= empMasterBeanList.iterator();
					while (empMasterBeanIterator.hasNext()) {
						EmpMasterBean empMasterBean = (EmpMasterBean) empMasterBeanIterator
								.next();
						long eid= empMasterBean.getId();
						EmployeeGenDetailsBean employeeGenVal = (EmployeeGenDetailsBean) session.get(EmployeeGenDetailsBean.class, eid);
						email= employeeGenVal.getEmailId();
					}
					List<String> to = new ArrayList<String>();
					to.add(email);
					to.add("rishabh.porwal@agnitio-technologies.com");
					to.add("kurmarao@agnitio-technologies.com");
					String subject= "Leave";
					String message= empLeaveApplyBean.getLeaveReason();
					String pwd= "Welcome$12345";
					
					List<String> toAddress= to;
					EmailSend.sendEmail("leaves@agnitio-technologies.com", pwd, toAddress, subject, message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.commit();
				//session.close();
				System.out.println("Successfully Saved");
				addActionMessage("Successfully Applied!");
				result= "success";
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		addActionError("There is some problem to Apply!");
		return result;
		
	}
	
	
	

}
