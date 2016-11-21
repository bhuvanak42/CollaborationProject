package com.niit.test;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumAnswerDao;
import com.niit.dao.UsersDetailDao;
import com.niit.model.ForumAnswer;
import com.niit.model.UsersDetail;

public class ForumAnswerTest1 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		ForumAnswer answer=(ForumAnswer)context.getBean("forumAnswer");
		ForumAnswerDao answerDAO = (ForumAnswerDao) context.getBean("forumAnswerDao");
	
		
		/*answer.setAnswerId(311);
		answer.setQuestionId(54);
		answer.setUserId(547);
		answer.setAnswer("answer");
		answer.setAnswerLike(451);
		answer.setAnswerDislike(321);
		answerDAO.saveOrUpdate(answer);	*/	
		/*answerDAO.delete(310);*/
		
		
		/* List<ForumAnswer> listOfAnswers=answerDAO.list();
		for (ForumAnswer forumAns : listOfAnswers) {
			System.out.println(forumAns.getQuestionId()+"\t"+forumAns.getAnswer());
		}*/
		
		
		 List<ForumAnswer> listOfAnswers=answerDAO.getAnswers(1);
			for (ForumAnswer forumAns : listOfAnswers) {
				System.out.println(forumAns.getQuestionId()+"\t"+forumAns.getAnswer());
			}
		
		context.close();
	}
}