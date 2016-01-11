package com.hrms.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.AttendenceUploadBean;
import com.hrms.model.EmpLeaveApplyBean;
import com.hrms.model.EmployeeLeaveManagementBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rishabh Porwal
 * this class is responsible to upload attendance from excel to DB.
 */
public class AttendenceUploadAction extends ActionSupport {

	private static final long serialVersionUID = 7410468838336317412L;
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private HttpServletRequest request;
	private AttendenceUploadBean attendenceUploadBean;
	public String result="error";
	/**
	 * 
	 */
	List<String> presentDurationList = new LinkedList<String>();
	List<String> absentDurationList = new LinkedList<String>();
	List<String> presentDateList = new LinkedList<String>();
	List<String> absentDateList = new LinkedList<String>();
	List<String> absentList = new LinkedList<String>();
	List<String> presentList = new LinkedList<String>();
	List<String> applyDateList = new LinkedList<String>();
	float leave;
	float totalLeaveVal;
	float remainLeaveVal;
	float usedLeaveVal;
	long leave_Id;
	String fromDateVal;
	String toDateVal;
	String fromString;
	String toString;
	String dateVal;
	/**
	 * 
	 */
	static LinkedList<List> empAttendenceList = new LinkedList<>();
	static Map<String, LinkedList<List>> empAttendenceMap = new LinkedHashMap<>(); 

	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public AttendenceUploadBean getAttendenceUploadBean() {
		return attendenceUploadBean;
	}
	public void setAttendenceUploadBean(AttendenceUploadBean attendenceUploadBean) {
		this.attendenceUploadBean = attendenceUploadBean;
	}
	public String execute()
	{
		try{
			List<String> empCodeList = null;
			List<String> dateList = null;
			List<String> inTimeList = null;
			List<String> outTimeList = null;
			List<String> durationList = null;
			List<String> statusList = null;
			List<String> empNameList = null;

			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();

			request = ServletActionContext.getRequest();
			//String filePath = request.getSession().getServletContext().getRealPath("/").concat(uploadFile.toString());
			String filePath = uploadFile.toString();  // Path where uploaded file will be stored
			FileInputStream fileInputStream = new FileInputStream(filePath);
			System.out.println(fileInputStream);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

			//HSSFSheet worksheet = workbook.getSheet("Monthly_WorkDurationReport");
			HSSFSheet worksheet = workbook.getSheet("Sheet1");
			HSSFRow row1 = worksheet.getRow(0);
			Iterator itRow = worksheet.rowIterator();
			String empCodeValue = "";
			String empNameValue = "";
			empCodeList = new LinkedList<>();
			dateList = new LinkedList<>();
			inTimeList = new LinkedList<>();
			outTimeList = new LinkedList<>();
			durationList = new LinkedList<>();
			statusList = new LinkedList<>();
			empNameList = new LinkedList<>();
			while(itRow.hasNext())
			{
				HSSFRow row = (HSSFRow) itRow.next();
				java.util.Iterator itCell = row.cellIterator();
				while(itCell.hasNext())
				{
					empCodeValue = "";
					empNameValue = "";

					HSSFCell cell = (HSSFCell) itCell.next();
					if(cell.getStringCellValue().equals("Employee Code:-"))
					{
						HSSFCell localCell = (HSSFCell) row.getCell((short) 10);
						//System.out.println(localCell.getStringCellValue());
						empCodeValue = localCell.getStringCellValue();
						empCodeList.add(empCodeValue);


					}
					
					if(cell.getStringCellValue().equals("Employee Code:-"))
					{
						HSSFCell localCell = (HSSFCell) row.getCell((short) 25);
						//System.out.println(localCell.getStringCellValue());
						empNameValue = localCell.getStringCellValue();
						empNameList.add(empNameValue);


					}
					if(cell.getStringCellValue().equals("Days"))	
					{
						while(itCell.hasNext())
						{
							HSSFCell localCell = (HSSFCell) itCell.next();
							dateList.add(localCell.getStringCellValue());
						}

					}

					if(cell.getStringCellValue().equals("In Time"))
					{
						while(itCell.hasNext())
						{

							HSSFCell localCell = (HSSFCell) itCell.next();
							inTimeList.add(localCell.getStringCellValue());
						}
					}
					if(cell.getStringCellValue().equals("Out Time"))
					{
						while(itCell.hasNext())
						{
							HSSFCell localCell = (HSSFCell) itCell.next();
							outTimeList.add(localCell.getStringCellValue());

						}
					}

					if(cell.getStringCellValue().equals("Duration"))
					{
						while(itCell.hasNext())
						{
							HSSFCell localCell = (HSSFCell) itCell.next();
							durationList.add(localCell.getStringCellValue());

						}
					}

					if(cell.getStringCellValue().equals("Status"))
					{
						while(itCell.hasNext())
						{
							HSSFCell localCell = (HSSFCell) itCell.next();
							statusList.add(localCell.getStringCellValue());

						}
					}
				}
			}


			int counter = 0;
			empCodeList.removeAll(Arrays.asList(null, ""));
			dateList.removeAll(Arrays.asList(null, ""));
			inTimeList.removeAll(Arrays.asList(null, ""));
			outTimeList.removeAll(Arrays.asList(null, ""));
			durationList.removeAll(Arrays.asList(null, ""));
			statusList.removeAll(Arrays.asList(null, ""));
			empNameList.removeAll(Arrays.asList(null, ""));
			for(int empCodeCount = 0; empCodeCount<empCodeList.size(); empCodeCount++)
			{	
				absentList.clear();
				absentDateList.clear();
				absentDurationList.clear();
				presentList.clear();
				presentDateList.clear();
				presentDurationList.clear();
				String empCode = empCodeList.get(empCodeCount);
				String empName = empNameList.get(empCodeCount);
				int j = 0;
				for(int i = counter; i<(counter+dateList.size()); i++, j++)
				{
					int year = Calendar.getInstance().get(Calendar.YEAR);
					String dateVal = dateList.get(j)+"-"+"2015";
					String inTimeString = inTimeList.get(i);
					String outTimeString = outTimeList.get(i);
					String durationString = durationList.get(i);
					String statusString = statusList.get(i);
					System.out.println(empCode+":"+empName+":"+dateVal+" :"+inTimeString+" :"+outTimeString+" :"+durationString+" :"+statusString);
					AttendenceUploadBean attendenceUploadDetails= new AttendenceUploadBean(empCode, empName, dateVal, inTimeString, outTimeString, durationString, statusString);
					session.save(attendenceUploadDetails);
					/**
					 * 
					 */


					if(statusString.equals("A"))
					{
						absentList.add(statusString);
						absentDateList.add(dateVal);
						absentDurationList.add(durationString);
						leave= 1.0f;

					}
					else if(statusString.equals("P"))
					{
						Date date;
						try {
							String time= durationString;
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

							} 
							catch (ParseException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						presentList.add(statusString);
						presentDateList.add(dateVal);
						presentDurationList.add(durationString);
						}
					else{

						}
				}
				List<EmployeeLeaveManagementBean> leaveResultList;
				SessionFactory sessionFactoryLeave = HibernateUtils.getSessionFactory(); 
				Session sessionLeave=sessionFactoryLeave.openSession();  
				Transaction transaction= sessionLeave.beginTransaction();
				Query leaveQueryResult = sessionLeave.createQuery("from EmployeeLeaveManagementBean where Employee_Code= "+ empCode);
				leaveResultList = leaveQueryResult.list(); 
				if(leaveResultList.size() > 0)
				{
					Iterator<EmployeeLeaveManagementBean> allUsersListIterator = leaveResultList.iterator();
					while (allUsersListIterator.hasNext()) 
					{
						EmployeeLeaveManagementBean employeeLeaveManagementBean = (EmployeeLeaveManagementBean) allUsersListIterator.next();
						totalLeaveVal= employeeLeaveManagementBean.getTotalLeaves();
						remainLeaveVal= employeeLeaveManagementBean.getRemainingLeaves();
						usedLeaveVal= employeeLeaveManagementBean.getUsedLeaves();
						leave_Id= employeeLeaveManagementBean.getLeave_ID();
					}	
					for(int k=0; k<absentDateList.size(); k++){
						leave= 1.0f;

						float remainingLeaves= remainLeaveVal - leave;
						float usedLeaves= usedLeaveVal + leave;
						remainLeaveVal= remainingLeaves ;
						usedLeaveVal= usedLeaves;
						EmployeeLeaveManagementBean employeeLeaveManagementVal = (EmployeeLeaveManagementBean) sessionLeave.get(EmployeeLeaveManagementBean.class, leave_Id);

						if(employeeLeaveManagementVal==null){

							System.out.println("Do Nothing");
							break;
						}
						else{
							applyDateList.clear();
							String date= absentDateList.get(k);
							String date1= absentDateList.get(k);
							String date2= absentDateList.get(k);
							employeeLeaveManagementVal.setEmpCode(empCode);
							employeeLeaveManagementVal.setTotalLeaves(totalLeaveVal);
							employeeLeaveManagementVal.setRemainingLeaves(remainingLeaves);
							employeeLeaveManagementVal.setUsedLeaves(usedLeaves);
							sessionLeave.saveOrUpdate(employeeLeaveManagementVal);
							
							List<EmpLeaveApplyBean> empLeaveDetailList = new ArrayList<EmpLeaveApplyBean>();
							 Query leaveQueryResultVal = session.createQuery("from EmpLeaveApplyBean where empCode= " + empCode);
							 empLeaveDetailList = leaveQueryResultVal.list();
							 
							 Iterator<EmpLeaveApplyBean> empLeaveIterator= empLeaveDetailList.iterator();
							 while (empLeaveIterator.hasNext()) {
								EmpLeaveApplyBean empLeaveApplyBean = (EmpLeaveApplyBean) empLeaveIterator.next();
								applyDateList.add(empLeaveApplyBean.getApplyDate().toString());
								System.out.println(empLeaveApplyBean.getApplyDate());
								System.out.println(empLeaveApplyBean.getLeaveReason());
								
							}
							 
							 if(applyDateList.contains(date)){
									System.out.println("This Date is already inserted");
								}
							else{
									System.out.println("hi");
									EmpLeaveApplyBean empLeaveApplyBeanVal= new EmpLeaveApplyBean(empCode, date, 1, date1, date2, "Casual Leave", "Approved");
									sessionLeave.save(empLeaveApplyBeanVal);
								}
							
							
						}
					}
					leaveResultList= null;
					transaction.commit();
					sessionLeave.close();
				}
				/*int k=dateList.size();
				dateVal= dateList.get(k);
				System.out.println(dateVal);*/
				
				
				counter = counter+dateList.size();
				
			}
				
			result= "success";
			t.commit();
			session.close();
			System.out.println("Successfully Saved");
			
			//String dateVal= dateList.get(dateList.size());
			/*List<AttendenceUploadBean> attendenceResultList;
			SessionFactory sessionFactoryAtt = HibernateUtils.getSessionFactory(); 
			Session sessionAtt =sessionFactoryAtt.openSession();  
			Transaction transaction= sessionAtt.beginTransaction();
			Query attendenceQueryResult = sessionAtt.createQuery("from AttendenceUploadBean where dateTime= "+ dateVal);
			attendenceResultList = attendenceQueryResult.list(); 
			System.out.println(attendenceResultList);*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
			addActionError(e.getMessage());
			return result;
			

		}
		return result;
	}


}
