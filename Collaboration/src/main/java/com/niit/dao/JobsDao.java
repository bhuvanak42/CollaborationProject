package com.niit.dao;

import java.util.List;

import com.niit.model.JobRegistration;
import com.niit.model.Job;

public interface JobsDao {
   void addJob(Job job);
   List<Job> viewJobs();
   void deleteJob(int id);
   void updateJob(Job job);
   Job viewJob(int id);
   void registerJob(JobRegistration jobRegistration);
}
