package com.hrms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.util.HibernateUtils;

public class NotificationAction {
	
	public static List<String> getNotification(String empCode){
		List data = null; 
		List notification = new ArrayList<String>();
			try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				StringBuilder sb = new StringBuilder();
				sb.append("select Message FROM Employee_Notification ");
				sb.append("where Emp_Code="+ empCode);
				Query queryResult=session.createSQLQuery(sb.toString());
				queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				data = queryResult.list();
				
				Map<String,Object> row = null;
	    		for (Object object : data) {
	    			row= (Map<String,Object>)object;
	    			notification.add(row.get("Message").toString());
	    			
	    		}
				
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return notification;
	    
		}

}
