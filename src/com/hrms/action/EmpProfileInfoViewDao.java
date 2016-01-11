package com.hrms.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpProfileViewBean;
import com.hrms.dao.EmployeeLoginDao;
import com.hrms.util.HibernateUtils;
import com.hrms.util.SessionTreckingCheckUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rishabh Porwal
 * this class responsible to fetch the employees details.
 */
public class EmpProfileInfoViewDao {
	
	
	
	private EmployeeLoginDao  employeeLoginDao;
	//private long empId= employeeLoginDao.userId;
	private List<EmpProfileViewBean> profileViewData;
	private List<EmpProfileViewBean> result;
	//String result="error";
	
	String empName = null;
	String firstName = null;
	String lastName = null;
	String ecode = null;
	String uname = null;
	String emailId = null;
	String empDOB = null;
	String passportNo = null;
	String panNo = null;
	String presentAdd = null;
	String permanentAdd = null;
	

	@SuppressWarnings("unchecked")
	public List<EmpProfileViewBean> employeeProfileInfo(){
		
		
		
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();  
			Transaction t=session.beginTransaction();
			List allUsersList;
			long empId= employeeLoginDao.userId;
			StringBuilder sb = new StringBuilder();
			sb.append("select em.*, egi.*, ead.* ");
			sb.append("from Employee_Master em, EmployeeGeneralInfo egi, EmpAddressDetails ead ");
			sb.append("where em.Emp_id = ead.Emp_id and em.Emp_id = egi.Emp_Genid ");
			sb.append("and em.Emp_id="+ empId);
			Query queryResult=session.createSQLQuery(sb.toString());
			//Query queryResult = session.createQuery("from EmpMasterBean");
		
			/*Map<String, LinkedList<String>> mainMenuMap = new LinkedHashMap<String, LinkedList<String>>();
			LinkedList<String> sideMenuList= new LinkedList<String>();
			sideMenuList.add("Basic Information");
			sideMenuList.add("Professional Details");
			sideMenuList.add("Family Details");
			sideMenuList.add("Educations Details");
			sideMenuList.add("Update Profile");
			
			mainMenuMap.put("Profile", sideMenuList);
			String jMenu = JSONValue.toJSONString(mainMenuMap);
			System.out.println("jMenu >> " + jMenu);*/
			
			profileViewData = new ArrayList<>();
		
			queryResult.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			Map<String,Object> row = null;
			List data = queryResult.list();
			for (Object object : data) {
			
				EmpProfileViewBean empProfileViewBean = new EmpProfileViewBean();
			
				row= (Map<String,Object>)object;
				ecode= String.valueOf(row.get("Emp_Code"));
		     
				empProfileViewBean.setEmpCode(row.get("Emp_Code").toString());
				empProfileViewBean.setFirstName(row.get("First_name").toString());
				empProfileViewBean.setLastName(row.get("Last_name").toString());
				empProfileViewBean.setUserName(row.get("User_name").toString());
				empProfileViewBean.setPanNumber(row.get("PanNo").toString());
				empProfileViewBean.setPassportNumber(row.get("PassportNo").toString());
				empProfileViewBean.setMarritalStatus(row.get("Marital_status").toString());
				//empProfileViewBean.setAccountNumber(row.get("AccountNo").toString());
				empProfileViewBean.setAnniversaryDate(row.get("User_name").toString());
				empProfileViewBean.setDob(row.get("Date_of_birth").toString());
				empProfileViewBean.setDoj(row.get("Date_of_joining").toString());
				empProfileViewBean.setPermanenetAddress(row.get("PermanentAdd").toString());
				empProfileViewBean.setPresentAddress(row.get("PresentAdd").toString());
				empProfileViewBean.setEmailId(row.get("Email_id").toString());
				empProfileViewBean.setAnniversaryDate(row.get("AnniversaryDate").toString());
		     
		     
				System.out.println(firstName);
				System.out.println("Emp_Code: " + row.get("Emp_Code"));
				System.out.println("first Name: " + row.get("First_name"));
				System.out.println("Last name: " + row.get("Last_name"));
				System.out.println("Emailid: " + row.get("Email_id"));
				System.out.println("Date_of_birth: " + row.get("Date_of_birth"));
		     
				System.out.println("PermanentAdd: " + row.get("PermanentAdd"));
				System.out.println("PresentAdd: " + row.get("PresentAdd"));
		     
				profileViewData.add(empProfileViewBean);
				}

			session.getTransaction().commit();
			return result=profileViewData;
			} 
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
   
   return result;
	}

	
		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getEmpDOB() {
			return empDOB;
		}

		public void setEmpDOB(String empDOB) {
			this.empDOB = empDOB;
		}

		public String getPassportNo() {
			return passportNo;
		}

		public void setPassportNo(String passportNo) {
			this.passportNo = passportNo;
		}

		public String getPanNo() {
			return panNo;
		}

		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}

		public String getPresentAdd() {
			return presentAdd;
		}

		public void setPresentAdd(String presentAdd) {
			this.presentAdd = presentAdd;
		}

		public String getPermanentAdd() {
			return permanentAdd;
		}

		public void setPermanentAdd(String permanentAdd) {
			this.permanentAdd = permanentAdd;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEcode() {
			return ecode;
		}

		public void setEcode(String ecode) {
			this.ecode = ecode;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public List<EmpProfileViewBean> getProfileViewData() {
			return profileViewData;
		}

		public void setProfileViewData(List<EmpProfileViewBean> profileViewData) {
			this.profileViewData = profileViewData;
		}
	
}
