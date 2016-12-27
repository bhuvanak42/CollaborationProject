package com.niit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogCommentDAO;
import com.niit.dao.BlogDao;
import com.niit.dao.UsersDetailDao;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.UsersDetail;

public class BlogCommentTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		BlogComment blogComment = (BlogComment) context.getBean("blogComment");
		BlogCommentDAO blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");

		// INSERT OBJECTS INTO DB

		
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
	
		

		// Get the date today using Calendar object.
		Date today = new Date();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		System.out.println("Report Date: " + reportDate);
		
		
		
		
		//blog.setId("BLOG_001");
		blogComment.setBlogID("BLOG_001");
		blogComment.setUserID(123);
		blogComment.setDateTime(reportDate);
		blogComment.setBlogComment("comment");
		blogComment.setBlogDislike(12);
		blogComment.setBlogLike(52);
		blogCommentDAO.save(blogComment);

	/*	blog.setBlogId("BLOG_002");
		blog.setContent("Content");
		blog.setDateOfCreation(new Date());
		blog.setTitle("title");
	//	blog.setUsersID("USER_001");
		blog.setCategory("this is category");
		blogDAO.saveOrUpdateBlog(blog);

		blog.setBlogId("BLOG_003");
		blog.setContent("Content");
		blog.setDateOfCreation(new Date());
	//	blog.setUsersID("USER_002");
		blog.setCategory("this is category");
		blog.setTitle("title");
		blogDAO.saveOrUpdateBlog(blog);

		blog = blogDAO.getBlogById("BLOG_002");
		System.out.println(blog.getContent() + "\t" + blog.getTitle() + "\t" + "\t" + blog.getDateOfCreation());
*/
		/*
		 * boolean flag=blogDAO.delete(blog); System.out.println("delete  "
		 * +flag);
		 */
		context.close();
	}
}