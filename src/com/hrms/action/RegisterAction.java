package com.hrms.action;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpFamilyDetailsBean;
import com.hrms.model.EmpAddressBean;
import com.hrms.model.EmpEducationDetails;
import com.hrms.model.EmpFamilyDetails;
import com.hrms.model.EmpMasterBean;
import com.hrms.model.EmpProfInfoBean;
import com.hrms.model.EmpProfessionalInfoBean;
import com.hrms.model.EmployeeGenDetailsBean;
import com.hrms.util.HibernateUtils;

/**
 * 
 * @author Rishabh Porwal
 *
 */
public class RegisterAction {
	
	private EmployeeGenDetailsBean employeeGenDetails;
	private EmpMasterBean empMasterDetails;
	private EmpAddressBean empAddressDetails;
	private EmpFamilyDetails empFamilyDetailsBean;
	//private EmpFamilyDetails empFamilyDetails;
	private EmpEducationDetails empEducationDetails;
	/*private EmployeeImagesDataBean employeeImagesDataBean;*/
	private EmpProfessionalInfoBean empProfessionalInfoBean;
	String result="error";
	
	
	 public EmployeeGenDetailsBean getEmployeeGenDetails() {
		return employeeGenDetails;
	}



	public void setEmployeeGenDetails(EmployeeGenDetailsBean employeeGenDetails) {
		this.employeeGenDetails = employeeGenDetails;
	}



	public EmpMasterBean getEmpMasterDetails() {
		return empMasterDetails;
	}



	public void setEmpMasterDetails(EmpMasterBean empMasterDetails) {
		this.empMasterDetails = empMasterDetails;
	}
	

	public EmpAddressBean getEmpAddressDetails() {
		return empAddressDetails;
	}



	public void setEmpAddressDetails(EmpAddressBean empAddressDetails) {
		this.empAddressDetails = empAddressDetails;
	}
	
	


	/*public EmployeeImagesDataBean getEmployeeImagesDataBean() {
		return employeeImagesDataBean;
	}



	public void setEmployeeImagesDataBean(
			EmployeeImagesDataBean employeeImagesDataBean) {
		this.employeeImagesDataBean = employeeImagesDataBean;
	}*/
	
	public EmpEducationDetails getEmpEducationDetails() {
		return empEducationDetails;
	}



	public void setEmpEducationDetails(EmpEducationDetails empEducationDetails) {
		this.empEducationDetails = empEducationDetails;
	}

	public EmpFamilyDetails getEmpFamilyDetailsBean() {
		return empFamilyDetailsBean;
	}



	public void setEmpFamilyDetailsBean(EmpFamilyDetails empFamilyDetailsBean) {
		this.empFamilyDetailsBean = empFamilyDetailsBean;
	}



	public EmpProfessionalInfoBean getEmpProfessionalInfoBean() {
		return empProfessionalInfoBean;
	}

	public void setEmpProfessionalInfoBean(EmpProfessionalInfoBean empProfessionalInfoBean) {
		this.empProfessionalInfoBean = empProfessionalInfoBean;
	}



