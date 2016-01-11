package com.agni.hrms.schedular;

import java.util.ArrayList;
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
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.util.HibernateUtils;



public class LeaveIncrementSchedular implements Job  {

	private EmployeeLeaveManagementBean empLeaveBean;
	private String empCode;
	private long attd_Id;
	static int count=0;
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
			new LeaveIncrementSchedular().executeLeaveIncrementor();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void executeLeaveIncrementor(){
		float totalLeaves = 0.0f;
		float remainingLeaves = 0.0f;
		float usedLeaves = 0.0f;
		float cfLeaves = 0.0f;

		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();

			StringBuilder sb = new StringBuilder();
			sb.append("select em.Emp_Code, em.Emp_id, em.First_name, em.Last_name, epi.Employee_Status ");
			sb.append("from Employee_Master em, Employee_ProfessionalInfo epi ");
			sb.append("where em.Emp_id = epi.Emp_id ");
			//sb.append("and em.Emp_id="+ empId);
			Query queryResult=session.createSQLQuery(sb.toString());
			//Query queryResult = session.createQuery("from EmpMasterBean");
			//empViewData = new ArrayList<>();
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			Map<String,Object> row = null;
			List data = queryResult.list();
			List<String> confirmedEmpList = new LinkedList<String>();
			List<String> probationEmpList = new LinkedList<String>();
			List<Long> leaveIdList = new LinkedList<Long>();
			for (Object object : data) {

				//EmployeesListBean empListViewBean = new EmployeesListBean();

				row= (Map<String,Object>)object;
				//ecode= String.valueOf(row.get("Emp_Code"));

				String empCode= row.get("Emp_Code").toString();
				//long empId= (long) row.get("Emp_id");
				System.out.println(row.get("Emp_Code").toString());
				System.out.println(row.get("Emp_id").toString());

				String empStatus= row.get("Employee_Status").toString();
				if(empStatus.equalsIgnoreCase("Confirm"))
				{
					confirmedEmpList.add(row.get("Emp_Code").toString());
					//System.out.println(row.get("Emp_Code").toString());
				}
				else{

					probationEmpList.add(row.get("Emp_Code").toString());
					//System.out.println(row.get("Emp_Code").toString());
				}

			}


			String empCodeVal;
			float totalLeaveVal ;
			float remainLeaveVal;
			float usedLeaveVal;
			float cfLeaveVal=0.0f;
			

			List<EmployeeLeaveManagementBean> leaveResultList;
			Query leaveQueryResult = session.createQuery("from EmployeeLeaveManagementBean");
			leaveResultList = leaveQueryResult.list(); 


			for(int i = 0; i<confirmedEmpList.size(); i++)
			{
				Iterator<EmployeeLeaveManagementBean> allUsersListIterator = leaveResultList.iterator();
				
				while(allUsersListIterator.hasNext())
				{

					empCode = confirmedEmpList.get(i);

					totalLeaves =  2.25f;
					remainingLeaves =  2.25f;
					usedLeaves =  0.0f;
					cfLeaves= 0.0f;
					empLeaveBean = allUsersListIterator.next();
					empCodeVal = empLeaveBean.getEmpCode();

					if(empCode.equalsIgnoreCase(empCodeVal))
					{
						if(count==12)
						{
							System.out.println(count);
							remainLeaveVal= empLeaveBean.getRemainingLeaves();
							if(remainLeaveVal>=8){
								cfLeaveVal= 8.0f;
							}
							else{
								cfLeaveVal= remainLeaveVal;
							}
							totalLeaveVal = 2.25f;
							remainLeaveVal = 2.25f;
							usedLeaveVal = 0.0f;
							//cfLeaveVal = 0.0f;
							//count = 0;
						}
						else
						{
							totalLeaveVal= empLeaveBean.getTotalLeaves();
							remainLeaveVal= empLeaveBean.getRemainingLeaves();
							usedLeaveVal= empLeaveBean.getUsedLeaves();
							cfLeaveVal= empLeaveBean.getCarryFwdLeaves();
						}
						

						attd_Id= empLeaveBean.getLeave_ID();
						leaveIdList.add(attd_Id);

						totalLeaves= totalLeaveVal + totalLeaves;
						remainingLeaves= remainLeaveVal + remainingLeaves;
						usedLeaves= usedLeaveVal;
						cfLeaves= cfLeaveVal;

						EmployeeLeaveManagementBean employeeLeaveManagementVal = (EmployeeLeaveManagementBean) session.get(EmployeeLeaveManagementBean.class, attd_Id);
						employeeLeaveManagementVal.setEmpCode(empCodeVal);
						employeeLeaveManagementVal.setTotalLeaves(totalLeaves);
						employeeLeaveManagementVal.setRemainingLeaves(remainingLeaves);
						employeeLeaveManagementVal.setUsedLeaves(usedLeaves);
						employeeLeaveManagementVal.setCarryFwdLeaves(cfLeaveVal);
						session.saveOrUpdate(employeeLeaveManagementVal);
					}
					else{

						/*Query leaveQueryResult1 = session.createQuery("from EmployeeLeaveManagementBean");
						 	leaveResultList = leaveQueryResult.list(); */
						
						float totalLeaves1 =  2.25f;
						float remainingLeaves1 =  2.25f;
						float usedLeaves1 =  0.0f;
						float carryFwdLeaves =  0.0f;
						List<EmployeeLeaveManagementBean> leaveEmpCodeList = new ArrayList<EmployeeLeaveManagementBean>();

						StringBuilder empCodeString= new StringBuilder();
						empCodeString.append("select Employee_Code ");
						empCodeString.append("from EmployeeLeaveInformation");

						Query queryLeaveResult=session.createSQLQuery(empCodeString.toString());
						leaveEmpCodeList = queryLeaveResult.list();


						if(leaveEmpCodeList.contains(empCode))
						{
							System.out.println("Already Inserted");
						}
						else
						{
							if(count==12)
							{
								System.out.println(count);
								remainLeaveVal= empLeaveBean.getRemainingLeaves();
								if(remainLeaveVal>=8){
									cfLeaveVal= 8.0f;
								}
								else{
									cfLeaveVal= remainLeaveVal;
								}
								totalLeaveVal = 2.25f;
								remainLeaveVal = 2.25f;
								usedLeaveVal = 0.0f;
								//cfLeaveVal = 0.0f;
								
							}
							/*else
							{
								totalLeaveVal= empLeaveBean.getTotalLeaves();
								remainLeaveVal= empLeaveBean.getRemainingLeaves();
								usedLeaveVal= empLeaveBean.getUsedLeaves();
								cfLeaveVal= empLeaveBean.getCarryFwdLeaves();
							}*/
							System.out.println(empCode +":" + totalLeaves1 +":" + remainingLeaves1 +":" + usedLeaves1);
							EmployeeLeaveManagementBean employeeLeaveManagementBean = new EmployeeLeaveManagementBean(empCode, totalLeaves1, remainingLeaves1, usedLeaves1, carryFwdLeaves);
							session.save(employeeLeaveManagementBean);
							break;
						}
					}
				}
			}

			/*for(int i = 0; i<confirmedEmpList.size(); i++)
			 {
				empCode = confirmedEmpList.get(i);
				float totalLeaves1 =  2.25f;
			 	float remainingLeaves1 =  2.25f;
				float usedLeaves1 =  0.0f;
				float carryFwdLeaves =  0.0f;
				List<EmployeeLeaveManagementBean> leaveEmpCodeList = new ArrayList<EmployeeLeaveManagementBean>();

				StringBuilder empCodeString= new StringBuilder();
				empCodeString.append("select Employee_Code ");
				empCodeString.append("from EmployeeLeaveInformation");

				Query queryLeaveResult=session.createSQLQuery(empCodeString.toString());
				leaveEmpCodeList = queryLeaveResult.list();


				if(leaveEmpCodeList.contains(empCode))
				{
					System.out.println("Already Inserted");
				}
				else
				{
					System.out.println(empCode +":" + totalLeaves1 +":" + remainingLeaves1 +":" + usedLeaves1+":" + carryFwdLeaves);
					EmployeeLeaveManagementBean employeeLeaveManagementBean = new EmployeeLeaveManagementBean(empCode, totalLeaves1, remainingLeaves1, usedLeaves1, carryFwdLeaves);
					session.save(employeeLeaveManagementBean);
					break;
				}
			 }*/

			
			t.commit();
			if(count==12)
			{
				count = 0;
			}
			count++;
			/*if(count==13)
			{
				 totalLeaves =  2.25f;
				 remainingLeaves =  2.25f;
				 usedLeaves =  0.0f;
				// count=0;
			}*/
			//session.close();
			System.out.println("Successfully Saved");
			System.out.println(count);
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


