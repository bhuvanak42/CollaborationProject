package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.JobRegistration;
import com.niit.model.UsersDetail;
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
		session.saveOrUpdate(job);
	}
	public List<Job> viewJobs() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(Job.class).list() ;
	}
	public void deleteJob(int id) {
		System.out.println("job id is  " +id);
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job) session.get(Job.class, new Integer(id));
		session.delete(job);
		
		
		
		System.out.println("deleted JobRegistration"+id);
		
		String hql = "from JobRegistration where jobid='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<JobRegistration> jobRegistrationList =(List<JobRegistration>)query.list();
		for (JobRegistration jobRegistration : jobRegistrationList) {
				session.delete(jobRegistration);
		}
		
		/*jobRegistration.setJobId(id);
		session.delete(jobRegistration);*/
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
	
	public boolean isJobApplied(int studentId,int jobId){
		
		Session session=sessionFactory.getCurrentSession();
		
		Query result=session.createQuery("from jobregistration where studentId ='"+studentId+"' and jobId='"+jobId+"'");
		if(result.list().isEmpty())
			return false;
		return true;
	}
	
	

	public List<JobRegistration> viewJobsApplied(int studentId) {

		String hql = "from JobRegistration where studentid=' "+studentId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<JobRegistration> list = query.list();
		if (list == null || list.isEmpty()) {
			System.out.println("No products available");
			return null;
		}
		return list;
	}
	
	
}
