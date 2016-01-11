package com.agni.hrms.schedular;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;

public class ServiceStatusChecker {
	
	public static boolean isJobRunning(JobExecutionContext jobExecutionContext, String runningModuleClassName) throws SchedulerException
	{
		List<JobExecutionContext> jobs = jobExecutionContext.getScheduler().getCurrentlyExecutingJobs();
		
		for (JobExecutionContext job : jobs)
		{
			// check if the current job is already running (make sure to check that fire times are different so that a different
			// instance of the same job is checked)
			if (job.getJobDetail().getJobClass().getName().equals(runningModuleClassName) && !job.getFireTime().equals(jobExecutionContext.getFireTime()))
			{
				return true;
			}
		}
		return false;
	}

}
