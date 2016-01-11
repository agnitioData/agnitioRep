package com.hrms.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hrms.action.EmployeeLoginAction;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmployeeLoginDetailsBean;
import com.hrms.util.HibernateUtils;

public class EmployeeLoginDao {

public static Long userId = null;
	
private EmployeeLoginDetailsBean user = new EmployeeLoginDetailsBean();
private EmployeeLoginAction  employeeLogin= null;


	public static String EMP_CODE = "";
	public static String USER_NAME = "";
	
	public static boolean validate(String name, String pwd){
        
		boolean result = false;
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
	    	String uname = emb.getEmpCode();
	    	String password = emb.getPassword();
	    	emb.getFirstName();
			emb.getLastName();
			String uName = emb.getFirstName();
	    	if(name.equals(uname) && pwd.equals(password))
	    	{
	    		EMP_CODE = uname;
	    		USER_NAME = uName;
	    		result = true;
	    		userId = emb.getId();
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
