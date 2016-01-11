package com.hrms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class SessionTreckingCheckUtil {
	
	public static String SessionCheck(){
	String result="error";
	HttpServletRequest request=ServletActionContext.getRequest();  
	HttpSession session=request.getSession();  
	  
	String s=(String)session.getAttribute("login");  
	if(s!=null && !s.equals("")){ 
		result= "success"; 
	    
	}  
	return result; 
	}

}
