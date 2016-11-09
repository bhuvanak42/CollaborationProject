package com.niit.test;

import java.util.Date;
import java.util.List;

import org.dom4j.util.UserDataAttribute;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDao;
import com.niit.dao.UsersDetailDao;
import com.niit.dao.UsersDetailDaoImpl;
import com.niit.model.Forum;
import com.niit.model.UsersDetail;

public class ForumTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Forum forum = (Forum) context.getBean("forum");
		ForumDao forumDAO = (ForumDao) context.getBean("forumDAO");
		
		forum.setQuestionDescription("qqqqq");
		forum.setQuestionTitle("yyyyyyyyyy");
		forumDAO.addQuestion(forum);
		
		/*("FORUM_001");
		forum.setDateOfCreation(new Date());
		forum.setDescription("ITI JOB ONLY");
		forum.setUsersDetail(usersDetail);
		forum.setUserID(usersDetail.getUserId());
		forum.setName("job");
		forum.setTopic("topic");
		forumDAO.saveOrUpdate(forum);*/
		
		
		
		/*forum.setForumId("FORUM_002");
		forum.setDateOfCreation(new Date());
		forum.setDescription("ITI JOB ONLY");
		//forum.setUserID(usersDetail.getUserId());
		forum.setName("job");
		forum.setTopic("topic");
		forumDAO.saveOrUpdate(forum);
		
		forum.setForumId("FORUM_004");
		forum.setDateOfCreation(new Date());
		forum.setDescription("ITI JOB ONLY");
		//forum.setUserID(usersDetail.getUserId());
		forum.setName("job");
		forum.setTopic("topic");
		forumDAO.saveOrUpdate(forum);
		
		List<Forum> list = forumDAO.list();

		for (Forum u : list) {
			System.out.println(u.getForumId() + "\t" + u.getName() + "\t" + u.getTopic()+"\t" + u.getDescription()+"\t" + u.getDateOfCreation());
		}*/
		
		
		/*Forum u=forumDAO.get("FORUM_001");
		System.out.println(u.getForumId() + "\t" + u.getName() + "\t" + u.getTopic()+"\t" + u.getDescription()+"\t" + u.getUserID()+"\t" + u.getDateOfCreation());
		
		boolean flag=forumDAO.delete("FORUM_001");
		System.out.println("delete  "+flag);*/
	}
}