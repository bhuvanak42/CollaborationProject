package com.niit.dao;

import java.util.List;

import com.niit.model.JobRegistration;
import com.niit.model.Job;

public interface JobsDao {
	void addJob(Job job);

	List<JobRegistration> viewJobsApplied(int studentId);

	List<Job> viewJobs();

	void deleteJob(int id);
	
	Job viewJob(int id);

	void registerJob(JobRegistration jobRegistration);

	boolean isJobApplied(int studentId, int jobId);

}
