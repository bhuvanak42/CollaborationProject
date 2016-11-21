package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobsDao;
import com.niit.model.Job;
import com.niit.model.JobRegistration;

public class JobRegistrationTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Job job = (Job) context.getBean("job");
		JobsDao jobDAO = (JobsDao) context.getBean("jobDao");
		
		JobRegistration jobRegistration = (JobRegistration) context.getBean("jobRegistration");
		
		
		// INSERT OBJECTS INTO DB

	
		job.setAddressOfTheCompany("Jayanagar");
		job.setCompany("NIIT");
		job.setCtc("Rs.30000");
	//	job.setDateOfInterview(new Date());
		job.setEligibilityCriteria("BE Fresher");		
		job.setRole("Associate");
		job.setSkillsRequired("Java knowledge");
		job.setUrlOfTheCompany("http://www.w3schools.com");
		jobDAO.addJob(job);
		
		
		jobRegistration.setJobId(119);
		jobRegistration.setRegistrationNumber("sdfasdf");
		jobRegistration.setStudentId(11);
		jobRegistration.setCertificateNumber("gsefvs");
		jobDAO.registerJob(jobRegistration);
		
		/*job = jobDAO.viewJob(116);
		job.setDateOfInterview(new Date());
		*/
		
		//job.setDateOfInterview("30-JUN-2016");

		/*		job.setJobId("JOB_002");
		job.setDescription("description");
		job.setTitle("title");
		job.setUsersID("35");
		jobDAO.saveOrUpdateJob(job);
		
		job.setJobId("JOB_003");
		job.setDescription("description");
		job.setTitle("title");
		job.setUsersID("35");;
		jobDAO.saveOrUpdateJob(job);
*/		
		/*job = jobDAO.viewJob(116);
		System.out.println(job.getJobId() + "\t" + job.getCompany() + "\t" + "\t" + job.getAddressOfTheCompany());*/
		
	/*	jobDAO.deleteJob(118);*/
		
		context.close();
	}
}