package com.hrms.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpAttendenceDetailsBean;
import com.hrms.model.AttendenceUploadBean;
import com.hrms.model.EmpLeaveApplyBean;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.util.HibernateUtils;


public class AttendenceAndLeaveCheckDao {
	
	private EmpLeaveApplyBean empLeaveApplyBean= new EmpLeaveApplyBean();
	List<EmpAttendenceDetailsBean> attendenceValList;
	List<String> presentDurationList = new LinkedList<String>();
	List<String> absentDurationList = new LinkedList<String>();
	List<String> presentECodeList = new LinkedList<String>();
	List<String> absentECodeList = new LinkedList<String>();
	List<EmpAttendenceDetailsBean> absentList = new ArrayList<EmpAttendenceDetailsBean>();
	List<EmpAttendenceDetailsBean> presentList = new ArrayList<EmpAttendenceDetailsBean>();
	List<EmpMasterBean> empNameList = new LinkedList<EmpMasterBean>();
	List<String> empNameListVal = new LinkedList<String>();
	List<EmpAttendenceDetailsBean> allEmpAttendenceResultValList= new LinkedList<EmpAttendenceDetailsBean>();
	float leave;
	float totalLeaveVal;
	float remainLeaveVal;
	float usedLeaveVal;
 	long attd_Id;
 	String fromDateVal;
	String toDateVal;
	String result="error";
	String empName;
	
	
	public String empPresentAttendenceDetails(){
		
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			
			//long empId= EmployeeLoginDao.userId;
			List<EmpAttendenceDetailsBean> attendenceResultList;
			StringBuilder sb = new StringBuilder();
			sb.append("select * FROM Employee_AttendenceDetails where DateTime= ");
			sb.append("(select DateTime FROM Employee_AttendenceDetails where Attd_Id= ");
			sb.append("(select MAX(Attd_Id) FROM Employee_AttendenceDetails)) ");
			
			Query queryResult=session.createSQLQuery(sb.toString());
			
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			/*SessionFactory sessionFactoryAtt = HibernateUtils.getSessionFactory(); 
			Session sessionAtt =sessionFactoryAtt.openSession();  
			Transaction transaction= sessionAtt.beginTransaction();
			Query attendenceQueryResult = sessionAtt.createQuery("from AttendenceUploadBean where dateTime= "+ dateVal);*/
			attendenceResultList = queryResult.list(); 
			Map<String,Object> row = null;
			List data = queryResult.list();
			
			
			for (Object object : data) {
				
				EmpAttendenceDetailsBean attendenceUploadBean= new EmpAttendenceDetailsBean();
				row= (Map<String,Object>)object;
				String statusString= row.get("Status").toString();
				
				if(statusString.equals("P")){
					String empCode=row.get("EmpCode").toString();
					
					attendenceUploadBean.setEmpCode(row.get("EmpCode").toString());
					attendenceUploadBean.setDateTime(row.get("DateTime").toString());
					attendenceUploadBean.setWorkingHours(row.get("Working_duration").toString());
					attendenceUploadBean.setStatus(row.get("Status").toString());
					attendenceUploadBean.setInTime(row.get("In_Time").toString());
					attendenceUploadBean.setOutTime(row.get("Out_Time").toString());
					attendenceUploadBean.setEmpName(row.get("EmpName").toString());
					System.out.println(row.get("EmpName").toString());
					
					/*Query empProfessionalDetailsVal = session.createQuery("from EmpMasterBean where Emp_Code= " + empCode);
					empNameList = empProfessionalDetailsVal.list();
					empName=null;
					if(empNameList.size()>0){
						Iterator<EmpMasterBean> empNameIterator= empNameList.iterator();
						while (empNameIterator.hasNext()) {
							EmpMasterBean empMasterBean = (EmpMasterBean) empNameIterator.next();
							
							empName= empMasterBean.getFirstName() + " "+empMasterBean.getLastName();
							//empNameListVal.add(empName);
						}
					}
					attendenceUploadBean.setEmpName(empName);*/
					presentList.add(attendenceUploadBean);
				}
			}
			result="success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*System.out.println(attendenceResultList);
		Iterator<AttendenceUploadBean> attendenceResultIterator= attendenceResultList.iterator();
		while (attendenceResultIterator.hasNext()) {
			AttendenceUploadBean attendenceUploadBean = (AttendenceUploadBean) attendenceResultIterator.next();
			String statusString =attendenceUploadBean.getStatus();
			String empCode =attendenceUploadBean.getEmpCode();
			String durationString =attendenceUploadBean.getWorkingDuration();
			
			if(statusString.equals("A"))
			{
				absentList.add(statusString);
				absentECodeList.add(empCode);
				absentDurationList.add(durationString);
				leave= 1.0f;

			}
			else{
				presentList.add(statusString);
				presentECodeList.add(empCode);
				presentDurationList.add(durationString);
			}
		}*/
		
		
		return result;
	}
	
	

