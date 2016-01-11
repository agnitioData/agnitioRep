package com.hrms.action;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.model.NewsAndBlogsModel;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAndBlogsAction extends ActionSupport {

	
	private static final long serialVersionUID = 5586878062641495821L;
	private NewsAndBlogsModel newsAndBlogsModel;
	private List<NewsAndBlogsModel> newsAndBlogsValList= new LinkedList<NewsAndBlogsModel>();
	private List<NewsAndBlogsModel> newsAndBlogsList= new LinkedList<NewsAndBlogsModel>();
	String result= "error";
	
	public NewsAndBlogsModel getNewsAndBlogsModel() {
		return newsAndBlogsModel;
	}
	public void setNewsAndBlogsModel(NewsAndBlogsModel newsAndBlogsModel) {
		this.newsAndBlogsModel = newsAndBlogsModel;
	}
	
	public String newsAndBlogsUpdate(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			Long id = (Long) session.save(newsAndBlogsModel);
			t.commit();//transaction is committed  
			session.close();
			
		if(id!=0 ){  
			System.out.println("successfully saved");
			result="success";
			}
			result= "success";
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
	public String newsAndBlogsView(){
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.openSession();  
			Transaction t= session.beginTransaction();
			
			Query newAndBlogsQuery = session.createQuery("from NewsAndBlogsModel ");
			newsAndBlogsValList= newAndBlogsQuery.list();
			Iterator<NewsAndBlogsModel> newsAndBlogsIterator= newsAndBlogsValList.iterator();
			
			while (newsAndBlogsIterator.hasNext()) {
				NewsAndBlogsModel newsAndBlogsModel = (NewsAndBlogsModel) newsAndBlogsIterator.next();
				newsAndBlogsList.add(newsAndBlogsModel);
				/*System.out.println(newsAndBlogsList);*/
			}
			result="success";
		} catch (HibernateException e) {
			
			e.printStackTrace();
			//throw e;
		} 
		return result;
		
	}
	public List<NewsAndBlogsModel> getNewsAndBlogsList() {
		return newsAndBlogsList;
	}
	public void setNewsAndBlogsList(List<NewsAndBlogsModel> newsAndBlogsList) {
		this.newsAndBlogsList = newsAndBlogsList;
	}
	
	

}
