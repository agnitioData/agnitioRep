package com.hrm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import com.hrms.model.EmployeeLoginDetailsBean;
 
public class UserDAOImpl implements UserDAO {
     
    private SessionFactory sf;
     
    public UserDAOImpl(SessionFactory sf){
        this.sf = sf;
    }
 
    @Override
    public EmployeeLoginDetailsBean getUserByCredentials(String name, String pwd) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where name='"+name+"' and pwd='"+pwd+"'");
       /* query.setString("name", name); 
        query.setString("pwd", pwd);*/
        EmployeeLoginDetailsBean user = (EmployeeLoginDetailsBean) query.uniqueResult();
        if(user != null){
            System.out.println("User Retrieved from DB::"+user);
        }
        tx.commit();session.close();
        return user;
    }
 
}
