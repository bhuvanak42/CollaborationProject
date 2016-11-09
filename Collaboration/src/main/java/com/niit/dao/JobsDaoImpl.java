package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.JobRegistration;
import com.niit.model.Job;

@Transactional
@Repository("jobDao")
public class JobsDaoImpl implements JobsDao {

	@Autowired
	SessionFactory sessionFactory;
	public JobsDaoImpl( ) {
		super();
	}
	public JobsDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
	}
	public List<Job> viewJobs() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(Job.class).list() ;
	}
	public void deleteJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job) session.get(Job.class, new Integer(id));
		session.delete(job);
		
	}
	public void updateJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.update(job);
		
	}
	public Job viewJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job) session.get(Job.class, new Integer(id));
		return job;
	}
	public void registerJob(JobRegistration jobRegistration) {
		Session session=sessionFactory.getCurrentSession();
		session.save(jobRegistration);
	}

}
