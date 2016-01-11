package com.hrms.action;

import java.util.LinkedList;
import java.util.List;

import com.agni.hrms.bean.EmpAttendenceBean;
import com.hrms.dao.AttendenceAndLeaveCheckDao;
import com.hrms.dao.EmployeeAttendenceViewDao;
import com.hrms.dao.EmployeeLoginDao;
import com.hrms.model.AttendenceUploadBean;
import com.hrms.model.EmpAttendenceDetailsBean;
import com.hrms.model.EmpMasterBean;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rishabh Porwal
 * This class is responsible to fetch employees attendance
 */
public class EmpAttendenceMaintenanceAction extends ActionSupport {

	static int check=0;
	private static final long serialVersionUID = -5068615928117261363L;
	private EmployeeLoginDao  employeeLoginDao;
	private static List<AttendenceUploadBean> attendenceViewData;
	public List<EmpAttendenceBean> empAttendenceDetailsList = new LinkedList<EmpAttendenceBean>();
	String result="error";
   
	private List<AttendenceUploadBean> attendenceDetailsBean;
   //private EmpAttendenceDetailsBean attendenceDetailsBean;
	private EmpMasterBean empMasterBean;
	
	public EmpMasterBean getEmpMasterBean() {
		return empMasterBean;
	}

	public void setEmpMasterBean(EmpMasterBean empMasterBean) {
		this.empMasterBean = empMasterBean;
	}

	
	public List<AttendenceUploadBean> getAttendenceDetailsBean() {
		return attendenceDetailsBean;
	}

	public void setAttendenceDetailsBean(
			List<AttendenceUploadBean> attendenceDetailsBean) {
		this.attendenceDetailsBean = attendenceDetailsBean;
	}

	public String employeeAttendenceRetrieve(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck(); 
			
		if(validation=="success"){
			try{
				empAttendenceDetailsList= new LinkedList<EmpAttendenceBean>();
				EmployeeAttendenceViewDao employeeAttendenceViewDao=new EmployeeAttendenceViewDao();
				empAttendenceDetailsList= employeeAttendenceViewDao.attendenceView();
				
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			
			}
		
			result="success";
			}
		
			return result;
		}
	
	public String attendenceCheck(){
		
		String validation= SessionTreckingCheckUtil.SessionCheck();
		
		if(validation=="success"){
			
			try {
				/*attendenceDetailsBean= new AttendenceAndLeaveCheckDao().empAttendenceDetails();
				System.out.println(attendenceDetailsBean);*/
				result="success";
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public List<EmpAttendenceBean> getEmpAttendenceDetailsList() {
		return empAttendenceDetailsList;
	}

	public void setEmpAttendenceDetailsList(
			List<EmpAttendenceBean> empAttendenceDetailsList) {
		this.empAttendenceDetailsList = empAttendenceDetailsList;
	}

	

	

	

	

}
