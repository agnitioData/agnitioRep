package com.hrms.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agni.hrms.bean.EmpAttendenceBean;
import com.hrms.model.AttendenceUploadBean;
import com.hrms.util.HibernateUtils;

/**
 * @author Rishabh Porwal
 * This class is responsible to retrieve data from attendence table.
 */
public class EmployeeAttendenceViewDao {
	
	//List<AttendenceUploadBean> attendenceList;
	List<AttendenceUploadBean> attendenceValList;
	List<EmpAttendenceBean> empAttendenceList = new LinkedList<EmpAttendenceBean>();
	List<String> outTimeList = new LinkedList<String>();
	List<String> durationList = new LinkedList<String>();
	List<String> dateList = new LinkedList<String>();
	//List<List<String>> empAttendenceList= new LinkedList<List<String>>();
	List<EmpAttendenceBean> result;
	
	public List<EmpAttendenceBean> attendenceView(){
		
		try {
			String empCode= EmployeeLoginDao.EMP_CODE;
			//attendenceList= new ArrayList<AttendenceUploadBean>();
			SessionFactory sf = HibernateUtils.getSessionFactory(); 
			Session session=sf.getCurrentSession();
			Transaction t= session.beginTransaction();
			
			Query attendenceDetailsVal = session.createQuery("from AttendenceUploadBean where empCode= " + empCode);
			attendenceValList = attendenceDetailsVal.list();
			Iterator<AttendenceUploadBean> attendenceBeanIterator= attendenceValList.iterator();
			
			while (attendenceBeanIterator.hasNext()) {
				AttendenceUploadBean attendenceUploadBean = (AttendenceUploadBean) attendenceBeanIterator.next();
				EmpAttendenceBean empAttendenceBean= new EmpAttendenceBean();
				empAttendenceBean.setInTime(attendenceUploadBean.getEmpInTime());
				empAttendenceBean.setOutTime(attendenceUploadBean.getEmpOutTime());
				empAttendenceBean.setDuration(attendenceUploadBean.getWorkingDuration());
				empAttendenceBean.setStatus(attendenceUploadBean.getStatus());
				empAttendenceBean.setDateTime(attendenceUploadBean.getDateTime());
				empAttendenceList.add(empAttendenceBean);
				/*inTimeList.add(attendenceUploadBean.getEmpInTime());
				outTimeList.add(attendenceUploadBean.getEmpOutTime());
				durationList.add(attendenceUploadBean.getWorkingDuration());
				dateList.add(attendenceUploadBean.getDateTime());*/
			}
			/*empAttendenceList.add(inTimeList);
			empAttendenceList.add(outTimeList);
			empAttendenceList.add(durationList);
			empAttendenceList.add(dateList);*/
			result= empAttendenceList;
				
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
