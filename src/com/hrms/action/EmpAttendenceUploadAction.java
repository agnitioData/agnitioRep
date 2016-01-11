package com.hrms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.hrms.model.EmpAttendenceFileUploadBean;
import com.opensymphony.xwork2.ActionSupport;



public class EmpAttendenceUploadAction extends ActionSupport //implements ServletRequestAware 
{
	private EmpAttendenceFileUploadBean empAttendenceFileUploadBean;
	//private File fileUpload;
	
	private static final long serialVersionUID = -8714338069073872307L;
	
	private File uploadFile;
	private String uploadFileFileName;
	private HttpServletRequest request;
	private String emp;
	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	
	String result="error";
	
	
	public String attendenceUpload(){
		
	try 
	{
		/*SessionFactory sf = HibernateUtils.getSessionFactory(); 
		Session session=sf.getCurrentSession();  
		Transaction t=session.beginTransaction();*/
		request = ServletActionContext.getRequest();
	
		String filePath = request.getSession().getServletContext().getRealPath("/");
		FileInputStream fileInputStream = new FileInputStream(filePath);
		//FileInputStream fileInputStream = new FileInputStream("d://MYSheet/Copy of Monthly_WorkDurationReport Oct 15 (2).xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet("Monthly_WorkDurationReport");
		HSSFRow row1 = worksheet.getRow(0);
		java.util.Iterator itRow = worksheet.rowIterator();
		List<String> empCode = new ArrayList<String>();
		while(itRow.hasNext())
		{
			HSSFRow row = (HSSFRow) itRow.next();
			java.util.Iterator itCell = row.cellIterator();
			while(itCell.hasNext())
			{
				HSSFCell cell = (HSSFCell) itCell.next();
				if(cell.getStringCellValue().equals("Employee Code:-"))
				{
					HSSFCell localCell = (HSSFCell) row.getCell((short) 10);
					empCode.add(localCell.getStringCellValue());
					System.out.println(localCell.getStringCellValue());
				}
				
			}
		}
		result="success";
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return result;
	
	}
	
	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EmpAttendenceFileUploadBean getEmpAttendenceFileUploadBean() {
		return empAttendenceFileUploadBean;
	}

	public void setEmpAttendenceFileUploadBean(
			EmpAttendenceFileUploadBean empAttendenceFileUploadBean) {
		this.empAttendenceFileUploadBean = empAttendenceFileUploadBean;
	}
	
	
	
}
