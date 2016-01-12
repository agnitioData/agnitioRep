package com.hrms.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 


import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeLoginDetailsBean;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;
 
public class LoginAction {

	private EmployeeLoginDetailsBean user = new EmployeeLoginDetailsBean();
    
	public String loginDetails(String name, String pwd){
        String result = "error";
    	SessionFactory sf = HibernateUtils.getSessionFactory(); 
	    Session session=sf.openSession();  
	    session.beginTransaction();
	    List<EmpMasterBean> allUsersList;
	    Query queryResult = session.createQuery("from EmpMasterBean");
	    allUsersList = queryResult.list(); 
	    Iterator<EmpMasterBean> allUsersListIterator = allUsersList.iterator();
	    while(allUsersListIterator.hasNext())
	    {
	    	EmpMasterBean emb = allUsersListIterator.next();
	    	String uname = emb.getUserName();
	    	String password = emb.getPassword();
	    	emb.getFirstName();
			emb.getLastName();
	    	if(name.equals(uname) && pwd.equals(password))
	    	{
	    		result = "success";
	    		break;
	    	}
	    }
	    //UserDAO userDAO = new UserDAOImpl(sf);
        //User userDB = userDAO.getUserByCredentials(name, pwd);
	    session.getTransaction().commit();
        //EmpRegisterDao empRegisterDao = new EmpRegisterDao(factory);
        //EmployeeGenDetailsBean empInfo = empRegisterDao.getUserByCredentials(user.getName(), user.getPwd());
        session.close();
       /* if(userDB == null) return "error";
        
        else {
            
            user.setName(userDB.getName());
            return "success";
        	}*/
        return result;
    }
 
   
     
    
     
    
     
}
