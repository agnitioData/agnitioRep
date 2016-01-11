package com.hrms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpEventsBean;
import com.hrms.model.EmpEventsUploadModel;
import com.hrms.model.ImagesUploadModel;
import com.hrms.util.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class EventsUploadAction extends ActionSupport {

	private static final long serialVersionUID = 873125623001567046L;
	private EmpEventsUploadModel empEventsUploadBean;
	private ImagesUploadModel imagesUploadModel= new ImagesUploadModel();;
	List<EmpEventsUploadModel> empEventsUploadListVal ;
	List<EmpEventsUploadModel> empEventsViewListVal= new LinkedList<EmpEventsUploadModel>() ;
	List<EmpEventsBean> empEventsBeanList= new LinkedList<EmpEventsBean>() ;
	
	public List<EmpEventsBean> getEmpEventsBeanList() {
		return empEventsBeanList;
	}
	public void setEmpEventsBeanList(List<EmpEventsBean> empEventsBeanList) {
		this.empEventsBeanList = empEventsBeanList;
	}
	public ImagesUploadModel getImagesUploadModel() {
		return imagesUploadModel;
	}
	public void setImagesUploadModel(ImagesUploadModel imagesUploadModel) {
		this.imagesUploadModel = imagesUploadModel;
	}


	private String userImageFileName;
	
	private File image;
	private String title;
	private String description;
	String result= "error";
	
	public String getUserImageFileName() {
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public List<EmpEventsUploadModel> getEmpEventsViewListVal() {
		return empEventsViewListVal;
	}
	public void setEmpEventsViewListVal(
			List<EmpEventsUploadModel> empEventsViewListVal) {
		this.empEventsViewListVal = empEventsViewListVal;
	}
	public EmpEventsUploadModel getEmpEventsUploadBean() {
		return empEventsUploadBean;
	}
	public void setEmpEventsUploadBean(EmpEventsUploadModel empEventsUploadBean) {
		this.empEventsUploadBean = empEventsUploadBean;
	}
	public String eventsUpload() throws IOException{
		
		 	try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.getCurrentSession();  
				Transaction t=session.beginTransaction();
				//File imageName= imagesUploadModel.getImage(); 
				String filePath = image.toString();
				File file = new File(filePath);
				byte[] imageData = new byte[(int) file.length()];
				
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					fileInputStream.read(imageData);
					fileInputStream.close();
					
				} catch (FileNotFoundException e) {
					System.err.println("File not Found. " + e);
					e.printStackTrace();
				}
				
				Blob blob = Hibernate.createBlob(imageData);
		    	empEventsUploadBean= new EmpEventsUploadModel();
		    	//empEventsUploadBean.setEventId(1);
		    	empEventsUploadBean.setData(imageData);
		    	empEventsUploadBean.setTitleName(title);
		    	empEventsUploadBean.setDescription(description);
		    	empEventsUploadBean.setFilePath(filePath);
		    	session.save(empEventsUploadBean);
		    	t.commit();
		    	
		    	result="success";
		    	
			} catch (HibernateException e) {
				
				e.printStackTrace();
			}
		 	//session.close();
		 return result;
	}
	
	public String imageRetrieve(){
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			List<EmpEventsUploadModel> empEventsUploadList= new LinkedList<EmpEventsUploadModel>();
			Query empEventsDetailsVal = session.createQuery("from EmpEventsUploadModel ");
			empEventsUploadList= empEventsDetailsVal.list();
			
			Iterator<EmpEventsUploadModel> empEventsViewIterator= empEventsUploadList.iterator();
			while (empEventsViewIterator.hasNext()) 
			{
				EmpEventsUploadModel empEventsUploadModel = (EmpEventsUploadModel) empEventsViewIterator.next();
				EmpEventsBean empEventsBean= new EmpEventsBean();
				String filePath= empEventsUploadModel.getFilePath();
				String title= empEventsUploadModel.getTitleName();
				String desc= empEventsUploadModel.getDescription();
				byte[] image = empEventsUploadModel.getData();
				
				try{
					File file = new File("D://"+title+".jpg");
				    FileOutputStream fos = new FileOutputStream(file);
				    /*int size = 0;
					while((size = is.read(image)) != -1){
						os.write(content, 0, size);
					}*/
				    fos.write(image);
				    fos.close();
				    userImageFileName= title+".jpg" ;
				    System.out.println(file);
				    empEventsBean.setTitleName(title);
				    empEventsBean.setDescription(desc);
				    empEventsBean.setImage(file);
				    empEventsBean.setFilePath(filePath);
				    empEventsBean.setImageName(userImageFileName);
				    empEventsBeanList.add(empEventsBean);
				}catch(Exception e){
				    e.printStackTrace();
				}
			}
			result="success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public String imageUpload() throws IOException{
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			File imageName= imagesUploadModel.getImage(); 
			String filePath = imageName.toString();
			File file = new File(filePath);
			byte[] imageData = new byte[(int) file.length()];
			
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(imageData);
				fileInputStream.close();
				
			} catch (FileNotFoundException e) {
				System.err.println("File not Found. " + e);
				e.printStackTrace();
			}
			
			//Blob blob = Hibernate.createBlob(imageData);
			session.save(imagesUploadModel);
	    	t.commit();
	    	
	    	result="success";
	    	
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
