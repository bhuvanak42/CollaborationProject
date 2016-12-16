package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumAnswerDao;
import com.niit.dao.ForumDao;
import com.niit.model.Forum;
import com.niit.model.ForumAnswer;

public class ForumAnswerTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		/*Forum forum = (Forum) context.getBean("forum");
		ForumDao forumDAO = (ForumDao) context.getBean("forumDAO");*/
		
		
		ForumAnswer answer=(ForumAnswer)context.getBean("forumAnswer");
		ForumAnswerDao answerDAO = (ForumAnswerDao) context.getBean("forumAnswerDao");
	
		
		answer.setAnswerId(311);
		answer.setQuestionId(54);
		answer.setUserId(547);
		answer.setAnswer("Check the file name and path correctly");
		answer.setAnswerLike(451);
		answer.setAnswerDislike(321);
		answerDAO.saveOrUpdate(answer);	
		
		
		/*forum.setQuestionId(1);
		forum.setQuestionTitle("404 error");
		forum.setQuestionDescription("File not found");
		forumDAO.addQuestion(forum);*/
		
		
		
		
		/*forum.setQuestionDescription("qqqqq");
		forum.setQuestionTitle("yyyyyyyyyy");
		forumDAO.addQuestion(forum);*/
		
		
		
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