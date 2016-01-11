package com.hrms.util;

import org.hibernate.SessionFactory;  
import org.hibernate.cfg.AnnotationConfiguration;  
    
public class HibernateUtils {  
    
    private static final SessionFactory sessionFactory = buildSessionFactory();  
    
    private static SessionFactory buildSessionFactory() {  
        try {  
        	AnnotationConfiguration cfg=new AnnotationConfiguration();  
    	    cfg.configure("hibernate.cfg.xml");
    	    SessionFactory factory=cfg.buildSessionFactory();
            // Create the SessionFactory from hibernate.cfg.xml  
            //return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();  
    	    return factory;
        } catch (Throwable ex) {  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
    
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
}  
