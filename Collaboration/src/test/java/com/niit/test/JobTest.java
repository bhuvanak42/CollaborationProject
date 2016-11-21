package com.niit.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobsDao;
import com.niit.model.Job;
import com.niit.model.JobRegistration;

public class JobTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Job job = (Job) context.getBean("job");
		JobsDao jobDAO = (JobsDao) context.getBean("jobDao");
		JobRegistration jobreg = (JobRegistration) context.getBean("jobRegistration");
		
		// INSERT OBJECTS INTO DB


		/*job.setAddressOfTheCompany("Jayanagar");
		job.setCompany("NIIT");
		job.setAboutCompany("NIIT");
		job.setCtc("Rs.30000");
		job.setDateOfInterview(new Date());
		job.setEligibilityCriteria("BE Fresher");		
		job.setRole("Associate");
		job.setSkillsRequired("Java knowledge");
		job.setUrlOfTheCompany("http://www.w3schools.com");
		jobDAO.addJob(job);*/
		
		
		
		/*jobreg.setCertificateNumber("cdasdvc");
		jobreg.setJobId(243);
		jobreg.setRegistrationNumber("cvasdc");
		jobreg.setStudentId(82);
		jobDAO.registerJob(jobreg);*/
		
		
		
		
		
		
		
		/*List<JobRegistration> list=jobDAO.viewJobsApplied(82);
		for (JobRegistration jobRegistration : list) {
			System.out.println(jobRegistration.getJobId() + "\t" + jobRegistration.getRegistrationNumber()+ "\t" + "\t" + jobRegistration.getCertificateNumber());
		}*/
		
		
		
		
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
		
	jobDAO.deleteJob(243);
		
		context.close();
	}
}