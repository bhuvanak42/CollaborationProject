package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.ForumAnswer;

@Repository("forumAnswerDao")
public class ForumAnswerDaoImpl implements ForumAnswerDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumAnswerDaoImpl() {
		super();
	}


	public ForumAnswerDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	
	public boolean saveOrUpdate(ForumAnswer answer) {
		// TODO Auto-generated method stub		
		Session session = sessionFactory.openSession();
		try {
			session.saveOrUpdate(answer);
			session.flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(int id) {
		
		// TODO Auto-generated method stub
		
		try {
			ForumAnswer answer = new ForumAnswer();
			answer.setAnswerId(id);
			sessionFactory.getCurrentSession().delete(answer);
			sessionFactory.getCurrentSession().flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public List<ForumAnswer> getAnswers(int questionId) {
		// TODO Auto-generated method stub
		
		
		String hql = "from ForumAnswer where questionId = '" + questionId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		

		@SuppressWarnings("unchecked")
		List<ForumAnswer> listAnswers = (List<ForumAnswer>) query.list();

		if (listAnswers != null && !listAnswers.isEmpty()) {
				return listAnswers;
		}

		return null;
	}
	@Transactional
	public List<ForumAnswer> list() {
		// TODO Auto-generated method stub
		
		
		
		/*String hql = "from ForumAnswer ORDER BY answerID ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumAnswer> list = query.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		
		return list;*/
		
		
		
		
		
		
		String hql = "from ForumAnswer order by answerId asc ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<ForumAnswer> listAnswers = (List<ForumAnswer>) query.list();

		if (listAnswers != null && !listAnswers.isEmpty()) {
				return listAnswers;
		}
		
		return null;
	}

}
