package com.hrms.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.dao.EmployeeLoginDao;
import com.hrms.util.HibernateUtils;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeDocumentDownloadAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 6573722408346997023L;
		private InputStream fileInputStream;
		
		public InputStream getFileInputStream() {
			return fileInputStream;
		}

		public String execute(){
			
			String validation= SessionTreckingCheckUtil.SessionCheck(); 
			String filePath = "";
			if(validation=="success"){
				
				try {
					SessionFactory sf = HibernateUtils.getSessionFactory(); 
					Session session=sf.getCurrentSession();  
					Transaction t=session.beginTransaction();
					StringBuilder sb = new StringBuilder();
					String empCode = EmployeeLoginDao.EMP_CODE;
					sb.append("select document FROM Employee_Documents ");
					sb.append("where Emp_Code="+ empCode +" and Doc_Type="+ "1");
					Query queryResult=session.createSQLQuery(sb.toString());
					queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
					List data = queryResult.list();
					Map<String,Object> row = null;
					for (Object object : data) {
						row= (Map<String,Object>)object;
						filePath=  String.valueOf(row.get("document"));
						fileInputStream = new FileInputStream(new File(filePath));
						
					}
				     
			    
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
			}
			
			
			 return SUCCESS; 
		}
	
}
