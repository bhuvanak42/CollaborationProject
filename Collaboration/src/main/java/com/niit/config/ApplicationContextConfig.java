package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogCommentDAO;
import com.niit.dao.BlogCommentDAOImpl;
import com.niit.dao.BlogDao;
import com.niit.dao.BlogDaoImpl;
import com.niit.dao.EventDao;
import com.niit.dao.EventDaoImpl;
import com.niit.dao.ForumAnswerDao;
import com.niit.dao.ForumAnswerDaoImpl;
import com.niit.dao.ForumDao;
import com.niit.dao.ForumDaoImpl;
import com.niit.dao.FriendsDAO;
import com.niit.dao.FriendsDAOImpl;
import com.niit.dao.JobsDao;
import com.niit.dao.JobsDaoImpl;
import com.niit.dao.UsersDetailDao;
import com.niit.dao.UsersDetailDaoImpl;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Event;
import com.niit.model.Forum;
import com.niit.model.ForumAnswer;
import com.niit.model.Friends;
import com.niit.model.Job;
import com.niit.model.JobRegistration;
import com.niit.model.UsersDetail;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		/*
		 * BasicDataSource dataSource = new BasicDataSource();
		 * dataSource.setDriverClassName("org.h2.Driver");
		 * dataSource.setUrl("jdbc:h2:tcp://localhost/~/temp");
		 * dataSource.setUsername("sa"); dataSource.setPassword("sa");
		 */

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("sa");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");

		/*
		 * properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect")
		 * ;
		 */

		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClasses(UsersDetail.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumAnswer.class);
		System.out.println("inside class ..");
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Friends.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(JobRegistration.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "usersDetailDao")
	public UsersDetailDao getusersDetailDao(SessionFactory sessionFactory) {
		return new UsersDetailDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "eventDao")
	public EventDao getEventDao(SessionFactory sessionFactory) {
		return new EventDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "jobDao")
	public JobsDao getJobDao(SessionFactory sessionFactory) {
		return new JobsDaoImpl(sessionFactory);
	}


	@Autowired
	@Bean(name = "blogDao")
	public BlogDao getBlogDao(SessionFactory sessionFactory) {
		return new BlogDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "blogCommentDAO")
	public BlogCommentDAO getBlogCommentDao(SessionFactory sessionFactory) {
		return new BlogCommentDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "forumDAO")
	public ForumDao getForumDao(SessionFactory sessionFactory) {
		return new ForumDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "forumAnswerDao")
	public ForumAnswerDao getAnswerDao(SessionFactory sessionFactory) {
		return new ForumAnswerDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "friendsDAO")
	public FriendsDAO getFriendsDAO(SessionFactory sessionFactory) {
		System.out.println("inside friendsDAO");
		return new FriendsDAOImpl(sessionFactory);
	}
}
