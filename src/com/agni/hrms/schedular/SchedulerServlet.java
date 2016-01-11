package com.agni.hrms.schedular;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;



public class SchedulerServlet extends HttpServlet  implements ServletContextListener{
	
	
	
	private static final long serialVersionUID = 5058763613568907735L;
	Scheduler scheduler;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		JobDetail jobLeaveIncrement = null;
		Trigger triggerLeaveIncrement = null;
		System.out.println("oyeeeeeeee");
	
		//if(commandExcecutionRecTime != "")
		{
			try {
				jobLeaveIncrement = JobBuilder.newJob(com.agni.hrms.schedular.LeaveIncrementSchedular.class)
						.withIdentity("ExecuteLeaveIncrement", "group1").build();

				/*triggerLeaveIncrement = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
						.withSchedule(
								CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))("0 32 14 * * ? *")
							.build();
*/				
				triggerLeaveIncrement = TriggerBuilder
						.newTrigger()
						.withIdentity("dummyTriggerName", "group1")
						.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(300).repeatForever())
						.build();
						/*.newTrigger().withIdentity("ExecuteNesCommand", "group2").startNow()
						.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(
									Integer.parseInt(0 15 10 L * ?)).repeatForever()).build();*/
			
				scheduler = new StdSchedulerFactory().getScheduler();
		    	scheduler.start();
				scheduler.scheduleJob(jobLeaveIncrement, triggerLeaveIncrement);
			} 
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		//response.sendRedirect("./index.jsp");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		
		System.out.println("oyeeeeeeee");
		
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} 
		catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		{
			JobDetail jobLeaveIncrement = null;
			Trigger triggerLeaveIncrement = null;
			
			try {
				jobLeaveIncrement = JobBuilder.newJob(com.agni.hrms.schedular.LeaveIncrementSchedular.class)
						.withIdentity("ExecuteLeaveIncrement", "group1").build();

				
				triggerLeaveIncrement = TriggerBuilder
						.newTrigger()
						.withIdentity("dummyTriggerName", "group1")
						.withSchedule(
							CronScheduleBuilder.cronSchedule("0 20 16 * * ? *"))
						.build();
				/*triggerLeaveIncrement = TriggerBuilder
						.newTrigger()
						.withIdentity("dummyTriggerName", "group1")
						.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(1440).repeatForever())
						.build();*/
						/*.newTrigger().withIdentity("ExecuteNesCommand", "group2").startNow()
						.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(
									Integer.parseInt(0 15 10 L * ?)).repeatForever()).build();*/
			
				
		    	scheduler.start();
				scheduler.scheduleJob(jobLeaveIncrement, triggerLeaveIncrement);
			} 
			catch (Exception exception) {
				exception.printStackTrace();
			}
			
			
			JobDetail jobBirthdayWishes = null;
			Trigger triggerBirthdayWishes = null;
			
			try {
				jobBirthdayWishes = JobBuilder.newJob(com.agni.hrms.schedular.BirthdayWishesEventSchedular.class)
						.withIdentity("ExecuteLeaveIncrement", "group2").build();

				
				triggerBirthdayWishes = TriggerBuilder
						.newTrigger()
						.withIdentity("dummyTriggerName", "group2")
						.withSchedule(
							CronScheduleBuilder.cronSchedule("0 20 17 * * ? *"))
						.build();
				/*triggerLeaveIncrement = TriggerBuilder
						.newTrigger()
						.withIdentity("dummyTriggerName", "group1")
						.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(1440).repeatForever())
						.build();*/
						/*.newTrigger().withIdentity("ExecuteNesCommand", "group2").startNow()
						.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(
									Integer.parseInt(0 15 10 L * ?)).repeatForever()).build();*/
			
				
		    	scheduler.start();
				scheduler.scheduleJob(jobBirthdayWishes, triggerBirthdayWishes);
			} 
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
	}
	
	

}
