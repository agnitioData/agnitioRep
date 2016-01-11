package com.hrms.action;

import java.util.List;

import org.hibernate.HibernateException;

import com.agni.hrms.bean.EmployeesListBean;
import com.hrms.dao.EmployeesListViewDao;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author Rishabh Porwal
 *
 */
public class EmployeeListDetailsAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -4408774577331517210L;
	private EmployeesListBean employeesListBean;
	private List<EmployeesListBean> employeesListBeanList;
	public String result="error";
	
	
	public List<EmployeesListBean> getEmployeesListBeanList() {
		return employeesListBeanList;
	}



	public void setEmployeesListBeanList(
			List<EmployeesListBean> employeesListBeanList) {
		this.employeesListBeanList = employeesListBeanList;
	}



	public EmployeesListBean getEmployeesListBean() {
		return employeesListBean;
	}



	public void setEmployeesListBean(EmployeesListBean employeesListBean) {
		this.employeesListBean = employeesListBean;
	}



	public String execute(){
		
		try{
			employeesListBeanList = new EmployeesListViewDao().empListDetails();
			result="success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