	public String insertDetails(){
         
		 	try {
				SessionFactory sf = HibernateUtils.getSessionFactory(); 
				Session session=sf.openSession();  
				
				Transaction t= session.beginTransaction();
				
				System.out.println("Transaction begin"); 
				
				
				/*try{
			        String filePath = ServletActionContext.getServletContext().getRealPath("/");
			        System.out.println("Server path:" + filePath);
			        File fileToCreate = new File(filePath, empMasterDetails.getImageName());
			        FileUtils.copyFile(empMasterDetails.getEmpImage(), fileToCreate);
			   }
			    catch (Exception e){
			        e.printStackTrace();
			        //addActionError(e.getMessage());
			        //return result;
			    }*/
				String fname=empFamilyDetailsBean.getFname();
				//String frelationship=empFamilyDetailsBean.getFrelationship();
				String foccupation=empFamilyDetailsBean.getFoccupation();
				long fmobileNo=empFamilyDetailsBean.getFmobileNo();
				String name=empFamilyDetailsBean.getName();
				//String relationship=empFamilyDetailsBean.getRelationship();
				String occupation=empFamilyDetailsBean.getOccupation();
				long mobileNo=empFamilyDetailsBean.getMobileNo();
				//String noOfSiblings=empFamilyDetailsBean.getNoOfSiblings();
				
				System.out.println(empFamilyDetailsBean.getFname());
				//System.out.println(empFamilyDetailsBean.getFrelationship());
				System.out.println(empFamilyDetailsBean.getFoccupation());
				System.out.println(empFamilyDetailsBean.getFmobileNo());
				System.out.println(empFamilyDetailsBean.getName()); 
				//System.out.println(empFamilyDetailsBean.getRelationship());
				System.out.println(empFamilyDetailsBean.getOccupation());
				System.out.println(empFamilyDetailsBean.getMobileNo());
				System.out.println(empFamilyDetailsBean.getNoOfSiblings());
				
				
				/*Enter Details into Employee Master table */
				EmpMasterBean empMasterBean = new EmpMasterBean(empMasterDetails.getEmpCode(), empMasterDetails.getFirstName(), empMasterDetails.getLastName(), empMasterDetails.getUserName(), empMasterDetails.getPassword());
				//empMasterBean.setEmpGenInfo(employeeGenDetailsBean);
				
				
				/*Enter Details into Employee General Details info table */
				//EmployeeGenDetailsBean employeeGenDetailsBean= new EmployeeGenDetailsBean(employeeGenDetails.getEmailId(), employeeGenDetails.getEmpGender(), employeeGenDetails.getDob(), employeeGenDetails.getDoj(), employeeGenDetails.getPassportNo(), employeeGenDetails.getPanNo(), employeeGenDetails.getMaritalStatus(), employeeGenDetails.getAnniversaryDate(), employeeGenDetails.getAccountNo());
				employeeGenDetails.setEmployees(empMasterBean);
				//session.save(employeeGenDetailsBean);
				Long EmpId = (Long) session.save(employeeGenDetails);
				
				
				//EmpFamilyDetails empFamilyDetailVal =new EmpFamilyDetails(fname, foccupation, fmobileNo, noOfSiblings);
				empFamilyDetailsBean.setEmployees(empMasterBean);
				session.save(empFamilyDetailsBean);
				
				//EmpFamilyDetails empFamilyDetailVal2 =new EmpFamilyDetails(name, occupation, mobileNo, noOfSiblings);
				/*empFamilyDetailVal.setEmployees(empMasterBean);
				session.save(empFamilyDetailVal2);*/
				
				/*Enter Details into Employee Address table */
				//EmpAddressBean empAddressBean= new EmpAddressBean(empAddressDetails.getPresentAdd(), empAddressDetails.getPermanentAdd(), empAddressDetails.getMobileNo(), empAddressDetails.getMobNumbertype());
				empAddressDetails.setEmployees(empMasterBean);
				session.save(empAddressDetails);
				
				empEducationDetails.setEmployees(empMasterBean);
				session.save(empEducationDetails);
				//EmpProfessionalInfoBean professionalInfoBean= new EmpProfessionalInfoBean(empProfessionalInfoBean.getDepartment(), empProfessionalInfoBean.getDesignation(), empProfessionalInfoBean.getEmpManager(), empProfessionalInfoBean.getDoj(), empProfessionalInfoBean.getTotalExp(), empProfessionalInfoBean.getEmpStatus(), empProfessionalInfoBean.getCtc());
				empProfessionalInfoBean.setEmployees(empMasterBean);
				session.save(empProfessionalInfoBean);
				/*EmpProfInfoBean empProfInfoBean= new EmpProfInfoBean(empProfInfoBeanDetails.getDepartment(), empProfInfoBeanDetails.getDesignation(), empProfInfoBeanDetails.getEmpManager(), empProfInfoBeanDetails.getDoj(),empProfInfoBeanDetails.getEmpStatus(), empProfInfoBeanDetails.getCtc());
				empProfInfoBean.setEmployees(empMasterBean);;
				session.save(empProfInfoBean);*/
				
				/*code start for Enter Image into EmployeeImage table */
				/*EmployeeImagesDataBean imagesDataBean= new EmployeeImagesDataBean();
				File file = new File(imagesDataBean.getImageAddress());
				byte[] imageData = new byte[(int) file.length()];
				 
				try {
				    FileInputStream fileInputStream = new FileInputStream(file);
				    fileInputStream.read(imageData);
				    fileInputStream.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				imagesDataBean.setImageName("test.jpeg");
				imagesDataBean.setData(imageData);
				 
				session.save(imagesDataBean); */
				/*code End for Enter Image into EmployeeImage table */
				
				
				EmpMasterBean book = (EmpMasterBean) session.get(EmpMasterBean.class, EmpId);
				System.out.println("First Name: " + book.getFirstName());
		        System.out.println("Last Name: " + book.getLastName());
				//employeeGenDetailsBean.getEmployees1().add(empMasterBean);
				//session.save(empMasterBean);
				//employeeGenDetailsBean.setEmployees1(empMasterBean);
				//User userDB = userDAO.getUserByCredentials(user.getId(), user.getPwd());
				System.out.println();
				//session.save(empMasterBean);
				//session.getTransaction().commit();
				t.commit();//transaction is committed  
				session.close();  
				
			if(EmpId!=0){  
				System.out.println("successfully saved");
				result="success";
				}
			
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result; 
		    
		    
	 }

}
