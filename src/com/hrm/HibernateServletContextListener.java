package com.hrm;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
import org.hibernate.cfg.Configuration;
 
public class HibernateServletContextListener implements ServletContextListener {
 
	@Override
    public void contextInitialized(ServletContextEvent sce) 
	{
        URL url = HibernateServletContextListener.class.getResource("/hibernate.cfg.xml");
        Configuration config = new Configuration();
        config.configure(url);
        //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //SessionFactory sf = config.buildSessionFactory(serviceRegistry);
        //sce.getServletContext().setAttribute("SessionFactory", sf);
    }
	
	
	@Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
      /*try{ System.out.println("helllo");
    	   SessionFactory sf = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
    	   sf.close();
       }
       catch(Exception e){
    	   e.printStackTrace();
       }*/
    }
 
    
 
}
