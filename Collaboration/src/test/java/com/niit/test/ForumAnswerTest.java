package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDao;
import com.niit.model.Forum;

public class ForumAnswerTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Forum forum = (Forum) context.getBean("forum");
		ForumDao forumDAO = (ForumDao) context.getBean("forumDAO");
		
		
		/*ForumAnswer forumAns = (ForumAnswer) context.getBean("forumAnswer");
		ForumAnswerDao forumAnsDAO = (ForumAnswerDao) context.getBean("forumAnswerDAO");
		
		forumAns.setForumAnswerId(12);
		forumAns.setQuestionId(12);
		forumAns.setUserId(12);
		forumAns.setAnswer("answer");
		forumAns.setLike(2);
		forumAns.setDislike(3);
		forumAnsDAO.saveOrUpdateForumAnswer(forumAns);*/
		
		
		
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