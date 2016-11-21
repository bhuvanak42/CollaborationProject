package com.niit.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Blog1Dao;
import com.niit.dao.UsersDetailDao;
import com.niit.model.Blog1;
import com.niit.model.UsersDetail;

public class Blog1Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Blog1 blog1 = (Blog1) context.getBean("blog1");
		Blog1Dao blog1DAO = (Blog1Dao) context.getBean("blog1DAO");

		// INSERT OBJECTS INTO DB

		//blog1.setBlogId("BLOG_001");
		blog1.setAnswer("Answer");
		blog1.setQuestionId(6);
		blog1.setUsersID(96);
		blog1.setAnswerDislike(32);
		blog1.setAnswerLike(659);
		blog1DAO.saveOrUpdateBlog1(blog1);

	/*	blog1.setBlog1Id("BLOG_002");
		blog1.setContent("Content");
		blog1.setDateOfCreation(new Date());
		blog1.setTitle("title");
	//	blog1.setUsersID("USER_001");
		blog1.setCategory("this is category");
		blog1DAO.saveOrUpdateBlog1(blog1);

		blog1.setBlog1Id("BLOG_003");
		blog1.setContent("Content");
		blog1.setDateOfCreation(new Date());
	//	blog1.setUsersID("USER_002");
		blog1.setCategory("this is category");
		blog1.setTitle("title");
		blog1DAO.saveOrUpdateBlog1(blog1);

		blog1 = blog1DAO.getBlog1ById("BLOG_002");
		System.out.println(blog1.getContent() + "\t" + blog1.getTitle() + "\t" + "\t" + blog1.getDateOfCreation());
*/
		/*
		 * boolean flag=blog1DAO.delete(blog1); System.out.println("delete  "
		 * +flag);
		 */
		context.close();
	}
}