package com.niit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog1;

import java.util.List;

import javax.transaction.Transactional;

@Repository("blog1DAO")
@Transactional
public class Blog1DaoImpl implements Blog1Dao {

	@Autowired
	private SessionFactory sessionFactory;

	public Blog1DaoImpl() {
		super();
	}

	public Blog1DaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlog1(Blog1 blog1) {

		Session session = sessionFactory.openSession();
		try {
			session.save(blog1);
			session.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public Blog1 getBlog1ById(String blog1Id) {
		Session session = sessionFactory.openSession();
		return (Blog1) session.get(Blog1.class, blog1Id);
	}

	@Transactional
	public boolean delete(String blog1Id) {
		// TODO Auto-generated method stub
		try {

			Blog1 blog1 = getBlog1ById(blog1Id);
			sessionFactory.getCurrentSession().delete(blog1);
			sessionFactory.getCurrentSession().flush();

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Transactional
	public List<Blog1> getAllBlog1s() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog1");
		List<Blog1> blog1s = query.list();
		return blog1s;
	}

	

}