	public List<EmpAttendenceDetailsBean> getAbsentList() {
		return absentList;
	}
	public void setAbsentList(List<EmpAttendenceDetailsBean> absentList) {
		this.absentList = absentList;
	}

	public List<EmpAttendenceDetailsBean> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<EmpAttendenceDetailsBean> presentList) {
		this.presentList = presentList;
	}



	public String empAbsentAttendenceDetails(){
		
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			
			//long empId= EmployeeLoginDao.userId;
			List<EmpAttendenceDetailsBean> attendenceResultList;
			StringBuilder sb = new StringBuilder();
			sb.append("select * FROM Employee_AttendenceDetails where DateTime= ");
			sb.append("(select DateTime FROM Employee_AttendenceDetails where Attd_Id= ");
			sb.append("(select MAX(Attd_Id) FROM Employee_AttendenceDetails)) ");
			
			Query queryResult=session.createSQLQuery(sb.toString());
			
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			/*SessionFactory sessionFactoryAtt = HibernateUtils.getSessionFactory(); 
			Session sessionAtt =sessionFactoryAtt.openSession();  
			Transaction transaction= sessionAtt.beginTransaction();
			Query attendenceQueryResult = sessionAtt.createQuery("from AttendenceUploadBean where dateTime= "+ dateVal);*/
			attendenceResultList = queryResult.list(); 
			Map<String,Object> row = null;
			List data = queryResult.list();
			
			for (Object object : data) {
				
				row= (Map<String,Object>)object;
				EmpAttendenceDetailsBean attendenceUploadBean= new EmpAttendenceDetailsBean();
				String statusString= row.get("Status").toString();
				
				if(statusString.equals("A"))
				{
					String empCode=row.get("EmpCode").toString();
					attendenceUploadBean.setEmpCode(row.get("EmpCode").toString());
					attendenceUploadBean.setDateTime(row.get("DateTime").toString());
					attendenceUploadBean.setWorkingHours(row.get("Working_duration").toString());
					attendenceUploadBean.setStatus(row.get("Status").toString());
					attendenceUploadBean.setInTime(row.get("In_Time").toString());
					attendenceUploadBean.setOutTime(row.get("Out_Time").toString());
					attendenceUploadBean.setEmpName(row.get("EmpName").toString());
					System.out.println(row.get("EmpName").toString());
					
					/*Query empProfessionalDetailsVal = session.createQuery("from EmpMasterBean where Emp_Code= " + empCode);
					empNameList = empProfessionalDetailsVal.list();
					empName=null;
					if(empNameList.size()>0){
						Iterator<EmpMasterBean> empNameIterator= empNameList.iterator();
						while (empNameIterator.hasNext()) {
							EmpMasterBean empMasterBean = (EmpMasterBean) empNameIterator.next();
							
							empName= empMasterBean.getFirstName() + " "+empMasterBean.getLastName();
							//empNameListVal.add(empName);
						}
					}
					attendenceUploadBean.setEmpName(empName);*/
					absentList.add(attendenceUploadBean);
				}
				
				
				
			}
			result="success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println(attendenceResultList);
		Iterator<AttendenceUploadBean> attendenceResultIterator= attendenceResultList.iterator();
		while (attendenceResultIterator.hasNext()) {
			AttendenceUploadBean attendenceUploadBean = (AttendenceUploadBean) attendenceResultIterator.next();
			String statusString =attendenceUploadBean.getStatus();
			String empCode =attendenceUploadBean.getEmpCode();
			String durationString =attendenceUploadBean.getWorkingDuration();
			
			if(statusString.equals("A"))
			{
				absentList.add(statusString);
				absentECodeList.add(empCode);
				absentDurationList.add(durationString);
				leave= 1.0f;

			}
			else{
				presentList.add(statusString);
				presentECodeList.add(empCode);
				presentDurationList.add(durationString);
			}
		}*/
		
		
		return result;
	}
	
	public String allEmpAttendence(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			
			List<AttendenceUploadBean> empAttendenceResultList;
			
			Query allEmpAttendenceQuery = session.createQuery("from AttendenceUploadBean ");
			empAttendenceResultList= allEmpAttendenceQuery.list();
			Iterator<AttendenceUploadBean> allEmpAttendenceResultIterator= empAttendenceResultList.iterator();
			while (allEmpAttendenceResultIterator.hasNext()) {
				AttendenceUploadBean attendenceDetailsBean = (AttendenceUploadBean) allEmpAttendenceResultIterator.next();
				EmpAttendenceDetailsBean empAttendenceDetailsBean= new EmpAttendenceDetailsBean();
				String empCode= attendenceDetailsBean.getEmpCode();
				empAttendenceDetailsBean.setEmpCode(attendenceDetailsBean.getEmpCode());
				empAttendenceDetailsBean.setDateTime(attendenceDetailsBean.getDateTime());
				empAttendenceDetailsBean.setInTime(attendenceDetailsBean.getEmpInTime());
				empAttendenceDetailsBean.setOutTime(attendenceDetailsBean.getEmpOutTime());
				empAttendenceDetailsBean.setWorkingHours(attendenceDetailsBean.getWorkingDuration());
				empAttendenceDetailsBean.setStatus(attendenceDetailsBean.getStatus());
				empAttendenceDetailsBean.setEmpName(attendenceDetailsBean.getEmpName());
				/*Query empAttendanceDetailsVal = session.createQuery("from EmpMasterBean where Emp_Code= " + empCode);
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
				empAttendenceDetailsBean.setEmpName(empName);*/
				allEmpAttendenceResultValList.add(empAttendenceDetailsBean);
				//System.out.println(allEmpAttendenceResultValList);
			}
			result="success";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
		
	}



	public List<EmpAttendenceDetailsBean> getAllEmpAttendenceResultValList() {
		return allEmpAttendenceResultValList;
	}

	public void setAllEmpAttendenceResultValList(
			List<EmpAttendenceDetailsBean> allEmpAttendenceResultValList) {
		this.allEmpAttendenceResultValList = allEmpAttendenceResultValList;
	}
	
	
	/*public String attendenceAndLeaveCheck(){
		
		String empCode= EmployeeLoginDao.EMP_CODE;
		String result="success";
		SessionFactory sf = HibernateUtils.getSessionFactory(); 
		Session session=sf.getCurrentSession();
		Transaction t= session.beginTransaction();
		Query attendenceDetailsVal = session.createQuery("from AttendenceUploadBean where empCode= " + empCode);
		attendenceValList = attendenceDetailsVal.list();
		Iterator<AttendenceUploadBean> attendenceBeanIterator= attendenceValList.iterator();
		
		while (attendenceBeanIterator.hasNext()) {
			AttendenceUploadBean attendenceUploadBean = (AttendenceUploadBean) attendenceBeanIterator.next();
			String status= attendenceUploadBean.getStatus();
			//durationList.add(attendenceUploadBean.getWorkingDuration());
			if(status.equals("A")){
				absentList.add(attendenceUploadBean.getStatus());
				absentDateList.add(attendenceUploadBean.getDateTime());
				absentDurationList.add(attendenceUploadBean.getWorkingDuration());
				leave= 1.0f;
			}
			else if(status.equals("P")){
				Date date;
				try {
					String time= attendenceUploadBean.getWorkingDuration();
					//int foo = Integer.parseInt(time);
					//System.out.println(foo);
					DateFormat sdf = new SimpleDateFormat("hh:mm");
					date = sdf.parse(time);
					int workingHr= date.getHours();
					if(workingHr<4){
						leave= 1.0f;
					}
					else if(workingHr>4 && workingHr<8){
						leave= 0.5f;
					}
					else{
						leave= 0.0f;
					}
					
					List<EmployeeLeaveManagementBean> leaveResultList;
					Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean where Employee_Code= "+ empCode);
					leaveResultList = leaveQueryResult.list(); 
					Iterator<EmployeeLeaveManagementBean> allUsersListIterator = leaveResultList.iterator();
					while (allUsersListIterator.hasNext()) {
						EmployeeLeaveManagementBean employeeLeaveManagementBean = (EmployeeLeaveManagementBean) allUsersListIterator.next();
						totalLeaveVal= employeeLeaveManagementBean.getTotalLeaves();
					 	remainLeaveVal= employeeLeaveManagementBean.getRemainingLeaves();
					 	usedLeaveVal= employeeLeaveManagementBean.getUsedLeaves();
					 	attd_Id= employeeLeaveManagementBean.getLeave_ID();
					}
					 	float remainingLeaves= remainLeaveVal - leave;
						float usedLeaves= usedLeaveVal + leave;
						EmployeeLeaveManagementBean employeeLeaveManagementVal = (EmployeeLeaveManagementBean) session.get(EmployeeLeaveManagementBean.class, attd_Id);
						 employeeLeaveManagementVal.setEmpCode(empCode);
				    	 employeeLeaveManagementVal.setTotalLeaves(totalLeaveVal);
				    	 employeeLeaveManagementVal.setRemainingLeaves(remainingLeaves);
				    	 employeeLeaveManagementVal.setUsedLeaves(usedLeaves);
				    	 session.saveOrUpdate(employeeLeaveManagementVal);
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    
				presentList.add(attendenceUploadBean.getStatus());
				presentDateList.add(attendenceUploadBean.getDateTime());
				presentDurationList.add(attendenceUploadBean.getWorkingDuration());
			}
			else{
				
			}
			statusList.add(attendenceUploadBean.getStatus());
			dateList.add(attendenceUploadBean.getDateTime());
		}
		int count=0;
		String fromString = null;
		String toString = null;
		List<EmpLeaveApplyBean> empLeaveDetailList = new ArrayList<EmpLeaveApplyBean>();
		 Query leaveQueryResultVal = session.createQuery("from EmpLeaveApplyBean where empCode= " + empCode);
		 empLeaveDetailList = leaveQueryResultVal.list();
		 
		 Iterator<EmpLeaveApplyBean> empLeaveIterator= empLeaveDetailList.iterator();
		 while (empLeaveIterator.hasNext()) {
			EmpLeaveApplyBean empLeaveApplyBean = (EmpLeaveApplyBean) empLeaveIterator.next();
			String fromDate= empLeaveApplyBean.getFromDate();
			System.out.println(empLeaveApplyBean.getApplyDate());
			System.out.println(empLeaveApplyBean.getLeaveReason());
			
			if(absentDateList.contains(fromDate)){
				System.out.println("This Date is already inserted");
			}
			else{
				for (int i=0; i<(absentDateList.size()-1); i++){
					
				fromDateVal= absentDateList.get(i);
				toDateVal= absentDateList.get(i+1);
				int from = Integer.parseInt(fromDateVal.substring(0, 2));
				int to = Integer.parseInt(toDateVal.substring(0, 2));
				int days= to - from;
				if(days==1){
					System.out.println("1 days");
					count++;
					if(count==1)
					{
						fromString = fromDateVal;
					}
					toString = toDateVal;
					empLeaveApplyBean.setLeaveReason("Casual Leave");
					empLeaveApplyBean.setApplyDate(fromString);
					empLeaveApplyBean.setFromDate(fromString);
					empLeaveApplyBean.setToDate(toString);
					empLeaveApplyBean.setEmpCode(empCode);
					empLeaveApplyBean.setStatus("Pending");
					empLeaveApplyBean.setNoOfDays(count);
					session.save(empLeaveApplyBean);
				}
				
				else{
					count=0;
					empLeaveApplyBean.setLeaveReason("Casual Leave");
					empLeaveApplyBean.setApplyDate(absentDateList.get(i));
					empLeaveApplyBean.setFromDate(absentDateList.get(i));
					empLeaveApplyBean.setToDate(absentDateList.get(i));
					empLeaveApplyBean.setEmpCode(empCode);
					empLeaveApplyBean.setStatus("Pending");
					empLeaveApplyBean.setNoOfDays(1);
					session.save(empLeaveApplyBean);
				}
				//String days= toDateVal - fromDateVal;
				System.out.println("From: "+ fromDateVal + "To: "+ toDateVal + "days: "+ days);
				}
			}
			//empLeaveApplyDetailList.add(empLeaveApplyBean);
		}
		 
		 List<EmployeeLeaveManagementBean> leaveResultList;
		 Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean where Employee_Code= "+ empCode);
		 leaveResultList = leaveQueryResult.list(); 
		 Iterator<EmployeeLeaveManagementBean> allUsersListIterator = leaveResultList.iterator();
		 while (allUsersListIterator.hasNext()) {
			EmployeeLeaveManagementBean employeeLeaveManagementBean = (EmployeeLeaveManagementBean) allUsersListIterator.next();
			totalLeaveVal= employeeLeaveManagementBean.getTotalLeaves();
		 	remainLeaveVal= employeeLeaveManagementBean.getRemainingLeaves();
		 	usedLeaveVal= employeeLeaveManagementBean.getUsedLeaves();
		 	attd_Id= employeeLeaveManagementBean.getLeave_ID();
		}
		 	float remainingLeaves= remainLeaveVal - leave;
			float usedLeaves= usedLeaveVal + leave;
			EmployeeLeaveManagementBean employeeLeaveManagementVal = (EmployeeLeaveManagementBean) session.get(EmployeeLeaveManagementBean.class, attd_Id);
			 employeeLeaveManagementVal.setEmpCode(empCode);
	    	 employeeLeaveManagementVal.setTotalLeaves(totalLeaveVal);
	    	 employeeLeaveManagementVal.setRemainingLeaves(remainingLeaves);
	    	 employeeLeaveManagementVal.setUsedLeaves(usedLeaves);
	    	 session.saveOrUpdate(employeeLeaveManagementVal);
		 
		return result;
		
	}*/

}
