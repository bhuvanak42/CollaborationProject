package com.niit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UsersDetail;

import java.util.List;

import javax.transaction.Transactional;

@Repository("usersDetailDAO")
@Transactional
public class UsersDetailDaoImpl implements UsersDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UsersDetailDaoImpl() {
		super();
	}

	public UsersDetailDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addUser(UsersDetail usersDetail) {

		Session session = sessionFactory.getCurrentSession();
		try {
			usersDetail.setEnabled(true);
			session.saveOrUpdate(usersDetail);
			session.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// LOOK HERE
	@Transactional
	public boolean isValidUser(String name) {
		List<UsersDetail> list = getAllUsers();

		for (UsersDetail usersDetail : list) {
			if (usersDetail.getUsername().equals(name)) {
				return false;// invalid user
			}
		}
		return true;// valid user
	}

	@Transactional
	public int validateUser(String username, String password) {
		int res=0;
		Session session=sessionFactory.getCurrentSession();
		Query result=session.createQuery("from UsersDetail u where u.username='"+username+"'");
		  // result.setString("username",username);
		List<UsersDetail> user=result.list();
		System.out.println("user:"+user);
	if(user.size()==0)
	{
		res=0;
	}
	else
	{
		for(int i=0;i<user.size();i++)
		{
			System.out.println("inside for loop");
			String dbuserName=user.get(i).getUsername();
			String dbpassword=user.get(i).getPassword();
			String dbrole=user.get(i).getRole();
			if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_USER"))
			{
				res=1;
				System.out.println("the result is:"+res);
			}
			else
				if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_ADMIN"))
			{
				res=2;
				System.out.println("the result  is:"+res);
			}
			}
	}	
	return res;
	}
	
	@Transactional
	public UsersDetail getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (UsersDetail) session.get(UsersDetail.class, userId);
	}

	@Transactional
	public List<UsersDetail> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UsersDetail");
		List<UsersDetail> usersDetail = query.list();
		return usersDetail;
	}

	@Transactional
	public UsersDetail getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UsersDetail where username = ?");
		query.setString(0, username);
		return (UsersDetail) query.uniqueResult();
	}

	public boolean deleteUser(UsersDetail usersDetail) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(usersDetail);
			session.flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}