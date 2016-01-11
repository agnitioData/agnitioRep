package com.hrms.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;  
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import com.hrms.dao.EmployeeLoginDao;
import com.opensymphony.xwork2.ActionSupport;


public class EmployeeLoginAction extends ActionSupport implements SessionAware{
	public List<String> notification;
	public static String NOTIFICATION_COUNT = "";
	List<String> adminName = new ArrayList<String>();
	String result="error";
	
	public List<String> getNotification() {
		return notification;
	}
	public void setNotification(List<String> notification) {
		this.notification = notification;
	}

	private String username,userpass, empCode, mailId, newPass, confirmPass;  
	
	SessionMap<String,String> sessionmap;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public List<String> returnNotifiacationList()
	{
		return notification;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		notification = new ArrayList<>();
		
		/**
		 Captcha Validation Test 
		 */
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY");

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				remoteAddr, challenge, uresponse);

		if (reCaptchaResponse.isValid()) {
			String user = username;
			if(EmployeeLoginDao.validate(username, userpass)){
		    	try{
		    		notification = new ArrayList<>(NotificationAction.getNotification(EmployeeLoginDao.EMP_CODE));
		    		NOTIFICATION_COUNT = String.valueOf(notification.size());
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    	try {
		    		
					Properties prop = new Properties();
					InputStream input = this.getClass().getClassLoader().getResourceAsStream("AdminNames.properties");
							try {
								prop.load(input);
							} catch (IOException e) {
								
								e.printStackTrace();
							}
							Enumeration e = prop.propertyNames();
							while (e.hasMoreElements()) {
								String key = (String) e.nextElement();
								adminName.add(key);
								System.out.println(key);
							}
							if(adminName.contains(username)){
								System.out.println("Welcome User :" + username +" admin" );
								String admin= username;
								result="admin";
							}
							else{
								System.out.println("Welcome User :" + username +" employee");
								result="employee";
							}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return result;  
		    }  
		    else{  
		    	addActionError("Username or Password is incorrect! Try Again.");
		        return result;  
		    } 
			//out.print("CAPTCHA Validation Success! User "+user+" registered.");
		} else {
			addActionError("CAPTCHA Validation Failed! Try Again.");
			//out.print("CAPTCHA Validation Failed! Try Again.");
		}
		/*End of captcha captcha */
	    /*if(EmployeeLoginDao.validate(username, userpass)){
	    	try{
	    		notification = new ArrayList<>(NotificationAction.getNotification(EmployeeLoginDao.EMP_CODE));
	    		NOTIFICATION_COUNT = String.valueOf(notification.size());
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	try {
	    		
				Properties prop = new Properties();
				InputStream input = this.getClass().getClassLoader().getResourceAsStream("AdminNames.properties");
						try {
							prop.load(input);
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						Enumeration e = prop.propertyNames();
						while (e.hasMoreElements()) {
							String key = (String) e.nextElement();
							adminName.add(key);
							System.out.println(key);
						}
						if(adminName.contains(username)){
							System.out.println("Welcome User :" + username +" admin" );
							String admin= username;
							result="admin";
						}
						else{
							System.out.println("Welcome User :" + username +" employee");
							result="employee";
						}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return result;  
	    }  
	    else{  
	        return result;  
	    } */
		return result; 
	    
	} 
	
	
	
	
	  
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  
	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}
	public List<String> getAdminName() {
		return adminName;
	}
	public void setAdminName(List<String> adminName) {
		this.adminName = adminName;
	} 
	

}
