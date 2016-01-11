package com.agni.hrms.schedular;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.hrms.model.EmployeeGenDetailsBean;
import com.hrms.util.BirthdayMailSend;
import com.hrms.util.HibernateUtils;

public class BirthdayWishesEventSchedular implements Job  {
	
	List<String> employeeDOBListVal = new LinkedList<String>();
	EmployeeGenDetailsBean employeeGenDetailsBean;
	String email;
	Date date;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		try {
			/*if(ServiceStatusChecker.isJobRunning(arg0,this.getClass().getName()) == true)
			{
				System.out.println("Yes, it is already running ------------------------------->");
			}
			else
			{*/
				System.out.println("Starting---------------------------------------->");
				new BirthdayWishesEventSchedular().executeBirthdayEvent();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void executeBirthdayEvent(){
		
		try {
			
			List<EmployeeGenDetailsBean> employeeDOBList = new LinkedList<EmployeeGenDetailsBean>();
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			session.beginTransaction();
			String currentDate;
			String currentDayString = "";
			String currentMonthString = "";
			/*StringBuilder empCodeString= new StringBuilder();
			empCodeString.append("select Date_of_birth ");
			empCodeString.append("from EmployeeGeneralInfo");*/
			Query queryResult = session.createQuery("from EmployeeGenDetailsBean");
			//Query queryLeaveResult=session.createSQLQuery(empCodeString.toString());
			employeeDOBList = queryResult.list();
			
			 Iterator<EmployeeGenDetailsBean> allUsersDOBIterator = employeeDOBList.iterator();
				while(allUsersDOBIterator.hasNext())
			    {
					//EmployeeLeaveManagementBean emp = null;
					employeeGenDetailsBean= new EmployeeGenDetailsBean();
					EmployeeGenDetailsBean empGeneralVal = allUsersDOBIterator.next();
					String dob= empGeneralVal.getDob();
					email = empGeneralVal.getEmailId();
					System.out.println(dob);
					System.out.println(email);
					String dobDate= dob.substring(0, 2);
					String dobMonth =dob.substring(3, 5);
					String dateMonthVal= dobDate+"/"+dobMonth;
					 System.out.println(dateMonthVal );
					 System.out.println(dobMonth);
					 
					 	
					    Calendar cal = Calendar.getInstance();
					    //cal.setTime(date);
					    int year = cal.get(Calendar.YEAR);
					    Integer month = cal.get(Calendar.MONTH);
					    int currentMonth= month+1;
					    String monthString = Integer.toString(month);
					    if(monthString.length()==1){
					    	currentMonthString = "0"+currentMonth;
					    }
					    else{
					    	currentMonthString= Integer.toString(month);
					    }
					    int day = cal.get(Calendar.DAY_OF_MONTH);
					    String dayString = Integer.toString(day);
					    if(dayString.length()==1){
					    	 currentDayString = "0"+dayString;
					    }
					    else{
					    	currentDayString= Integer.toString(day);
					    }
					    currentDate = currentDayString+"/"+currentMonthString;
					    System.out.println(currentDate);
					    System.out.println(day + "-->" + month +   "-->" + year);
					
					//String empDOB= employeeGenDetailsBean.getDob();
					/*float totalLeaveVal= empLeaveManagingBean.getTotalLeaves();
					float remainLeaveVal= empLeaveManagingBean.getRemainingLeaves();
					float usedLeaveVal= empLeaveManagingBean.getUsedLeaves();*/
					//employeeDOBListVal.add(employeeGenDetailsBean);
					System.out.println(dob + "-->" +   "-->" + currentDate);
					 try {
						 BirthdayMailSend birthdayMailSend = new BirthdayMailSend();
						 //TimePassClass tym=new TimePassClass();
						if(currentDate.equalsIgnoreCase(dateMonthVal)){
							 
						    	System.out.println("Hii");
						    	//BirthdayMailSend birthdayMailSend = new BirthdayMailSend();
						    	String result= birthdayMailSend.sendMail(email);
						    	//tym.time();
						    	System.out.println(result);
						    }
						    else{
						    	System.out.println("Bye");
						    }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
