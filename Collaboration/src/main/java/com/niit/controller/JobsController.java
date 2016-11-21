package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobsDao;
import com.niit.model.JobRegistration;
import com.niit.model.Job;

@RestController
public class JobsController {
	@Autowired
	JobsDao jobsDao;
	@RequestMapping(value="/addJob",headers="Accept=application/json",method=RequestMethod.POST)
	public void addJob(@RequestBody Job job)
	{
		System.out.println("Date is  "+job.getDateOfInterview());
		jobsDao.addJob(job); 
	}
	@RequestMapping(value="/viewAllJobs",headers="Accept=application/json",method=RequestMethod.GET)
	public  List<Job> viewJobs()
	{
		return jobsDao.viewJobs();
	}
	
	@RequestMapping(value="/jobsApplied",headers="Accept=application/json",method=RequestMethod.GET)
	public  List<JobRegistration> jobsApplied(HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		return jobsDao.viewJobsApplied(userId);
	}
	
	
	@RequestMapping(value="/deleteJob/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteJob(@PathVariable int id)
	{
		jobsDao.deleteJob(id);
	}
	@RequestMapping(value="/updateJob",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateJob(@RequestBody Job job)
	{
		jobsDao.addJob(job);
	}
	@RequestMapping(value="/viewJob/{id}",headers="Accept=application/json",method=RequestMethod.GET)
	public Job viewJob(@PathVariable int id)
	{
		return jobsDao.viewJob(id);
	}
	@RequestMapping(value="/registerJob",headers="Accept=application/json",method=RequestMethod.POST)
	public int registerJob(@RequestBody JobRegistration jobRegistration,HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		
		jobRegistration.setStudentId(userId);
		
		jobsDao.registerJob(jobRegistration);
		
		System.out.println("job successfully applied");
		return 1;
	}
	
	@RequestMapping(value="/jobApplied/{jobId}",headers="Accept=application/json",method=RequestMethod.GET)
	public  boolean viewJobRegistration(@PathVariable int jobId,HttpSession session)
	{
		
		int studentId=(Integer) session.getAttribute("loggedInUserId");
		return jobsDao.isJobApplied(studentId, jobId);
	}

	
}
